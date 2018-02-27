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
			case 1: 
				mS = new ListerPizzaService();
			break;
			
			case 2: 
				mS = new AjouterPizzaService();
			break;
			
			case 3: 
				mS = new ModifierPizzaService();
			break;
			
			case 4: 
				mS = new SupprimerPizzaService();
			break;
			
			default: 
				throw new PizzaException("Erreur, mauvais choix de menu");
		}
		
		return mS;
	}
}
