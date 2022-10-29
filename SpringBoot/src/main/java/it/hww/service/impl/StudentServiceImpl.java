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
        List<StudentDO> studentDOList = studentMapper.selectByAge(studentDO);
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
