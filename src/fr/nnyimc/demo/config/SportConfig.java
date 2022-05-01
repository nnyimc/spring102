package fr.nnyimc.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import fr.nnyimc.demo.model.Coach;
import fr.nnyimc.demo.model.SwimCoach;
import fr.nnyimc.demo.service.RandomWeatherService;
import fr.nnyimc.demo.service.WeatherService;

@Configuration
@ComponentScan("fr.nnyimc.demo")
@PropertySource("classpath:sports.properties")
public class SportConfig {

	// Mandatory for Spring version < 4.3, in order to print out values imported
	// from property files
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {

		return new PropertySourcesPlaceholderConfigurer();
	}

	@Value("${swim.email}")
	private String email;

	@Value("${swim.team}")
	private String team;

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Bean
	public WeatherService randomWeatherService() {
		return new RandomWeatherService();
	}

	@Bean
	public Coach swimCoach() {
		SwimCoach swimCoach = new SwimCoach();
		swimCoach.setWeatherService(randomWeatherService());
		return swimCoach;
	}

}
