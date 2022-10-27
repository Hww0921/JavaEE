package it.hww.dao;

import it.hww.service.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelloMapper {

    public Employee queryOne(String id);
}
