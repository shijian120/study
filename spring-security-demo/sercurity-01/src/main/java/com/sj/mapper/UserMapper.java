package com.sj.mapper;

import com.sj.entity.MyUser.MyUser;

/**
 * ClassName: UserMapper
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/31 20:36
 * @Version 1.0
 */

public interface UserMapper {
	public MyUser selectByUsername(String username);
}
