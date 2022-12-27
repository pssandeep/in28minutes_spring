package com.pssandeep.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	private static String INSERT_QUERY = """
			insert into course values(1,'Learn AWS','in28Minutes');

			""";

	public void insert() {
		
		System.out.println("JDBC Repository - INSERT");
		springJdbcTemplate.update(INSERT_QUERY);
	}

}
