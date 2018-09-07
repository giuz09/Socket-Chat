package multihilo;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ApliClientes {

	public static void main(String[] args) throws UnknownHostException, IOException {  
	            
		        
			Cliente cli1 = new Cliente("127.0.0.1",10578,0,"Calculadora");
			cli1.start();
			Cliente cli2 = new Cliente("127.0.0.1",10578,0,"Saludador");
			cli2.start();
		
	}
}
	        

