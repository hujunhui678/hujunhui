package cn.atc.pojo;

public class Shippingaddress {
	/*
	 * �ͻ��ջ���ַ��
	 */
		private long id;//�ͻ��ջ���ַ����
		private long clientId;//�ͻ������
		private String address;//�ջ���ַ
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
