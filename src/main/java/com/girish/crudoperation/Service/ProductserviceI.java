package com.girish.crudoperation.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.girish.crudoperation.Entity.Product;


public interface ProductserviceI {
	
	public Product saveProduct( Product product);
	
	public Product updateProduct(Product product,Integer pid);
	
	public Product getProduct(Integer pid);
	
	public List<Product> getall();
	
	public void deleteid(Integer pid);
	
	public Page<Product> pagination();

}
