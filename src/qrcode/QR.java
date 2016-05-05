package qrcode;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;


/*
 * cette classe doit: 
 * 		ouvrir le choix de fichier QR apres autorisation et enregistrer path et name
 * 		lire le QR code
 * 		enregistrer les données du QR code
 */


public class QR {
	private String path;
	private String name;
	private String qrCodeData;
	
 	public QR(){
		
	}
 	
 	//Définir et acceder à la variable path
 	public void setPath(String pPath){
 		this.path =pPath;
 	}	
 	public String getPath(){
 		return path;
 	}
 	
 	
 	//Définir et acceder à la variable name
 	public void setName(String pName){
 		this.name = pName;
 	}
 	public String getName(){
 		return name;
 	}
 	
 	
 	//Définir et acceder à la variable qrCodeData
 	public void setQrCodeData(String pData){
 		this.qrCodeData = pData;
 	}
 	public String getGrCodeData(){
 		return qrCodeData;
 	}
	
 	//Permet de choisir le fichier QR et enregistre le path et le name
	public void openFile(){
 		String path ="";
 		String name = "";
 		
 		
    	Filtre filtre   = new Filtre( new String[] {"jpg", "png", "gif"}, "fichiers au format image" );
 		JFileChooser chooser = new JFileChooser();
	    chooser.addChoosableFileFilter( filtre );

	    Component bouton = null;
		int retour = chooser.showDialog(bouton , "Charger l'image" );

	    // si l'utilisateur a cliqué sur le bouton "Charger l'image"
	    if ( retour == 	JFileChooser.APPROVE_OPTION ){
		    path = chooser.getSelectedFile().getPath();
		    name = chooser.getSelectedFile().getName();      
 		}

	    setPath(path);
	    setName(name);
	    
 	}

	//Doit prendre le path de l'objet QR et mettre à jour les data de l'objet QR
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void readQRCode(String filePath, Map hintMap)
			   throws FileNotFoundException, IOException, NotFoundException {
		
		  BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
		    new BufferedImageLuminanceSource(
		      ImageIO.read(new FileInputStream(filePath)))));
		  Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,
		    hintMap);
		  
		  setQrCodeData(qrCodeResult.getText());
		 }
		
	
}
