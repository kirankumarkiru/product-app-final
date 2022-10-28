package com.training.pms.galaxe.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="freshProducts")
@Data
public class Product {
	@Id
private int productid;
private String productName;
private int quantityinhand;
private int price;






}
