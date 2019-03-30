import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: HuangSuhai
 * @Date: 2018/9/23 12:52
 * @Version 1.0
 */
public class sdsd {
    @Test
    public void evaluate() throws ParseException {
        String fmt = "yyyy";
        String ms = "20180505";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt) ;
        Date d = new Date();
        d.setTime(Long.parseLong(ms));
        System.out.println(sdf.format(d));
    }

    @Test
    public void ss() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        System.out.println(new Date());
        System.out.println(c.getTime());
        System.out.println(c.getTimeInMillis());
    }
}
