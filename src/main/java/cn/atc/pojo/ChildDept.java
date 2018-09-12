package cn.atc.pojo;
/*
 * 子部门表
 */
public class ChildDept {
		private long id;//子部门表编号
		private String childName;//子部门名称
		private long deptId;//部门编号外键
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
