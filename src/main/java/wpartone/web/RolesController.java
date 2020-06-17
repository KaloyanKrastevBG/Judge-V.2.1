package wpartone.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wpartone.service.RoleService;
import wpartone.service.UserService;

@Controller
@RequestMapping("/roles")
public class RolesController {

    private final RoleService roleService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public RolesController(RoleService roleService, UserService userService, ModelMapper modelMapper) {
        this.roleService = roleService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView){

        modelAndView.addObject("usernames",
                this.userService.findAllUserNames());
        modelAndView.setViewName("role-add");
        return modelAndView;
    }

//    @PostMapping(/add)
//    public String addConfirm()


}
