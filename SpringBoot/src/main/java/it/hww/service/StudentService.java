package it.hww.service;

import it.hww.controller.dto.StudentDTO;
import it.hww.controller.request.StudentRequest;

import java.util.List;

/**
 * @author dkp
 * @create 2022-10-29 22:11
 */
public interface StudentService {
    /**
     * 查询学生信息
     * @param studentRequest
     * @return 查询出年纪>=20的学生信息
     */
    List<StudentDTO> getStudentsInfo(StudentRequest studentRequest);

}
