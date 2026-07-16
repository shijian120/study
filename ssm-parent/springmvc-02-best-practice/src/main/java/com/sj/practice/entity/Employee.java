package com.sj.practice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 
 @NotNull	任意类型（Object）	不能为 null，但可以是空字符串 "" 或空集合。	传入的 ID、外键字段。
 
 @NotEmpty	String、Collection、Map、Array	不能为 null，且 长度/大小 > 0。
 （" " 空格字符串算有内容，不会报错）。	校验 List 参数不能为空数组。
 
 @NotBlank	仅限 String	不能为 null，且 trim() 后长度 > 0。
 （" " 全是空格会报错！）。	用户姓名、标题、内容等必填文本字段。
 
 💡 实战口诀：校验字符串请无脑用 @NotBlank，它最严格；
    校验集合/数组用 @NotEmpty；
    只校验 null 用 @NotNull。
 */

@Schema(description = "员工")
@Data
public class Employee {
	
	@Schema(description = "员工ID")
	private Integer id;
	
	@Schema(description = "员工名称")
	@NotBlank(message = "名称不能为空")
	private String name;
	
	
	@NotNull(message = "年龄不能为空")
	@Min(value = 18, message = "年龄不能小于18")
	@Max(value = 150, message = "年龄不能超过150")
	private Integer age;
	
	@Email(message = "邮箱格式不正确")
	private String email;
	
	@Pattern(regexp = "^[男女]$", message = "性别只能是男或女")
	private String gender;
	private String address;
	private BigDecimal salary;
}
