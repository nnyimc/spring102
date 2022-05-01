package fr.nnyimc.demo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.nnyimc.demo.model.Coach;
import fr.nnyimc.demo.model.TennisCoach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		Coach trackCoach = context.getBean("newCoach", Coach.class);
		System.out.println( trackCoach.getDailyWorkOut() );
		System.out.println( trackCoach.getDailyWeather() );
		
		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println( tennisCoach.getDailyWorkOut() );
		System.out.println( tennisCoach.getDailyWeather() );
		System.out.println( "Contact: " + ((TennisCoach) tennisCoach).getEmail() );
		
		Coach soccerCoach = context.getBean("soccerCoach", Coach.class);
		System.out.println( soccerCoach.getDailyWorkOut() );
		System.out.println( soccerCoach.getDailyWeather() );
		context.close();
		
	}

}
