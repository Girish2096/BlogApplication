package com.girish.crudoperation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.girish.crudoperation.Entity.Product;
import com.girish.crudoperation.Repository.ProductRepository;


@Service
public class ProductServiceImp implements ProductserviceI {
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product saveProduct(Product product) {
		Product save = productRepo.save(product);
		return save;
	}

	@Override
	public Product updateProduct(Product product, Integer pid) {
		 Product product1 = productRepo.findById(pid).get();
		 product1.setPname(product.getPname());
		 product1.setPprice(product.getPprice());
		 product1.setPcategory(product.getPcategory());
		 
		 Product update = productRepo.save(product1);
		return update;
	}

	public Product getProduct(Integer pid) {
		
		 Product product = productRepo.findById(pid).get();
		  return product;
	}
	
	
	public List<Product> getall()	{
		List<Product> findAll = productRepo.findAll();
		return findAll;
		
	}
	
	
	public void deleteid(Integer pid)
	{
		productRepo.deleteById(pid);
		
	}

	@Override
	public Page<Product> pagination() {
	
		PageRequest pageReq = PageRequest.of(0,3);
		Page<Product> findAll = productRepo.findAll(pageReq);
		return findAll;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
