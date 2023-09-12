package ru.cramonk.spring.config.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam (value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {
      //  System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam ("a") double a,
                            @RequestParam ("b") double b,
                            @RequestParam("action") String action, Model model) {
        double result = switch (action) {
            case ("addition") -> a + b;
            case ("multiplication") -> a * b;
            case ("subtraction") -> a - b;
            case ("division") -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + action);
        };

        model.addAttribute("result", result);
        return "first/calculator";
    }
}
