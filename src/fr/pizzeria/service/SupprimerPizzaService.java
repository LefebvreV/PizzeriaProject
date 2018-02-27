package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.console.*;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaService extends MenuService {

	Scanner choixUtilisateur = new Scanner(System.in); 
	
	@Override
	public void executeUC(IPizzaDao pizzaDao) throws DeletePizzaException{
		System.out.println("Suppresion d'une pizza");
		System.out.println("Liste des pizzas");
		for(Pizza pizzaTemp:pizzaDao.findAllPizzas())
			System.out.println(pizzaTemp.toString());
		System.out.println("Veuillez choisir le code de la pizza � supprimer :");
		String codeSupprimer = choixUtilisateur.nextLine();
		if(codeSupprimer.isEmpty()){
			throw new DeletePizzaException("Le code est vide");
		}else if(!pizzaDao.pizzaExists(codeSupprimer)){
			throw new DeletePizzaException("La pizza n'existe pas");
		}
		pizzaDao.deletePizza(codeSupprimer);
		
	}

}
