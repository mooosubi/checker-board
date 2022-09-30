

//Name: Enzo La
//Date: 9/29/22
/*
 * The user will decide the width and height of a 
checkerboard.  Use two different colors squares to output
the graphics of your boards.You need to use nested "for" loops

Use the attached code to get started
 */



import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.event.*;



public class Main extends JFrame implements ActionListener{
		
	//timer buttons
	JButton btnGenerate = new JButton("Generate");
	JTextField txtInput1 = new JTextField(20);
	JTextField txtInput2 = new JTextField(20);
	JLabel inputWidth = new JLabel("Input a width between 0 and 20: ");
	JLabel inputHeight = new JLabel("Input a height between 0 and 20: ");

	JTextArea txaOutput = new JTextArea("Try another dimension", 5, 10);
	
	//Location variables for circle
	int intX = 400;
	int intY = 100;
	int boardWidth = 0;
	int boardHeight = 0;
	
	//create the init method
	//the init is the first method to run
	
	public Main(){
		
		
		super("Checkerboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		//pnlInput.setLayout(new GridLayout(0,2));
		add(inputWidth);
		add(txtInput1);
		add(inputHeight);
		add(txtInput2);
		add(btnGenerate);
		btnGenerate.addActionListener(this);
		
		repaint();		
	}
	public static void main(String[]args){
		
		//Place components on the applet panel
		final int FRAME_WIDTH = 500;
		final int FRAME_HEIGHT = 500;
		
		Main frame = new Main();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);		     
	}
	//when you push the button it comes this method
	public void actionPerformed(ActionEvent event){
		
		//declare variable to hold which button is called
		String outputString = "";
		Object objSource = event.getSource();
		if(objSource == btnGenerate)
		{
			boardWidth = Integer.parseInt(txtInput1.getText());
			boardHeight = Integer.parseInt(txtInput2.getText());
			if(boardWidth > 0 && boardWidth < 21 && boardHeight > 0 && boardHeight < 21)
			{
				//runs code if dimensions are less than 40 by 40 and greater than 0
				repaint();
				remove(txaOutput);
			}
			else {
				//outputs a try another dimension
				add(txaOutput);
				txaOutput.setText("Try another dimension");				
			}
			intX = 400;
			intY = 100;			
		}
		//requestFocus();
	}

	//create the paint method to show graphics
	public void paint(Graphics g){
		
		super.paint(g);
		for(int h = 0; h < boardHeight;h++)
		{
			for(int u = 0; u < boardWidth; u++)
			{
				if(h%2 == 1)
				{
					if(u%2 == 1)
					{
						g.setColor(Color.white);	
					}
					if(u%2 == 0)
					{
						g.setColor(Color.black);
					}
				}
				else
				{
					if(u%2 == 1)
					{
						g.setColor(Color.black);	
					}
					if(u%2 == 0)
					{
						g.setColor(Color.white);
					}
				}
				
				g.fillRect(intX, intY, 40, 40);
				intX += 40;
			}
			intX = 400;
			intY += 40;
		}
		/*g.setColor(Color.red);
		g.fillRect(intX,intY,40,40);
		*/
		
	}
	public void Update(Graphics gr){
		
		//call the paint method
		paint(gr);
	}
	
	
	

}



