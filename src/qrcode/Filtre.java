package qrcode;

import java.io.File;
import javax.swing.filechooser.FileFilter;


public class Filtre extends FileFilter {

	private String[] extensions;
	private String description;
	
	/**
	 * Constructeur de FiltreXML
	 * 
	 * @param String[] extensions
	 * 		Les extensions de fichiers autoris�es
	 * @param String description
	 * 		Courte description de l'ensemble des extensions autoris�es
	 * */
	public Filtre( String[] extensions, String description ){
		this.extensions =   extensions;	
		this.description = description;
	}
	
	/**
	* Un getter
	*/
	public String getDescription(){
		return this.description;
	}
	
	/** 
	 * M�thode qui v�rifie si une extension appartient � celles autoris�es (pr�sentes dans un tableau)
	 * 
	 * @param String extension
	 * 		Extension � v�rifier
	 * 
	 * @return boolean
	 * 		Si l'extension appartient ou non � celles autoris�es
	 */
	public boolean appartient( String extension ){
	
		for (int i = 0; i < extensions.length; i++ )
			if ( extension.equals( extensions[ i ] ) )
					return true;
		
		return false;
	
	}
	
	/**
	 * M�thode provenant de la classe FileFilter
	 * V�rifie si le fichier en param�tre est un r�pertoire ou qu'il soit autoris�
	 * 
	 * @param File fichier
	 * 		Fichier � tester
	 * 
	 * @return boolean
	 * 		Si le fichier peut �tre utilis�
	 * */
	public boolean accept( File fichier ){
	
		String suffixe, fileName;
		int i;
		
		if ( fichier.isDirectory() )
			return true;
		
		suffixe = null;
		fileName = fichier.getName();
		i = fileName.lastIndexOf('.');
		
		if ( i > 0 && i < fileName.length() - 1 )
			suffixe = fileName.substring( i + 1 ).toLowerCase();
		
		return suffixe != null && appartient( suffixe );
	
	}

}
