package business;


import java.io.BufferedWriter;

import java.io.FileWriter;
import java.util.ArrayList;

import fabrikMethodAlSammour.ConcretecsvtxtCreator;
import fabrikMethodAlSammour.CreatorsAlSammour;
import fabrikMethodAlSammour.ProductAlSammour;
import ownUtil.Observable;
import ownUtil.Observer;

public class MoebelstueckModel implements Observable {
	//private Moebelstueck moebelstueck;
	private static MoebelstueckModel theInstance;
	
	ArrayList<Observer> liste = new ArrayList<>(); 
	ArrayList<Moebelstueck> moebelstueck = new ArrayList<Moebelstueck>(); 
	
	private MoebelstueckModel() {
		
	}
	public ArrayList<Moebelstueck> getMoebelstueck() {
		return moebelstueck;
	}

	public void addMoebelstueck(Moebelstueck moebelstueck) {
		this.moebelstueck.add(moebelstueck); 
		notifyObserver();
	}
	public static MoebelstueckModel getInstance() {
		if(theInstance == null) {
			theInstance = new MoebelstueckModel(); 
		}return theInstance; 
	}

	
	
	public void leseAusDatei(String typ)throws Exception {
		//BufferedReader ein = new BufferedReader(new FileReader("Moebelstueck.csv"));
		CreatorsAlSammour creatorsAlSammour = new ConcretecsvtxtCreator(); 
		ProductAlSammour reader = creatorsAlSammour.factoryMethod(typ); 
		
	    String[] zeile = reader.leseAusDatei();
	    this.moebelstueck.add( new Moebelstueck(zeile[0],
	        zeile[1],
	        zeile[2],
	        Float.parseFloat(zeile[3]),
	        zeile[4].split("_")));
	    	reader.schlisseDatei();
      		notifyObserver();
	}
		
	public void schreibeMoebelstueckeInCsvDatei() throws Exception{
			BufferedWriter aus = new BufferedWriter(new FileWriter("MoebelstueckeAusgabe.csv", true));
			for(Moebelstueck moebelstueck: this.moebelstueck) {
				aus.write(moebelstueck.gibMoebelstueckZurueck(';'));
			}
			aus.close();
      		notifyObserver();

	
	}
	
	public void addObserver(Observer obs) {
		liste.add(obs); 
		
	}

	public void removeObserver(Observer obs) {
		liste.remove(obs); 
		
	}
	
	public void notifyObserver() {
		for (Observer obs: liste) {
			obs.update();
		}
		
	}

}
