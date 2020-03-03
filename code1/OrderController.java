package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;



@RestController
@RequestMapping("order")
public class OrderController {
	
   @Autowired
   private OrderService orderService;
   
   /** 
    * @Description: 查询用户列表
    * @Param: 不用传参数
    * @return: java.util.List<com.example.mybatis.bean.User> 
    * @Author: 
    * @Date: 2019/10/9
    */ 
    @RequestMapping(value = "/findall")
    public List<Order> findAll(@RequestParam("state")String state) {
        return orderService.findAll(state);
    }
    
    @RequestMapping(value = "/findpersonalorder")
    public List<Order> findOrderByPid(@RequestParam("pid")String pid) {
    	return orderService.findOrderByPid(pid);
    }
    
    @RequestMapping(value = "/findbyid")
    public List<Order> findbyid(@RequestParam("id")String id){
    	return orderService.findbyid(id);
    }
 
    
    
    /** 
     * @Description: 保存用户信息方法
     * @Param: [order] 
     * @return: void 
     * @Author: 
     * @Date: 2019/10/9
     */
     @RequestMapping(value = "/add")
     public void save(@RequestParam("id")String id,@RequestParam("goodsName")String goodsName,@RequestParam("count")String count,@RequestParam("price")String price,@RequestParam("state")String state,@RequestParam("time")String time,@RequestParam("pic")String pic,@RequestParam("name")String name,@RequestParam("phone")String phone,@RequestParam("receivetime")String receivetime,@RequestParam("province")String province,@RequestParam("city")String city,@RequestParam("county")String county,@RequestParam("address")String address,@RequestParam("pid")String pid) {
         orderService.insert(id, goodsName,count,price, state,time,pic,name,phone,receivetime,province,city,county,address,pid);
     }
     
     @RequestMapping(value = "/update")
     public void update(@RequestParam("id")String id,@RequestParam("state")String state) {
    	 orderService.update(id,state);
     }
     
     
     
     /**
      * @Description:  删除用户信息方法
      * @Param: [order]
      * @return: void
      * @Author: 
      * @Date: 2019/10/9
      */
      @RequestMapping(value = "/deletebyId")
      public void delete (@RequestParam("id") String id) {
          orderService.delete(id);
      }
      
      @RequestMapping(value = "/findstate1")
      public List<Order> findstate1( @RequestParam("state") String state,@RequestParam("pid") String pid) {
          return orderService.findstate1(state,pid);
      }
      
      @RequestMapping(value = "/findstate2")
      public List<Order> findstate2() {
          return orderService.findstate2();
      }
      
      @RequestMapping(value = "/findstate3")
      public List<Order> findstate3() {
          return orderService.findstate3();
      }
}
