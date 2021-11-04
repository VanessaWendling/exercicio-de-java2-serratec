package br.org.serratec.projeto02.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	//sobrescrevemos o método para tratar do nosso jeito
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		/*		podemos fazer
		 * return super.handleExceptionInternal (ex, ex, headers, status, request);
		 */
		
		//adicionamos essa lista de erro
		List<String> erros = new ArrayList<String>();
		for (FieldError erro : ex.getBindingResult().getFieldErrors()) {
			erros.add(erro.getField() + " : " + erro.getDefaultMessage());
		}
		
		//trocamos o return 
		ErroResposta erroResposta= new ErroResposta(status.value(), "Existem Campos inválidos", LocalDateTime.now(), erros);
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}
	/*
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable (HttpMessageNotReadableException ex,
			HttpHeaders headers */
}
