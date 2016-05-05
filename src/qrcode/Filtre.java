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
	 * 		Les extensions de fichiers autorisées
	 * @param String description
	 * 		Courte description de l'ensemble des extensions autorisées
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
	 * Méthode qui vérifie si une extension appartient à celles autorisées (présentes dans un tableau)
	 * 
	 * @param String extension
	 * 		Extension à vérifier
	 * 
	 * @return boolean
	 * 		Si l'extension appartient ou non à celles autorisées
	 */
	public boolean appartient( String extension ){
	
		for (int i = 0; i < extensions.length; i++ )
			if ( extension.equals( extensions[ i ] ) )
					return true;
		
		return false;
	
	}
	
	/**
	 * Méthode provenant de la classe FileFilter
	 * Vérifie si le fichier en paramètre est un répertoire ou qu'il soit autorisé
	 * 
	 * @param File fichier
	 * 		Fichier à tester
	 * 
	 * @return boolean
	 * 		Si le fichier peut être utilisé
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
