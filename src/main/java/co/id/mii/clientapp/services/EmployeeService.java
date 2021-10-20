/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.clientapp.services;

import co.id.mii.clientapp.models.Employee;
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
 * @author hp
 */
@Service
public class EmployeeService {
    private RestTemplate restTemplate;
    
    @Value("${api.baseUrl}/employee")
    private String url;

    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public List<Employee> getAll() {
        ResponseEntity<List<Employee>> response =  restTemplate
                .exchange(url + "/dto", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<List<Employee>>(){});
    
        return response.getBody();
    }
    
    public Employee getById(Integer id) {
        Employee print = restTemplate
                .getForObject(url + "/" + id, Employee.class);
        System.out.println(print.toString());
        return restTemplate
                .getForObject(url + "/" + id, Employee.class);
    }
    
    public ResponseModel<Employee> create(Employee employee) {
        return new ResponseModel<>(
                restTemplate
                        .postForObject(url + "/dto", employee, Employee.class), "Employee Created");
    }
    
//    public void create(Employee employee) {
//        restTemplate
//                .postForObject(url + "/dto", employee, Employee.class);
//    }
    
    public ResponseModel<Employee> update(Integer id, Employee employee) {
        restTemplate
                .put(url + "/dto" + "/" + id, employee, Employee.class);
        return new ResponseModel<>(employee, "Employee Updated");
    }
    
//    public void update(Integer id, Employee employee) {
//        restTemplate
//                .put(url + "/dto" + "/" + id, employee, Employee.class);
//    }
    
    public ResponseModel<Employee> delete(Integer id) {
        Employee employee = new Employee();
        restTemplate
                .delete(url + "/" + id, Integer.class);
        
        return new ResponseModel<>(employee, "Employee deleted");
    }
}
