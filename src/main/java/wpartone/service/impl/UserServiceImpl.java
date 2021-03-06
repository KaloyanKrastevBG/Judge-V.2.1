package wpartone.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wpartone.model.entity.Role;
import wpartone.model.entity.User;
import wpartone.model.service.UserServiceModel;
import wpartone.repository.UserRepository;
import wpartone.service.RoleService;
import wpartone.service.UserService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }


    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {

        userServiceModel.setRole(
                this.roleService.findByName(this.userRepository.count() == 0
                ? "ADMIN" : "USER"));

        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsername(String username) {

        return this.userRepository.findByUsername(username)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public List<String> findAllUserNames() {

        return this.userRepository
                .findAll()
                .stream()
                .map(u -> u.getUsername())
                .collect(Collectors.toList());
    }

    @Override
    public void addRoleToUser(String username, String role) {
         User user = this.userRepository.findByUsername(username).orElse(null);

         if (!user.getRole().getName().equals(role)){
             Role role1 = this.modelMapper.map(this.roleService.findByName(role), Role.class);
             user.setRole(role1);
             this.userRepository.saveAndFlush(user);
         }
    }
}
