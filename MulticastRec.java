package DRD;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Vector;

import org.omg.CORBA.PRIVATE_MEMBER;

public class MulticastRec extends Thread
{
	private int port = 500;
	private String group  ="225.4.5.6";
	private String IP ;
	protected MulticastSocket socket = new MulticastSocket(port);
	protected byte buf[] = new byte[256];
	DatagramPacket word = new DatagramPacket(buf, buf.length);
	
	

	
	public MulticastRec(String ip) throws IOException
	{
		this.IP = ip;
	}
	
	
	public void run()
	{
		try 
		{
			PeersIp.addPeer(IP);
			sleep(1500);
			socket.joinGroup(InetAddress.getByName(group));
			System.out.println("ur ip is :" +" "+ IP);

		} 
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true)
		{
			System.out.println("Waiting to receive...");
			try 
			{
				socket.receive(word);
				String peerIp = "" ;
				String message = "" ;
	            String data2Rec = new String(word.getData());
	            boolean flag = false;
	            
	            for(int i = 0; i < data2Rec.length(); ++i)
	            {
	            	if(data2Rec.charAt(i) == '$')
	            	{
	            		flag = true;
	            		continue;
	            	}
	            	
	            	if(!flag)
	            		peerIp += data2Rec.charAt(i);
	            	else
	            		message += data2Rec.charAt(i);
	            }
	        
	           // System.out.println("received data issssssssss: " + message);
	            System.out.println("data received from : " + peerIp);
	            PeersIp.addPeer(peerIp);
	            message = "";
	            peerIp ="";	
	            sleep(1000);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			
		}
	}
	
	
	
}
