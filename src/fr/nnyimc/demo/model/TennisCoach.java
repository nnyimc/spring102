package fr.nnyimc.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.nnyimc.demo.service.WeatherService;

@Component
public class TennisCoach implements Coach {
	
	private WeatherService weatherService;
	
	@Value("${tennis.email}")
	private String email;
	
	@Value("${tennis.team}")
	private String team;
	
	@Autowired
	public TennisCoach(@Qualifier("RESTWeatherService") WeatherService weatherService ) {
		this.weatherService = weatherService;
	}
	
	public String getEmail() {
		return email;
	}


	public String getTeam() {
		return team;
	}



	@Override
	public String getDailyWorkOut() {
		return "Practive your backhand volley for 20 minutes!!";
	}

	@Override
	public String getDailyWeather() {
		return weatherService.getWeather();
	}

}
