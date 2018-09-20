package cn.atc.pojo;

import java.sql.Date;
/*
 * 订单表
 */
public class Orderform {
			private String id;//订单表编号
			private long finishedType;//成品类型(成品类型表外键)
			private long orderNum;//订购数量
			private long clientId;//客户表外键
			private Date orderDate;//订单日期
			private Date estimatedTimeOfArrival;//预计到达时间(3天后)
			private String productType;	//成品类型
			private String clientCompany;//客户公司
			private String clientContact;//客户人联系方式
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
