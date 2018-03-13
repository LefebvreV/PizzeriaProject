package fr.pizzeria.exception;

/**
 * Exception pour l'ajout d'une pizza
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
