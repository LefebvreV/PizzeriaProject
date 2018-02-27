package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans_Viande");
	
	private String type;
	
	/**
	 * Constructeur
	 * @param type
	 */
	private CategoriePizza(String type){
		this.type = type;
	}
	
	/**
	 * M�thode pour r�cup�rer le type de pizza
	 * @return le type de pizza (String)
	 */
	public String getType(){
		return type;
	}
}
