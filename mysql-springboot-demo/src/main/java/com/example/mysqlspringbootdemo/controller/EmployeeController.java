package com.example.mysqlspringbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping
	public List<Employee> fetchEmployee() {
		
		
		return jdbcTemplate.query("Select * FROM crash_course.employee", new EmployeeRowMapper());
		
		/*
		
		
		jdbcTemplate.query("Select * FROM crash_course.employee", new RowMapper() {

			@Override
			public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getString("salary"));
				return employee;
			}
		});
		
		*/
	}
	
	@GetMapping("/{id}")
	public List<Employee> fetchEmployeeById(@PathVariable Integer id) {
		
		
		return jdbcTemplate.query("Select * FROM crash_course.employee where id = ?", new EmployeeRowMapper(), id);
		
		/*
		
		
		jdbcTemplate.query("Select * FROM crash_course.employee", new RowMapper() {

			@Override
			public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getString("salary"));
				return employee;
			}
		});
		
		*/
	}
	
	
	@PostMapping
	public Integer saveEmoployee(@RequestBody Employee employee) {
		jdbcTemplate.update("insert into crash_course.employee (id, name, salary) values (?, ?, ?)", employee.getId(), employee.getName(), employee.getSalary());
		return employee.getId();
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Integer id) {
		jdbcTemplate.update("Delete FROM crash_course.employee where id = ?", id);
		return "Record deleted";
	}
	
	
}
