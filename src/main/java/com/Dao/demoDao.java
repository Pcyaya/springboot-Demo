package com.Dao;

import com.entity.db.AcUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface demoDao {

    @Select("select * " +
            "   from user " +
            "   where ifnull(del, 0) = 0 and phone = #{phone} " +
            "   order by create_date desc ")
    AcUser getPhoneOneKey(@Param("phone") String phone);
}
