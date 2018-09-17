package cn.appsys.dao.devuser;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DevUser;

public interface DevUserMapper {

	/**
	 * 根据开发者编号查询开发者
	 * @param devCode
	 * @return
	 */
	DevUser getDevUserByDevCode(@Param("devCode")String devCode);

}
