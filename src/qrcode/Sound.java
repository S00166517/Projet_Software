package qrcode;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



/*
 * Cette class doit jouer un son en fonction des directions
 */





public class Sound {
	
	
	public Sound(){
			
		}
	
	
	public void delayfor(int n)
	{
		try {
		    Thread.sleep(n * 1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}

}
	
	
	/*
	 * Method is passed a sound flag it will play that sound there is only one
	 * currently supported. To use this sound - call new playit(SOUND);
	 */
	public void playit(String soundRequired) {
		String fn = null;
		File sound; 
        URL location = Sound.class.getProtectionDomain().getCodeSource().getLocation();
        
        System.out.println(location.getFile());
		switch (soundRequired) {
			case "BUILDING_A":
				fn = location.getFile() + "../src/ressources/case A.wav";
				break;
				
			case "BUILDING_B":
				fn = location.getFile() + "../src/ressources/case B.wav";
				break;
				
			case "BUILDING_C":
				fn = location.getFile() + "../src/ressources/Case C & D.wav";
				break;
				
			case "BUILDING_D":
				fn = location.getFile() + "../src/ressources/Case C & D.wav";
				break;
				
			case "BUILDING_E":
				fn = location.getFile() + "../src/ressources/Case E.wav";
				break;
				
			case "BUILDING_F":
				fn = location.getFile() + "../src/ressources/Case F.wav";
				break;
				
			case "BUILDING_DEFAULT":
				fn = location.getFile() + "../src/ressources/defaultBuilding.wav";
				break;
				
			case "SAME_FLOOR":
				fn = location.getFile() + "../src/ressources/Case 0.wav";
				break;
				
			case "FIRST_FLOOR":
				fn = location.getFile() + "../src/ressources/Case 1.wav";
				break;
				
			case "SECOND_FLOOR":
				fn = location.getFile() + "../src/ressources/Case 2.wav";
				break;
				
			case "FLOOR_DEFAULT":
				fn = location.getFile() + "../src/ressources/defaultFloor.wav";
				break;
				
			case "ROOM_006":
				fn = location.getFile() + "../src/ressources/Case 006 & 007.wav";
				break;
				
			case "ROOM_007":
				fn = location.getFile() + "../src/ressourcesCase 006 & 007.wav";
				break;
				
			case "ROOM_003":
				fn = location.getFile() + "../src/ressourcesCase 003.wav";
				break;
				
			case "ROOM_004":
				fn = location.getFile() + "../src/ressources/Case 004.wav";
				break;
				
			case "ROOM_DEFAULT":
				fn = location.getFile() + "../src/ressources/defaultRoom.wav";
				break;
	
			default:
				break;
	
			}

		// Go for it!
		try {
			// Open an audio input stream.
			sound = new File(fn);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// plays
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
