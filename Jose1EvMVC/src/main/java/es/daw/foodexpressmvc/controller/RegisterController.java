package es.daw.foodexpressmvc.controller;

import es.daw.foodexpressmvc.dto.UserRegisterDTO;
import es.daw.foodexpressmvc.exception.PasswordsDoNotMatchException;
import es.daw.foodexpressmvc.exception.UsernameAlreadyExistsException;
import es.daw.foodexpressmvc.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserRegisterDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") UserRegisterDTO dto,
                           BindingResult bindingResult,
                           Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            userService.register(dto);
        } catch (UsernameAlreadyExistsException | PasswordsDoNotMatchException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }

        // Redirige a login con parámetro de éxito
        return "redirect:/login?registered=true";
    }
}
