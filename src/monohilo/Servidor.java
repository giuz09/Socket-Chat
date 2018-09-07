package monohilo;

    import java.io.*;  
    import java.net.*;
import java.util.Scanner;
import java.util.logging.*;  
    public class Servidor {  
       
    	private ServerSocket ss; 
    	private Socket socket;
    	private int idSession;
    	private DataOutputStream dos;  
        private DataInputStream dis; 
        
    	public Servidor()
    	{
    		
    		try {
				ss=new ServerSocket(10579);
				
				this.conectarServidor();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
			} 
    		
    	}
    	
    	public void conectarServidor() throws IOException
 
    	{
    		 System.out.print("Inicializando servidor... "); 
    		 System.out.println("\t[OK]");  
             idSession = 0;  
             socket = ss.accept();
             dos = new DataOutputStream(socket.getOutputStream());  
             dis = new DataInputStream(socket.getInputStream());  
             Scanner  sc = new Scanner(System.in); 
             String mensaje = ""; 
             System.out.println("- Servidor: " + mensaje); 
             while (true) {                   
            	 //lee
                 System.out.println("- cliente dice "+dis.readUTF()); 
                 //escribe
                 mensaje = sc.nextLine(); 
                
                 dos.writeUTF(mensaje); 
                
                 
             }  
    		 
    	}
    	
    	
    	
    }  