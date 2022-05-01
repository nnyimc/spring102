package fr.nnyimc.demo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.nnyimc.demo.model.Coach;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		Coach tennisCoach =  context.getBean("tennisCoach", Coach.class);
		Coach suppleantCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (tennisCoach == suppleantCoach);
		System.out.println("Singleton?: " + result);
		
		Coach trackCoach = context.getBean("newCoach", Coach.class);
		System.out.println(trackCoach.getDailyWeather());
		
		
		context.close();
	}

}
