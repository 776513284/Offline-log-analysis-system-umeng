package com.huangsuhai.applogs.visualize.dao;


import com.huangsuhai.applogs.visualize.domain.StatBean;

import java.util.List;

/**
 * BaseDao接口
 */
public interface BaseDao<T> {
	public StatBean findNewUsers();
	//查询指定app的今日新增用户数
	public Long todayNweUsers(String appid);

	List<T> findDayNewUsersInWeek(String appid);

	List<T> findThisWeekNweUsers(String appid);
}
