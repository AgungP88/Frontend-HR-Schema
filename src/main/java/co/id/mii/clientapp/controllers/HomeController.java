/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author WahyuKu
 */
@Controller
public class HomeController {
    
    @GetMapping("/layout")
    public String layout() {
        return "layout/_layout";
    }
    
    @GetMapping("/index")
    public String home() {
        return "index";
    }
}
