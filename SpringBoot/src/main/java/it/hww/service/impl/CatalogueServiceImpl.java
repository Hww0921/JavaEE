package it.hww.service.impl;

import com.google.common.collect.Lists;
import it.hww.controller.dto.CatalogueDTO;
import it.hww.dao.CatalogueMapepr;
import it.hww.entity.CatalogueDO;
import it.hww.service.CatalogueService;
import it.hww.service.converter.StudentConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dkp
 * @create 2023-07-09 14:09
 */
@Service
public class CatalogueServiceImpl implements CatalogueService {
    @Autowired
    CatalogueMapepr catalogueMapepr;
    @Override
    public List<CatalogueDTO> getCatalogueTree() {
        List<CatalogueDO> catalogueDOList = catalogueMapepr.getCatalogueTree();

        // 此处是使用 mapstruct 的方式进行对象的copy 类似与 BeanUtils.copyProperties();
        List<CatalogueDTO> catalogueDtos= StudentConverter.INSTANCE.doToDto(catalogueDOList);

        // 获取顶层目录
        List<CatalogueDTO> topCatalogue = catalogueDtos.stream().filter(item -> item.getParentId() == null).collect(Collectors.toList());

        // 获取非顶层目录通过目录parentId做分组
        Map<Long, List<CatalogueDTO>> catalogueMap = catalogueDtos.stream()
                .filter(e -> e.getParentId() != null)
                .collect(Collectors.groupingBy(CatalogueDTO::getParentId));

        setChildren(topCatalogue,catalogueMap);
        return topCatalogue;
    }

    /**
     * 这种查询目录两个关键地方：递归 && 设置子集  从两个角度思考问题
     * 类比mybatis的嵌套子查询 孩子
     */

    public void setChildren(List<CatalogueDTO> catalogueDTO, Map<Long, List<CatalogueDTO>> catalogueMap) {
        for (CatalogueDTO dto : catalogueDTO) {
            List<CatalogueDTO> childrenDtos = catalogueMap.getOrDefault(dto.getCatalogueId(),Lists.newArrayList());
            dto.setChildrenDTO(childrenDtos);
            setChildren(childrenDtos,catalogueMap);
        }
    }
}
