package com.example.restservice.greeting;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/saludos")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		 LocalTime ahora = LocalTime.now();
		 DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		 String horaActual = ahora.format(formatoHora);
		 String saludo ="";
		 
		 if (ahora.isBefore(LocalTime.of(12, 0))) {
		 		saludo=    "Buenos días, son las " + horaActual;
	     } else if (ahora.isBefore(LocalTime.of(18, 0))) {
	        	saludo=    "Buenas tardes, son las " + horaActual;
	     } else {
	        	saludo=    "Buenas noches, son las " + horaActual;
	     }		 	 
		return new Greeting(counter.incrementAndGet(), String.format(template, name)  , saludo ,  horaActual  );
	}
}
