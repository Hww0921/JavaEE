package it.hww.controller;

import it.hww.comom.response.RestResponse;
import it.hww.controller.dto.CatalogueDTO;
import it.hww.controller.dto.StudentDTO;
import it.hww.controller.request.StudentRequest;
import it.hww.service.CatalogueService;
import it.hww.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dkp
 * @create 2023-07-09 13:47
 */
@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

    @Autowired
    CatalogueService catalogueService;

    @PostMapping("/getStudentsInfo")
    public RestResponse<Object> getStudentsInfo(@RequestBody StudentRequest studentRequest){
        List<CatalogueDTO> studentDTOList = catalogueService.getCatalogueTree();
        return RestResponse.ok(studentDTOList);
    }
}
