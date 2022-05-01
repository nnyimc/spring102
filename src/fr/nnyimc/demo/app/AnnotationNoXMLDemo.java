package fr.nnyimc.demo.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.nnyimc.demo.config.BalletConfig;
import fr.nnyimc.demo.config.SportConfig;
import fr.nnyimc.demo.model.Coach;

public class AnnotationNoXMLDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach tennisCoach = context.getBean( "tennisCoach", Coach.class );
		System.out.println( tennisCoach.getDailyWeather() );
		System.out.println( tennisCoach.getDailyWorkOut() );
		
		Coach swimCoach = context.getBean( "swimCoach", Coach.class);
		System.out.println( swimCoach.getDailyWorkOut() );
		System.out.println( swimCoach.getDailyWeather() );
		
		context.close();
		
		
		AnnotationConfigApplicationContext balletContext = new AnnotationConfigApplicationContext(BalletConfig.class);
		
		Coach balletCoach = balletContext.getBean( "balletCoach", Coach.class );
		System.out.println( balletCoach.getDailyWorkOut() );
		System.out.println( balletCoach.getDailyWeather() );
		
		balletContext.close();

	}

}
