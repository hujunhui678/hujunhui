package cn.atc.pojo;
/*
 * �ͻ���
 */
public class Client {
		private long id; //�ͻ�����
		private String clientName;//�ͻ�����������
		private String clientContact;//�ͻ���������ϵ��ʽ
		private String clientCompany;//�ͻ���˾
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
