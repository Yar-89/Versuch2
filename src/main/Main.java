package main;


import gui.Moebel.WarenuebersichtControl;
import gui.guiWarenuebersicht.MoebelstueckControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new MoebelstueckControl(primaryStage);
		Stage fenster = new Stage (); 
		new WarenuebersichtControl(fenster); 
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
