package cn.atc.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.common.AllPerm;
import cn.atc.common.PermLv2;
import cn.atc.mapper.PermissionMapper;
import cn.atc.pojo.Permission;
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
		if (permLevel == 3) {
			permList = permissionMapper.getAllPermThr(new Long(-1));
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

}
