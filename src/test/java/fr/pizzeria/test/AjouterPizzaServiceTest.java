package fr.pizzeria.test;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.console.IPizzaDao;
import fr.pizzeria.console.PizzaMemDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.service.AjouterPizzaService;

public class AjouterPizzaServiceTest {

	
	/** Création d'une "Rule" qui va permettre
	* de substituer le System.in utilisé par le Scanner
	* par un mock: systemInMock */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	
	@Test
	public void testExecuteUC() {
		IPizzaDao dao = new PizzaMemDao(); 
		AjouterPizzaService menu = new AjouterPizzaService();
		systemInMock.provideLines("POP","Poporoni", "VIANDE","12.50");
		
		try{
			menu.executeUC(dao);
		}catch(SavePizzaException e){
			System.out.println(e.getMessage());
		}
		
		assertEquals(9, dao.findAllPizzas().size());
		assertEquals("POP", dao.findPizzaByCode("POP").getCode());
		assertEquals("Poporoni", dao.findPizzaByCode("POP").getLibelle());
		assertEquals(12.50, dao.findPizzaByCode("POP").getPrix(),0.0);
		assertEquals(CategoriePizza.VIANDE, dao.findPizzaByCode("POP").getType());
	}
	
	@Test (expected = SavePizzaException.class)
	public void testExecuteUCExceptionVide() throws SavePizzaException{
		IPizzaDao dao = new PizzaMemDao(); 
		AjouterPizzaService menu = new AjouterPizzaService();
		systemInMock.provideLines("PEP","Pépéroni", "","12.50");
		menu.executeUC(dao);
	}
	
	@Test (expected = SavePizzaException.class)
	public void testExecuteUCExceptionAutreValeur() throws SavePizzaException{
		IPizzaDao dao = new PizzaMemDao(); 
		AjouterPizzaService menu = new AjouterPizzaService();
		systemInMock.provideLines("36","46", "VIANDE","coucou");
		menu.executeUC(dao);
	}

}
