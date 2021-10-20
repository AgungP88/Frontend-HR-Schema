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
public class Country {
    @NotEmpty(message = "Field id is required")
    private String id;
    
    @NotEmpty(message = "Field name is required")
    private String name;
    
    @NotNull(message = "Field region id is required")
    private Region region;
}
