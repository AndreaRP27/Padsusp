package noodle.test;

import es.uam.eps.padsof.emailconnection.*;

public class TestEmailSystem {
	
	public static void main(String[] args){
		System.out.println(EmailSystem.isValidEmailAddr("hola@hotmail.com"));
		try{
		EmailSystem.send("hola@hotmail.com", "Urgente", "Este correo se autodestruirá en 3..2...1... BOOOM", true);
		}
		catch (InvalidEmailAddressException exception){
			System.out.println("Correo erróneo");
		}
		catch (FailedInternetConnectionException exception){
			System.out.println("Sin conexión a internet");
		}		
		finally{
			System.out.println("Fin");
		}
		
		System.out.println(EmailSystem.isValidEmailAddr("algo"));
	
	}

}
