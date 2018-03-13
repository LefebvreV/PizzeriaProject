package fr.pizzeria.service;

import fr.pizzeria.exception.PizzaException;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class MenuServiceFactory {
	
	static MenuService mS;
	
	/**
	 *  Méthode oriantant l'utilisateur selon son choix de menu
	 * @param choix
	 * @return MenuService
	 * @throws PizzaException
	 */
	public static MenuService execute(int choix) throws PizzaException{
		switch(choix){
			//Afficher les pizzas existantes
			case 1: 
				mS = new ListerPizzaService();
			break;
			
			//Ajouter une nouvelle pizza
			case 2: 
				mS = new AjouterPizzaService();
			break;
			
			//Modifier une pizza existante
			case 3: 
				mS = new ModifierPizzaService();
			break;
			
			//Supprimer une pizza existante
			case 4: 
				mS = new SupprimerPizzaService();
			break;
			
			//Générer un pdf avec la liste des pizzas
			case 5: 
				mS = new GenererPDFService();
			break;
			
			default: 
				throw new PizzaException("Erreur, mauvais choix de menu");
		}
		
		return mS;
	}
}
