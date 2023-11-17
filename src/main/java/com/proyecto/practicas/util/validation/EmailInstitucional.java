package com.proyecto.practicas.util.validation;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Constraint(validatedBy = { })
@Target(FIELD)
@Retention(RUNTIME)
public @interface EmailInstitucional {

	
    String message() default "El correo electrónico debe ser institucional";

    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

}
