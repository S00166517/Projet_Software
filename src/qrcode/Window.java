package qrcode;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;






public class Window extends JFrame implements ActionListener{
	//Instanciation d'un objet JPanel
    private JPanel pan = new JPanel();
    private JButton bouton = new JButton("Choose QRCode");
    //private JPanel container = new JPanel();
    private JLabel direction = new JLabel("<html><u>Direction:</u></html>");
    private ImageIcon qrIcon; // = new ImageIcon("qrcodeaccueil.png");
    
    private ImageIcon logoIT = new ImageIcon("itsligo-logo.png");
    private boolean permission = false;
    
    
    public JButton getBouton(){
    	return bouton;
    }
    
    public ImageIcon getLogoIT(){
    	return logoIT;
    }
    
    public void setQrIcon(ImageIcon image){    	
    	this.qrIcon = image;
    }
    public ImageIcon getQrIcon(){
    	return qrIcon;
    }
    
    public void setDirection(String dir){
    	this.direction.setText(dir);
    }
    
    public JLabel getDirection(){
    	return direction;
    }
   
    
	
	public Window(){
		
		
		this.setTitle("Where is the room");
	    this.setSize(500, 350);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //this.setResizable(false);
	    //this.setLayout(new BorderLayout());
	    
	    pan.setLayout(new BorderLayout());
	    //Nous ajoutons notre fenêtre à la liste des auditeurs de notre bouton
	    bouton.addActionListener(this);
	    
	    
	    //JLabel img = new JLabel( new ImageIcon( "qrcodeaccueil.png"));
	    
	    
	    
	    //setQrIcon(new ImageIcon("qrcodeaccueil.png"));
	    
	    
	    ImageIcon vatefairefoutre = this.getQrIcon();
	    
	    //affiche l'image QRCode à l'ouest
	    JLabel img = new JLabel(vatefairefoutre);
	    //this.getContentPane().add(img, BorderLayout.WEST);	    
	    //img.repaint();
	    
	    
	    img.setIcon(vatefairefoutre);
	  
	    
	    pan.add(img, BorderLayout.WEST);
	    this.repaint();
	   
	   
	    
	    //affiche le logo IT
	    JLabel img2 = new JLabel(logoIT);
	   // this.getContentPane().add(img2, BorderLayout.NORTH);
	    pan.add(img2, BorderLayout.NORTH);

	    //affiche le bouton au sud
	    JPanel south = new JPanel();
	    south.add(bouton);
	    this.getContentPane().add(south, BorderLayout.SOUTH);
	    pan.add(south, BorderLayout.SOUTH);
	    
	    
	    
	    
	    direction.setHorizontalAlignment(JLabel.LEFT);// texte centré
	    direction.setVerticalAlignment(JLabel.NORTH);
	    
	    //this.getContentPane().add(direction, BorderLayout.CENTER); //affiche le label direction
	    pan.add(direction, BorderLayout.CENTER);
	    
	    
	    //On prévient notre JFrame que notre JPanel sera son content pane
	    this.setContentPane(pan); 
	    
	    this.setVisible(true);
	}
	
	
	 public void actionPerformed(ActionEvent arg0){
		//Lorsque l'on clique sur le bouton, on permet la recherche de fichier QR
		 setPermission(true);
		 
	 }
	
	 
	 //Définir et acceder à la variable permition
	 public void setPermission(boolean perm){
		 this.permission = perm;
	 }
	 public boolean getPermission(){
		 return permission;
	 }
}
