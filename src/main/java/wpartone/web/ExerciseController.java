package wpartone.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import wpartone.model.binding.ExerciseBindingModelAdd;

import javax.validation.Valid;

@Controller
@RequestMapping("/exercises")
public class ExerciseController {

    @GetMapping("/add")
    public String add() {

        return "exercise-add";
    }

    @PostMapping("/add")
    public String addPost(@Valid @ModelAttribute("exerciseBindingModelAdd")
                                  ExerciseBindingModelAdd exerciseBindingModelAdd,
                          BindingResult bindingResult) {


        System.out.println();
    if(bindingResult.hasErrors()){
            // todo
        } else {

            return "redirect:/";
        }


        return "redirect:/";

    }

}
