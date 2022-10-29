package it.hww.controller;

import it.hww.comom.response.RestResponse;
import it.hww.controller.dto.StudentDTO;
import it.hww.controller.request.StudentRequest;
import it.hww.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dkp
 * @create 2022-10-29 22:09
 */
@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    StudentService studentService;


    @PostMapping("/getStudentsInfo")
    public RestResponse<Object> getStudentsInfo(@RequestBody StudentRequest studentRequest){
        List<StudentDTO> studentDTOList = studentService.getStudentsInfo(studentRequest);
        return RestResponse.ok(studentDTOList);
    }
}
