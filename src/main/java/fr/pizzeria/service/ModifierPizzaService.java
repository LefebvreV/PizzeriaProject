package fr.pizzeria.service;

import java.util.Scanner;
import fr.pizzeria.console.*;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Service pour modifier une pizza existante
 * @author Valentin Lefebvre
 *
 */
public class ModifierPizzaService extends MenuService {

	Scanner choixUtilisateur = new Scanner(System.in); 
	
	@Override
	public void executeUC(IPizzaDao pizzaDao) throws UpdatePizzaException{
		//Affichage de la liste existante
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Liste des pizzas");
		if(pizzaDao.findAllPizzas() == null)
			throw new UpdatePizzaException("La liste renvoyé par findAllPizzas est null");
		for(Pizza pizzaTemp:pizzaDao.findAllPizzas()){
			if (pizzaTemp == null)
				throw new UpdatePizzaException("Une des pizza retourné est null");
			System.out.println(pizzaTemp.toString());
		}
			
		//Acquisition et test du code de la pizza à modifier
		System.out.println("Veuillez choisir le code de la pizza à modifier :");
		String codeModif = choixUtilisateur.nextLine();
		if(codeModif.isEmpty()){
			throw new UpdatePizzaException("Le code est vide");
		}else if(!pizzaDao.pizzaExists(codeModif)){
			throw new UpdatePizzaException("La pizza n'existe pas");
		}
		
		//Acquisition et test du nouveau code
		System.out.println("Veuillez saisir le nouveau code :");
		String newCode = choixUtilisateur.nextLine();
		if(newCode.isEmpty()){
			throw new UpdatePizzaException("Le code est vide");
		}
		
		//Acquisition et test du nouveau nom
		System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
		String newNom = choixUtilisateur.nextLine();
		if(newNom.isEmpty()){
			throw new UpdatePizzaException("Le nom est vide");
		}
		
		//Acquisition et test de la nouvelle catégorie
		String s="";
		for(CategoriePizza c : CategoriePizza.values()){
			s += c.getType() + " ";
		}
		System.out.println("Veuillez saisir le type parmi :" + s);
		String newType = choixUtilisateur.nextLine().toUpperCase();
		if(newType.isEmpty()){
			throw new UpdatePizzaException("Le type est vide");
		}
		boolean categorieExist = false;
		for(CategoriePizza typePizza : CategoriePizza.values()){
			if(newType.equals(typePizza.toString())){
				categorieExist = true;
			}
		}
		if(!categorieExist)
			throw new UpdatePizzaException("La catégorie de pizza n'existe pas");
		
		CategoriePizza newCategorie = CategoriePizza.valueOf(newType);
		
		//Acquisition et test du nouveau prix
		System.out.println("Veuillez saisir le nouveau prix :");
		String newPrixTemp = choixUtilisateur.nextLine();
		if(newPrixTemp.isEmpty()){
			throw new UpdatePizzaException("Le prix est vide");
		}
		double newPrix = Double.parseDouble(newPrixTemp);
		
		pizzaDao.updatePizza(codeModif, new Pizza(newCode,newNom,newCategorie,newPrix));
		
	}

}