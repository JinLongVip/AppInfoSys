package cn.appsys.web;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.QueryAppInfoVO;
import cn.appsys.service.appcategory.AppCategoryService;
import cn.appsys.service.appinfo.AppInfoService;
import cn.appsys.service.datadictionary.DataDictionaryService;
import cn.appsys.util.PageBean;
@Controller
@RequestMapping("/dev/app")
public class AppinfoaddCtr {

	/*---------------------- 新增a p p基础信息加载启动列表------------------------------------*/
	@RequestMapping("/appinfoadd")
		public  String addNewAppInfo() {
		 
		return "developer/appinfoadd";
	}
	
	@Resource
	private AppInfoService appInfoService;
	
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	
	/**
	 * 三级联动 分类查询
	 * @param pid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getclist2/{pid}")
	public String getCategoryList(@PathVariable Integer pid) {
		List<AppCategory> appCategoryList = appCategoryService.getAppCategoryListByParentId(pid);
		return JSON.toJSONString(appCategoryList);
	}
	
	@RequestMapping("/appinfoadd_list")
	public String appinfoadd_list(Model model,@ModelAttribute QueryAppInfoVO queryAppInfoVO) {
		
		Integer currentPageNo = 1;
		if(queryAppInfoVO.getPageIndex() != null) {
			currentPageNo = queryAppInfoVO.getPageIndex();
		}
		Integer pageSize = 5;
		PageBean<AppInfo> pageBean = new PageBean<AppInfo>();
		pageBean.setCurrentPageNo(currentPageNo);
		pageBean.setPageSize(pageSize);
		
		appInfoService.getAppInfoList(pageBean,queryAppInfoVO);
		
		// 查询状态列表 statusList
		List<DataDictionary> statusList = dataDictionaryService.getDataDictionaryListByTypeCode("APP_STATUS");
		// 查询平台列表 flatFormList
		List<DataDictionary> flatFormList = dataDictionaryService.getDataDictionaryListByTypeCode("APP_FLATFORM");
		
		// 查询所有的1级分类 categoryLevel1List
		List<AppCategory> categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);
		
		// 完善分类的回显
		// 如果传了一级分类  说明你选择过  所以肯定触发过三级联动  认为应该将二级分类全部查询
		if(queryAppInfoVO.getQueryCategoryLevel1() != null) {
			List<AppCategory> categoryLevel2List = appCategoryService.getAppCategoryListByParentId(queryAppInfoVO.getQueryCategoryLevel1());
			model.addAttribute("categoryLevel2List", categoryLevel2List);
		}
		if(queryAppInfoVO.getQueryCategoryLevel2() != null) {
			List<AppCategory> categoryLevel3List = appCategoryService.getAppCategoryListByParentId(queryAppInfoVO.getQueryCategoryLevel2());
			model.addAttribute("categoryLevel3List", categoryLevel3List);
		}
		
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		model.addAttribute("queryAppInfoVO", queryAppInfoVO);
		return "developer/appinfoadd";
	}
	/*^^^^^^^^^^^^^以上---新增a p p基础信息加载启动列表^^^^^^^^^^^^^^^^^^^*/
			
	
	
	
	
	
	/*---------------------- 新增a p p基础信息----保存表单数据到数据库------------------------------------*/
	
	private AppInfo appInfoTo;
	@RequestMapping(value="/appinfoaddsave.html",method=RequestMethod.POST)
	                               
			public String appInfoAddSaveTo(@RequestParam(required=false) String softwareName,
																	@RequestParam(required=false) String APKName,
																	@RequestParam(required=false) String supportROM,
																	@RequestParam(required=false)  String interfaceLanguage,
																	@RequestParam(required=false) BigDecimal softwareSize,
																	@RequestParam(required=false)  Integer downloads,
																	@RequestParam(required=false)  Integer queryFlatformId,
																	@RequestParam(required=false)  Integer status,
																	@RequestParam(required=false)  String appInfo) {
		appInfoTo = new AppInfo();

		
		appInfoTo.setSoftwareName(softwareName);
		appInfoTo.setAPKName(APKName);
		appInfoTo.setSupportROM(supportROM);
		appInfoTo.setInterfaceLanguage(interfaceLanguage);
		appInfoTo.setSoftwareSize(softwareSize);
		appInfoTo.setDownloads(downloads);
		appInfoTo.setFlatformId(queryFlatformId);
		appInfoTo.setStatus(status);
		appInfoTo.setAppInfo(appInfo);
		
		
		
		
		
		
				System.out.println(appInfoTo);
				
				
				
				
				
				return "developer/appinfolist";
				
				
			}
	
			/*^^^^^^^^^^^^^以上新增a p p基础信息^^^^^^^^^^^^^^^^^^^*/
	
	
	
}
