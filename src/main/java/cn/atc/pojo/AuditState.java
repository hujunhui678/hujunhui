package cn.atc.pojo;

/**
 * ���״̬��
 * @author ASUS
 *
 */
public class AuditState {
	
	private Integer id;//���״̬����
	private String auditStateName;//���״̬��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuditStateName() {
		return auditStateName;
	}
	public void setAuditStateName(String auditStateName) {
		this.auditStateName = auditStateName;
	}
	public AuditState(Integer id, String auditStateName) {
		super();
		this.id = id;
		this.auditStateName = auditStateName;
	}
	public AuditState() {
		super();
	}
	
}
