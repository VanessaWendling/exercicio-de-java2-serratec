package br.org.serratec.projeto02.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.org.serratec.projeto02.exception.EnumValidationException;

public enum Categoria {
	SEDAN, HATCH, SUV, CONVERSÍVEL, MINIVAN, PICAPE;
	
	@JsonCreator
	public static Categoria verificar(String valor) throws EnumValidationException {
		for(Categoria categoria : values()) {
			if (valor.equals(categoria)) {
				return categoria;
			}
		}
		throw new EnumValidationException ("Categoria Inválida");
	}
}
