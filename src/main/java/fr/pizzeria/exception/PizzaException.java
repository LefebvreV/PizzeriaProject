package fr.pizzeria.exception;

/**
 * Exception g�n�rale
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
