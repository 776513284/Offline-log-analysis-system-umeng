package com.huangsuhai.applogs.visualize.service.impl;

import com.huangsuhai.applogs.visualize.domain.StatBean;
import com.huangsuhai.applogs.visualize.dao.BaseDao;
import com.huangsuhai.applogs.visualize.service.StatService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * 统计服务
 */
@Service("statService")
public class StatServiceImpl extends BaseServiceImpl<StatBean> implements StatService {

	@Override
	@Resource(name="statDao")
	public void setDao(BaseDao<StatBean> dao) {
		super.setDao(dao);
	}

	/**
	 * 查询新增用户
	 */
	public StatBean findNewUsers() {
		return getDao().findNewUsers();
	}

	/**
	 * 查询指定app的今天新增用户数
	 */
	public Long todayNewUsers(String appid){
		return getDao().todayNweUsers(appid);
	}

	/**
	 * 忽略
	 * @param appid
	 * @return
	 */
	public List<StatBean> findDayNewUsersInWeek(String appid) {
		return getDao().findDayNewUsersInWeek(appid);
	}

	//查询本周每天指定app新增用户
	public List<StatBean> findThisWeekNweUsers(String appid) {
		return getDao().findThisWeekNweUsers(appid);
	}
}
