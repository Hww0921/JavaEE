package it.hww.service;

import it.hww.service.entity.Employee;
import org.springframework.stereotype.Service;

public interface HelloService {
    /**
     * 通过id查询
     * @return
     */
    Employee queryOne(String id);
}
