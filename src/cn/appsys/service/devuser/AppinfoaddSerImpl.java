package cn.appsys.service.devuser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.appinfo.AppinfoaddMapper;
import cn.appsys.pojo.AppInfo;

@Service
public class AppinfoaddSerImpl implements AppinfoaddSer {
	@Resource
	AppinfoaddMapper appinfoaddMapper;
	@Override
	public int appInfoAddSaveSo(AppInfo appInfomo) {
		int count=appinfoaddMapper.appInfoAddSaveDo(appInfomo);
		return count;
	}

}
