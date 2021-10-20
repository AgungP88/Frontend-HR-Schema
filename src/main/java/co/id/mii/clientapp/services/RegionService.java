/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.services;

import co.id.mii.clientapp.models.Region;
import co.id.mii.clientapp.models.dto.ResponseModel;
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
 * @author WahyuKu
 */
@Service
public class RegionService {
    
    private RestTemplate restTemplate;
    
    @Value("${api.baseUrl}/region")
    private String url;

    @Autowired
    public RegionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<Region> getAll() {
        ResponseEntity<List<Region>> response =  restTemplate
                .exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Region>>(){});
    
        return response.getBody();
    }
    
    public Region getById(Long id) {
        return restTemplate
                .getForObject(url + "/" + id, Region.class);
    }
    
    public ResponseModel<Region> create(Region region) {
        return new ResponseModel<>(
                restTemplate
                        .postForObject(url, region, Region.class), "Region Created");
    }
    
    public ResponseModel<Region> update(Long id, Region region) {
        restTemplate
                .put(url + "/" + id, region, Region.class);
        
        return new ResponseModel<>(region, "Region Updated");
    }
    
    public void delete(Long id) {
        restTemplate
                .delete(url + "/" + id, String.class);
    }
}
