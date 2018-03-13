package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class PizzaTxtDao implements IPizzaDao{

	/**
	 * Pour le moment, aucune différences avec PizzaMemDao
	 */
private List<Pizza> listPizza;
	
	/**
	 * Constructeur PizzaTextDao avec une liste de pizza initiale
	 */
	public PizzaTxtDao(){
		listPizza = new ArrayList<>();
		listPizza.add(new Pizza(0,"PEP","Pépéroni", CategoriePizza.VIANDE,12.50));
		listPizza.add(new Pizza(1,"MAR","Margherita",CategoriePizza.SANS_VIANDE,14.00));
		listPizza.add(new Pizza(2,"REIN","La reine",CategoriePizza.POISSON, 11.50));
		listPizza.add(new Pizza(3,"FRO","La 4 formages",CategoriePizza.SANS_VIANDE,12.00));
		listPizza.add(new Pizza(4,"CAN","La cannibale",CategoriePizza.VIANDE,12.50));
		listPizza.add(new Pizza(5,"SAV","La savoyarde", CategoriePizza.VIANDE,13.00));
		listPizza.add( new Pizza(6,"NOR","La nordique",CategoriePizza.POISSON,13.50));
		listPizza.add( new Pizza(7,"IND","L'indienne", CategoriePizza.VIANDE, 14.00)); 
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		listPizza.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		listPizza.set(listPizza.indexOf(findPizzaByCode(codePizza)), pizza);	
	}

	@Override
	public void deletePizza(String codePizza) {
		listPizza.remove(listPizza.indexOf(findPizzaByCode(codePizza)));
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		Pizza pizza=null;
		for(int i=0; i <listPizza.size();i++){
			if(listPizza.get(i).getCode().equals(codePizza)){
				pizza=listPizza.get(i);
				break;
			}
		}
		return pizza;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		if(findPizzaByCode(codePizza)!=null)
			return true;
		return false;
	}
}
