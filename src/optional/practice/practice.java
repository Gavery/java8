package optional.practice;

import java.util.Optional;

import org.junit.Test;

public class practice {
/*
 * Optional实践
 */
	@Test
	public void test() {
		Optional<Godness> gn=Optional.ofNullable(new Godness("高嘉银"));
		Optional<NewMan> op=Optional.ofNullable(new NewMan(gn));
		String str=getGodnewssName(op);
		System.out.println(str);
	}
	public String getGodnewssName(Optional<NewMan> man) {
		return man.orElse(new NewMan())//这一步表示如果传过来的man参数为null的话就默认new 一个新的对象
				.getGodness()//这一步不可能出现null的情况，因为上面已经做了处理
				.orElse(new Godness("廖立晴"))
				.getName();
	}
}
