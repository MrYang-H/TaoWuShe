package com.example.demo.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.Goods;
import com.example.demo.service.GoodsService;



@RestController
@RequestMapping("GOTO")
public class GoodsController {
	
   @Autowired
   private GoodsService goodsService;
   
  
    @RequestMapping(value = "/SearchAll")
    public List<Goods> SearchAll() {
        return goodsService.SearchAll();
    }
    
    
    
   
     @RequestMapping(value = "/add")
     public void save(@RequestParam("goodsName")String goodsName,@RequestParam("describe")String describe,@RequestParam("nature")String nature,@RequestParam("price")String price,@RequestParam("type")String type,@RequestParam("pid")String pid) {
    	 goodsService.insert(goodsName,describe, nature, price,type,pid);
     }
     
     
      @RequestMapping(value = "/deletebyId")
      public void delete (@RequestParam("id") String id) {
    	  goodsService.delete(id);
      }
      
      @RequestMapping(value = "/searchBy")
      public List<Goods> searchby(@RequestParam("goodsName")String goodsName){
          return goodsService.searchby(goodsName);
      }
      
      
      @RequestMapping(value = "/upload", method = RequestMethod.POST)
      public String uoloadFile(@RequestParam("file") MultipartFile file) {
          
          //String originalFilename = file.getOriginalFilename();
    	  String newFileName = null;
          // 首先校验图片格式
          List<String> imageType = new ArrayList<String>();
          imageType.add("jpg");
          imageType.add("jpeg");
          imageType.add("png");
          imageType.add("bmp");
          image
