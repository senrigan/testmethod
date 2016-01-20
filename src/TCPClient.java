import java.io.*;
import java.net.*;
class TCPClient {
 public static void main(String argv[]) throws Exception {
  try{
	  String modifiedSentence;
	  String mensaje="hola";
	  Socket clientSocket = new Socket("10.158.67.11", 7);
	  //clientSocket.setSoTimeout(10000);
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	  
	  //sentence = inFromUser.readLine();
	  outToServer.writeBytes(mensaje + '\n');
	  modifiedSentence = inFromServer.readLine();
	  System.out.println("FROM SERVER: " + modifiedSentence);
	  clientSocket.close();
  }catch(ConnectException e){//conexion rechazada
	  //conexion tiempo expiro de conexiion
	  System.out.println("el tiempo de conexion termino");
  }
  catch(SocketTimeoutException e){
	  System.out.println("el tiempo de espera termino");
  }
 
 }
} 