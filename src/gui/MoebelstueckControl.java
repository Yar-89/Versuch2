package gui;

import java.io.IOException;

import business.Moebelstueck;
import business.MoebelstueckModel;
import javafx.stage.Stage;

public class MoebelstueckControl {
	private MoebelstueckModel moebelstueckModel; 
	private MoebelstueckView moebelstueckView;
	
	
	public MoebelstueckControl(Stage primaryStage) {
		this.moebelstueckModel = new MoebelstueckModel();
		this.moebelstueckView = new MoebelstueckView(this, moebelstueckModel, primaryStage);
	} 
	
	  
    public void leseAusDatei(String typ){
    	try {
    		if("csv".equals(typ)) {
    			this.moebelstueckModel.leseAusDatei(typ);
    			moebelstueckView.zeigeInformationsfensterAn("Datei erfolgreich eingelesen!"); 
    			
    		}
    		else {
    			System.out.println("txt noch nicht ");
    		}
		}
		catch(IOException exc){
			moebelstueckView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			moebelstueckView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
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
	    		this.moebelstueckModel.setMoebelstueck ( new Moebelstueck(
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
	   

	
	
}
