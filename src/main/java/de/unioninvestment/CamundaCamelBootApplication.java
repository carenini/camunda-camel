package de.unioninvestment;

import java.io.File;
import java.util.Arrays;

//import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.apache.camel.spring.Main;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


///**
// * @SpringBootApplication is a convenience annotation that adds all of the following:
// *  - @Configuration: Tags the class as a source of bean definitions for the application context.
// *  - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
// *  - @ComponentScan: Tells Spring to look for other components, configurations, and services in the src/main package, letting it find the controllers
// */ 
//@SpringBootApplication
//public class CamundaCamelBootApplication {
//
//	public static void main(String[] args) {
//		SpringApplication application = new SpringApplication(CamundaCamelBootApplication.class);
//		application.setBannerMode(Banner.Mode.CONSOLE);
//		application.setLazyInitialization(false);
//		application.run(args);
//	}
//	
////	@Bean
////	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
////		return args -> {
////
////			System.out.println("Let's inspect the beans provided by Spring Boot:");
////
////			String[] beanNames = ctx.getBeanDefinitionNames();
////			Arrays.sort(beanNames);
////			for (String beanName : beanNames) {
////				System.out.println(beanName);
////			}
////
////		};
////	}
//}


public class CamundaCamelBootApplication {
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		String path = "camel-context.xml";
		File f = new File("./" + path);
		if(f.exists() && !f.isDirectory()) {
            System.out.println("Routes in current directory");
			main.setFileApplicationContextUri("./" + path);
		} else {
            System.out.println("Routes in dedicated directory");
			main.setApplicationContextUri("classpath:/routes/send-to-camel-config.xml");
		}
		main.run();
	}
}

