package fr.pizzeria.exception;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class SavePizzaException extends PizzaException{
	
	public SavePizzaException(){
	}
	
	public SavePizzaException(String man){
		super(man);
	}
}
