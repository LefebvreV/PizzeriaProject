package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Valentin Lefebvre
 *
 */
public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		
		IPizzaDao pizza = new PizzaMemDao();
		
		Scanner choixUtilisateur = new Scanner(System.in); 
		System.out.println(afficherMenu());
		String choixTemp = choixUtilisateur.nextLine();
		int choix = Integer.parseInt(choixTemp);
		
		do{
			switch(choix){
				case 1: 
					System.out.println("Liste des pizzas");
					for(Pizza pizzaTemp:pizza.findAllPizzas())
						System.out.println(pizzaTemp.toString());
				break;
				
				case 2: 
					System.out.println("Ajout d'une nouvelle pizza");
					System.out.println("Veuillez saisir le code :");
					String code = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nom (sans espace) :");
					String nom = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le type parmi :" + CategoriePizza.values());
					String type = choixUtilisateur.nextLine().toUpperCase();
					CategoriePizza categorie = CategoriePizza.valueOf(type);
					
					System.out.println("Veuillez saisir le prix :");
					String prixTemp = choixUtilisateur.nextLine();
					double prix = Double.parseDouble(prixTemp);
					
					pizza.saveNewPizza(new Pizza(code,nom,categorie,prix));
				break;
				
				case 3: 
					System.out.println("Mise à jour d'une pizza");
					System.out.println("Liste des pizzas");
					for(Pizza pizzaTemp:pizza.findAllPizzas())
						System.out.println(pizzaTemp.toString());
			
					System.out.println("Veuillez choisir le code de la pizza à modifier :");
					String codeModif = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nouveau code :");
					String newCode = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nouveau type parmi :" + CategoriePizza.values());
					String newType = choixUtilisateur.nextLine().toUpperCase();
					CategoriePizza newCategorie = CategoriePizza.valueOf(newType);
					
					System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
					String newNom = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nouveau prix :");
					String newPrixTemp = choixUtilisateur.nextLine();
					double newPrix = Double.parseDouble(newPrixTemp);
					
					pizza.updatePizza(codeModif, new Pizza(newCode,newNom,newCategorie, newPrix));
					
				break;
				
				case 4: 
					System.out.println("Suppresion d'une pizza");
					System.out.println("Liste des pizzas");
					for(Pizza pizzaTemp:pizza.findAllPizzas())
						System.out.println(pizzaTemp.toString());
					System.out.println("Veuillez choisir le code de la pizza à supprimer :");
					String codeSupprimer = choixUtilisateur.nextLine();
					
					pizza.deletePizza(codeSupprimer);
				break;
				
				case 99: System.out.println("Aurevoir ☹");
				break;
			}
			
			if(choix!=99){
				System.out.println(afficherMenu());
				choixTemp = choixUtilisateur.nextLine();
				choix = Integer.parseInt(choixTemp);	
			}
						
		}while(choix!=99);
		
		choixUtilisateur.close();
	}
	
	/**
	 * Méthode pour afficher le menu
	 * @return menu
	 */
	private static String afficherMenu(){
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
