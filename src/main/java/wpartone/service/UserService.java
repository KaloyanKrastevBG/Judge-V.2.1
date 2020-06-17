package wpartone.service;

import wpartone.model.service.UserServiceModel;

import java.util.List;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);

    List<String> findAllUserNames();


    void addRoleToUser(String username, String role);

}
