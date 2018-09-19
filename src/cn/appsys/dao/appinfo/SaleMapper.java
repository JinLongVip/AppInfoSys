package cn.appsys.dao.appinfo;

import org.apache.ibatis.annotations.Param;

public interface SaleMapper {
	
	int daoSaleAddOrRemov_getStatus(@Param("pid") int pid);
	
	int daoSaleAddOrRemov(@Param("pid") int pid,@Param("status") int status);
	
}
