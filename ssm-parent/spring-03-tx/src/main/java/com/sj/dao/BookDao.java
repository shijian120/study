package com.sj.dao;

import com.sj.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/*
Dao 层, 是和数据库 打交道的,
1. 方法的命名, 应该  以 select ..  insert ..  update .. delete .. 开头, 这样比较规范
2. insert 语句应该 返回 受影响的行数, 或者 插入后返回 id
3. update delete 应该 返回 受影响的行数
 */

@Component
public class BookDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 *  根据 id 查询图书信息
	 * @param id   图书id
	 * @return  返回图书信息
	 */
	public Book selectBookById(Integer id){
		String sql = "select id,bookName,stock,price from book where id = ?";
		Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
		return book;
	}
	
	/**
	 *  插入图书信息
	 * @param book 图书信息
	 */
	public void insert(Book book){
		String sql = "insert into book(bookName,stock,price) values(?,?,?)";
		jdbcTemplate.update(sql,book.getBookName(),book.getStock(),book.getPrice());
	}
	
	// 更新库存,  根据id 更新坤村
	public int updateBookStock(Integer id, Integer stock){
		String sql = "update book set stock = stock -  ? where id = ?";
		// 受影响的行数
		int count = jdbcTemplate.update(sql, stock, id);
		
		return count;
	}
	
	
	// 按照id删除图书
	public int deleteBookById(Integer id){
		String sql = "delete from book where id = ?";
		int update = jdbcTemplate.update(sql, id);
		return update;
	}
	
	
	/*
	更新图书库存
	 */
	
	// public void updateBookStock(Integer id){
	//
	// }
	//
	// public void update  BookPrice(Integer id){
	//
	// }
}
