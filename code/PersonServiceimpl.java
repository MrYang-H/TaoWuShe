package com.example.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.pojo.Person;
import com.example.demo.service.PersonService;




@Service
public class PersonServiceimpl implements PersonService{
	 @Autowired
	 private PersonMapper personMapper;

	@Override
	public List<Person> findAll() {
		 List<Person> list =personMapper.getAll();
		 return list ;
	}
	
	
	
	@Override
	public void insert(String name, String sex, String phone, String email, String address) {
		// TODO Auto-generated method stub
		personMapper.insert(name, sex, phone, email, address);
	}


}
