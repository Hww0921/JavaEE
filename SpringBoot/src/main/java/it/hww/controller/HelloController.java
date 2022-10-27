package it.hww.controller;

import it.hww.service.HelloService;
import it.hww.service.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/queryById/{id}")
    public Employee queryById(@PathVariable("id") String id){
        Employee employee = helloService.queryOne(id);
        return employee;
    }
}
