package com.proyecto.practicas.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailEstudiantilValidation implements  ConstraintValidator<EmailInstitucional, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
		return value.endsWith("@tecnocomfenalco.edu.co");
	}

}
