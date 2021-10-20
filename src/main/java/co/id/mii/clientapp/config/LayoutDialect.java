/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.config;

import org.springframework.context.annotation.Bean;

/**
 *
 * @author hp
 */
public class LayoutDialect {
    @Bean
    public LayoutDialect layoutDialect() {
    return new LayoutDialect();
}
}
