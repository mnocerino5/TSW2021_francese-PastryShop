package model.pastryshop;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<ProductBean> products;
	
	public Cart() {
		products = new ArrayList<ProductBean>();
		
	}
	
	public void addProduct(ProductBean product) {
		boolean ver = false;
		for(ProductBean prod : products) {
			if(prod.getCode() == product.getCode()) {
				ver = true;
				prod.setQq(prod.getQq()+1);	
				prod.setTot_price(prod.getTot_price()+prod.getPrice());
			}		
		}
		if(!ver) {
			products.add(product);
			product.setTot_price(product.getPrice());
		}
		
			
	}
	
	public void deleteProduct(ProductBean product) {
		
		for(ProductBean prod : products) {
			if(prod.getCode() == product.getCode()) {
				if(prod.getQq() > 1) {
					prod.setQq(prod.getQq() - 1);
					prod.setTot_price(prod.getTot_price()-prod.getPrice());
				}
				else if(prod.getQq() == 1){
					products.remove(prod);
					break;
				}
			}
		}
 	}
	
	public List<ProductBean> getProducts() {
		return  products;
	}
	public int getTotal() {
		int somma = 0;
		for(ProductBean prod : products) {
			somma += prod.getQq() * prod.getPrice();
		}
		return somma;
	}
	
	public void removeall(){
		products.removeAll(products);
	}

	@Override
	public String toString() {
		return "Cart [products=" + products + "]";
	}
}
