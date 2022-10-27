package it.hww.service.impl;

import it.hww.service.HelloService;
import it.hww.service.entity.Employee;
import it.hww.dao.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;

    @Override
    public Employee queryOne(String id) {
        Employee employee  = helloMapper.queryOne(id);
        return employee;
    }
}
