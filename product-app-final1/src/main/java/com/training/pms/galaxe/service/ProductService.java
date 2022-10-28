package com.training.pms.galaxe.service;
import com.training.pms.galaxe.model.Product;
import java.util.List;


public interface ProductService  {
	public String saveProduct(Product product);
	public String updateProduct(Product product);
	public String deleteProduct(int productId);
	public Product getProduct(int productId);
	public boolean isProductExists(int productid);
	public List<Product> getproduct();
	
	public List<Product> searchproduct(String productname);
	public List<Product> searchproduct(String productname,int price,int qoh);
	public List<Product> searchproduct(int min,int max);
	public List<Product> checkstockstatus(int minstock);
}
