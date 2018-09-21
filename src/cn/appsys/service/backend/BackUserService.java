package cn.appsys.service.backend;

import cn.appsys.pojo.BackendUser;

public interface BackUserService {
	
	/**
	 * 后台管理员登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	BackendUser login(String userCode, String userPassword);

}
