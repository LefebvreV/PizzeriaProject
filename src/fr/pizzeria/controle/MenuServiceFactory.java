package fr.pizzeria.controle;

import fr.pizzeria.exception.PizzaException;

public class MenuServiceFactory {
	
	static MenuService mS;
	
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
			
			case 99: System.out.println("Aurevoir ☹");
			break;
			
			default: 
				throw new PizzaException("Coucou, ça a foiré");
		}
		
		return mS;
	}
}
