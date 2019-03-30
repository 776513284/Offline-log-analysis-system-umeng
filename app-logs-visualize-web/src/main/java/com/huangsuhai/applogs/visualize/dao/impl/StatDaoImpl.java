package com.huangsuhai.applogs.visualize.dao.impl;

import com.huangsuhai.applogs.visualize.domain.StatBean;
import com.huangsuhai.applogs.visualize.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 统计
 */
@Repository("statDao")
public class StatDaoImpl extends SqlSessionDaoSupport implements BaseDao {

	/**
	 * 查询新增用户
	 */
	public StatBean findNewUsers(){
		return getSqlSession().selectOne("stats.newusers");
	}

	public Long todayNweUsers(String appid) {
		return getSqlSession().selectOne("stats.selectAppIdTodayNewusers", appid);
	}

	public List<StatBean> findDayNewUsersInWeek(String appid) {
		return getSqlSession().selectList("stats.selectThisWeekNewusers", appid);
	}

	public List findThisWeekNweUsers(String appid) {
		return getSqlSession().selectList("stats.selectThisWeekNewusers", appid);
	}

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
