package fr.pizzeria.exception;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class PizzaException extends Exception{
	
	public PizzaException(){
	}
	
	public PizzaException(String man){
		super(man);
	}

}
