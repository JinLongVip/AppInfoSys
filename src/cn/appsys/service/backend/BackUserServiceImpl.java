package cn.appsys.service.backend;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.backuser.BackUserMapper;
import cn.appsys.pojo.BackendUser;

@Transactional
@Service
public class BackUserServiceImpl implements BackUserService {
	
	@Resource
	private BackUserMapper backUserMapper;
	
	@Override
	public BackendUser login(String userCode, String userPassword) {
		BackendUser backendUser = backUserMapper.getBackUserByDevCode(userCode);
		if (backendUser != null) {
			if (!backendUser.getUserPassword().equals(userPassword)) {
				backendUser = null;
			}
		}
		return backendUser;
	}

}
