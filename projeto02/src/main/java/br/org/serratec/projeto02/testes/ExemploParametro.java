package br.org.serratec.projeto02.testes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplo")
public class ExemploParametro {
	
	@GetMapping
	public String parametro(@RequestParam String palavra) {
		return palavra.toLowerCase();
	}

//http://localhost:8080/exemplo/soma?valor1=3&valor2=6
@RequestMapping("/soma")
public Double parametro(@RequestParam Double valor1, @RequestParam Double valor2) {
	return valor1+valor2;
}
//http://localhost:8080/exemplo/subt?valor1=3&valor2=6
@RequestMapping("/subt")
public Double paramet(@RequestParam Double valor1, @RequestParam Double valor2) {
	return valor1-valor2;
}
//http://localhost:8080/exemplo/mult?valor1=3&valor2=6
@RequestMapping("/mult")
public Double param(@RequestParam Double valor1, @RequestParam Double valor2) {
	return valor1*valor2;
}
//http://localhost:8080/exemplo/div?valor1=3&valor2=6
@RequestMapping("/div")
public Double p(@RequestParam Double valor1, @RequestParam Double valor2) {
	return valor1/valor2;
}
	
}
