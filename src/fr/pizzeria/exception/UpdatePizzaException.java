package fr.pizzeria.exception;

/**
 * Exception pour la modification d'une pizza
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