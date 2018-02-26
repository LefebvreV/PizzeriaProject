package fr.pizzeria.exception;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class UpdatePizzaException extends PizzaException{
	
	public UpdatePizzaException(){	
	}
	
	public UpdatePizzaException(String man){
		super(man);
	}
}