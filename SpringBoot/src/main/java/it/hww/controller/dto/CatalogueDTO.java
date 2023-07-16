package it.hww.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author dkp
 * @create 2023-07-09 14:07
 */
@NoArgsConstructor
@Data
public class CatalogueDTO{

    private Long catalogueId;
    private String catalogueCode;
    private String catalogueName;
    private Long parentId;
    private String idPath;
    private String namePath;

    private List<CatalogueDTO> childrenDTO;

}
