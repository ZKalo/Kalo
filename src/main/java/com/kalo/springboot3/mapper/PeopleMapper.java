package com.kalo.springboot3.mapper;

import com.github.pagehelper.Page;
import com.kalo.springboot3.entity.People;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Kalo
 * @create 2019-03-07 15:42
 */
@Component
public interface PeopleMapper {

   @Select("select * from people")
   List<People> findAll();

   @Select("select id,pName,sex,phone from people where pName=#{pName}")
   People findByName(String pName);

}
