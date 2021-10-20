/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.models;

import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author WahyuKu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Region {
    
    @NotNull(message = "Field id is required")
    private Long id;
    
    @NotEmpty(message = "Field name is required")
    private String name;
}
