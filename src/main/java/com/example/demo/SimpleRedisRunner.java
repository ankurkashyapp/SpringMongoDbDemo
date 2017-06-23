package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleRedisRunner implements CommandLineRunner {

	@Autowired
	StringRedisTemplate redistemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(jdbcTemplate);
		ValueOperations<String, String> operations = redistemplate.opsForValue();
		operations.set("foo", "bar");
		System.out.println(operations.get("foo"));
	}

}
