package qrcode;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Main {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws WriterException, IOException, NotFoundException {
		
		Map hintMap = new HashMap();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		Window fen = new Window();
		boolean ok = true;
		
		
		
		while(true){
			QR qr = new QR();
			Room room = new Room();
			Directions direction = new Directions();
			Sound sound = new Sound();
			boolean valid;
			boolean permission;
			
			fen.setQrIcon(new ImageIcon("qrcodeaccueil.png"));
			JLabel qrImage2 = new JLabel(fen.getQrIcon());
			fen.getContentPane().add(qrImage2, BorderLayout.WEST);
			
			System.out.println("fen " + fen.getQrIcon());
			
			
			
			
			
			
			permission = fen.getPermission();
			System.out.println(permission);
			//while no permission
			while(permission != true){
				//we do nothing
				permission = fen.getPermission();
			}
			System.out.println(permission);
			fen.setPermission(false);
			
			
			qr.openFile();
			
			
			
			
			qr.readQRCode(qr.getPath(), hintMap);
			//room.get(qr.getGrCodeData());
			
			//If the room's format is correct we set up the direction text
			valid = direction.validate(room.get(qr.getGrCodeData()));
			if(valid == false){
				System.out.println("The directions to this room are unknown");
				sound.playit("ROOM_DEFAULT");
				ok = false;
				fen.setPermission(false);
			}
			else{
				direction.displayText();
				ok = true;
			}
			
			
			fen.getContentPane().removeAll();


			
			//ImageIcon image = new ImageIcon(qr.getPath());
			fen.setQrIcon( new ImageIcon(qr.getPath()));
			JLabel qrImage = new JLabel(fen.getQrIcon());
			fen.getContentPane().add(qrImage, BorderLayout.WEST);
			
			
			System.out.println("path " + qr.getPath());
			System.out.println("name " + qr.getName());
			System.out.println("fen " + fen.getQrIcon());
			
			
			
			//We set up the direction label in the window
			String texto = "<html><span><u>DIRECTION for room: " + room.get(qr.getGrCodeData()) + "</u><br><br>" + direction.getBuildingDisp() + "<br><br>" + direction.getFloorDisp() + "<br><br>" + direction.getLocationDisp() + "</span></html>";
			fen.setDirection(texto);
			
			
			fen.getContentPane().add(fen.getDirection(), BorderLayout.CENTER);
			JLabel logoIT = new JLabel(fen.getLogoIT());
			fen.getContentPane().add(logoIT, BorderLayout.NORTH);
			
			JPanel south = new JPanel();
		    south.add(fen.getBouton());
			fen.getContentPane().add(south, BorderLayout.SOUTH);
			
			fen.setContentPane(fen.getContentPane());
			//We play the direction Information's sounds
			
			if(ok == true){
				sound.playit(direction.getBuildingSound());
				sound.delayfor(direction.getBDelay());
				if(!direction.getBuildingSound().equals("BUILDING_DEFAULT")){
					sound.playit(direction.getFloorSound());
					sound.delayfor(direction.getFDelay());
					if(!direction.getFloorSound().equals("FLOOR_DEFAULT")){
						sound.playit(direction.getLocationSound());
						sound.delayfor(direction.getLDelay());
						
					}
				}
			}
		}
	}

}
