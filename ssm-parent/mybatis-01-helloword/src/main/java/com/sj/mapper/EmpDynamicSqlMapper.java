package com.sj.mapper;

import com.sj.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
动态sql测试
 */

@Mapper
public interface EmpDynamicSqlMapper {

	// 按照 empName 和 empSalary 查询员工
	List<Emp> selectByEmpNameAndSalary(@Param("empName") String empName, @Param("empSalary") Double emSalary);

	
	
	// 更新员工信息
	int updateEmp(@Param("emp") Emp emp);
	
	
	// 通过 trim 标签 实现  按照员工 name 和 salary 查询员工
	List<Emp> selectByEmpNameAndSalaryByTrimLable(@Param("empName") String empName, @Param("emSalary") Double emSalary);
	
	// forEach 标签  做批量插入
	// 查询指定id的员工
	List<Emp> selectEmpByIdsIn(@Param("ids") List<Integer> ids);
	
	
	// 批量插入
	int insertEmpBatch(@Param("emps") List<Emp> emps);
	
	
	
	// 批量更新
	int updateEmpBatch(@Param("emps") List<Emp> emps);
}
