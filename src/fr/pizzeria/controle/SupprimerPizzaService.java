package fr.pizzeria.controle;

import java.util.Scanner;

import fr.pizzeria.console.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService {

	Scanner choixUtilisateur = new Scanner(System.in); 
	
	@Override
	void executeUC(PizzaMemDao pizzaDao) {
		System.out.println("Suppresion d'une pizza");
		System.out.println("Liste des pizzas");
		for(Pizza pizzaTemp:pizzaDao.findAllPizzas())
			System.out.println(pizzaTemp.toString());
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");
		String codeSupprimer = choixUtilisateur.nextLine();
		
		pizzaDao.deletePizza(codeSupprimer);
		
	}

}
