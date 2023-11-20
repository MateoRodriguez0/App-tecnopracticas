package com.proyecto.practicas.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VerificationCode {

	@NotEmpty
	private String email;
	
	@NotNull
	@Min(value = 6)
	@Max(value = 6)
	private Integer codigo;

	
}