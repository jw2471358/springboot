package com.example.demo.h2;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class H2Runner implements ApplicationRunner {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Connection conn = dataSource.getConnection();
		System.out.println("connection="+conn);
		String url = conn.getMetaData().getURL();
		System.out.println("url="+url);
		String userNm = conn.getMetaData().getUserName();
		System.out.println("userNm="+userNm);
		Statement statement = conn.createStatement();
//		String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ID) )";
		String sql = "CREATE TABLE IF NOT EXISTS members "
				+ "( m_num bigint(5) NOT NULL AUTO_INCREMENT"
				+ ", name varchar(100) NOT NULL"
				+ ", age int(3) NOT NULL"
				+ ", PRIMARY KEY (m_num) ) ";
		statement.executeUpdate(sql);
		
		sql = "create table student("
			+ "	   id integer not null,"
			+ "	   name varchar(255) not null,"
			+ "	   passport_number varchar(255) not null,"
			+ "	   primary key(id)"
			+ "	); ";
		statement.executeUpdate(sql);
		
//		jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'H2USER')");
		jdbcTemplate.execute("INSERT INTO members (m_num, name, age) VALUES (1, 'rubin', 7), (2, 'ruahn', 6)");
		
		jdbcTemplate.execute("insert into student values(10001,'Ranga', 'E1234567'); insert into student values(10002,'Ravi', 'A1234568'); ");
		
		CrudMembers crudMembers = new CrudMembers();
		crudMembers.findAll();
	}

}
