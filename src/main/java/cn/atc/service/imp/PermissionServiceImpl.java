package cn.atc.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.atc.common.AllPerm;
import cn.atc.common.PermLv2;
import cn.atc.mapper.PermissionMapper;
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

}
