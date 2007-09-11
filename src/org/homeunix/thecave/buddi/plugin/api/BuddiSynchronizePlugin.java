/*
 * Created on Sep 14, 2006 by wyatt
 * 
 * The interface which can be extended to create import filters
 */
package org.homeunix.thecave.buddi.plugin.api;

import java.io.File;

import org.homeunix.thecave.buddi.i18n.BuddiKeys;
import org.homeunix.thecave.buddi.plugin.api.exception.PluginException;
import org.homeunix.thecave.buddi.plugin.api.model.MutableDocument;
import org.homeunix.thecave.moss.plugin.MossPlugin;
import org.homeunix.thecave.moss.swing.MossDocumentFrame;

/**
 * The abstract class to extend when creating a synchronize plugin.  The method synchronizeData() 
 * is the one which is called by Buddi when executing the plugin.  In this method,
 * you have access to the main document object, the frame from which the plugin was
 * called, and the file to synchronize with.
 * 
 * @author wyatt
 *
 */
public abstract class BuddiSynchronizePlugin extends BuddiPluginPreference implements MossPlugin {
	
	/**
	 * Imports data as required.  The plugin launch code will prompt for a file
	 * and pass it in (unless you override the isPromptForFile() method to return false).
	 */
	public abstract void synchronizeData(MutableDocument model, MossDocumentFrame callingFrame, File file) throws PluginException;
	
	/**
	 * Return the description which shows up in the file chooser.  By default, this 
	 * is set to "Buddi Import Files".  This value is filtered through the translator
	 * before being displayed.
	 */
	public String getDescription() {
		return BuddiKeys.FILE_DESCRIPTION_BUDDI_SYNCHRONIZE_FILES.toString();
	}
	
	public boolean isPluginActive() {
		return true;
	}
	
	/**
	 * Should Buddi prompt for a file to synchronize?  Defaults to true.  If you know what
	 * the file name is (or you are importing from a different source, such as the 
	 * network), you should override this method and return false. 
	 * @return
	 */
	public boolean isPromptForFile(){
		return true;
	}
	
	/**
	 * Override to specify that Buddi should only include certain file types in 
	 * the file chooser.  This only has an effect if isPromptForFile() is true.  If
	 * you want to do this, return a String array of the file extensions which you wish
	 * to match.  The plugin loader will create a FileFilter for this.
	 * @return
	 */
	public String[] getFileExtensions(){
		return null;
	}
}