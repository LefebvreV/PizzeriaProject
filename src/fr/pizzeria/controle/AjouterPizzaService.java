package fr.pizzeria.controle;

import java.util.Scanner;

import fr.pizzeria.console.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {
	
	Scanner choixUtilisateur = new Scanner(System.in); 

	@Override
	void executeUC(PizzaMemDao pizzaDao) {
		System.out.println("Ajout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code :");
		String code = choixUtilisateur.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String nom = choixUtilisateur.nextLine();
		
		System.out.println("Veuillez saisir le prix :");
		String prixTemp = choixUtilisateur.nextLine();
		double prix = Double.parseDouble(prixTemp);
		
		pizzaDao.saveNewPizza(new Pizza(code,nom,prix));
		
	}

}