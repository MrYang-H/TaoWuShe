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
	
	/** 
	    * @Description: 查询用户列表
	    * @Param: 不用传参数
	    * @return: java.util.List<com.example.mybatis.bean.Person> 
	    * @Author: 
	    * @Date: 2019/10/9
	    */ 
	    @RequestMapping(value = "/findall")
	    public List<Person> findAll() {
	        return personService.findAll();
	    }
	    
	    /** 
		    * @Description: 查询用户个人列表
		    * @Param: 不用传参数
		    * @return: java.util.List<com.example.mybatis.bean.Person> 
		    * @Author: 
		    * @Date: 2019/10/9
		    */ 
		    @RequestMapping(value = "/findpersonal")
		    public Person findPersonByPid(@RequestParam("pid") String pid) {
		        return personService.findPersonByPid(pid);
		    }
	    
	    /** 
	     * @Description: 保存用户信息方法
	     * @Param: [person] 
	     * @return: void 
	     * @Author: 
	     * @Date: 2019/10/9
	     */
	    @RequestMapping(value = "/add")
	    public void save(@RequestParam("pid")String pid,@RequestParam("name")String name,@RequestParam("sex")String sex,@RequestParam("phone")String phone,@RequestParam("email")String email,@RequestParam("address")String address) {
	    	personService.insert(pid,name,sex,phone,email,address);
	    }
	    
	    /** 
	     * @Description: 保存前台用户信息方法
	     * @Param: [person] 
	     * @return: void 
	     * @Author: 
	     * @Date: 2019/10/10 
	     */ 
	     @RequestMapping(value = "/save")
	     public void update(@RequestParam("pid")String pid,@RequestParam("name")String name,@RequestParam("sex")String sex,@RequestParam("phone")String phone,@RequestParam("email")String email,@RequestParam("address")String address) {
	    	 if(personService.findPersonByPid(pid)!=null)
	    		 personService.update(pid,name,sex,phone,email,address);
	    	 else {
	    		 personService.insert(pid,name,sex,phone,email,address);
	    	 }
	    		 
	     }
	     
}
