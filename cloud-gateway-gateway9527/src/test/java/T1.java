import java.time.ZonedDateTime;

/**
 *@descript 
 *@author yu
 *@date 2021/5/13 10:22
 *@version 1.0
 */
public class T1 {
    public static void main(String[] args) {
        //默认时区
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    //    2021-05-13T10:23:04.250+08:00[Asia/Shanghai]
    }

}
