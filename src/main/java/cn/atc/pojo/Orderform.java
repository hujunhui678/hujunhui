package cn.atc.pojo;

import java.sql.Date;
/*
 * ������
 */
public class Orderform {
			private String id;//��������
			private long finishedType;//��Ʒ����(��Ʒ���ͱ����)
			private long orderNum;//��������
			private long clientId;//�ͻ������
			private Date orderDate;//��������
			private Date estimatedTimeOfArrival;//Ԥ�Ƶ���ʱ��(3���)
			private String productType;	//��Ʒ����
			private String clientCompany;//�ͻ���˾
			private String clientContact;//�ͻ�����ϵ��ʽ
			public String getProductType() {
				return productType;
			}
			public void setProductType(String productType) {
				this.productType = productType;
			}
			public String getClientCompany() {
				return clientCompany;
			}
			public void setClientCompany(String clientCompany) {
				this.clientCompany = clientCompany;
			}
			public String getClientContact() {
				return clientContact;
			}
			public void setClientContact(String clientContact) {
				this.clientContact = clientContact;
			}
			
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			public long getFinishedType() {
				return finishedType;
			}
			public void setFinishedType(long finishedType) {
				this.finishedType = finishedType;
			}
			public long getOrderNum() {
				return orderNum;
			}
			public void setOrderNum(long orderNum) {
				this.orderNum = orderNum;
			}
			public long getClientId() {
				return clientId;
			}
			public void setClientId(long clientId) {
				this.clientId = clientId;
			}
			public Date getOrderDate() {
				return orderDate;
			}
			public void setOrderDate(Date orderDate) {
				this.orderDate = orderDate;
			}
			public Date getEstimatedTimeOfArrival() {
				return estimatedTimeOfArrival;
			}
			public void setEstimatedTimeOfArrival(Date estimatedTimeOfArrival) {
				this.estimatedTimeOfArrival = estimatedTimeOfArrival;
			}
			public Orderform(String id, long finishedType, long orderNum,
					long clientId, Date orderDate, Date estimatedTimeOfArrival) {
				super();
				this.id = id;
				this.finishedType = finishedType;
				this.orderNum = orderNum;
				this.clientId = clientId;
				this.orderDate = orderDate;
				this.estimatedTimeOfArrival = estimatedTimeOfArrival;
			}
			public Orderform() {
				super();
				// TODO Auto-generated constructor stub
			}
			
}
