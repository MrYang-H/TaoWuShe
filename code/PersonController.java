package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Person;
import com.example.demo.service.PersonService;



@RestController
@RequestMapping("person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	
	    @RequestMapping(value = "/findall")
	    public List<Person> findAll() {
	        return personService.findAll();
	    }
	    
	  
		    
	 
	    @RequestMapping(value = "/add")
	    public void save(@RequestParam("name")String name,@RequestParam("sex")String sex,@RequestParam("phone")String phone,@RequestParam("email")String email,@RequestParam("address")String address) {
	    	personService.insert(name,sex,phone,email,address);
	    }
	    
	   
	    
	    		 
	     
	     
}
