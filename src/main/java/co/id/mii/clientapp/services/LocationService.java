/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.services;

import co.id.mii.clientapp.models.Location;
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
public class LocationService {
    private RestTemplate restTemplate;
    
    @Value("${api.baseUrl}/location")
    private String url;

    @Autowired
    public LocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<Location> getAll() {
        ResponseEntity<List<Location>> response =  restTemplate
                .exchange(url + "/dto", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<List<Location>>(){});
    
        return response.getBody();
    }
    
    public Location getById(Integer id) {
        return restTemplate
                .getForObject(url + "/" + id, Location.class);
    }
    
    public void create(Location location) {
        restTemplate
                .postForObject(url + "/dto", location, Location.class);
    }
    
    public void update(Integer id, Location location) {
        restTemplate
                .put(url + "/dto" + "/" + id, location, Location.class);
    }
    
    public void delete(Integer id) {
        restTemplate
                .delete(url + "/" + id, Integer.class);
    }
}
