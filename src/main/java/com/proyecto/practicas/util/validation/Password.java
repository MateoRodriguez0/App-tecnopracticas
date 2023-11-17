package com.proyecto.practicas.util.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = PasswordValidation.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

	String message() default "el campo Contraseña inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};	
}
