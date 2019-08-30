package com.Dao;

import com.entity.db.AcUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DemoDao {

    @Select("select * " +
            "   from ah_user " +
            "   where ifnull(del, 0) = 0 and au_phone = #{phone} " +
            "   order by create_date desc ")
    AcUser getPhoneOneKey(@Param("phone") String phone);

    @Select("select * " +
            "   from ah_user " +
            "   where ifnull(del, 0) = 0 " +
            "   order by create_date desc ")
    List<AcUser> getUserList();
}
