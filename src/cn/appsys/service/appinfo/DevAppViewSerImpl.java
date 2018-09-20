package cn.appsys.service.appinfo;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.appinfo.DevAppViewMapper;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.QueryAppInfoVO;

@Service
@Transactional
public class DevAppViewSerImpl implements DevAppViewSer {
@Resource
DevAppViewMapper  devAppViewMapper;

@Override
public AppInfo doDevAppView(@Param(value = "pid") int pid) {
	// TODO Auto-generated method stub
	AppInfo appinfo=devAppViewMapper.daoDevAppView(pid);
/*	System.out.println(appinfo);*/
	
	return appinfo;
	
}

@Override
public QueryAppInfoVO doDevAppViewVO(@Param(value = "pid")int pid) {
	// TODO Auto-generated method stub
	QueryAppInfoVO queryAppInfoVO=devAppViewMapper.daoDevAppViewVO(pid);
	return queryAppInfoVO;
}
	
	

}
