package it.hww.dao;


import it.hww.entity.WebsiteDO;

public interface WebsiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteDO record);

    int insertSelective(WebsiteDO record);

    WebsiteDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WebsiteDO record);

    int updateByPrimaryKey(WebsiteDO record);
}