package cn.appsys.service.appinfo;

import java.util.List;

import cn.appsys.pojo.AppVersion;

public interface AppVersionAddSer {
	List<AppVersion> appVersionAddSo_getlist(Integer pid);

	boolean appVersionAddSo_tosave(AppVersion appVersion);

}
