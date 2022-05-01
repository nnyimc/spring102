package fr.nnyimc.demo.model;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.nnyimc.demo.service.WeatherService;

@Component
public class SoccerCoach implements Coach {
	
	private WeatherService weatherService;
	
	public SoccerCoach() {}
	
	@PostConstruct
	public void checkBeginTime() {
		System.out.println(LocalDateTime.now());
	}
	
	@PreDestroy
	public void checkEndTime() {
		System.out.println(LocalDateTime.now());
	}
	
    @Autowired
    @Qualifier("databaseWeatherService")
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}


	@Override
	public String getDailyWorkOut() {
		return "Practice kick-offs from 35 meters!";
	}

	@Override
	public String getDailyWeather() {
		return weatherService.getWeather();
	}

}
