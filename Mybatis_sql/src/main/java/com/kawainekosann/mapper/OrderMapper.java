package com.kawainekosann.mapper;

import com.kawainekosann.domain.Orders;
import com.kawainekosann.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    /*@Select("SELECT *,o.\"id\" oid FROM orders o ,\"user\" u where o.\"id\"=u.\"id\"")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertimes", property = "ordertimes"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid", property = "user.id"),
            @Result(column = "userName", property = "user.userName"),
            @Result(column = "passWord", property = "user.passWord"),
            @Result(column = "birthday", property = "user.birthday"),
    })
    public List<Orders> findAll();*/

    @Select("SELECT * FROM orders")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ordertimes", property = "ordertimes"),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "user",//要封装的属性名称
                    column = "uid",//根据哪个字段查询user
                    javaType = User.class,//要封装的实体类型
                    one = @One(select = "com.kawainekosann.mapper.UserMapper.select")//select属性表示查询哪个接口的方法获得对应属性
            )

    })
    public List<Orders> findAll();


    @Select("select * from orders where uid = #{uid}")
    public List<Orders> findById(int uid);
}
