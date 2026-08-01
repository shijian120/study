package com.sj.service;

import com.sj.entity.MyUser.MyUser;
import com.sj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * spring-security 实现认证的流程很复杂
 * <p>
 * 总之会调用到  UserDetailsService 中的 loadUserByUsername 进行认证
 * <p>
 * 这里懒得写实现,就不写了, 应该能看到吧
 *
 * 注意: 我们应该将这个SecurityUserDetailService 放入到容器中, 替换掉容器中默认的
 *
 * 可以实现 UserDetailsService, 也可以实现 UserDetailsManager
 */
@Service
public class SecurityUserDetailService /*implements UserDetailsService */ {
	
	// @Autowired
	// UserMapper userMapper;
	//
	// @Override
	// public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// 	MyUser myUser = userMapper.selectByUsername(username);
	// 	// 转换 myUser -> UserDetails
	// 	UserDetails user = User.builder()
	// 			                   .username(myUser.getUserName())     // 用户名
	// 			                   .password(myUser.getUserPass())     // 密码
	// 			                   .roles("USER")                      // USER-普通用户角色，ADMIN-管理员角色
	// 			                   .build();
	// 	return user;
	// }
}
