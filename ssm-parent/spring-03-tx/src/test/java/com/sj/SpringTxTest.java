package com.sj;

import com.sj.bean.Book;
import com.sj.dao.BookDao;
import com.sj.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * ClassName: SpringTxTest
 * Package:
 * Description:
 *
 * @Author shijian
 * @Create 2026/7/12 19:51
 * @Version 1.0
 */

@SpringBootTest
public class SpringTxTest {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	UserService userService;
	
    @Test
    public void test(){
        userService.checkoutPlus("lisi",2,2);
    }
}
