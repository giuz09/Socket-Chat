package multihilo;

    import java.io.*;  
    import java.net.*;  
    import java.util.logging.*;  
    public class Servidor {  
       
    	private ServerSocket ss; 
    	private Socket socket;
    	private int idSession;
    	
    	
        
    	public Servidor()
    	{
    		
    		try {
				ss=new ServerSocket(10578);
				
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
             while (true) {    
                 socket = ss.accept();
                 String accion = "";
                 DataInputStream is = new DataInputStream(socket.getInputStream());
                 System.out.println("Nueva conexión entrante: "+socket); 
                 idSession++; 
                     accion =  is.readUTF(); 
                     if(accion.equals("Saludador")){  
                
                   ServidorHilo sh= new ServidorHilo(socket, idSession);
                   sh.start();
                
                
             }
                     else if(accion.equals("Calculadora"))
                     {
                    	 
                        
                         ServidorCalculadora sc = new ServidorCalculadora(socket, idSession);
						 sc.start();
						 
                     }
    		 
    	}
    	}

	
    }
    	
             
    	
    