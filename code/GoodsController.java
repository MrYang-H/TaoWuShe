package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
    
    
    //@RequestParam注解可以用来提取名为“goosname”的String类型的参数，并将之作为输入参数传入
   //@RequestMapping 是一个注解，用来标识 http 请求地址与 Controller 类的方法之间的映射
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
          
         
    	  String newFileName = null;
          // 首先校验图片格式
          List<String> imageType = new ArrayList<String>();
          imageType.add("jpg");
          imageType.add("jpeg");
          imageType.add("png");
          imageType.add("bmp");
          imageType.add("gif");
          // 获取文件名，带后缀
          String originalFilename = file.getOriginalFilename();
          System.out.println(originalFilename);
          // 获取文件的后缀格式
          String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
          if (imageType.contains(fileSuffix)) {
              // 只有当满足图片格式时才进来，重新赋图片名，防止出现名称重复的情况
              newFileName = originalFilename;
              // 该方法返回的为当前项目的工作目录，即在哪个地方启动的java线程
             
              String path = "C:\\Users\\Administrator\\Desktop\\淘物社\\淘物社\\image\\"+newFileName;
              File destFile = new File(path);
              if (!destFile.getParentFile().exists()) {
                  destFile.getParentFile().mkdirs();
              }
              //把数据存数据库
              /*
               * id	goodsName	count	price	state	time	pid
				 3	运动装备	3	100￥	有货	3	../../image/yundong.jpg
				 4  zhijian
               * */
              //url ：../../image/+文件名(newFileName)
              try {
                  file.transferTo(destFile);
                  // 将相对路径返回给前端
                  //return path;
              } catch (IOException e) {
              }
          }
          return "../../image/"+newFileName;
        
      }
      
      @RequestMapping(value = "/data", method = RequestMethod.POST)
      public String data(@RequestBody Goods order) {
    	  System.out.print(order.getGoodsName());
    	  return null;
          
         
      }
      
}

