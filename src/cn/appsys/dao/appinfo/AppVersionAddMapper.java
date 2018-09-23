package cn.appsys.dao.appinfo;

import java.util.List;

import cn.appsys.pojo.AppVersion;

public interface AppVersionAddMapper {
	List<AppVersion>appVersionAddDo_getlist(int pid);
	int appVersionAddDo_tosave(AppVersion appVersion);
	
	
	
}
