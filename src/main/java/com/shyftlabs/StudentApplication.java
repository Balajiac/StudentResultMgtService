package com.shyftlabs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableTransactionManagement
//@EnableJpaRepositories("com.shyftlabs.repository")
//@PropertySource("classpath:database.properties")
public class StudentApplication {

	private static Log logger = LogFactory.getLog(StudentApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StudentApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200")
				.allowedMethods("GET","POST","DELETE");
			}
		};
	}


}
