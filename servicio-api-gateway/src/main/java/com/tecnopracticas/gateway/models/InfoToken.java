package com.tecnopracticas.gateway.models;

import lombok.*;
import java.util.List;
import java.util.UUID;



@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InfoToken  {
	private UUID id;
    private List<String> roles;
}