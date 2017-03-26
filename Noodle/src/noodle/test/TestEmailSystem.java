package noodle.test;

import es.uam.eps.padsof.emailconnection.*;

public class TestEmailSystem {
	
	public static void main(String[] args){
		System.out.println(EmailSystem.isValidEmailAddr("hola@hotmail.com"));
		try{
		EmailSystem.send("hola@hotmail.com", "Urgente", "Este correo se autodestruir� en 3..2...1... BOOOM", true);
		}
		catch (InvalidEmailAddressException exception){
			System.out.println("Correo err�neo");
		}
		catch (FailedInternetConnectionException exception){
			System.out.println("Sin conexi�n a internet");
		}		
		finally{
			System.out.println("Fin");
		}
		
		System.out.println(EmailSystem.isValidEmailAddr("algo"));
	
	}

}
