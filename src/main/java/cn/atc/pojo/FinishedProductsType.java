package cn.atc.pojo;

/*
 * ��Ʒ����
 */
public class FinishedProductsType {
	private long id;// ��Ʒ������
	private String productType;// ��Ʒ����
	private String productName;// ��Ʒ��

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

	public FinishedProductsType(long id, String productType, String productName) {
		super();
		this.id = id;
		this.productType = productType;
		this.productName = productName;
	}

	public FinishedProductsType() {
		super();
	}

}
