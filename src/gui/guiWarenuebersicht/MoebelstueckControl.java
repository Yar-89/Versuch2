package gui.guiWarenuebersicht;

import java.io.IOException;

import business.Moebelstueck;
import business.MoebelstueckModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class MoebelstueckControl implements Observer {
	private MoebelstueckModel moebelstueckModel; 
	private MoebelstueckView moebelstueckView;
	
	
	public MoebelstueckControl(Stage primaryStage) {
		this.moebelstueckModel = moebelstueckModel.getInstance();
		this.moebelstueckView = new MoebelstueckView(this, moebelstueckModel, primaryStage);
		moebelstueckModel.addObserver(this);
	} 
	
	  
    public void leseAusDatei(String typ){
    	try {
    		
    			this.moebelstueckModel.leseAusDatei(typ);
    			moebelstueckView.zeigeInformationsfensterAn("Datei erfolgreich eingelesen!"); 
    		
		}
		catch(IOException exc){
			moebelstueckView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
			//exc.printStackTrace();
		}
		catch(Exception exc){
			moebelstueckView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
			//exc.printStackTrace();
		}
	}
		
	public void schreibeMoebelstueckeInCsvDatei() {
		try {
			this.moebelstueckModel.schreibeMoebelstueckeInCsvDatei();
			 moebelstueckView.zeigeInformationsfensterAn("Datei erfolgreich gespeichert!");
		}	
		catch(IOException exc){
			moebelstueckView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			moebelstueckView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	 public void nehmeMoebelstueckAuf(){
	    	try{ 
	    		this.moebelstueckModel.addMoebelstueck ( new Moebelstueck(
	    			moebelstueckView.getTxtName().getText(), 
	    			moebelstueckView.getTxtWohnraum().getText(),
	    			moebelstueckView.getTxtStil().getText(),
	   	            Float.parseFloat(moebelstueckView.getTxtPreis().getText()),
	   	         moebelstueckView.getTxtMaterialien().getText().split(";")));
	    		moebelstueckView.zeigeInformationsfensterAn("Das Moebelstueck wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		moebelstueckView.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }


	
	public void update() {
		moebelstueckView.zeigeMoebelstueckAn(); 
		
	}
	   

	
	
}
