package com.tecnopracticas.gateway.errors;


import java.util.Map;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler; 
import org.springframework.boot.web.error.ErrorAttributeOptions; 
import org.springframework.boot.web.reactive.error.ErrorAttributes; 
import org.springframework.context.ApplicationContext; 
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType; 
import org.springframework.http.codec.ServerCodecConfigurer; 
import org.springframework.stereotype.Component; 
import org.springframework.web.reactive.function.BodyInserters; 
import org.springframework.web.reactive.function.server.RequestPredicates; 
import org.springframework.web.reactive.function.server.RouterFunction; 
import org.springframework.web.reactive.function.server.RouterFunctions; 
import org.springframework.web.reactive.function.server.ServerRequest; 
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import reactor.core.publisher.Mono; 
  
@Component
public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

	public GlobalErrorWebExceptionHandler(ErrorAttributes errorAttributes,
            ApplicationContext applicationContext,
            ServerCodecConfigurer serverCodecConfigurer) {
		
			super(errorAttributes, new WebProperties.Resources(), applicationContext);
			super.setMessageWriters(serverCodecConfigurer.getWriters());
			super.setMessageReaders(serverCodecConfigurer.getReaders());}

	private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
	    ErrorAttributeOptions options = ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE);
	    Map<String, Object> errorPropertiesMap = getErrorAttributes(request, options);
	    Throwable throwable = getError(request);
	    HttpStatusCode httpStatus = determineHttpStatus(throwable);

	    errorPropertiesMap.remove("requestId");
	    errorPropertiesMap.put("status",httpStatus.value());
	    errorPropertiesMap.remove("error");

	    return ServerResponse.status(httpStatus)
	      .contentType(MediaType.APPLICATION_JSON)
	      .body(BodyInserters.fromValue(errorPropertiesMap));
	}

	private HttpStatusCode determineHttpStatus(Throwable throwable) {
	    if (throwable instanceof ResponseStatusException) {
	        return ((ResponseStatusException) throwable).getStatusCode();
	    }
	    else if(throwable instanceof ExpiredJwtException 
	    		|| throwable instanceof MalformedJwtException 
	    		|| throwable instanceof NoTokenHeaderException) {
	        return HttpStatus.UNAUTHORIZED;
	    } else {
	        return HttpStatus.INTERNAL_SERVER_ERROR;
	    }
	}
	
	@Override
	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
		// TODO Auto-generated method stub
		return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
	}
	
	
  
   
} 
