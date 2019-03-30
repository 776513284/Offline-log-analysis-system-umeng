package com.huangsuhai.applogs.visualize.service;

import com.huangsuhai.applogs.visualize.domain.StatBean;

import java.util.List;

/**
 * Service
 */
public interface StatService extends BaseService<StatBean> {
    public StatBean findNewUsers();

    public Long todayNewUsers(String appid) ;

    public List<StatBean> findDayNewUsersInWeek(String appid);

    //查询本周每天指定app新增用户
    List<StatBean> findThisWeekNweUsers(String sdk34734);
}
