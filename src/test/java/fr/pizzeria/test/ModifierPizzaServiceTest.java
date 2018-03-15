package fr.pizzeria.test;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import fr.pizzeria.console.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.ModifierPizzaService;

public class ModifierPizzaServiceTest {

	/** Création d'une "Rule" qui va permettre
	* de substituer le System.in utilisé par le Scanner
	* par un mock: systemInMock */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	
	@Test (expected = UpdatePizzaException.class)
	public void testExecuteUC() throws UpdatePizzaException{
		IPizzaDao dao = Mockito.mock( IPizzaDao.class);
		
		Mockito.when(dao.findAllPizzas()).thenReturn(null);
		
		ModifierPizzaService menu = new ModifierPizzaService();
		systemInMock.provideLines("PEP","POP","Poporoni", "VIANDE","12.50");
		menu.executeUC(dao);
		
		
	}
	
	@Test (expected = UpdatePizzaException.class)
	public void testExecuteUCIncoherent() throws UpdatePizzaException{
		IPizzaDao dao = Mockito.mock( IPizzaDao.class);
		
		List<Pizza> list = new ArrayList<Pizza>();
		list.add(null);
		list.add(new Pizza(null,"Poporoni",CategoriePizza.VIANDE,12.50));
		
		Mockito.when(dao.findAllPizzas()).thenReturn(list);
		
		ModifierPizzaService menu = new ModifierPizzaService();
		systemInMock.provideLines("PEP","POP","Poporoni", "VIANDE","12.50");
		menu.executeUC(dao);
		
		
	}

}
