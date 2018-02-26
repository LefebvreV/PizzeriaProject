package fr.pizzeria.controle;

import fr.pizzeria.console.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzaService extends MenuService {

	@Override
	void executeUC(PizzaMemDao pizzaDao) {
		System.out.println("Liste des pizzas");
		for(Pizza pizzaTemp:pizzaDao.findAllPizzas())
			System.out.println(pizzaTemp.toString());
	}

}