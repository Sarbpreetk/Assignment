package com.example.game;

import com.example.game.beans.BoxWrapper;
import com.example.game.util.GameUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableAutoConfiguration
public class GameApplication{


	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);

	}
	@Bean
	public BoxWrapper boxWrapper(){
		return (new BoxWrapper());
	}

	@Bean
	public GameUtil gameUtil(){
		return (new GameUtil());
	}



}
