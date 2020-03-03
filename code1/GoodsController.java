package com.example.demo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Goods;

import com.example.demo.service.GoodsService;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	
	@RequestMapping(value = "/findall")
    public List<Goods> findAll(@RequestParam("name")String name) {
        return goodsService.find(name);
    }
	
	@RequestMapping(value = "/findById")
	public List<Goods> findById(@RequestParam("id")int id ){
		return goodsService.findById(id);
	}
	
	/** 
     * @Description: 自增id添加物品信息方法
     * @Param: [Goods] 
     * @return: void 
     * @Author: 
     * @Date: 2019/10/9
     */
    @RequestMapping(value = "/add")
    public void save(@Param("goodsName")String goodsName,@Param("count")String count,@Param("price")String price,@Param("kind")String kind,@Param("pic")String pic) {
    	goodsService.insert(goodsName,count,price,kind,pic);
    }
    
	
	@RequestMapping(value = "/findkindJiaju")
	public List<Goods> getKindJiaju() {
		// TODO Auto-generated method stub
		return goodsService.getKindJiaju();
	}
	
	@RequestMapping(value = "/findkindDigtal")
	public List<Goods> getKindDigtal() {
		// TODO Auto-generated method stub
		return goodsService.getKindDigital();
	}
	
	@RequestMapping(value = "/findkindClothes")
	public List<Goods> getKindClothes() {
		// TODO Auto-generated method stub
		return goodsService.getKindClothes();
	}
	
	@RequestMapping(value = "/findkindOther")
	public List<Goods> getKindOther() {
		// TODO Auto-generated method stub
		return goodsService.getKindOther();
	}
	
	@RequestMapping(value = "/findkindall")
	public List<Goods> getKindall() {
		// TODO Auto-generated method stub
		return goodsService.getKindall();
	}
}
