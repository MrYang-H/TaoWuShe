package com.example.demo.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Person;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface PersonMapper {
	
	    @Select("SELECT * FROM user.`user1`")
	    List<Person> getAll();
	    
	    
	   
		  
	    
	   
	     @Insert("INSERT INTO `user`.`user1` (`name`, `sex`, `phone`, `email`,`address`) VALUES (#{name},#{sex},#{phone},#{email},#{address})")
	     void insert(@Param("name")String name,@Param("sex")String sex,@Param("phone")String phone,@Param("email")String email,@Param("address")String address);
	     
	   
	     
}
