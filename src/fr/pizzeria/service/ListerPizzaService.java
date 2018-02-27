package fr.pizzeria.service;

import fr.pizzeria.console.*;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class ListerPizzaService extends MenuService {

	@Override
	public void executeUC(IPizzaDao pizzaDao) {
		System.out.println("Liste des pizzas");
		for(Pizza pizzaTemp:pizzaDao.findAllPizzas())
			System.out.println(pizzaTemp.toString());
	}

}