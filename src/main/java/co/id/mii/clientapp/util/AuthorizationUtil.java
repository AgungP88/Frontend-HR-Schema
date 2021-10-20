/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.util;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author hp
 */
public class AuthorizationUtil {
    public static Authentication auth(){
        return SecurityContextHolder.getContext().getAuthentication();  
    }
}
