package fr.pizzeria.service;

import java.util.Scanner;
import fr.pizzeria.console.*;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class AjouterPizzaService extends MenuService {
	
	Scanner choixUtilisateur = new Scanner(System.in); 

	@Override
	public void executeUC(IPizzaDao pizzaDao) throws SavePizzaException {
		
		//Acquisition et test du code
		System.out.println("Ajout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code :");
		String code = choixUtilisateur.nextLine();
		if(code.isEmpty()){
			throw new SavePizzaException("Le code est vide");
		}
		
		//Acquisition et test du nom
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String nom = choixUtilisateur.nextLine();
		if(nom.isEmpty()){
			throw new SavePizzaException("Le nom est vide");
		}
		
		//Acquisition et test de la categorie de pizza
		String s="";
		for(CategoriePizza c : CategoriePizza.values()){
			s += c.getType() + " ";
		}
		System.out.println("Veuillez saisir le type parmi :" + s);
		String type = choixUtilisateur.nextLine().toUpperCase();
		if(type.isEmpty()){
			throw new SavePizzaException("Le type est vide");
		}
		boolean categorieExist = false;
		for(CategoriePizza typePizza : CategoriePizza.values()){
			if(type.equals(typePizza.toString())){
				categorieExist = true;
			}
		}
		if(!categorieExist)
			throw new SavePizzaException("La catégorie de pizza n'existe pas");
		CategoriePizza categorie = CategoriePizza.valueOf(type);
		
		//Acquisition et test du prix
		System.out.println("Veuillez saisir le prix :");
		String prixTemp = choixUtilisateur.nextLine();
		if(prixTemp.isEmpty()){
			throw new SavePizzaException("Le prix est vide");
		}
		double prix = Double.parseDouble(prixTemp);
		
		pizzaDao.saveNewPizza(new Pizza(code,nom,categorie,prix));
		
	}

}