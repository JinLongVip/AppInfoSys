package cn.appsys.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.QueryAppInfoVO;
import cn.appsys.service.appinfo.DevAppViewSer;

@Controller
@RequestMapping("/dev/app")
public class DevAppViewCtr {
	@Resource
	private DevAppViewSer devAppViewSer;
	@RequestMapping("/appview/{pid}")
	public String DevAppView(Model model,@PathVariable Integer pid) {
		AppInfo result=devAppViewSer.doDevAppView(pid);
		QueryAppInfoVO resultVO=devAppViewSer.doDevAppViewVO(pid);
			
		System.out.println(resultVO);	//\\//\\//\\//\\//\\
		
		model.addAttribute("appInfo", result);
		model.addAttribute("appInfoVO", resultVO);
		
		
		return "developer/appinfoview";
		

	}
}
/*-------------s q l 语句------------------------------*/
/*select i.*,
(select c.categoryName from app_category c where i.categoryLevel1 = c.id) as categoryLevel1Name,
(select c.categoryName from app_category c where i.categoryLevel2 = c.id) as categoryLevel2Name,
(select c.categoryName from app_category c where i.categoryLevel3 = c.id) as categoryLevel3Name
from app_info i where i.id='48';*/
/*-------------------------------------------*/

