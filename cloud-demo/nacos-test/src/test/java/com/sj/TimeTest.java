package com.sj;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Set;

/**
 * ClassName: TimeTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/5/24 16:09
 * @Version 1.0
 */

public class TimeTest {
	
	
	
	/*
	计算2个时间相差的 天数,小时数,纳秒数 .....
	 */
	@Test
	public void testDuration(){
		Instant now = Instant.now();
		Instant now1 = Instant.now();
		
		Duration between = Duration.between(now, now1);
		int nano = between.getNano();
		System.out.println(nano); // 2000 , 这个值会变
		
	}
	
	/*
	Period 可以计算 LocalDate 对象的 相差的 年数月数天数的
	 */
	@Test
	public void testPeriod(){
		LocalDate localDate = LocalDate.of(2022, 12, 12);
		LocalDate now = LocalDate.now();
		Period between = Period.between(now, localDate);
		System.out.println(between); // P-3Y-5M-12D  这个应该是 负值
		Period between1 = Period.between(localDate, now);
		System.out.println(between1); // P3Y5M12D  3年5月12天
		
		
		
	}
	
	
	/**
	 * 线程安全
	 */
	@Test
	public void testDateTimeFormatter() {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern(
				"yyyy年MM月dd日 HH:mm:ss"
		).toFormatter(Locale.CHINESE);
		
		Instant now = Instant.now();
		
		String format = formatter.format(now.atZone(ZoneId.systemDefault()));
		System.out.println(format);
	}
	
	
	@Test
	public void test() {
		
		long now0 = System.currentTimeMillis();
		LocalDateTime now1 = LocalDateTime.now();
		Instant now2 = Instant.now();
		
		System.out.println(now0); // 1779610233206
		
		System.out.println(now1); // 2026-05-24T16:10:33.230386
		
		System.out.println(now2); // 2026-05-24T08:10:33.230542Z
		
		
	}
	
	/**
	 * instant 瞬时时间
	 * <p>
	 * Date 只能精确到毫秒, Instant精确到纳秒
	 */
	@Test
	public void instantTest1() {
		Instant now = Instant.now();
		System.out.println(now);  // 2026-05-24T12:25:45.253841Z
		
		
		// 获取 总秒数
		long epochSecond = now.getEpochSecond();  // 1779625545
		
		System.out.println(epochSecond);
		
		int nano = now.getNano();
		System.out.println(nano);  // 253841000
		
		// + 1 s
		Instant instant = now.plusSeconds(1);
		System.out.println(instant);
		
	}
	
	
	@Test
	public void instantTest() {
		Instant now = Instant.now(); // 当前UTC时刻
		
		// 1. 指定目标时区（例如北京时间）
		ZoneId zone = ZoneId.of("Asia/Shanghai");
		
		// 2. 定义中文日期时间格式
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss")
				                              .withLocale(Locale.CHINESE); // 确保星期、月份等词为中文（本模式没有，但可以加）
		
		// 3. 转换并格式化
		String formatted = formatter.format(now.atZone(zone));
		System.out.println(formatted); // 输出类似：2026年05月24日 15:30:45
	}
	
	@Test
	public void zoneIdTest() {
		
		/*
		ZoneId 就代表时区
		 */
		
		
		// 获取 可见的时区
		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
		// 总共有 603个, 为什么这么多? 不是应该有24个时区吗?
		// 应该是 有些国家, 他不像中国一样, 全国就一个时区, 有些国家有多个时区
		System.out.println(availableZoneIds.size()); // 603
		System.out.println(availableZoneIds); // 打印所有 603个时区
		
		// 得到系统的默认时区, 中国就是   Asia/Shanghai
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println(zoneId); // Asia/Shanghai
		System.out.println(zoneId.getId()); // Asia/Shanghai
		
		// 根据时区封装 ZoneId
		ZoneId zoneId1 = ZoneId.of("America/New_York");
		
		String id = zoneId1.getId();
		System.out.println(id); // America/New_York
		
		// 不填写默认时区,就是 Asia/Shanghai
		ZonedDateTime now1 = ZonedDateTime.now();
		System.out.println(now1);  // 2026-05-24T18:25:20.324096+08:00[Asia/Shanghai]
		
		
		// 根据默认时区获取方法
		ZonedDateTime now2 = ZonedDateTime.now(ZoneId.systemDefault());
		System.out.println(now2);  // 2026-05-24T18:25:20.324096+08:00[Asia/Shanghai]
		
		
		// 按照时区获取当前时间爱你
		ZonedDateTime now3 = ZonedDateTime.now(zoneId1);
		// 可以看到 美国纽约时间和中国上海时间 相差12个小时, 美国时间比中国时间早12个小时
		// 本初子午线是 0点, 中国就是 8点, 美国纽约就是 前一天 20点
		// 20点到到24点正好 4个小时, 因此 相差就是12个小时
		System.out.println(now3);  // 2026-05-24T06:25:20.324269-04:00[America/New_York]
		
		
		// 获取世界标准时间
		ZonedDateTime now = ZonedDateTime.now(Clock.systemUTC());
		// 这个时间 就是 我们 Asia/Shanghai 的时间 减去 8小时
		System.out.println(now);
		
		
	}
	
	@Test
	public void test1111() {
		// 类不能用 反射也不行,需要加参数
		// StaticProperty
		
	}
}
