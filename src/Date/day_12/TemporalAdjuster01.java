package Date.day_12;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

public class TemporalAdjuster01 {
	//对时区的操作 ZoneDate,ZoneTime,ZoneDateTime
	@Test
	public void test4() {
		//指定时区来构建时间
		LocalDateTime ldt=LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
		System.out.println(ldt);
		
		LocalDateTime ldt2=LocalDateTime.now();
		ZonedDateTime zdt=ldt2.atZone(ZoneId.of("Europe/Tallinn"));//得到带时区的时间
		System.out.println(zdt);
	}
	@Test
	public void test3() {
		Set<String> set=ZoneId.getAvailableZoneIds();//得到所有的时区
		set.forEach(System.out::println);
	}
	//DateTimeFormatter::格式化时间、日期
	@Test
	public void test2() {
		DateTimeFormatter dtf=DateTimeFormatter.ISO_DATE;
		LocalDateTime ldt=LocalDateTime.now();
		
		String strDate=ldt.format(dtf);
		System.out.println(strDate);
		
		System.out.println("----------------------");
		//自定义时间格式(时间转换为字符串)
		DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String strDate2=dtf2.format(ldt);
		System.out.println(strDate2);
		//字符串转换为时间格式
		LocalDateTime newDate=ldt.parse(strDate2,dtf2);
		System.out.println(newDate);
	}
//TemporalAdjuster01:时间矫正器
	@Test
	public void test1() {
		//获取系统当前时间
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ldt2=ldt.withDayOfMonth(10);
		System.out.println(ldt2);
	
		LocalDateTime ldt3=ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(ldt3);
		
		//自定义：下一个工作日
		LocalDateTime ldt5=ldt.with((l)->{
			LocalDateTime ldt4=(LocalDateTime)l;
			DayOfWeek dow=ldt4.getDayOfWeek();
			if(dow.equals(DayOfWeek.FRIDAY)) {
				return ldt4.plusDays(3);
			}else if(dow.equals(DayOfWeek.SATURDAY)) {
				return ldt4.plusDays(2);
			}else {
				return ldt4.plusDays(1);
			}
		});
		
		System.out.println(ldt5);
	}
}
