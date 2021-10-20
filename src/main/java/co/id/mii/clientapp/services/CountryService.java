/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.services;

import co.id.mii.clientapp.models.Country;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hp
 */
@Service
public class CountryService {
    private RestTemplate restTemplate;
    
    @Value("${api.baseUrl}/country")
    private String url;

    @Autowired
    public CountryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<Country> getAll() {
        ResponseEntity<List<Country>> response =  restTemplate
                .exchange(url, HttpMethod.GET, null, 
                        new ParameterizedTypeReference<List<Country>>(){});
    
        return response.getBody();
    }
    
    public Country getById(String id) {
        return restTemplate
                .getForObject(url + "/" + id, Country.class);
    }
    
    public void create(Country country) {
        restTemplate
                .postForObject(url, country, Country.class);
    }
    
    public void update(String id, Country country) {
        restTemplate
                .put(url + "/" + id, country, Country.class);
    }
    
    public void delete(String id) {
        restTemplate
                .delete(url + "/" + id, String.class);
    }
}
