package fr.pizzeria.exception;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class DeletePizzaException extends PizzaException{
	
	public DeletePizzaException(){
		
		
	}
	
	public DeletePizzaException(String man){
		super(man);
		
	}
}