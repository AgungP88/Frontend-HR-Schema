/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    
//    @NotNull(message = "Please insert id")
    private Integer id;
    
//    @NotEmpty(message = "Please Insert name")
    private String name;
    
//    @NotNull(message = "Please insert location")
    private Location location;
    
//    @NotNull(message = "Please insert manager")
    private Employee manager;
    
    private Employee employee;
    
    private Integer managerId;
    
    private Integer locationId;
}
