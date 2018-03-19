package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.console.IPizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class EnregistrerBDD extends MenuService {

	@Override
	public void executeUC(IPizzaDao pizzaDao) throws PizzaException {
		List<Pizza> listPizza = new ArrayList<>();
		listPizza.add( new Pizza("PEP","Pépéroni", CategoriePizza.VIANDE,12.50));
		listPizza.add( new Pizza("MAR","Margherita",CategoriePizza.SANS_VIANDE,14.00));
		listPizza.add( new Pizza("REIN","La reine",CategoriePizza.POISSON, 11.50));
		listPizza.add( new Pizza("FRO","La 4 formages",CategoriePizza.SANS_VIANDE,12.00));
		listPizza.add( new Pizza("CAN","La cannibale",CategoriePizza.VIANDE,12.50));
		listPizza.add( new Pizza("SAV","La savoyarde", CategoriePizza.VIANDE,13.00));
		listPizza.add( new Pizza("NOR","La nordique",CategoriePizza.POISSON,13.50));
		listPizza.add( new Pizza("IND","L'indienne", CategoriePizza.VIANDE, 14.00)); 

		for(Pizza pizza : listPizza)
			pizzaDao.saveNewPizza(pizza);
	}

}
