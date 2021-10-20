/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.controllers;

import co.id.mii.clientapp.models.Region;
import co.id.mii.clientapp.models.dto.ResponseModel;
import co.id.mii.clientapp.services.RegionService;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

/**
 *
 * @author WahyuKu
 */
@Controller
@RequestMapping(value= "/region", consumes = {MediaType.ALL_VALUE})
public class RegionController {
    
    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }
    
    @GetMapping
    public String getAll(Region region, Model model) {
        model.addAttribute("regions", regionService.getAll());
        return "region/index";
    }
    
    @GetMapping("/getAll")
    public @ResponseBody List<Region> getAll(){
        return regionService.getAll();
    }
    
    @GetMapping("/add")
    public String create(Region region) {
        return "region/add-form";
    }
    
    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('CREATE_DATA')")
    public @ResponseBody ResponseModel<Region> add(@RequestBody Region region) {
        return regionService.create(region);
    }
    
    @GetMapping("/edit/{id}")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("region", regionService.getById(id));
        return "region/update-form";
    }
    
    @PutMapping("/{id}")
    public @ResponseBody ResponseModel<Region> edit(@PathVariable Long id, 
            @RequestBody Region region) {
        
        return regionService.update(id, region);
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        regionService.delete(id);
        return "redirect:/region";
    }
}
