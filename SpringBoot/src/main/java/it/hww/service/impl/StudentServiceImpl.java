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
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//        StudentDO oneStudent = studentMapper.selectByPrimaryKey(1000);
//        assert oneStudent != null:"查询的数据库对象为null";
//        String name = oneStudent.getName();
        List<StudentDO> studentDOList = studentMapper.selectByAge(studentDO);
        if (null == studentDOList){
            System.out.println("ao层查询数据库，返回为一个集合对象的时候，不可能 null");
        }

        Map<String, Integer> stringIntegerMap = studentDOList.stream().collect(
                Collectors.toMap(StudentDO::getName, StudentDO::getSex, (v1, v2) -> v2));
        System.out.println(stringIntegerMap);

        List<String> nameList = studentDOList.stream().map(StudentDO::getName).collect(Collectors.toList());
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
