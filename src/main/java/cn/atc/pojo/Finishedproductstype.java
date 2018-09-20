package cn.atc.pojo;

/*
 * 成品类别表
 */
public class Finishedproductstype {
	private long id;// 成品类别表编号
	private String productType;// 成品类型
	private String productName;// 成品名

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Finishedproductstype(long id, String productType, String productName) {
		super();
		this.id = id;
		this.productType = productType;
		this.productName = productName;
	}

	public Finishedproductstype() {
		super();
		// TODO Auto-generated constructor stub
	}

}
