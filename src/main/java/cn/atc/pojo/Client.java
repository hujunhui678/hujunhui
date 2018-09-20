package cn.atc.pojo;
/*
 * 客户表
 */
public class Client {
		private long id; //客户表编号
		private String clientName;//客户代表人姓名
		private String clientContact;//客户代表人联系方式
		private String clientCompany;//客户公司
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getClientName() {
			return clientName;
		}
		public void setClientName(String clientName) {
			this.clientName = clientName;
		}
		public String getClientContact() {
			return clientContact;
		}
		public void setClientContact(String clientContact) {
			this.clientContact = clientContact;
		}
		public String getClientCompany() {
			return clientCompany;
		}
		public void setClientCompany(String clientCompany) {
			this.clientCompany = clientCompany;
		}
		public Client(long id, String clientName, String clientContact,
				String clientCompany) {
			super();
			this.id = id;
			this.clientName = clientName;
			this.clientContact = clientContact;
			this.clientCompany = clientCompany;
		}
		public Client() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
