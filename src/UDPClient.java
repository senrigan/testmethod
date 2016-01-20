import java.io.*; 
import java.net.*;
import java.util.concurrent.TimeoutException; 
public class UDPClient {    
	public static void main(String args[])    {       
		try{
			String message="hola";
			DatagramSocket clientSocket = new DatagramSocket();       
			InetAddress IPAddress = InetAddress.getByName("10.158.67.110");       
			byte[] sendData = new byte[message.length()];       
			byte[] receiveData = new byte[message.length()];       
			String sentence =message;       
			sendData = sentence.getBytes();       
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7);
			clientSocket.setSoTimeout(10000);
			clientSocket.send(sendPacket);       
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);       
			clientSocket.receive(receivePacket);       
			String modifiedSentence = new String(receivePacket.getData());       
			System.out.println("FROM SERVER:" + modifiedSentence);       
			clientSocket.close();
		}catch(SocketTimeoutException e){
			System.out.println("se tardo mas de lo esperado");
			//el tiempo de espera termino no respondio;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	} 
} 