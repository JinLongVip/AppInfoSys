package cn.appsys.web;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.appsys.pojo.AppVersion;
import cn.appsys.service.appinfo.AppVersionAddSer;

@Controller
@RequestMapping("/dev/app/list")
public class AppVersionAddCtr {
	private Integer appId;
	@Resource
	AppVersionAddSer appVersionAddSer;
	/*appVersionAddMo_getlist*/
	@RequestMapping("/appVersionAddMo_getlist/{pid}")
	public String appVersionAddMo_getlist(Model model,@PathVariable Integer pid){
		appId=pid;
		List<AppVersion> appVersionList = new ArrayList<AppVersion>();
		appVersionList= appVersionAddSer.appVersionAddSo_getlist(pid);
		model.addAttribute("appVersionList",appVersionList);
		/*model.addAttribute("appId",appId);*/
	/*	model.addAttribute(arg0)*/
		return "developer/appversionadd";
		
	}
	@RequestMapping("/appVersionAddMo_tosave")
	public String appVersionAddMo_tosave(@RequestParam(value="a_downloadLink",required=false)MultipartFile multipartFile,
																		@ModelAttribute AppVersion appVersion,
																		HttpServletRequest request,HttpSession session){
		
		String apkLocPath="";
		String apkFileName="";
		String downloadLink="";
		if (!multipartFile.isEmpty()) {
			String realPath=session.getServletContext().getRealPath("/statics/uploadfiles");
			int fileSize = 2000000;
			long size = multipartFile.getSize();
			String fileName=multipartFile.getOriginalFilename();
			String extension = FilenameUtils.getExtension(fileName);
			if (size>fileSize) {
				request.setAttribute("fileUploadError", "上传文件超出大小限制!");
				return "developer/appversionadd";
			}else if (!("apk".equals(extension)||"APK".equals(extension))) {
				request.setAttribute("fileUploadError", "不支持此类文件上传!");
				return "developer/appversionadd";
			}else {
				//f g f 不同系统下的"分隔符"
				String fgf = File.separator;
                    String relativePath=request.getContextPath().substring(1);
					realPath +=fgf;
					downloadLink=fgf+relativePath+fgf+"statics"+fgf+"uploadfiles"+fgf+fileName;
			System.out.println("realPath"+realPath);
			File desc =new File(realPath+fileName);
			apkLocPath=realPath+fileName;
			apkFileName=fileName;
			try {
				multipartFile.transferTo(desc);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			}
			
			
		}
		appVersion.setDownloadLink(downloadLink);
		appVersion.setAppId(appId);
		appVersion.setApkLocPath(apkLocPath);
		appVersion.setApkFileName(apkFileName);
		boolean flag=appVersionAddSer.appVersionAddSo_tosave(appVersion);
		
		if (flag) {
			System.out.println("添加成功!");
		}else {
			System.out.println("添加失败!");
		}
		
		return "redirect:/dev/app/list";
	/*	return "test";*/
		
	}
	
	
}
