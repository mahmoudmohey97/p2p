package DRD;

import java.io.IOException;
import java.util.Vector;

public class PeersIp 
{
	private static Vector<String> peers = new Vector<>();
	
	public static Vector<String> getPeers() 
	{
		return peers;
	}
	
	public static void addto(String newIp)
	{
		peers.add(newIp);
	}
	
//	public static void setPeers() 
//	{
//		peers = new Vector<>();
//	}
//	
	public static void addPeer(String peerIp) throws IOException
	{
		System.out.println("----------> : " + peers);
		if(!peers.contains(peerIp))
        {
        	System.out.println("Peer of IP : " + peerIp + " " + "joined");
        	addto(peerIp);
        	//System.out.println(peers);
        	MulticastSend socketSender = new MulticastSend(peerIp);
        	socketSender.start();
        }
	}

	public void showPeers()
	{
		System.out.println(peers);
	}
	
}
