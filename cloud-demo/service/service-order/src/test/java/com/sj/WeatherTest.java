package com.sj;

import com.sj.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: WeatherTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2025/2/27 16:07
 * @Version 1.0
 */

@SpringBootTest
public class WeatherTest {
	
	@Autowired
	WeatherFeignClient weatherFeignClient;
	
	@Test
	void testWeather(){
		String weatherAboutFangShan = weatherFeignClient.getWeatherAboutFangShan(
				"APPCODE 93b7e19861a24c519a7548b17dc16d75",
				"50b53ff8dd7d9fa320d3d3ca32cf8ed1",
				"14");
		
		System.out.println(weatherAboutFangShan);
	}
}
