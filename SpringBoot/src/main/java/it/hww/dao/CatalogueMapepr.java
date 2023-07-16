package it.hww.dao;

import it.hww.entity.CatalogueDO;

import java.util.List;

/**
 * @author dkp
 * @create 2023-07-09 13:49
 */
public interface CatalogueMapepr {
    /**
     * 查询所有的目录信息
     *
     * @return CatalogueDO
     */
    List<CatalogueDO> getCatalogueTree();
}
