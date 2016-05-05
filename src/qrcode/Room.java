package qrcode;

/*
 * Cette classe doit:
 * 		retourner la valeur de la room
 */


public class Room {
	private String room;
	
	
 	public Room(){
		
	}
	
 	
 	
 	
 	//Doit prendre le Data de l'objet QR et retourne la room
 	public String get(String data)
	{
		
		String delims = "[ \n]";
		String[] tokens;
		int i = 0;
		boolean temp;
	
		tokens = data.split(delims);

		temp = tokens[i].equals("Room:");
		
		
		do{
			temp = tokens[i].equals("Room:");
			i++;
		}while(temp!=true);
	
		room = tokens[i];

		return(room);
	}

}
