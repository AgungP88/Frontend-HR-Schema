/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.services;

import co.id.mii.clientapp.models.Department;
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
public class DepartmentService {
    private RestTemplate restTemplate;
    
    @Value("${api.baseUrl}/department")
    private String url;

    @Autowired
    public DepartmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<Department> getAll() {
        ResponseEntity<List<Department>> response =  restTemplate
                .exchange(url + "/dto", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<List<Department>>(){});
    
        return response.getBody();
    }
    
    public Department getById(Integer id) {
        return restTemplate
                .getForObject(url + "/" + id, Department.class);
    }
    
    public void create(Department department) {
        restTemplate
                .postForObject(url + "/dto", department, Department.class);
    }
    
    public void update(Integer id, Department department) {
        restTemplate
                .put(url + "/dto" + "/" + id, department, Department.class);
    }
    
    public void delete(Integer id) {
        restTemplate
                .delete(url + "/" + id, Integer.class);
    }
}
