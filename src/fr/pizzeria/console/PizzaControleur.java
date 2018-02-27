package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.console.*;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.service.MenuService;
import fr.pizzeria.service.MenuServiceFactory;


public class PizzaControleur {

	
	public static void main(String[] args) {
		
		IPizzaDao pizzaDao = new PizzaMemDao();
		
		Scanner choixUtilisateur = new Scanner(System.in); 
		System.out.println(menu());
		String choixTemp = choixUtilisateur.nextLine();
		int choix = Integer.parseInt(choixTemp);
		
		if(choix!=99)
			do{
			
				
				try {
					MenuService mSF = MenuServiceFactory.execute(choix);
					mSF.executeUC(pizzaDao);
				} catch (PizzaException e) {
					System.err.println(e.getMessage());
				}
				
				if(choix!=99){
					System.out.println(menu());
					choixTemp = choixUtilisateur.nextLine();
					choix = Integer.parseInt(choixTemp);	
				}
				
			}while(choix!=99);
		System.out.println("Aurevoir ☹");
		choixUtilisateur.close();
		
		/*ListerPizzaService lPS = new ListerPizzaService();
		AjouterPizzaService aPS = new AjouterPizzaService();
		ModifierPizzaService mPS = new ModifierPizzaService();
		SupprimerPizzaService sPS = new SupprimerPizzaService();
		
		do{
			switch(choix){
				case 1: 
					lPS.executeUC(pizzaDao);
				break;
				
				case 2: 
					aPS.executeUC(pizzaDao);
				break;
				
				case 3: 
					mPS.executeUC(pizzaDao);
				break;
				
				case 4: 
					sPS.executeUC(pizzaDao);
				break;
				
				case 99: System.out.println("Aurevoir ☹");
				break;
			}
			
			if(choix!=99){
				System.out.println(menu());
				choixTemp = choixUtilisateur.nextLine();
				choix = Integer.parseInt(choixTemp);	
			}
						
		}while(choix!=99);
		choixUtilisateur.close();
		*/
		
	}

	
	/**
	 * Méthode pour afficher le menu
	 * @return menu
	 */
	private static String menu(){
		String menu;
		menu = "\n***** Pizzeria Administration *****\n";
		menu += "1. Lister les pizzas\n";
		menu += "2. Ajouter une nouvelle pizza\n";
		menu += "3. Mettre à jour une pizza\n";
		menu += "4. Supprimer une pizza\n";
		menu += "99. Sortir\n";
		return menu;
	}

}