package it.hww.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dkp0911
 */
@Data
public class StudentDO implements Serializable {
    private Integer id;

    private String name;

    private Integer sex;

    private Integer cardId;

    private static final long serialVersionUID = 1L;

}