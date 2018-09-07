package multihilo;

    import java.io.*;  
    import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;  
    import java.util.logging.*;  
   public class Cliente extends Thread {  
        
	    protected Socket sk;  
        protected DataOutputStream dos;  
        protected DataInputStream dis;  
        private int identificador;
        private String tipoCliente;
        
        public Cliente(String ip, int puerto, int id,String tipo) throws UnknownHostException, IOException {  
            this.setIdentificador(id);
            this.setSk(new Socket(ip, puerto));  
            this.setDos(new DataOutputStream(this.getSk().getOutputStream()));  
            this.setDis(new DataInputStream(this.getSk().getInputStream()));  
            this.setTipoCliente(tipo);
        }  
        @Override  
        public void run() {  
            try {  
                
               
                this.getDos().writeUTF(this.getTipoCliente());
                this.getDos().writeInt(5);
                this.getDos().writeInt(4);
                String respuesta="";  
                respuesta = this.getDis().readUTF();  
                System.out.println("id: " + this.getIdentificador() + " Servidor devuelve: " + respuesta);  
                this.getDis().close();  
                this.getDos().close();  
                this.getSk().close();  
            } catch (IOException ex) {  
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);  
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
		public int getIdentificador() {
			return identificador;
		}
		public void setIdentificador(int id) {
			this.identificador = id;
		}
		public String getTipoCliente() {
			return tipoCliente;
		}
		public void setTipoCliente(String tipoCliente) {
			this.tipoCliente = tipoCliente;
		}  
    }  
   
     