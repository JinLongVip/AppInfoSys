package cn.appsys.service.appinfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.appinfo.AppVersionAddMapper;
import cn.appsys.pojo.AppVersion;

@Service
@Transactional
public class AppVersionAddSerImpl implements AppVersionAddSer {
    @Resource
    AppVersionAddMapper  appVersionAddMapper;
	@Override
	public List<AppVersion> appVersionAddSo_getlist(Integer pid) {
		List<AppVersion> appVersionList=appVersionAddMapper.appVersionAddDo_getlist(pid);
		return appVersionList;
	}

	@Override
	public boolean appVersionAddSo_tosave(AppVersion appVersion) {
		boolean flag=false;
		int count=appVersionAddMapper.appVersionAddDo_tosave(appVersion);
		if (count>=1) {
			flag=true;
		}
		return flag;
	}

}
