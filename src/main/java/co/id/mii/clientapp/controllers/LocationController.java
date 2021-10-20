/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.controllers;

import co.id.mii.clientapp.models.Location;
import co.id.mii.clientapp.services.CountryService;
import co.id.mii.clientapp.services.LocationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author hp
 */
@Controller
@RequestMapping("/location")
public class LocationController {
    
    private LocationService locationService;
    private CountryService countryService;
    
    @Autowired
    public LocationController(LocationService locationService, 
            CountryService countryService){
        this.countryService = countryService;
        this.locationService = locationService;
    }
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("locations", locationService.getAll());
        return "location/index";
    }
    
    @GetMapping("/add")
    public String create(Location location, Model model) {
        model.addAttribute("countries", countryService.getAll());
        return "location/add-form";
    }
    
    @PostMapping("/add")
    public String create(@Valid Location location, 
            BindingResult result, RedirectAttributes redirect, Model model) {
        
        if (result.hasErrors()) {
            model.addAttribute("countries", countryService.getAll());
            return "location/add-form";
        }
        
//        employee
        locationService.create(location);
        
        redirect.addFlashAttribute("message", "Location created");
        
        return "redirect:/location";
    }
    
    @GetMapping("/edit/{id}")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("location", locationService.getById(id));
        
        return "location/update-form";
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @Valid Location location, 
            BindingResult result, RedirectAttributes redirect, Model model) {
        
        System.out.println(location.toString());
        if (result.hasErrors()) {
            model.addAttribute("countries", countryService.getAll());
            return "location/update-form";
        }
        
        locationService.update(id, location);
        
        redirect.addFlashAttribute("message", "Location updated");
        
        return "redirect:/location";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        locationService.delete(id);
        return "redirect:/location";
    }
}
