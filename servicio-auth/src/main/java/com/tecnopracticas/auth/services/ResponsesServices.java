package com.tecnopracticas.auth.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class ResponsesServices {

	public ResponseEntity<?> DisabledException(){
		ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
		node.put("status", 200);
    	node.put("message","Disabled");
		return ResponseEntity.ok(node);
	}
	
	public ResponseEntity<?> BadCredentialsException(){
		ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
		node.put("status", 200);
    	node.put("message","BadCredentials");
		return ResponseEntity.ok(node);
	}
	

	public ResponseEntity<?> InvalidToken(){
		ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
		node.put("status", 200);
    	node.put("message","InvalidToken");
		return ResponseEntity.ok(node);
	}
	
	public ResponseEntity<?> ExpiredToken(){
		ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
		node.put("status", 200);
    	node.put("message","ExpiredToken");
		return ResponseEntity.ok(node);
	}
}
