/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.services;

import co.id.mii.clientapp.models.dto.AuthRequestDTO;
import co.id.mii.clientapp.models.dto.AuthResponseDTO;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hp
 */
@Service
public class LoginService {
    
    private RestTemplate restTemplate;
    
    @Value("${api.baseUrl}/auth")
    private String url;
    
    @Autowired
    public LoginService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    
    public boolean login(AuthRequestDTO request){
        try{ 
            ResponseEntity<AuthResponseDTO> response = restTemplate
                    .postForEntity(url + "/login", request , AuthResponseDTO.class);
            
            if (response.getStatusCode() == HttpStatus.OK) {
                setAuthorization(response.getBody(), request);
                return true;
            }
            
            return false;
        } catch (RestClientException e) {
            return false;
        }
    }
    
    private void setAuthorization(AuthResponseDTO response, AuthRequestDTO request){
        UsernamePasswordAuthenticationToken auth = new 
            UsernamePasswordAuthenticationToken(request.getUsername(), 
                    response.getAccessToken(), authorities(response.getAuthorities()));
        
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
    
    private Collection<GrantedAuthority> authorities(List<String> authorities){
        return authorities
                .stream()
                .map(auth -> new SimpleGrantedAuthority(auth.toUpperCase()))
                .collect(Collectors.toList());
    }
}
