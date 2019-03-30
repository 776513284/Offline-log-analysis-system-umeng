package com.huangsuhai.applogs.visualize.domain;

/**
 * @Author: HuangSuhai
 * @Date: 2018/9/27 8:53
 * @Version 1.0
 */

import java.io.Serializable;

/**
 * 统计信息
 */
public class StatBean implements Serializable {
    //统计日期
    private String date ;
    //统计数量
    private long count ;

    private long date2;

    public long getDate2() {
        return date2;
    }

    public void setDate2(long date2) {
        this.date2 = date2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}