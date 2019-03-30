package com.huangsuhai.applogs.visualize.test;

import com.huangsuhai.applogs.visualize.domain.StatBean;
import com.huangsuhai.applogs.visualize.service.StatService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @Author: HuangSuhai
 * @Date: 2018/9/23 14:44
 * @Version 1.0
 */
public class TestSource {
    @Test
    public void testConn() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DataSource ds = (DataSource) ac.getBean("dataSource");
        Connection conn = ds.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select formattime(getdaybegin(-1), 'yyyy/MM/dd')");
        if (rs.next()) {
            String time = rs.getString(1);
            System.out.println(time);
        }
        rs.close();
        conn.close();
    }

    @Test
    public void testService() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        StatService ss = (StatService) ac.getBean("statService");
        StatBean sb = ss.findNewUsers();
        System.out.println(sb.getCount());
    }

    @Test
    public void testService2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        StatService ss = (StatService) ac.getBean("statService");
        System.out.println(ss.todayNewUsers("sdk34734"));
    }

    @Test
    public void testService3() {
        System.out.println("sdsdsdsdsdsdsd");
    }

//    @Test
//    public void testSparkSQLThriftServer() throws Exception{
//        Class.forName("org.apache.hive.jdbc.HiveDriver");
//        Connection conn = DriverManager.getConnection("jdbc:hive2://s201:10000");
//        String sql = "select * from applogsdb.ext_error_logs";
//        Statement st = conn.createStatement();
//        ResultSet rs = st.executeQuery(sql);
//        int i = 0;
//        while (rs.next()) {
//           i = i + 1;
//        }
//        rs.close();
//        st.close();
//        conn.close();
//       System.out.println(i);
//    }
}
