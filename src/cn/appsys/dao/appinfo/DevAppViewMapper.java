package cn.appsys.dao.appinfo;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.QueryAppInfoVO;

public interface DevAppViewMapper {
	AppInfo daoDevAppView(@Param(value = "pid") int pid);
	QueryAppInfoVO daoDevAppViewVO(@Param(value = "pid") int pid);
}
