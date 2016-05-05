package qrcode;

public class Directions {
	private final int ROOM_LENGTH = 5; // size of the room string
	private char building ; //lettre du batiment (A) mis à jour par validate
	private char floor; //chiffre étage (2) mis à jour par validate
	private String locationOnFloor; //numero de salle (003) mis à jour par validate
	
	private String buildingSound = null; 	//Pour savoir quel son building jouer
	private String floorSound = null; 		//Pour savoir quel son floor jouer
	private String locationSound = null;	//Pour savoir quel son building jouer
	
	private String buildingDisp; 	//Texte à afficher
	private String floorDisp; 		//Texte à afficher
	private String locationDisp;	//Texte à afficher
	
	private int bDelay;
	private int fDelay;
	private int rDelay;
	
	public int getBDelay() {
		return bDelay;
	}
	public void setBDelay(int delay) {
		this.bDelay = delay;
	}
	
	public int getFDelay() {
		return fDelay;
	}
	public void setFDelay(int fDelay) {
		this.fDelay = fDelay;
	}
	
	public int getLDelay() {
		return rDelay;
	}
	public void setLDelay(int rDelay) {
		this.rDelay = rDelay;
	}
	

	public void setBuildingSound(String pBuilding){
 		this.buildingSound = pBuilding;
 	}	
 	public String getBuildingSound(){
 		return buildingSound;
 	}
	 	
 	public void setFloorSound(String pFloor){
 		this.floorSound = pFloor;
 	}	
 	public String getFloorSound(){
 		return floorSound;
 	}
 	
 	public void setLocationSound(String pLocation){
 		this.locationSound = pLocation;
 	}	
 	public String getLocationSound(){
 		return locationSound;
 	}
	
	
	
	
	public void setBuildingDisp(String pBuilding){
 		this.buildingDisp = pBuilding;
 	}	
 	public String getBuildingDisp(){
 		return buildingDisp;
 	}
	 	
 	public void setFloorDisp(String pFloor){
 		this.floorDisp = pFloor;
 	}	
 	public String getFloorDisp(){
 		return floorDisp;
 	}
 	
 	public void setLocationDisp(String pLocation){
 		this.locationDisp = pLocation;
 	}	
 	public String getLocationDisp(){
 		return locationDisp;
 	}
	
 	
	
	
	//Définir et acceder à la variable building
 	public void setBuilding(char pBuilding){
 		this.building = pBuilding;
 	}	
 	public char getBuilding(){
 		return building;
 	}
 	
 	//Définir et acceder à la variable floor
 	public void setFloor(char pFloor){
 		this.floor = pFloor;
 	}	
 	public char getFloor(){
 		return floor;
 	}
	 	
 	//Définir et acceder à la variable locaationOnFloor
 	public void setLocationOnFloor(String pLocation){
 		this.locationOnFloor =pLocation;
 	}	
 	public String getLocationOnFloor(){
 		return locationOnFloor;
 	}
 	
 	
 	
 	
 	
 	public boolean validate(String pRoom) {
		if (pRoom.length() != ROOM_LENGTH) {
			return false;
		}
		if (Character.isLetter(pRoom.charAt(0)) == false) {
			return false; // room must start with a letter
		}
		for (int i = 1; i < ROOM_LENGTH; i++) {
			if (Character.isDigit(pRoom.charAt(i)) == false) {
				return false; // room must start with a letter
			}
		}
		
		// all ok - store the info
		setBuilding(pRoom.charAt(0));
		setFloor(pRoom.charAt(1));
		setLocationOnFloor(pRoom.substring(2));
		
		return true;
	}

 	
 	
 	
 	
 	//Met à jour les son à jouer et les text à afficher
 	
 	
 	public void displayText(){
		
		//Building case
		switch (this.getBuilding()) {
			case 'A':
				setBuildingSound("BUILDING_A");
				setBuildingDisp("From reception, walk straight ahead and then turn to your right");				
				setBDelay(6);
				break;
			case 'B':
				// TODO play the sound here for this here
				setBuildingSound("BUILDING_B");
				setBuildingDisp("From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest");
				setBDelay(10);
				break;
			case 'C':
				// TODO play the sound here for this here
				setBuildingSound("BUILDING_C");
				setBuildingDisp("From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and conrinute through long corridor");
				setBDelay(13);
				break;
			case 'D':
				// TODO play the sound here for this here
				setBuildingSound("BUILDING_D");
				setBuildingDisp("From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and conrinute through long corridor");
				setBDelay(13);
				break;
			case 'E':
				// TODO play the sound here for this here
				setBuildingSound("BUILDING_E");
				setBuildingDisp("From reception, move the the centre of reception and turn left into the engineering building");
				setBDelay(7);
				break;
			case 'F':
				// TODO play the sound here for this here
				setBuildingSound("BUILDING_F");
				setBuildingDisp("From reception, walk outside and turn to your right.  Walk past the engineering building and the F block is straigt in front");
				setBDelay(10);
				break;
			default:
				setBuildingSound("BUILDING_DEFAULT");
				setBuildingDisp("Sorry, that building is not recognised");
				setBDelay(4);
				break;
			}
		
		//Floor case
		switch (this.getFloor()) {
			case '0':
				// TODO play the sound here for this here
				setFloorSound("SAME_FLOOR");
				setFloorDisp("Stay on this floor");
				setFDelay(3);
				break;
			case '1':
				// TODO play the sound here for this here
				setFloorSound("FIRST_FLOOR");
				setFloorDisp("Ascend the stairs or take the lift to the first floor");
				setFDelay(5);
				break;
			case '2':
				// TODO play the sound here for this here
				setFloorSound("SECOND_FLOOR");
				setFloorDisp("Ascend two flight of stairs or take the lift to the second floor");
				setFDelay(6);
				break;
			default:
				setFloorSound("FLOOR_DEFAULT");
				setFloorDisp("Sorry, floor " + this.floor + " is not recognised");
				setFDelay(5);
				break;
				
			}
		
		
		//Location case
		switch (this.getLocationOnFloor()) {
			case "006":
				// TODO play the sound here for this here
				setLocationSound("ROOM_006");
				setLocationDisp("This is a room to the right on this level");
				setLDelay(4);
				break;
			case "007":
				// TODO play the sound here for this here
				setLocationSound("ROOM_007");
				setLocationDisp("This is a room to the right on this level");
				setLDelay(4);
				break;
			case "003":
				// TODO play the sound here for this here
				setLocationSound("ROOM_003");
				setLocationDisp("This is the last room to the right on this level");	
				setLDelay(5);
				break;
			case "004":
				// TODO play the sound here for this here
				setLocationSound("ROOM_004");
				setLocationDisp("This is the second last room to the right on this level");	
				setLDelay(5);
				break;
			default:
				setLocationSound("ROOM_DEFAULT");
				setLocationDisp("Sorry, that room in not recognised");
				setLDelay(5);
				break;
			
		}
	}
	
	

}
