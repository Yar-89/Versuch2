package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Test;

class MoebelstueckTest {
	Moebelstueck moebelstueck; 
	
	@Test
	void test1() {
		moebelstueck = new Moebelstueck("Esszimmersruhl", "esszimmer ", "rustikal", 399.0f, new String[] {"Holz"}); 
		BooleanSupplier bs = () -> this.moebelstueck.getName().equals("Esszimmersruhl"); 
		assertTrue(bs);
	}
	
	@Test
	void test2() {
		Throwable exc = assertThrows(IllegalArgumentException.class, () -> new Moebelstueck("Esszimmersruhl", "esszimmer ", "rustikal", 399.0f,null)
		); 
	};

}

//Esszimmersruhl. esszimmer. rustikal. 399, holz 
