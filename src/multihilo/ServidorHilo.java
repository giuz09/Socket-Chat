package multihilo;

    import java.io.*;  
    import java.net.*;  
    import java.util.logging.*;  
    public class ServidorHilo extends Thread {  
        private Socket socket;  
        private DataOutputStream dos;  
        private DataInputStream dis;  
        private int idSession;
        
        public ServidorHilo(Socket socket, int id) {  
            this.setSocket(socket);  
            this.setIdSession(id);  
            try {  
                this.setDos(new DataOutputStream(socket.getOutputStream()));  
                this.setDis(new DataInputStream(socket.getInputStream()));  
            } catch (IOException ex) {  
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);  
            }  
        }  
        public void desconectar() {  
            try {  
                this.getSocket().close();  
            } catch (IOException ex) {  
                Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);  
            }  
        }  
        @Override  
        public void run() {  
           
                  
                    try {
						this.getDos().writeUTF("Hola soy el servidor hilo");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
                  
            
            desconectar();  
        }
		public Socket getSocket() {
			return socket;
		}
		public void setSocket(Socket socket) {
			this.socket = socket;
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
		public void setIdSession(int idSessio) {
			this.idSession = idSessio;
		}  
    }  