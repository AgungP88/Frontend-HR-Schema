/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.controllers;

import co.id.mii.clientapp.models.dto.AuthRequestDTO;
import co.id.mii.clientapp.services.LoginService;
import co.id.mii.clientapp.util.AuthorizationUtil;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author hp
 */
@Controller
public class LoginController {
    private LoginService loginService;
    
    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }
    
    @PostMapping("/logout")
    public String logout(){
        SecurityContextHolder.getContext().setAuthentication(null);  
        return "login";
    }
    
    @GetMapping("/login")
    public String login(@ModelAttribute(name = "auth") AuthRequestDTO auth) {
        System.out.println(AuthorizationUtil.auth());
        if (AuthorizationUtil.auth() == null || AuthorizationUtil.auth() instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/index";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute(name = "auth") AuthRequestDTO auth, 
            BindingResult result, RedirectAttributes attributes) {
        
        System.out.println(auth.getUsername()+auth.getPassword());
        System.out.println(loginService.login(auth));
        
        if (loginService.login(auth)) {
            return "redirect:/index";
        }

        return "redirect:/login?error=true";
    }
}
