package fr.pizzeria.controle;

import java.util.Scanner;
import fr.pizzeria.console.*;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class ModifierPizzaService extends MenuService {

	Scanner choixUtilisateur = new Scanner(System.in); 
	
	@Override
	void executeUC(IPizzaDao pizzaDao) throws UpdatePizzaException{
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Liste des pizzas");
		for(Pizza pizzaTemp:pizzaDao.findAllPizzas())
			System.out.println(pizzaTemp.toString());

		System.out.println("Veuillez choisir le code de la pizza à modifier :");
		String codeModif = choixUtilisateur.nextLine();
		if(codeModif.isEmpty()){
			throw new UpdatePizzaException("Le code est vide");
		}else if(!pizzaDao.pizzaExists(codeModif)){
			throw new UpdatePizzaException("La pizza n'existe pas");
		}
		
		System.out.println("Veuillez saisir le nouveau code :");
		String newCode = choixUtilisateur.nextLine();
		if(newCode.isEmpty()){
			throw new UpdatePizzaException("Le code est vide");
		}
		
		System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
		String newNom = choixUtilisateur.nextLine();
		if(newNom.isEmpty()){
			throw new UpdatePizzaException("Le nom est vide");
		}
		
		System.out.println("Veuillez saisir le nouveau prix :");
		String newPrixTemp = choixUtilisateur.nextLine();
		if(newPrixTemp.isEmpty()){
			throw new UpdatePizzaException("Le prix est vide");
		}
		double newPrix = Double.parseDouble(newPrixTemp);
		
		pizzaDao.updatePizza(codeModif, new Pizza(newCode,newNom,newPrix));
		
	}

}