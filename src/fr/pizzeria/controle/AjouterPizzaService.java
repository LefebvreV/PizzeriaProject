package fr.pizzeria.controle;

import java.util.Scanner;
import fr.pizzeria.console.*;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class AjouterPizzaService extends MenuService {
	
	Scanner choixUtilisateur = new Scanner(System.in); 

	@Override
	void executeUC(IPizzaDao pizzaDao) throws SavePizzaException {
		System.out.println("Ajout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code :");
		String code = choixUtilisateur.nextLine();
		if(code.isEmpty()){
			throw new SavePizzaException("Le code est vide");
		}
		
		System.out.println("Veuillez saisir le nom (sans espace) :");
		String nom = choixUtilisateur.nextLine();
		if(nom.isEmpty()){
			throw new SavePizzaException("Le nom est vide");
		}
		
		System.out.println("Veuillez saisir le prix :");
		String prixTemp = choixUtilisateur.nextLine();
		if(prixTemp.isEmpty()){
			throw new SavePizzaException("Le prix est vide");
		}
		double prix = Double.parseDouble(prixTemp);
		
		pizzaDao.saveNewPizza(new Pizza(code,nom,prix));
		
	}

}