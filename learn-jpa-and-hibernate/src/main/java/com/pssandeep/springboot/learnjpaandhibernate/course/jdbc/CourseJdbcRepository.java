package com.pssandeep.springboot.learnjpaandhibernate.course.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pssandeep.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	private static String INSERT_QUERY = """
			insert into course values(?,?,?);

			""";
	private static String DELETE_QUERY = """
			delete from course where id = ?;

			""";

	private static String SELECT_QUERY = """
			select * from course where id = ?;

			""";

	private static String SELECT_ALL_QUERY = """
			select * from course;

			""";

	
	public void insert( Course course) {
		
		System.out.println("JDBC Repository - INSERT");
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById( long id) {
		
		System.out.println("JDBC Repository - DELETE");
		springJdbcTemplate.update(DELETE_QUERY, id);
	}

	public Course findByID( long id) {
		
		System.out.println("JDBC Repository - SELECT");
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}

	public List<Course> findAll() {
		
		System.out.println("JDBC Repository - SELECT ALL");
		
		List<Course> courses = new ArrayList<>();
		List<Map<String, Object>> rows = springJdbcTemplate.queryForList(SELECT_ALL_QUERY);
		for(Map row : rows) {
			Course course = new Course();
			course.setId((Long)row.get("id"));
			course.setName((String)row.get("name"));
			course.setAuthor((String)row.get("author"));
			courses.add(course);
		}
		
		return courses;
	}	
}
