 package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Person;






public interface PersonService {

	
	    List<Person> findAll();
	    
	  
		
	  void insert(String name,String sex,String phone,String email,String address);
	    
	 
	    
}
