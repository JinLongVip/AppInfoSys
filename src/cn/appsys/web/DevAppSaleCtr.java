package cn.appsys.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.appsys.service.appinfo.SaleSer;

@Controller
@RequestMapping("/dev/app")
public class DevAppSaleCtr {
	@Resource
	private SaleSer saleSer;
	/*---------------sale add-----------------*/
	@ResponseBody
	@RequestMapping("/sale/{pid}")
	public String saleAddOrRemov(@PathVariable Integer pid ){
		HashMap<String, String > hm=new HashMap<String, String >();
		boolean flag=saleSer.doSaleAddOrRemovById(pid);
		if (flag) {
			
			hm.put("resultMsg", "success");
		}else {
			hm.put("resultMsg", "failed");
			
		}
		hm.put("errorCode", "0");
		return JSON.toJSONString(hm);
		
		
		
	}
}
