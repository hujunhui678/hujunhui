package cn.atc.pojo;

public class Shippingaddress {
	/*
	 * 客户收货地址表
	 */
		private long id;//客户收货地址表编号
		private long clientId;//客户表外键
		private String address;//收货地址
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getClientId() {
			return clientId;
		}
		public void setClientId(long clientId) {
			this.clientId = clientId;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Shippingaddress(long id, long clientId, String address) {
			super();
			this.id = id;
			this.clientId = clientId;
			this.address = address;
		}
		public Shippingaddress() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
