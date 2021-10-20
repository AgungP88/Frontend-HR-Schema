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
public class Job {
    @NotEmpty(message = "Field id is required")
    private String id;
    
    @NotEmpty(message = "Field name is required")
    private String title;
    
    @NotNull(message = "Field min salary is required")
    private Integer min_salary;
    
    @NotNull(message = "Field max salary is required")
    private Integer max_salary;
}
