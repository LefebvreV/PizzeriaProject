package fr.pizzeria.model;

public class Pizza {
	
	/** id : int */
	public int id;
	/** code : String */
	public String code;
	/** libelle : String */
	public String libelle;
	/** prix : double */
	public double prix;
	/** type : CategoriePizza */
	public CategoriePizza type;
	/** compteur : int */
	private static int compteur=0;

	public Pizza(String code, String libelle, CategoriePizza type, double prix) {
		this.id = compteur++;
		this.code = code;
		this.libelle = libelle;
		this.type = type;
		this.prix = prix;
	}

	public Pizza(int id, String code, String libelle, CategoriePizza type, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.type = type;
		this.prix = prix;
		compteur++;
	}



	/**
	 * Getter 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter 
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * Setter
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * Getter 
	 * @return the type
	 */
	public CategoriePizza getType() {
		return type;
	}

	/**
	 * Setter
	 * @param type the type to set
	 */
	public void setType(CategoriePizza type) {
		this.type = type;
	}

	/**
	 * Getter qui retourne le compteur
	 * @return int
	 */
	public static int getCompteur() {
		return compteur;
	}

	/**
	 * Setter modifié du compteur
	 */
	public static void modifCompteur() {
		compteur--;
	}
	
	@Override 
	public String toString(){
		String pizza = this.code + " -> " + this.libelle + " - " + this.type.getType()  + " (" + this.prix + " \u20ac)";
		return pizza;
	}

}
