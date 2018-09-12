package cn.atc.pojo;

public class Role_perm {
	/*
	 * 角色权限表
	 */
		private long id;//角色权限表编号
		private long roleId;//角色编号外键
		private long permId;//权限编号外键
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getRoleId() {
			return roleId;
		}
		public void setRoleId(long roleId) {
			this.roleId = roleId;
		}
		public long getPermId() {
			return permId;
		}
		public void setPermId(long permId) {
			this.permId = permId;
		}
		public Role_perm(long id, long roleId, long permId) {
			super();
			this.id = id;
			this.roleId = roleId;
			this.permId = permId;
		}
		public Role_perm() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
