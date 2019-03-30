package com.huangsuhai.applogs.visualize.web.controller;

import com.huangsuhai.applogs.visualize.domain.StatBean;
import com.huangsuhai.applogs.visualize.service.StatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: HuangSuhai
 * @Date: 2018/9/24 10:07
 * @Version 1.0
 * 统计分析类
 */
@Controller
@RequestMapping("/stat")
public class StatController {

    @Resource(name="statService")
    private StatService ss;
    /**
     * appid = "sdk34734"
     * 本周每天新增用户数
     */
    @RequestMapping("/newusers")
    public long findNewUsers(){
        StatBean bean = ss.findNewUsers();
        System.out.println(bean.getCount());
        return bean.getCount() ;
    }

    @RequestMapping("/index")
    public String toStatPage() {
        return "index";
    }

    /**
     * 查询周内每天新增用户数
     * @return
     */
    @RequestMapping("/weeks")
    public String findDayNewUsersInWeek() {
        ss.findDayNewUsersInWeek("sdk34734");
        return "index";
    }

    /**
     * 统计
     */
    @RequestMapping("/stat1")
    @ResponseBody
    public StatBean stat1(){
        StatBean b1 = new StatBean();
        b1.setDate("2017/06/30");
        b1.setCount(1000);
        return b1 ;
    }


    /**
     * 统计
     */
    @RequestMapping("/stat2")
    @ResponseBody
    public List<StatBean> stat2(){
        List<StatBean> list = new ArrayList<StatBean>();
        for(int i = 0 ; i < 10 ; i ++){
            StatBean b1 = new StatBean();
            b1.setDate("2017/06/" + (10 + i));
            b1.setCount(100 + i);
            list.add(b1) ;
        }
        return list;
    }
    /**
     * 统计
     */
    @RequestMapping("/week1")
    @ResponseBody
    public Map<String,Object> stat3(HttpServletResponse response){
        List<StatBean> list = ss.findThisWeekNweUsers("sdk34734");
        //对日期格式进行转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd") ;
        for (StatBean statBean : list) {
            Date d = new Date();
            d.setTime(statBean.getDate2());
            statBean.setDate(sdf.format(d));
        }
        Map<String,Object> map = new LinkedHashMap<String, Object>();
        String[] xlabels = new String[list.size()] ;
        long[] newUsers = new long[list.size()];
        for(int i = 0 ; i < list.size() ; i ++){
            xlabels[i] = list.get(i).getDate();
            newUsers[i] = list.get(i).getCount();
        }
        map.put("labels",xlabels);
        map.put("data", newUsers);
        return map;
    }

}
