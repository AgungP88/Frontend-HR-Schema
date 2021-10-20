/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.models;

import java.sql.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 *
 * @author hp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
//  @NotNull(message = "Please insert Employee id")
    @Nullable
    private Integer id;
    
//    @NotNull(message = "Please insert comission pct")
    private Double commissionPct;
    
    @NotEmpty(message = "Please insert email")
    @Email(message = "wrong format email")
    private String email;
    
    @NotEmpty(message = "Please insert first name")
    private String firstName;
    
    @NotEmpty(message = "Please insert last name")
    private String lastName;
    
    private Date hireDate;
    
//    @NotEmpty(message = "Please insert phone number")
    private String phoneNumber;
    
//    @NotNull(message = "Please insert salary")
    private Double salary;
    
//    @NotEmpty(message = "Please insert department name")
    private String departmentName;
    
//    @NotEmpty(message = "Please insert job title")
    private String jobTitle;
    
//    @NotEmpty(message = "Please insert manager name")
    private String managerName;
    
//    @NotNull(message = "Please insert department name")
    private Integer departmentId;
    
//    @NotNull(message = "Please insert department name")
    private Integer managerId;
    
//    @NotEmpty(message = "Please insert job title")
    private String jobId;
    
    private Job job;
    private Department department;
    
//    @NotNull(message = "Please insert manager name")
    private Employee employee;
    private Employee manager;
}
