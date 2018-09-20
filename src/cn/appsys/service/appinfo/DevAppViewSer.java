package cn.appsys.service.appinfo;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.QueryAppInfoVO;

public interface DevAppViewSer {

	AppInfo doDevAppView(int pid);
	QueryAppInfoVO  doDevAppViewVO(int pid);

}
