package fr.pizzeria.exception;

/**
 * Exception pour le service supprimer
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