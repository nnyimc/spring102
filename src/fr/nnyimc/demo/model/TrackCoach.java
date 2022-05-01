package fr.nnyimc.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.nnyimc.demo.service.WeatherService;

@Component("newCoach")
public class TrackCoach implements Coach {
	
	@Autowired
	@Qualifier("randomWeatherService")
	private WeatherService weatherService;
	
	public TrackCoach() {
		
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Run 25 minutes!";
	}

	@Override
	public String getDailyWeather() {
		return weatherService.getWeather();
	}

}
