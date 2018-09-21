package cn.appsys.dao.backuser;

import cn.appsys.pojo.BackendUser;

public interface BackUserMapper {

	BackendUser getBackUserByDevCode(String userCode);

}
