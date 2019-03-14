/**
 * 
 */
package com.oup.ae.integration.materialmaster.exception;

import org.springframework.stereotype.Component;

/**
 * @author gunakalc
 *
 */
@Component("validationException")
public class ValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ValidationException(){
		super();
	}
	
	public ValidationException(String message){
		super(message);
	}
	
	

}
