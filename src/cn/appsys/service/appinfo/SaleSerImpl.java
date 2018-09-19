package cn.appsys.service.appinfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.appinfo.SaleMapper;

@Service
@Transactional
public class SaleSerImpl implements SaleSer {
	@Resource 
	private SaleMapper saleMapper;
	@Override
	public boolean doSaleAddOrRemovById(Integer pid) {
		System.out.println("pid"+pid);//\\//\\
		int status = saleMapper.daoSaleAddOrRemov_getStatus(pid);
		if(status==4) {
			status=5;
		}else {
			status=4;
		}
		int lineNum = saleMapper.daoSaleAddOrRemov(pid, status);
		
		
		boolean flag = false;
		if(lineNum>=1) {
			flag =true;
		}
		System.out.println("flag"+flag);//\\//\\
		return flag;
		
	}

}
