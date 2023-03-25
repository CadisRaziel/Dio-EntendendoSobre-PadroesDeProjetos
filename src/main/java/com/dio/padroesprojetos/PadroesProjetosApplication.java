package com.dio.padroesprojetos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Modulos desse projeto
//Spring data JPA
//Spring Web
//H2 Database
//OpenFeign

@EnableFeignClients //Habilita o feign no nosso projeto
@SpringBootApplication
public class PadroesProjetosApplication {

	//OBSERVAÇÃO IMPORTANTE
	//OpenFeign -> Para pegar api's externa
	//openApi -> Alternativa ao swagger
	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetosApplication.class, args);
	}

}
