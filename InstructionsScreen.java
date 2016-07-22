/***********************************
Author: Mubbashir10
Web: http://mubbashir10.com
Description: A remake of super mario game in JAVA. A starter program that can help you learn gaming in java and it can be extended to a full game.
***********************************/
//importing required libraries
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.io.*;
import java.io.File;
import javax.imageio.*;
import javax.sound.sampled.*;

//use to create main panel
class InstructionsPanel extends JPanel{ 

	//creating refrences variables for image       
	BufferedImage bimg;

	//contructor
	InstructionsPanel(){

		//setting background
		try{
			bimg = ImageIO.read(new File("resources/images/ins-bg.jpg"));
		}catch (Exception e){}    

	  }

	//drawing background
	public void paint(Graphics g){
		g.drawImage(bimg,0,0,null);
	}

}//ends InstructionsPanel here


//main class starts here
public class InstructionsScreen extends JFrame implements MouseListener{

	JButton jbtnback; 
	static SuperMario smn;
	Image mbImg1;
	String imgPath1;

	InstructionsScreen()
	{
		//creating back buttons
		jbtnback = new JButton();
		jbtnback.setBounds(185,675,113,41);
		jbtnback.setOpaque(false);
		jbtnback.setContentAreaFilled(false);
		jbtnback.setBorderPainted(false);
		try
  		{	
  			mbImg1 = ImageIO.read(getClass().getResource("resources/images/btn-back.png"));
			jbtnback.setIcon(new ImageIcon(mbImg1));

 		}catch(Exception e){}

 		//adding back button to frame
		add(jbtnback);

		//creating and adding instructions panel object into frame
		InstructionsPanel mp = new InstructionsPanel();
		add(mp);

		//assigning Mouselistener to menu buttons
		jbtnback.addMouseListener(this);

	}

	//mouse hover actions and effects
	public void mouseEntered(MouseEvent me) {

		Object stringobj4 = me.getSource();
       	if (stringobj4==jbtnback) {
        	try
        	{
        		imgPath1 = "resources/images/btn-back_active.png";
        		mbImg1 = ImageIO.read(getClass().getResource(imgPath1));
        		jbtnback.setIcon(new ImageIcon(mbImg1));
        		
        	}catch(Exception e){};

        	jbtnback.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
	
	}
	public void mouseExited(MouseEvent me) { 

			//setting hover states of back button
			try
        	{
        		imgPath1 = "resources/images/btn-back.png";
        		mbImg1 = ImageIO.read(getClass().getResource(imgPath1));
        		jbtnback.setIcon(new ImageIcon(mbImg1));

        	}catch(Exception e){};

	}
    public void mouseClicked(MouseEvent me){ 

		Object stringobj4 = me.getSource();
       	if (stringobj4==jbtnback) {
        	
        		smn = new SuperMario();
        		smn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				smn.setUndecorated(true);
				smn.setExtendedState(JFrame.MAXIMIZED_BOTH);
				smn.clip.close();
				smn.setVisible(true);
				smn.isc.setVisible(false);
				smn.isc.dispose();
        }

    }
    public void mousePressed(MouseEvent me) { }
    public void mouseReleased(MouseEvent me) { }

}//InstructionsScreen class ends here







