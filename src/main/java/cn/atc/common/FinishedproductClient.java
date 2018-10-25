package cn.atc.common;

import java.util.List;

import cn.atc.pojo.Client;
import cn.atc.pojo.FinishedProductsType;

public class FinishedproductClient {
	private long id;
	private List<FinishedProductsType> productList;
	private List<Client> clientList;
	public List<FinishedProductsType> getProductList() {
		return productList;
	}
	public void setProductList(List<FinishedProductsType> productList) {
		this.productList = productList;
	}
	public List<Client> getClientList() {
		return clientList;
	}
	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public FinishedproductClient(long id, List<FinishedProductsType> productList, List<Client> clientList) {
		super();
		this.id = id;
		this.productList = productList;
		this.clientList = clientList;
	}
	public FinishedproductClient() {
		super();
	}

	
}
