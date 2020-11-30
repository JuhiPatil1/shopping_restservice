package com.application.shopping.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.shopping.model.Product;
import com.application.shopping.model.ShoppingCart;
import com.application.shopping.repository.ProductRepository;
import com.application.shopping.repository.ShoppingCartRepository;


public class addToShoppingCart {
	
	 
	  private static ShoppingCartRepository scRepo;
	 
	 
	  private static ProductRepository prodRepo;
	 
	
	public static ShoppingCartRepository getScRepo() {
		return scRepo;
	}
	@Autowired
	public static void setScRepo(ShoppingCartRepository scRepo) {
		addToShoppingCart.scRepo = scRepo;
	}

	public static ProductRepository getProdRepo() {
		return prodRepo;
	}
	@Autowired
	public static void setProdRepo(ProductRepository prodRepo) {
		addToShoppingCart.prodRepo = prodRepo;
	}

	public static void addShoppingCart(ShoppingCart shoppingCart)
	{
		
		shoppingCart.setSold(false);
		shoppingCart.setTotal(calcTotalPrice(shoppingCart));
		scRepo.save(shoppingCart);
			
	}
	
	public static void updateShoppingCart(ShoppingCart shoppingCart)
	{
		shoppingCart.setTotal(calcTotalPrice(shoppingCart));
		scRepo.save(shoppingCart);
		
		
		
	}
	
	public static void checkoutShoppingCart(ShoppingCart shoppingCart)
	{
		Optional<ShoppingCart> updateSC=scRepo.findById(shoppingCart.getId());
		
		if(updateSC!=null)
		{
			shoppingCart.setSold(true);
			scRepo.save(shoppingCart);		
		}
		
	}


	private static int calcTotalPrice(ShoppingCart shoppingCart) {
		
		ArrayList<Integer> productIdList=new ArrayList<Integer>(shoppingCart.getProductList());
		
		
		ArrayList<Product> productList= (ArrayList<Product>) prodRepo.findAllById(productIdList);
		
		int total=0;
		for(int i=0;i<productIdList.size();i++)
		{
			Product repoProd=productList.get(i);
			
			total=total+repoProd.getPrice();
			
		}
		return total;
	}


	
}