package it.hww.dao;


import it.hww.entity.StudentDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dkp0911
 */
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentDO record);

    int insertSelective(StudentDO record);

    StudentDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentDO record);

    int updateByPrimaryKey(StudentDO record);

    /**
     * 根据年纪查询学生信息
     * @param record StudentDO
     * @return 根据年纪范围查找 list
     */
    List<StudentDO> selectByAge(@Param("studentDO") StudentDO record);
}