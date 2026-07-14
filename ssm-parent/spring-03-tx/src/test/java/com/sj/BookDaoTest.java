package com.sj;

import com.sj.bean.Book;
import com.sj.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 */

@SpringBootTest
public class BookDaoTest {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BookDao bookDao;
	
	
	
	
	
	// 删除图书
	@Test
	public void testDeleteBook(){
		int i = bookDao.deleteBookById(4);
		System.out.println("受影响的行数:" + i);
		
	}
	
	
	//更新库存
	@Test
	public void testUpdateBook(){
		int i = bookDao.updateBookStock(4, 1);
		System.out.println("受影响的行数:" + i);
		
	}
	
	
	// 新增图书
	@Test
	public void testInsert(){
		bookDao.insert(new Book(null,"《Spring Boot》",100,new BigDecimal("58.6")));
	}
	
	// 按照BookId查询图书
	@Test
	public void testQueryByBookId(){
		
		Book book = bookDao.selectBookById(1);
		System.out.println(book);
		
	}
	
	
	
	
	@Test
	public void testJdbcTemplate(){
		
		System.out.println(jdbcTemplate); // org.springframework.jdbc.core.JdbcTemplate@59b98ad1
		
		
	}
	
	
	// 测试数据源, 底层使用 HikariDataSource
	@Test
	public void test() throws SQLException {
		System.out.println(dataSource);  // HikariDataSource (HikariPool-1)
		
		System.out.println(dataSource.getConnection());  // 证明 Spring 配置文件中数据源配置正确
	}
}
