/*
 * Created on Aug 24, 2007 by wyatt
 */
package org.homeunix.thecave.buddi.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;

import org.homeunix.thecave.buddi.i18n.keys.BudgetCategoryTypes;
import org.homeunix.thecave.buddi.model.impl.ModelFactory;
import org.homeunix.thecave.moss.util.DateFunctions;
import org.junit.Test;



public class BudgetCategoryTest {
	
	@Test
	public void testBudgetCategory(){
		try {
			BudgetCategoryType bct = ModelFactory.getBudgetCategoryType(BudgetCategoryTypes.BUDGET_CATEGORY_TYPE_MONTH);
			BudgetCategory bc = ModelFactory.createBudgetCategory("Test", bct, false);
			bc.setAmount(DateFunctions.getDate(2007, Calendar.APRIL, 1), 100);
			bc.setAmount(DateFunctions.getDate(2007, Calendar.MAY, 1), 200);
			bc.setAmount(DateFunctions.getDate(2007, Calendar.JUNE, 1), 240);
			bc.setAmount(DateFunctions.getDate(2007, Calendar.JULY, 1), 10);
			bc.setAmount(DateFunctions.getDate(2007, Calendar.AUGUST, 1), 130);
			bc.setAmount(DateFunctions.getDate(2007, Calendar.SEPTEMBER, 1), 13);
			bc.setAmount(DateFunctions.getDate(2007, Calendar.OCTOBER, 1), 333);
			bc.setAmount(DateFunctions.getDate(2007, Calendar.NOVEMBER, 1), 331);
			
			assertEquals((double) 100, bc.getAmount(DateFunctions.getDate(2007, Calendar.APRIL, 1)), 1);
			assertEquals((double) 100, bc.getAmount(DateFunctions.getDate(2007, Calendar.APRIL, 10)), 1);
			assertEquals((double) 100, bc.getAmount(DateFunctions.getDate(2007, Calendar.APRIL, 28)), 1);
			
			assertEquals((double) 300, bc.getAmount(DateFunctions.getDate(2007, Calendar.APRIL, 1), DateFunctions.getDate(2007, Calendar.MAY, 31)), 1);
			assertEquals((double) 147, bc.getAmount(DateFunctions.getDate(2007, Calendar.APRIL, 15), DateFunctions.getDate(2007, Calendar.MAY, 15)), 1);
			
		}
		catch (Exception e){
			fail("Exception: " + e);
		}
	}
	
}