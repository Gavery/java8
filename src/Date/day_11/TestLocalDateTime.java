package Date.day_11;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;

import org.junit.Test;

public class TestLocalDateTime {
	/*
	 * 计算两个时间之间的间隔
	 * Duration：计算两个时间之间的间隔
	 * Period:计算两个日期之间的间隔
	 */
	@Test
	public void test4() {
		LocalDate ld1=LocalDate.of(2015,1,1);
		LocalDate ld2=LocalDate.now();
		Period period=Period.between(ld1, ld2);
		System.out.println(period);//输出的是iso标准格式
		System.out.println(period.getYears());
	}
	@Test
	public void test3() throws InterruptedException {
		Instant ins1=Instant.now();
		Thread.sleep(1000);
		Instant ins2=Instant.now();
		Duration duration=Duration.between(ins1,ins2);
		System.out.println(duration.toMillis());
		System.out.println("--------------------");
		
		LocalTime lt1=LocalTime.now();
		Thread.sleep(1000);
		LocalTime lt2=LocalTime.now();
		System.out.println(Duration.between(lt1, lt2).toMillis());
	}
	/*
	 * 机器读：
	 * Instant:时间戳(以Unix元年：1970年1月1日 00:00:00 到某个时间之间的毫秒值)
	 */
	@Test
	public void test2() {
		Instant ins1=Instant.now();//默认获取UTC时区（和中国差8个时差）
		System.out.println(ins1);
		//现在是带了偏移量的时间,带了8个小时的偏移量（中国）
		OffsetDateTime odt=ins1.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
		//转换为时间戳
		System.out.println(ins1.toEpochMilli());
		//相对于元年进行运算
		Instant ins2=Instant.ofEpochSecond(60);//在元年的基础上加60秒
		System.out.println(ins2);
	}
	/*认读：
	 * localDate 专门表示日期(年月日)
	 * LocalTime 专门表示时间(年月日时分秒)
	 *  LocalDateTime 涵盖了上面的两个
	 */
	@Test
	public void test1() {
		//获取系统当前时间
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ldt);
		//指定一个时间
		LocalDateTime ldt2=LocalDateTime.of(2015, 10, 12, 22,34);
		System.out.println(ldt2);
		//对时间进行加减(会产生一个新的实例)
		LocalDateTime ldt3=ldt.plusYears(2);
		System.out.println(ldt3);
		LocalDateTime ldt4=ldt.minusYears(3);
		System.out.println(ldt4);
		
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
		//获取当前时间的秒数
		System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
		//获取当前时间的毫秒数
		System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
	}
}
