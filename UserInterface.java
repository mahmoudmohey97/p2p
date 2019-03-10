package DRD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramSocket;

public class UserInterface extends JFrame {
    JTextArea textArea= new JTextArea(10, 40);
    JTextField textField = new JTextField("IP",40);
    JScrollPane scroll = new JScrollPane(textArea);
    JButton join = new JButton("Join");
    JButton loadData = new JButton("Load");
    dataHolder dataStore = new dataHolder();

    public UserInterface(){
        setTitle("P2P");
        setSize(600,600);
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(textField);
        getContentPane().add(join);
        getContentPane().add(scroll);
        getContentPane().add(loadData);


        textField.addActionListener(new UiMain());
        join.addActionListener(new UiMain());
        loadData.addActionListener(new UiMain());

    }

    private class UiMain implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed = e.getSource();

            if(buttonPressed == loadData)
            {
            	dataHolder dataHolder = new dataHolder();
                try 
                {
                	textArea.setText(dataHolder.readFile());
					
				} 
                catch (IOException e1) 
                {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            
            if(buttonPressed == join)
            {
            	String myIP =  textField.getText();
                MulticastSend multicastPublisher;
                MulticastRec multicastReceiver;
//                receiver serverSocketReceiver;
				try {
					multicastPublisher = new MulticastSend(myIP);
//					multicastPublisher.sendsocket = new DatagramSocket();
					multicastReceiver = new MulticastRec(myIP);

						
					multicastPublisher.start();
					multicastReceiver.start();
					
				} 
				catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				

            }
        }
    }
}
