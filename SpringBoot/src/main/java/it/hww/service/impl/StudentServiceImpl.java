package it.hww.service.impl;

import it.hww.controller.dto.StudentDTO;
import it.hww.controller.request.StudentRequest;
import it.hww.dao.StudentMapper;
import it.hww.entity.StudentDO;
import it.hww.service.StudentService;
import it.hww.service.converter.StudentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkp
 * @create 2022-10-29 22:11
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<StudentDTO> getStudentsInfo(StudentRequest studentRequest) {
        List<StudentDTO> result = new ArrayList<>();

        //1.参数校验
        StudentDO studentDO = new StudentDO();
        studentDO.setSex(studentRequest.getAge());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        StudentDO oneStudent = studentMapper.selectByPrimaryKey(1000);
        if (null == oneStudent){
            System.out.println("dao层查询数据库，返回为一个对象的时候，可能 null");
        }
        List<StudentDO> studentDOList = studentMapper.selectByAge(studentDO);
        if (null == studentDOList){
            System.out.println("ao层查询数据库，返回为一个集合对象的时候，不可能 null");
        }
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        System.out.println("query dataBase cost:" + totalTimeMillis);
        for (StudentDO student : studentDOList) {
            StudentDTO studentDTO = StudentConverter.INSTANCE.do2dto(student);
            result.add(studentDTO);
        }
        return result;
    }
}
