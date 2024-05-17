package com.tecnopracticas.gateway.security;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class ResponsesServices {

	public ObjectNode DisabledException(){
		ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
		node.put("status", 200);
    	node.put("message","Disabled");
		return node;
	}
	
	public ObjectNode BadCredentialsException(){
		ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
		node.put("status", 200);
    	node.put("message","BadCredentials");
		return node;
	}
	

	public ObjectNode InvalidToken(){
		ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
		node.put("status", 200);
    	node.put("message","InvalidToken");
		return node;
	}
	
	public ObjectNode ExpiredToken(){
		ObjectNode node= new ObjectNode(JsonNodeFactory.instance);
		node.put("status", 200);
    	node.put("message","ExpiredToken");
		return node;
	}
}
