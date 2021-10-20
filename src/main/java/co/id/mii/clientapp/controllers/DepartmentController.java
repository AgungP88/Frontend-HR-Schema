/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.controllers;

import co.id.mii.clientapp.models.Department;
import co.id.mii.clientapp.services.DepartmentService;
import co.id.mii.clientapp.services.EmployeeService;
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
@RequestMapping("/department")
public class DepartmentController {
    
    private LocationService locationService;
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    
    @Autowired
    public DepartmentController(LocationService locationService, 
            EmployeeService employeeService, 
            DepartmentService departmentService){
        this.employeeService = employeeService;
        this.locationService = locationService;
        this.departmentService = departmentService;
    }
    
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("departments", departmentService.getAll());
        return "department/index";
    }
    
    @GetMapping("/add")
    public String create(Department department, Model model) {
        model.addAttribute("locations", locationService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "department/add-form";
    }
    
    @PostMapping("/add")
    public String create(@Valid Department department, 
            BindingResult result, RedirectAttributes redirect, Model model) {
        
        if (result.hasErrors()) {
            model.addAttribute("locations", locationService.getAll());
            model.addAttribute("employees", employeeService.getAll());
            return "department/add-form";
        }
        
//        employee
        departmentService.create(department);
        
        redirect.addFlashAttribute("message", "Department created");
        
        return "redirect:/department";
    }
    
    @GetMapping("/edit/{id}")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("locations", locationService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("department", departmentService.getById(id));
        
        return "department/update-form";
    }
    
    @PutMapping("/{id}")
    public String update(@PathVariable Integer id, @Valid Department department, 
            BindingResult result, RedirectAttributes redirect, Model model) {
        
        System.out.println(department.toString());
        if (result.hasErrors()) {
            model.addAttribute("locations", locationService.getAll());
            model.addAttribute("employees", employeeService.getAll());
            return "department/update-form";
        }
        
        departmentService.update(id, department);
        
        redirect.addFlashAttribute("message", "Department updated");
        
        return "redirect:/department";
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        departmentService.delete(id);
        return "redirect:/department";
    }
}
