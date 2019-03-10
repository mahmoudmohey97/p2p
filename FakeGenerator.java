package DRD;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.xml.ws.Holder;

public class FakeGenerator
{
	String[] all = {"I" , "am" , "is" , "hate" , "lol" , "play" , "ay7aga"};
	public String generate() 
	{
		Random rand = new Random();
		Vector<Integer>matcher = new Vector<>();
		String sentence = "";
		int i = 0 ;
		while(matcher.size() < 3)
		{
			int guess = rand.nextInt(7);
			if(matcher.contains(guess) )
			{
				continue;
			}
			else
			{
				sentence += all[guess] + " ";
				matcher.add(guess);
			}
			
		}
		//System.out.println(sentence);
		return sentence;
	}
	
}
