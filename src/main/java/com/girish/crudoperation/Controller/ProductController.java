package com.girish.crudoperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.girish.crudoperation.Entity.Product;
import com.girish.crudoperation.Exception.NotProductfoundException;
import com.girish.crudoperation.Service.ProductserviceI;
import com.girish.crudoperation.prop.Appconstants;


@RestController
public class ProductController {
	
	@Autowired
	private ProductserviceI productserviceI;
	
	
	@PostMapping("/saveproduct")
	public ResponseEntity<Product> save(@RequestBody Product product)
	{
		Product saveProduct = productserviceI.saveProduct(product);
		
		return new ResponseEntity<Product>(saveProduct,HttpStatus.CREATED);
		
	}
	
	
	
	@PutMapping("/updateProduct/{pid}")
	public ResponseEntity<Product> updateUser(@RequestBody Product product,@PathVariable Integer pid)
	{
		
		Product updateProduct = productserviceI.updateProduct(product, pid);
		if(updateProduct!=null)
		{
		return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
		}else
		{
		     throw new NotProductfoundException(" No product found for particular Id");
		}
		
	}
	
	

	@GetMapping("/getid/{pid}")
	public ResponseEntity<Product> getbyid(@PathVariable Integer pid)
	{
		Product product = productserviceI.getProduct(pid);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<Product>> getall()
	{
		List<Product> getall = productserviceI.getall();
		
		return new ResponseEntity<List<Product>>(getall, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteid/{pid}")
	public ResponseEntity<String> delete(@PathVariable Integer pid)
	{
		productserviceI.deleteid(pid);
		String msg=Appconstants.delete;
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/pagination")
	public ResponseEntity<Page<Product>> pagination()
	{
		Page<Product> pagination = productserviceI.pagination();
		System.out.println(pagination);
		return new ResponseEntity<Page<Product>>(pagination, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	

}
