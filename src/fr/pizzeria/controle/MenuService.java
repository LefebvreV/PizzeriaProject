package fr.pizzeria.controle;

import fr.pizzeria.console.*;
import fr.pizzeria.exception.PizzaException;

public abstract class MenuService {
	
	/**
	 * Methode absract qui va devoir gerer les différents services.
	 * @param pizzaDao
	 * @throws PizzaException
	 */
	abstract void executeUC(IPizzaDao pizzaDao) throws PizzaException;
}
