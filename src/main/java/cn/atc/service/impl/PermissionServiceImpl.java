package cn.atc.service.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.common.AllPerm;
import cn.atc.common.PermLv2;
import cn.atc.mapper.PermissionMapper;
import cn.atc.pojo.Permission;
import cn.atc.pojo.Role_perm;
import cn.atc.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<AllPerm> getPerm() {
		List<AllPerm> allPerm = permissionMapper.getAllPermOne();
		for (AllPerm perm1 : allPerm) {
			perm1.setPermListLv2(permissionMapper.getAllPermTwo(perm1.getId()));
			for (PermLv2 perm2 : perm1.getPermListLv2()) {
				perm2.setPermListLv3(permissionMapper.getAllPermThr(perm2.getId()));
			}
		}
		return allPerm;
	}

	@Override
	public List<AllPerm> getPermByRoleId(long id) {
		List<AllPerm> allPerm = permissionMapper.getPermByRoleIdOne(id);
		for (AllPerm perm1 : allPerm) {
			perm1.setPermListLv2(permissionMapper.getPermByRoleIdTwo(id));
			for (PermLv2 perm2 : perm1.getPermListLv2()) {
				perm2.setPermListLv3(permissionMapper.getPermByRoleIdThr(id));
			}
		}
		return allPerm;
	}

	@Override
	public List<Permission> getAllPermConverterPerm(Integer permLevel) {
		List<Permission> permList = new ArrayList<Permission>();
		if (permLevel == 1) {
			List<AllPerm> allPerm = permissionMapper.getAllPermOne();
			if (allPerm.size() != 0) {
				for (int i = 0; i < allPerm.size(); i++) {
					Permission permission = new Permission();
					AllPerm temp = allPerm.get(i);
					permission.setId(temp.getId());
					permission.setPermNameC(temp.getPermNameC());
					permission.setPermNameE(temp.getPermNameE());
					permission.setPermLevel(temp.getPermLevel());
					permList.add(permission);
				}
			}
		} else if (permLevel == 2) {
			List<PermLv2> permLv2 = permissionMapper.getAllPermTwo(new Long(-1));
			if (permLv2.size() != 0) {
				for (int i = 0; i < permLv2.size(); i++) {
					Permission permission = new Permission();
					PermLv2 temp = permLv2.get(i);
					permission.setId(temp.getId());
					permission.setPermNameC(temp.getPermNameC());
					permission.setPermNameE(temp.getPermNameE());
					permission.setPermLevel(temp.getPermLevel());
					permList.add(permission);
				}
			}
		}
		return permList;
	}

	@Override
	public boolean insertPerm(Permission permission) {
		Integer insertPermId = permissionMapper.insertPerm(permission);
		return insertPermId>0;
	}

	@Override
	public boolean insertRolePermByRoleIdAndPermId(Map<String, Object> map) {
		String[] permIds = (String[])map.get("permIds");
		Integer roleId = (Integer)map.get("roleId");
		if(roleId!=null&&roleId!=0) {
			permissionMapper.deleteRolePermByRoleId(roleId);
			if(permIds!=null&&permIds.length!=0) {
				for (String permId : permIds) {
					Role_perm role_perm = new Role_perm(0, roleId, Integer.parseInt(permId));
					Integer result = permissionMapper.insertRolePermByRoleIdAndPermId(role_perm);
					if(result==0) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
