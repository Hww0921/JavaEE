package it.hww.entity;

import lombok.Data;

/**
 * @author dkp
 * @create 2023-07-09 14:12
 */
@Data
public class CatalogueDO {
    private Long catalogueId;
    private String catalogueCode;
    private String catalogueName;
    private Long parentId;
    private String idPath;
    private String namePath;
}
