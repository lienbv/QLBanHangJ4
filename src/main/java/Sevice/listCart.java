package Sevice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entity.Product;

public class listCart {
	private List<Product> product;
	public listCart() {
		this.product = new ArrayList<>();
	}
public Product find(int id) {
	for (Product lst : this.product) {
		if(lst.getId() == id) {
			return lst;
		}
	}
	return null;
}
}
