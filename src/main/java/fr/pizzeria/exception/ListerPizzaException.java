package fr.pizzeria.exception;

/**
 * Exception pour le service lister
 * @author Valentin Lefebvre
 *
 */
public class ListerPizzaException extends PizzaException{
	
	public ListerPizzaException(){
	}
	
	public ListerPizzaException(String man){
		super(man);
	}
}