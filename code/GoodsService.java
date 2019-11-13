package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Goods;




public interface  GoodsService {
	 
	    List<Goods> SearchAll();
	    
	  
	 
	      void insert(String goodsName,String describe,String nature,String price,String type,String pid);
	      
	   
	       void delete(String id);
	       
	       
		    List<Goods> searchby(@Param("goodsName") String goodsName);
		    
		    
		   

}
