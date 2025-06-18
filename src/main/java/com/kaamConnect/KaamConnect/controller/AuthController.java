package com.kaamConnect.KaamConnect.controller;

import com.kaamConnect.KaamConnect.model.User;
import com.kaamConnect.KaamConnect.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageSource messageSource;

    // Login endpoint
    @PostMapping("/login")
    public String login(@RequestBody User user, @RequestParam(defaultValue = "en") String lang) {
        Locale locale = Locale.forLanguageTag(lang); // ✅ Replaces deprecated constructor
        User dbUser = userRepository.findByUsername(user.getUsername());

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return messageSource.getMessage("login.success", null, locale);
        }
        return messageSource.getMessage("login.fail", null, locale);
    }

    // Test endpoint to return localized message
    @GetMapping("/message")
    public String getWelcomeMessage(@RequestParam(defaultValue = "en") String lang) {
        Locale locale = Locale.forLanguageTag(lang); // ✅
        return messageSource.getMessage("welcome", null, locale);
    }
}
