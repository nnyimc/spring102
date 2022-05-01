package fr.nnyimc.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import fr.nnyimc.demo.model.BalletCoach;
import fr.nnyimc.demo.model.Coach;
import fr.nnyimc.demo.service.DatabaseWeatherService;
import fr.nnyimc.demo.service.WeatherService;

@Configuration
@ComponentScan("fr.nnyimc.demo")
@PropertySource("classpath:sports.properties")
public class BalletConfig {

	// Mandatory for Spring version < 4.3, in order to print out values imported
	// from property files
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {

		return new PropertySourcesPlaceholderConfigurer();
	}

	@Value("${ballet.email}")
	private String email;

	@Value("${ballet.team}")
	private String team;

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Bean
	public WeatherService getDatabaseWeatherService() {
		return new DatabaseWeatherService();
	}

	@Bean
	public Coach balletCoach() {
		BalletCoach balletCoach = new BalletCoach(getDatabaseWeatherService());
		return balletCoach;
	}

}
