package DRD;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;

public class regulateTraffic 
{
	private static Queue<String> queue = new LinkedList<>();
	
	public regulateTraffic()
	{
		
	}
//	 public regulateTraffic(Queue<String> dQueue) 
//	 {
//	       this.queue = dQueue;
//	 }
	 
	 public static int getRemaining()
	 {
		 return (10 - queue.size());
	 }
	 
	public static String popElement()
	 {
	    return queue.poll();
	 }
	
	public static void addTo(String data)
	{
        queue.add(data);
    }

    public static boolean isEmpty()
    {
        return queue.isEmpty();
    }
	
    public Queue<String> getQueue() 
    {
        return queue;
    }

//    public void setQueue(Queue<String> dQueue) 
//    {
//        this.queue = dQueue;
//    }
	
}
