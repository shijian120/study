package com.sj.controller;

import com.sj.Bean.Product;
import com.sj.Bean.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 测试页面请求
 *
 *
 * 总结:
 *  前端如果发送的是  url?k=v
 *         直接通过 @RequestParam 来接收即可, 可以直接写方法的参数列表, 或者直接写pojo
 *
 *  前端如果发送的json 使用 @RequestBody 来接收, 接收的参数必须是 pojo
 *
 *
 */

@Slf4j
@RestController
public class RequestTestController {
	
	/*
	前端通过 get 请求 url 传递参数, 后端可以直接接受
	如果前端没有携带,参数, 此时会被封装成 null ,和 @RequestParam 的 required = false 功能一样
	
	但是 @RequestParam 默认的 required 属性值是 true ,如果前端没有传递,会出现错误
	因此需要添加 required = false ,表示可不带此参数
	
	@RequestParam 的好处就是, 明确了前端传递的参数是什么, 传递的参数必须是 username, password, phone, agree
	如果前端没有传递,parameters 参数, 后端会报错
	
	 */
	@GetMapping("/test01")
	public String test01(String username,
	                     String password,
	                     String phone,
	                     boolean agree) {
		
		log.info("username: {}, password: {}, phone: {}, agree: {}", username, password, phone, agree);
		
		
		return "成功!!!!";
	}
	
	/*
	@RequestParam 注解:
	  默认使用 @RequestParam 的注解 ,必须携带参数
	  如果不携带,需要指定 required = false ,表示可不带此参数
	  
	 defaultValue 参数不携带,有默认值, 此时其实可以不写 required = false
	 
	 
	 @RequestParam 不仅可以获取 get请求的请求参数, 如果是post请求方式,同样可以获取请求参数
	  
	 */
	@GetMapping("/test02")
	public String test02(@RequestParam("username") String username,
	                     @RequestParam("password") String password,
	                     @RequestParam(value = "phone", defaultValue = "12345") String phoneNumber,
	                     @RequestParam(value = "agree", required = false) boolean agree) {
		
		log.info("username: {}, password: {}, phone: {}, agree: {}", username, password, phoneNumber, agree);
		
		
		return "成功!!!!";
	}
	
	
	/*
		通过pojo封装
		
		如果前端发送的请求是  url?k=v&k=v的形式,  @RequestBody 不用写
		但是如果前端发送的请求是 json 格式, 那么就需要使用 @RequestBody 来封装
		
		也就说,前端发送的json数据,才需要使用 @RequestBody
		如果前端发送的数据在请求体中,但是是 k=v的形式,是不需要使用 @RequestBody 的
	 */
	@PostMapping("/test03")
	public String test02(@RequestBody User user) {
		
		log.info("user: {}", user);
		
		
		return "封装成 bean";
	}
	
	
	// 获取请求头
	/*
	这种写法默认也是 必须携带请求头, 如果不携带,会出现错误
	如果请求头不携带, 可以使用  required = false 来指定 不必须携带
	 */
	@GetMapping("/test04")
	public String test04(@RequestHeader("Host") String host,
	                     @RequestHeader("User-Agent") String userAgent) {
		
		log.info("host: {}, userAgent: {}", host, userAgent);
		
		
		return "获取请求头";
	}
	
	// 获取cookie
	@GetMapping("/test05")
	public String test05(@CookieValue("JSESSIONID") String sessionId) {
		
		log.info("sessionId: {}", sessionId);
		
		return "获取cookie: " + sessionId;
	}
	
	
	// 级联封装
	@PostMapping("/test06")
	public String test06(@RequestBody User user) {
		log.info("user: {}", user);
		return "封装成 bean" + user;
	}
	
	
	// @RequestBody  取出请求体的json数据, 自动封装成 Product对象
	/*
	 前端传递的是 json数据, 其实也是字符串, json 字符串
	 @RequestBody 注解, 首先会解析 json 字符串, 接着将 json字符串转换成 product对象
	 
	 因此其实 我们通过 string 接受也是可以的, 相当于获取到json字符串, 之后可以自己转换
	
	
	 */
	@PostMapping("/test07")
	public String test07(@RequestBody Product product) {
		log.info("user: {}", product);
		return "封装成 bean: " + product;
	}
	
	
	// 文件上传
	// spring 对文件上传有限制, 最大不能超过 1MB, 通过配置文件可以修改这个限制
	// 配置为 spring.servlet.multipart.max-file-size 和 spring.servlet.multipart.max-request-size
	// 也可以使用 @RequestPart 来接收
	@PostMapping("/test08")
	public String test08(@RequestParam("file") MultipartFile file, @RequestParam("description") String desc) {
		log.info("desc: {}", desc);
		log.info("file: {}", file);
		
		// 原始文件名
		String originalFilename = file.getOriginalFilename();
		// 文件大小
		long size = file.getSize();
		
		log.info("originalFilename: {}, size: {}", originalFilename, size);
		
		// 存储到当前项目下
		try {
			file.transferTo(new File(originalFilename != null ? originalFilename : null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "文件上传";
	}
	
	
	// 通过 HttpEntity 封装请求体, 包含请求头 + 请求体
	// 泛型是 <String> ,表示请求体是字符串类型
	@PostMapping("/test09")
	public String test09(HttpEntity<String> httpEntity) {
		
		// 请求头
		HttpHeaders headers = httpEntity.getHeaders();
		
		// 请求体
		String body = httpEntity.getBody();
		
		log.info("headers:{}",headers);
		log.info("body:{}", body);
		
		
		return "请求的数据" + headers + "/n" + body;
	}
	
	
	// 原生servlet Api
	@GetMapping("/test10")
	public void test10(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		
		log.info("request: {}", request);
		log.info("response: {}", response);
		
		response.getWriter().write("原生servlet Api");
	}
}
