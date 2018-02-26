package fr.pizzeria.controle;

import fr.pizzeria.console.*;
import fr.pizzeria.exception.PizzaException;

public abstract class MenuService {

	abstract void executeUC(IPizzaDao pizzaDao) throws PizzaException;
}
