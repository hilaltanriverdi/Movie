package com.example;

import com.infoowl.Task2Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Task2Application.class)
@WebAppConfiguration
public class Task2ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
