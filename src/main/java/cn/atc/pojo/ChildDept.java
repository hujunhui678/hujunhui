package cn.atc.pojo;
/*
 * �Ӳ��ű�
 */
public class ChildDept {
		private long id;//�Ӳ��ű���
		private String childName;//�Ӳ�������
		private long deptId;//���ű�����
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getChildName() {
			return childName;
		}
		public void setChildName(String childName) {
			this.childName = childName;
		}
		public long getDeptId() {
			return deptId;
		}
		public void setDeptId(long deptId) {
			this.deptId = deptId;
		}
		public ChildDept(long id, String childName, long deptId) {
			super();
			this.id = id;
			this.childName = childName;
			this.deptId = deptId;
		}
		public ChildDept() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
