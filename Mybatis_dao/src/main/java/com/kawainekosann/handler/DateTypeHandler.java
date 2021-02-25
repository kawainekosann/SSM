package com.kawainekosann.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {
    //将Java类型转换成数据库需要的类型
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        long time = parameter.getTime();
        ps.setLong(i,time);
    }

    //将数据库中的类型转换成Java类型
    //columnName为数据库字段名称
    //ResultSet查询结果集
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        //获得结果集中的数据(long)转换成Date类型
        long aLong = rs.getLong(columnName);
        Date date = new Date(aLong);
        return date;
    }

    //将数据库中的类型转换成Java类型
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        //获得结果集中的数据(long)转换成Date类型
        long aLong = rs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }

    //将数据库中的类型转换成Java类型
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long aLong = cs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }
}
