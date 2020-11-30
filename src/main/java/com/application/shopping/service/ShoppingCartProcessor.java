package com.application.shopping.service;

import java.util.ArrayList;

import com.application.shopping.model.ShoppingCart;
import com.application.shopping.repository.ShoppingCartRepository;

public class ShoppingCartProcessor {
	
	private ShoppingCartRepository scRepo;
	
	public String addShoppingCart(ShoppingCart sc)
	{
		
		ArrayList<String> listOfProducts = new ArrayList<String>();
		int total=0;
	
		for(int i=0;i<listOfProducts.size();i++)
		{
			
			String prodStr=listOfProducts.get(i);
			total=total+Integer.parseInt(prodStr);
		}
		
		scRepo.save(sc);
		
		return "";
	}
	
	public String deleteShoppingCart(ShoppingCart sc)
	{
		return "";
	}
	
	public String updateShoppingCart(ShoppingCart sc)
	{
		return "";
	}
	
	public String buyShoppingCart(ShoppingCart sc)
	{
		return "";
	}

}
