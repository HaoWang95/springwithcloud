package AlanJava.SpringBootStarter;

import AlanJava.SpringBootStarter.startup.MyApplicationDemoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringBootStarterApplicationTests {

	@Autowired
	private MyApplicationDemoController myApplicationDemoController;

	@Test
	void contextLoads() throws Exception {
	}
}
