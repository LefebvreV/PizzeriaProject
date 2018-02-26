package fr.pizzeria.controle;

import java.util.Scanner;

import fr.pizzeria.console.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	Scanner choixUtilisateur = new Scanner(System.in); 
	
	@Override
	void executeUC(PizzaMemDao pizzaDao) {
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Liste des pizzas");
		for(Pizza pizzaTemp:pizzaDao.findAllPizzas())
			System.out.println(pizzaTemp.toString());

		System.out.println("Veuillez choisir le code de la pizza à modifier :");
		String codeModif = choixUtilisateur.nextLine();
		
		System.out.println("Veuillez saisir le nouveau code :");
		String newCode = choixUtilisateur.nextLine();
		
		System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
		String newNom = choixUtilisateur.nextLine();
		
		System.out.println("Veuillez saisir le nouveau prix :");
		String newPrixTemp = choixUtilisateur.nextLine();
		double newPrix = Double.parseDouble(newPrixTemp);
		
		pizzaDao.updatePizza(codeModif, new Pizza(newCode,newNom,newPrix));
		
	}

}