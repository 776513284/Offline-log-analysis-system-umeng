package com.huangsuhai.applogs.visualize.service.impl;

import com.huangsuhai.applogs.visualize.dao.BaseDao;
import com.huangsuhai.applogs.visualize.service.BaseService;

import javax.annotation.Resource;

/**
 * BaseService实现类
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	private BaseDao<T> dao ;

	@Resource
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	public BaseDao<T> getDao() {
		return dao;
	}
}
