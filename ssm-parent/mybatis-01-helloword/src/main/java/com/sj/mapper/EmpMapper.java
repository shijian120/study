package com.sj.mapper;

import com.sj.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: EmpDao
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/16 14:30
 * @Version 1.0
 */

// 告诉spring 这个mybatis操作数据库用的接口
@Mapper
public interface EmpMapper {
	// 根据id查询员工
	Emp selectById(Integer id);
	// 更新员工信息
	void updateEmpById(Emp emp);

	// 添加员工信息
	void insertEmp(Emp emp);
	
	// 删除员工信息
	void deleteEmpById(Integer id);
}
