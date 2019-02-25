package com.usermanagement;

import com.usermanagement.dao.entity.Person;
import com.usermanagement.services.PersonService;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableMongoRepositories("com.usermanagement.dao.repo")
@EnableSwagger2
public class UserManagementApplication {

	@Autowired
	private PersonService service;

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
	}


	/*
	* Add Sample Data
	*
	* */
	@Bean
	CommandLineRunner init() {
		return args -> {

			service.save(new Person( "", "Ahmet", "Hamdi", "5145454345", "ahmet.hamdi@hellom.com"));
			service.save(new Person( "", "Kemal", "Tahir", "5143544334", "kemal.tahir@hellom.com"));
			service.save(new Person( "", "Peyami", "Safa", "5143455454", "peyami.safa@hellom.com"));

		};

	}

	/*
	* Dozer Bean Mapper COnfiguration
	*
	* */
	@Bean
	public Mapper mapper() {
		return new DozerBeanMapper();
	}



	/*
	 * Swagger Configuration
	 *
	 * */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.usermanagement.controller"))
				.paths(PathSelectors.any())
				.build().pathMapping("/").apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("User Management API through Swagger UI").version("1.0").license("(C) Copyright Test")
				.description("User Management API Rest Web Services");
		return builder.build();
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/");
		bean.setSuffix(".html");

		return bean;
	}

}
