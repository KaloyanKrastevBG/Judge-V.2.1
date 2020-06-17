package wpartone.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wpartone.model.binding.ExerciseBindingAddModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/exercises")
public class ExercisesController {

    @GetMapping("/add")
    public String add() {

        return "exercise-add";
    }

//    @PostMapping("/add")
//    public String addPost(@Valid @ModelAttribute("exerciseBindingModelAdd")
//                                  ExerciseBindingAddModel exerciseBindingAddModel,
//                          BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//
//
//
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("exerciseBindingModelAdd", exerciseBindingAddModel);
//            return "redirect:/";
//        } else {
//            // todo save
//            return "redirect:/";
//        }
//
//
//    }

}
