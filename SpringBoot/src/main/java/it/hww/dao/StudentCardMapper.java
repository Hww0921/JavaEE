package it.hww.dao;


import it.hww.entity.StudentCardDO;

public interface StudentCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentCardDO record);

    int insertSelective(StudentCardDO record);

    StudentCardDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentCardDO record);

    int updateByPrimaryKey(StudentCardDO record);
}