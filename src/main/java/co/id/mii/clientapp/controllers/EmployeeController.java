/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.controllers;

import co.id.mii.clientapp.models.Employee;
import co.id.mii.clientapp.models.dto.ResponseModel;
import co.id.mii.clientapp.services.DepartmentService;
import co.id.mii.clientapp.services.EmployeeService;
import co.id.mii.clientapp.services.JobService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author hp
 */
@Controller
@RequestMapping("/employee")
@PreAuthorize("isAuthenticated()")
public class EmployeeController {
    private JobService jobService;
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService, 
            JobService jobService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.jobService = jobService;
        this.departmentService = departmentService;
    }
    
    @GetMapping
    @PreAuthorize("hasAuthority('READ_DATA')")
    public String getAll(Employee employee, Model model) {
        model.addAttribute("jobs", jobService.getAll());
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "employee/index";
    }
    
    @GetMapping("/getAll")
    public @ResponseBody List<Employee> getAll(){
        return employeeService.getAll();
    }
    
    @GetMapping("/add")
    @PreAuthorize("hasAuthority('READ_DATA')")
    public String create(Employee employee, Model model) {
        model.addAttribute("jobs", jobService.getAll());
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "employee/add-form";
    }
    
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('CREATE_DATA')")
    public @ResponseBody ResponseModel<Employee> add(@RequestBody Employee employee) {
//        model.addAttribute("jobs", jobService.getAll());
//        model.addAttribute("departments", departmentService.getAll());
//        model.addAttribute("employees", employeeService.getAll());
        return employeeService.create(employee);
    }
    
//    @PostMapping("/add")
//    @PreAuthorize("hasAuthority('CREATE_DATA')")
//    public String create(@Valid Employee employee, 
//            BindingResult result, RedirectAttributes redirect, Model model) {
//        
//        if (result.hasErrors()) {
//            model.addAttribute("jobs", jobService.getAll());
//            model.addAttribute("departments", departmentService.getAll());
//            model.addAttribute("employees", employeeService.getAll());
//            return "employee/add-form";
//        }
//        
////        employee
//        employeeService.create(employee);
//        
//        redirect.addFlashAttribute("message", "Employee created");
//        
//        return "redirect:/employee";
//    }
    
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('EDIT_DATA')")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("jobs", jobService.getAll());
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("employee", employeeService.getById(id));
        
        return "employee/update-form";
    }
    
    
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('EDIT_DATA')")
    public @ResponseBody ResponseModel<Employee> update(@PathVariable Integer id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }
    
//    @PutMapping("/{id}")
//    @PreAuthorize("hasAuthority('EDIT_DATA')")
//    public String update(@PathVariable Integer id, @Valid Employee employee, 
//            BindingResult result, RedirectAttributes redirect, Model model) {
//        
//        System.out.println(employee.toString());
//        if (result.hasErrors()) {
//            model.addAttribute("jobs", jobService.getAll());
//            model.addAttribute("departments", departmentService.getAll());
//            model.addAttribute("employees", employeeService.getAll());
//            return "employee/update-form";
//        }
//        
//        employeeService.update(id, employee);
//        
//        redirect.addFlashAttribute("message", "Employee updated");
//        
//        return "redirect:/employee";
//    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_DATA')")
    public @ResponseBody ResponseModel<Employee> delete(@PathVariable Integer id) {
        return employeeService.delete(id);
    }
//    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAuthority('DELETE_DATA')")
//    public String delete(@PathVariable Integer id) {
//        employeeService.delete(id);
//        return "redirect:/employee";
//    }
   
}
