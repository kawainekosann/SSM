package com.kawainekosann.mapper;

import com.kawainekosann.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    //public List<User> findAll();
    public List<User> findAllMsg();

    //public List<User> findUserAndRole();

    @Insert("insert into public.user values (#{id},#{userName},#{passWord},#{birthday})")
    public void save(User user);

    @Update("update public.user set \"userName\"=#{userName},\"passWord\"=#{passWord},birthday=#{birthday} where id = #{id}")
    public void update(User user);

    @Delete("delete from public.user where id=#{id}")
    public void delete(int id);

    @Select("select * from public.user where id=#{id}")
    public User select(int id);

    @Select("select * from public.user")
    public List<User> findAll();

    @Select("select * from public.user")
    @Results({
            //id = true可以将该字段看作主键
            @Result(id = true ,column = "id" , property = "id"),
            @Result(column = "userName" , property = "userName"),
            @Result(column = "passWord" , property = "userName"),
            @Result(
                    property = "ordersList",
                    column = "id",
                    javaType = List.class,
                    many = @Many( select = "com.kawainekosann.mapper.OrderMapper.findById")
            )}
    )
    public List<User> findUserAndOrders();

    @Select("select * from public.user")
    @Results({
            //id = true可以将该字段看作主键
            @Result(id = true ,column = "id" , property = "id"),
            @Result(column = "userName" , property = "userName"),
            @Result(column = "passWord" , property = "userName"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many( select = "com.kawainekosann.mapper.RoleMapper.findByUid")
            )}
    )
    public List<User> findUserAndRole();
}
