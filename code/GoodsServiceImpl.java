package com.example.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.GoodsMapper;
import com.example.demo.pojo.Goods;
import com.example.demo.service.GoodsService;



@Service
public class GoodsServiceImpl implements  GoodsService{
	 @Autowired
	    private GoodsMapper goodsMapper;

	    @Override
	    public List<Goods> SearchAll() {
	        List<Goods> list = goodsMapper.getAll();
	        return list;
	    }
	    
	  
	   
	    
	    @Override
	    public void delete(String id) {
	    	goodsMapper.delete(id);
	    }

		@Override
		public void insert(String goodsName,String describe,String nature,String price,String type,String pid) {
			// TODO Auto-generated method stub
			goodsMapper.insert(goodsName,describe, nature, price,type,pid);
		}



		@Override
		public List<Goods> searchby(String goodsName) {
			return goodsMapper.search(goodsName);
		}


	


		
}
