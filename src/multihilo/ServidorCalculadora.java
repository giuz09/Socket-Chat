package multihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorCalculadora extends Thread {
	
	 protected Socket sk;  
     protected DataOutputStream dos;  
     protected DataInputStream dis;  
     private int idSession;  
	
	public ServidorCalculadora(Socket s, int id)
	{
		this.setSk(s); 
		this.setIdSession(id); 
		 try {  
             this.setDos(new DataOutputStream(this.getSk().getOutputStream()));  
             this.setDis(new DataInputStream(this.getSk().getInputStream()));  
         } catch (IOException ex) {  
             Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);  
         }  
	}
	
	public void run()
	{
		
         try {
				//this.getDos().writeUTF("Hola soy el servidor calculadora");
				Integer resultado =sumar(this.getDis().readInt(),this.getDis().readInt());
				this.getDos().writeUTF(String.valueOf(resultado));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
       
 
         desconectar();  
	}
	
	private Integer sumar(Integer x,Integer y)
	{
		return x+y;
	}
	
	public void desconectar() {  
        try {  
            this.getSk().close();  
        } catch (IOException ex) {  
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);  
        }  
    }  
	public Socket getSk() {
		return sk;
	}
	public void setSk(Socket sk) {
		this.sk = sk;
	}
	public DataOutputStream getDos() {
		return dos;
	}
	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}
	public DataInputStream getDis() {
		return dis;
	}
	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int id) {
		this.idSession = id;
	}  
}  

 
	


