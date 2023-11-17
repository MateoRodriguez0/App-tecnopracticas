package com.proyecto.practicas.util.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidation implements ConstraintValidator<Password, String> {

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		
		return password != null && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*");
	}

}