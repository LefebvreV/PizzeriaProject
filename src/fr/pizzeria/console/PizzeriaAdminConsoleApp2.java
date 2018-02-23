package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp2 {

private static ArrayList<Pizza> listPizza; 
	
	public static void main(String[] args) {
		listPizza = new ArrayList<Pizza>();
		listPizza.add(new Pizza(0,"PEP","Pépéroni",12.50));
		listPizza.add(new Pizza(1,"MAR","Margherita",14.00));
		listPizza.add(new Pizza(2,"REIN","La reine",11.50));
		listPizza.add(new Pizza(3,"FRO","La 4 formages",12.00));
		listPizza.add(new Pizza(4,"CAN","La cannibale",12.50));
		listPizza.add(new Pizza(5,"SAV","La savoyarde",13.00));
		listPizza.add( new Pizza(6,"ORI","L'orientale",13.50));
		listPizza.add( new Pizza(7,"IND","L'indienne",14.00));
		
		Scanner choixUtilisateur = new Scanner(System.in); 
		System.out.println(afficherMenu());
		String choixTemp = choixUtilisateur.nextLine();
		int choix = Integer.parseInt(choixTemp);
		
		do{
			switch(choix){
				case 1: 
					System.out.println("Liste des pizzas");
					for(int i=0; i<listPizza.size();i++)
						System.out.println(listPizza.get(i).toString());
				
				break;
				
				case 2: 
					System.out.println("Ajout d'une nouvelle pizza");
					System.out.println("Veuillez saisir le code :");
					String code = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nom (sans espace) :");
					String nom = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le prix :");
					String prixTemp = choixUtilisateur.nextLine();
					double prix = Double.parseDouble(prixTemp);
					
					listPizza.add(new Pizza(code,nom,prix));
				break;
				
				case 3: 
					System.out.println("Mise à jour d'une pizza");
					System.out.println("Liste des pizzas");
					for(int i=0; i<listPizza.size();i++)
						System.out.println(listPizza.get(i).toString());
			
					System.out.println("Veuillez choisir le code de la pizza à modifier :");
					String codeModif = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nouveau code :");
					String newCode = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
					String newNom = choixUtilisateur.nextLine();
					
					System.out.println("Veuillez saisir le nouveau prix :");
					String newPrixTemp = choixUtilisateur.nextLine();
					double newPrix = Double.parseDouble(newPrixTemp);
					
					for(int i=0; i <listPizza.size();i++){
						if(listPizza.get(i).getCode().equals(codeModif)){
							listPizza.get(i).setCode(newCode);
							listPizza.get(i).setLibelle(newNom);
							listPizza.get(i).setPrix(newPrix);
							break;
						}
					}
				break;
				
				case 4: 
					System.out.println("Suppresion d'une pizza");
					System.out.println("Liste des pizzas");
					for(int i=0; i<listPizza.size();i++)
						System.out.println(listPizza.get(i).toString());
					
					System.out.println("Veuillez choisir le code de la pizza à supprimer :");
					String codeSupprimer = choixUtilisateur.nextLine();
					
					for(int i=0; i <listPizza.size();i++){
						if(listPizza.get(i).getCode().equals(codeSupprimer)){
							listPizza.remove(i);
						}
					}
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
