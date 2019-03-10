package DRD;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;

// this class should take care of reading and writing on files
public class dataHolder 
{
	public void writeFile() throws IOException
	{
		String HoldPoped ="";
//		regulateTraffic.popElement();
		
		File file = new File("append.txt");
		FileWriter fr = new FileWriter(file, true);
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);
		
		while(!regulateTraffic.isEmpty())
		{
			HoldPoped = regulateTraffic.popElement();
			System.out.println(HoldPoped);
			pr.println(HoldPoped);
		}
		pr.close();
		br.close();
		fr.close();
	
	}
	
	public String readFile() throws IOException
	{
		String data ="";
		BufferedReader reader;
		reader = new BufferedReader(new FileReader("append.txt"));
		String line = reader.readLine();
		String text = "";
		while (line != null) 
		{
			System.out.println(line);
			line = reader.readLine();
			if (line==null) 
			{
				break;
			}
			text += line;
			text += "\n";
		}
		
		reader.close();
		return text;
	}
	
}
