package com.Ayush.SpringAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAssignmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringAssignmentApplication.class, args);
		ApplicationContext context = SpringApplication.run(SpringAssignmentApplication.class);
		Car car = context.getBean(Car.class);
		car.H();
		String [] beanName = context.getBeanDefinitionNames();
		for (String bean: beanName){
			System.out.println(bean);
		}
	}
}
