package fr.pizzeria.service;

import fr.pizzeria.console.*;
import fr.pizzeria.exception.PizzaException;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public abstract class MenuService {
	
	/**
	 * Methode absract qui va devoir gerer les diff�rents services.
	 * @param pizzaDao
	 * @throws PizzaException
	 */
	public abstract void executeUC(IPizzaDao pizzaDao) throws PizzaException;
}
