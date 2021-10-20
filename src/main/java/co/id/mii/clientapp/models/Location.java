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
public class Location {
    
//    @NotNull(message = "Please insert Id Location")
    private Integer id;
    
//    @NotEmpty(message = "Please insert city")
    private String city;
    
//    @NotEmpty(message = "Please insert Postal Code")
    private String postalCode;
    
//    @NotEmpty(message = "Please insert Street")
    private String street;
    
//    @NotEmpty(message = "Please insert Province")
    private String province;
    
//    @NotNull(message = "Please insert Country")
    private Country country;
    
    private String countryId;
    
}
