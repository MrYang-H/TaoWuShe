package com.example.demo.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.Goods;




@Mapper
public interface GoodsMapper {
	 
	    @Select("SELECT * FROM user.`user`")
	 
	    List<Goods> getAll();
	    
	   
	    
	    
	
	     @Insert("INSERT INTO `user`.`user` ( `goodsName`, `describe`, `nature`, `price`, `type`, `pid`) VALUES (#{goodsName},#{describe},#{nature},#{price},#{type},#{pid})")
	     void insert(@Param("goodsName")String goodsName,@Param("describe")String describe,@Param("nature")String nature,@Param("price")String price,@Param("type")String type,@Param("pid")String pid);
	     
	    
	      @Delete("DELETE FROM `user`.`user` WHERE id =#{id}")
	      void delete(@Param("id")String id);
	      
	      
	      
	      
	      
	      @Select("SELECT * FROM user.`user` WHERE goodsName = #{goodsName}")
	      @Results({
	            
	            @Result(property = "goodsName", column = "goodsName"),
	            @Result(property = "describe",  column = "describe"),
	            @Result(property = "nature",  column = "nature"),
	            @Result(property = "price", column = "price"),
	            @Result(property = "type", column = "type"),
	            
	            @Result(property = "pid",  column = "pid")
	    })
		    List<Goods>search(String goodsName);
	      
	     
	      
	      
}