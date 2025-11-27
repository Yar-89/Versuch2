package gui.Moebel;

import business.MoebelstueckModel;
import javafx.stage.Stage;
import ownUtil.Observer;

	public class WarenuebersichtControl implements Observer {
		private WarenuebersichtView warenuebersichtView;
		private MoebelstueckModel moebelstueckModel;
		
		
		public WarenuebersichtControl(Stage primaryStage){
			this.moebelstueckModel = moebelstueckModel.getInstance(); 		
			this.warenuebersichtView = new WarenuebersichtView(moebelstueckModel, this, primaryStage);
			moebelstueckModel.addObserver(this);
		}



		public void update() {
			warenuebersichtView.zeigeMoebelstueckAn(); 
			
		}
		
		
}
