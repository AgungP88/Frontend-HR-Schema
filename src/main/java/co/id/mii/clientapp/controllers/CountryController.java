/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.controllers;

import co.id.mii.clientapp.models.Country;
import co.id.mii.clientapp.services.CountryService;
import co.id.mii.clientapp.services.RegionService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author hp
 */
@Controller
@RequestMapping("/country")
public class CountryController {
    private CountryService countryService;
    private RegionService regionService;

    @Autowired
    public CountryController(CountryService countryService, RegionService regionService) {
        this.countryService = countryService;
        this.regionService = regionService;
    }
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("countries", countryService.getAll());
        return "country/index";
    }
    
    @GetMapping("/add")
    public String create(Country country, Model model) {
        model.addAttribute("regions", regionService.getAll());
        return "country/add-form";
    }
    
    @PostMapping("/add")
    public String create(@Valid Country country, 
            BindingResult result, RedirectAttributes redirect, Model model) {
        
        if (result.hasErrors()) {
            model.addAttribute("regions", regionService.getAll());
            return "country/add-form";
        }
        
        countryService.create(country);
        
        redirect.addFlashAttribute("message", "Country created");
        
        return "redirect:/country";
    }
    
    @GetMapping("/edit/{id}")
    public String update(@PathVariable String id, Model model) {
        model.addAttribute("regions", regionService.getAll());
        model.addAttribute("country", countryService.getById(id));
        return "country/update-form";
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable String id, @Valid Country country, 
            BindingResult result, RedirectAttributes redirect, Model model) {
        
        if (result.hasErrors()) {
            model.addAttribute("regions", regionService.getAll());
            return "country/update-form";
        }
        
        countryService.update(id, country);
        
        redirect.addFlashAttribute("message", "Country updated");
        
        return "redirect:/country";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        countryService.delete(id);
        return "redirect:/country";
    }
}
