package DRD;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;


public class MulticastSend extends Thread
{
	private int port ;
	private String group  ="225.4.5.6";
	private String IP ;
	protected MulticastSocket socket = new MulticastSocket();
	protected byte buf[] , data[];
	private InetAddress IADRESS;
	private regulateTraffic rTraffic = new regulateTraffic();
	FakeGenerator fGenerator = new FakeGenerator();
	dataHolder dh = new dataHolder();
	public static boolean flag =true;
	
	public MulticastSend(String ip) throws IOException
	{
		this.IP = ip;
		port = 500; 
		
	}
	public void run()
	{
		try 
		{
			socket.joinGroup(InetAddress.getByName(group));
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
		}
		
		try 
		{
			IADRESS = InetAddress.getByName(group);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while(true)
		{	
			buf = new byte[256];
			String dHolder;
			flag =true;
			try 
			{
				if(flag && (rTraffic.getQueue().size() <= 10))
				{
				   dHolder = fGenerator.generate();
				   System.out.println(dHolder + "*//*/*/*/*//*/*/*/*/*");
				   rTraffic.addTo(dHolder);
				   //System.out.println("SENDING :" + " " + dHolder);
				   String neew = IP + "$" + dHolder;
				   buf = neew.getBytes();
				   DatagramPacket pack = new DatagramPacket(buf, buf.length, IADRESS, port);
				   if(rTraffic.getRemaining() < 0)
				   {
					   System.err.println("NETWORK IS GETTING BUSY, EMPTYING CACHE...");
					   flag = false;
					   dh.writeFile();
					   flag = true;
				   }
				   
				   socket.send(pack);
				   System.out.println("Data is sent");
			
				}
				
				else
				{
					System.err.println("network is busy right now please wait...");
					System.err.println(IP);
					System.out.println(rTraffic.getQueue().size());
					sleep(500);
					continue;
				}
			}
			
			
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try 
			{
				sleep(6200);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
