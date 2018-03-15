package fr.pizzeria.service;

import fr.pizzeria.console.*;
import fr.pizzeria.exception.ListerPizzaException;
import fr.pizzeria.model.Pizza;

/**
 * Service pour afficher la liste des pizzas
 * @author Valentin Lefebvre
 *
 */
public class ListerPizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao pizzaDao) throws ListerPizzaException{
		System.out.println("Liste des pizzas");
		if(pizzaDao.findAllPizzas() == null)
			throw new ListerPizzaException("La liste renvoyé par findAllPizzas est null");
		for(Pizza pizzaTemp:pizzaDao.findAllPizzas())
			System.out.println(pizzaTemp.toString());
	}

}