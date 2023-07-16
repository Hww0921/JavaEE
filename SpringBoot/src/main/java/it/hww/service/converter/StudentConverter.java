package it.hww.service.converter;


import it.hww.controller.dto.CatalogueDTO;
import it.hww.controller.dto.StudentDTO;
import it.hww.entity.CatalogueDO;
import it.hww.entity.StudentDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author dkp
 * @create 2022-10-29 22:59
 */
@Mapper
public interface StudentConverter {
    StudentConverter INSTANCE = Mappers.getMapper(StudentConverter.class);

    /**
     * 实体之间转换
      * @param studentDO
     * @return StudentDTO
     */
    StudentDTO do2dto(StudentDO studentDO);

    /**
     * catalogueDOList--> CatalogueDTOList
     *
     * @param catalogueDOList catalogueDOList
     * @return CatalogueDTOList
     */
    List<CatalogueDTO> doToDto(List<CatalogueDO> catalogueDOList);

    CatalogueDTO doToDtoOne(CatalogueDO catalogueDO);
}
