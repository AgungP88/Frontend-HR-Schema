/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.controllers;

import co.id.mii.clientapp.models.Job;
import co.id.mii.clientapp.services.JobService;
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

/**
 *
 * @author hp
 */
@Controller
@RequestMapping("/job")
public class JobController {
    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("jobs", jobService.getAll());
        return "job/index";
    }
    
    @GetMapping("/add")
    public String create(Job job) {
        return "job/add-form";
    }
    
    @PostMapping("/add")
    public String create(@Valid Job job, 
            BindingResult result) {
        
        if (result.hasErrors()) {
            return "job/add-form";
        }
        
        jobService.create(job);
        
        return "redirect:/job";
    }
    
    @GetMapping("/edit/{id}")
    public String update(@PathVariable String id, Model model) {
        model.addAttribute("job", jobService.getById(id));
        return "job/update-form";
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable String id, @Valid Job job, 
            BindingResult result) {
        
        if (result.hasErrors()) {
            return "job/update-form";
        }
        
        jobService.update(id, job);
        
        return "redirect:/job";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        jobService.delete(id);
        return "redirect:/job";
    }
}
