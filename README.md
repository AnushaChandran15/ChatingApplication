# OverView

        This is a simple chat application implemented in Java, consisting of a server (Server.java) and a client (Client.java). 
        The application allows communication between clients by sending messages through the server.

# Socket Class

        A socket is simply an endpoint for communications between the machines. The Socket class can be used to create a socket.

# Creating Client:

      Socket s=new Socket("localhost",6666);  
      
              1. IP Address of Server,
              2. Port number.


# Using Methods

                Method	                                                    Description
                
        1)  public InputStream  getInputStream()                 returns the InputStream attached with this socket.
        2)  public OutputStream getOutputStream()	        returns the OutputStream attached with this socket.
        3)  public synchronized void close()	                closes this socket


# ServerSocker Class

        The ServerSocket class can be used to create a server socket. This object is used to establish communication with the clients.

# Creating Server:

        ServerSocket ss=new ServerSocket(6666);  
        Socket s=ss.accept();//establishes connection and waits for the client   
               
                
# Using methods

        Method                           	                        Description

1) public Socket accept()	                returns the socket and establish a connection between server and client.
2) public synchronized void close()	        closes the server socket.

# Follow
![image](https://github.com/AnushaChandran15/ChatingApplication/assets/148624590/9b697995-231c-463e-9eb2-cf52ab23c2c8)
 


    


