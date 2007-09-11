/*
 * Created on Aug 26, 2007 by wyatt
 */
package org.homeunix.thecave.buddi.model.impl;

import java.util.Date;

import org.homeunix.thecave.buddi.i18n.keys.BudgetCategoryTypes;
import org.homeunix.thecave.buddi.model.BudgetCategoryType;
import org.homeunix.thecave.moss.util.DateFunctions;

/**
 * Definition of a Monthly BudgetCategoryType.
 *  
 * @author wyatt
 *
 */
public class BudgetCategoryTypeMonthly extends BudgetCategoryType {
	
	public Date getStartOfBudgetPeriod(Date date) {
		return DateFunctions.getStartOfMonth(date);
	}
	
	public Date getEndOfBudgetPeriod(Date date) {
		return DateFunctions.getEndOfMonth(date);
	}
	
	public Date getBudgetPeriodOffset(Date date, int offset) {
		return getStartOfBudgetPeriod(DateFunctions.addMonths(DateFunctions.getStartOfMonth(date), 1 * offset));
	}
	
	public long getDaysInPeriod(Date date) {
		return DateFunctions.getDaysInMonth(date);
	}
	
	public String getDateFormat() {
		return "MMM yyyy";
	}
			
	public String getName() {
		return BudgetCategoryTypes.BUDGET_CATEGORY_TYPE_MONTH.toString();
	}
}