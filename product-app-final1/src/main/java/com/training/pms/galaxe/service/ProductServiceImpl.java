package com.training.pms.galaxe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.galaxe.dao.ProductDAO;
import com.training.pms.galaxe.model.Product;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productdao;

	@Override
	public String saveProduct(Product product) {
		// TODO Auto-generated method stub
		if(product.getPrice()<0 || product.getQuantityinhand()<0) {
			return "product no saved";
		}
		else {
			productdao.save(product);
			return "Product saved succesfully";
		}
		
	}

	@Override
	public String updateProduct(Product product) {
		
		// TODO Auto-generated method stub
		
		if (product.getPrice() < 0 | product.getQuantityinhand() < 0) {
            return "Product Price Or QOH Canont Be Negative";
        } else {
            productdao.save(product);
            return "Product Updated Successfully";
        }

		
	}

	@Override
	public String deleteProduct(int productId) {
		
		// TODO Auto-generated method stub
		 productdao.deleteById(productId);
		 return "prodyct deeted";
		
		
	}

	@Override
	public Product getProduct(int productId) {
	 Optional<Product> product = productdao.findById(productId);
	return product.get();
		
	}

	@Override
	public boolean isProductExists(int productid) {
		// TODO Auto-generated method stub
		 Optional<Product> product = productdao.findById(productid);
			return product.isPresent();
		
	}

	@Override
	public List<Product> getproduct() {
		// TODO Auto-generated method stub
		return (List<Product>) productdao.findAll();
		
	}

	@Override
	public List<Product> searchproduct(String productname) {
		// TODO Auto-generated method stub
		return productdao.findByProductName(productname);
	}
	

	@Override
	public List<Product> searchproduct(String productname, int price, int qoh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchproduct(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> checkstockstatus(int minstock) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
