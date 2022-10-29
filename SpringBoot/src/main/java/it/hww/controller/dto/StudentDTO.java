package it.hww.controller.dto;

import it.hww.entity.StudentDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author dkp
 * @create 2022-10-29 22:23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Integer id;

    private String name;

    private Integer sex;

    private Date startDate;

    private Date endDate;
}
