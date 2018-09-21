package cn.appsys.service.appinfo;

import java.util.List;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.QueryAppInfoVO;
import cn.appsys.util.PageBean;

public interface AppInfoService {

	/**
	 * 根据条件进行分页查询
	 * @param pageBean
	 * @param queryAppInfoVO
	 */
	void getAppInfoList(PageBean<AppInfo> pageBean,QueryAppInfoVO queryAppInfoVO);

	List<AppInfo> getAppInfoCheck(Integer aid);

	List<AppVersion> getAppVersionList(Integer vid);



}
