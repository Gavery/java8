package Date.day_11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 传统的时间是线程不安全的
 * 现在java8中的是线程安全的，因为当不同线程访问它时，它都是返回一个新的实例
 */
public class TestSimpleDateFormat {
public static void main(String[] args) throws Exception{
	//SimpleDateFormat sdf=new SimpleDateFormat("yyyMMdd");原先的是线程不安全的
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMdd");
	Callable<LocalDate> task=new Callable<LocalDate>() {

		@Override
		public LocalDate call() throws Exception {
			// TODO Auto-generated method stub
			return LocalDate.parse("20161218",dtf);
		}
		
	};
	ExecutorService pool=Executors.newFixedThreadPool(10);//创建一个线程池
	List<Future<LocalDate>> results=new ArrayList<>();
	for (int i = 0; i < 10; i++) {
		results.add(pool.submit(task));
	}
	for (Future<LocalDate> future:results) {
		System.out.println(future.get());
	}
	pool.shutdown();
}
}
