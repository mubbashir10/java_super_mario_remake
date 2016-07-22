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
class MenuScreen extends JPanel{ 

	//creating refrences variables for images       
	BufferedImage bimg;
	BufferedImage limg;

	//contructor
	MenuScreen(){

		//setting logo and background
		try{
			bimg= ImageIO.read(new File("resources/images/main-bg.jpg"));
			limg= ImageIO.read(new File("resources/images/logo.png"));
		}catch (Exception e){}    

	}

	//drawing logo and background
	public void paint(Graphics g){
		g.drawImage(bimg,-250,0,null);
		g.drawImage(limg,50,50,null);
	}

}//ends MenuScreen here


//main class starts here
public class SuperMario extends JFrame implements MouseListener{

	static SuperMario sm = new SuperMario();
	static InstructionsScreen isc;
	static HighScoreScreen hsc;
	static Clip clip;

	//creating refrence variables for buttons
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JButton jb4;
	String imgPath1;
	String imgPath2;
	String imgPath3;
	String imgPath4;	


	//constructor for main class
	SuperMario()
	{

		//creating buttons
		jb1 = new JButton();
		jb2 = new JButton();
		jb3 = new JButton();
		jb4 = new JButton();
		jb1.setBounds(150,360,221,60);
		jb2.setBounds(150,435,221,60);
		jb3.setBounds(150,510,221,60);
		jb4.setBounds(150,585,221,60);
		jb1.setOpaque(false);
		jb1.setContentAreaFilled(false);
		jb1.setBorderPainted(false);
		jb2.setOpaque(false);
		jb2.setContentAreaFilled(false);
		jb2.setBorderPainted(false);
		jb3.setOpaque(false);
		jb3.setContentAreaFilled(false);
		jb3.setBorderPainted(false);
		jb4.setOpaque(false);
		jb4.setContentAreaFilled(false);
		jb4.setBorderPainted(false);
		try
		{	
			Image mbImg1 = ImageIO.read(getClass().getResource("resources/images/mb1.png"));
			Image mbImg2 = ImageIO.read(getClass().getResource("resources/images/mb2.png"));
			Image mbImg3 = ImageIO.read(getClass().getResource("resources/images/mb3.png"));
			Image mbImg4 = ImageIO.read(getClass().getResource("resources/images/mb4.png"));

			jb1.setIcon(new ImageIcon(mbImg1));
			jb2.setIcon(new ImageIcon(mbImg2));
			jb3.setIcon(new ImageIcon(mbImg3));
			jb4.setIcon(new ImageIcon(mbImg4));


		}catch(Exception e){}

		//adding buttons to panel
		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);

		//assigning Mouselistener to menu buttons
		jb1.addMouseListener(this);
		jb2.addMouseListener(this);
		jb3.addMouseListener(this);
		jb4.addMouseListener(this);


		//adding background music												   
		try
		{  
			File yourFile=new File("resources/sounds/mario.wav");
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;

			stream = AudioSystem.getAudioInputStream(yourFile);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		}catch (Exception e){}

		//creating frame object     
		MenuScreen mp = new MenuScreen();

		//configuring frame 
		add(mp);

	}//constructor ends	

	//method main starts here
	public static void main(String []args)
	{          

		sm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sm.setUndecorated(true);
		sm.setExtendedState(JFrame.MAXIMIZED_BOTH);
		sm.setVisible(true);

	}//method main ends here                


	//mouse hover actions and effects
	public void mouseEntered(MouseEvent me) {

		Object stringobj1 = me.getSource();
		if (stringobj1==jb1) {

			try
			{
				imgPath1 = "resources/images/mb1_active.png";
				Image mbImg1 = ImageIO.read(getClass().getResource(imgPath1));
				jb1.setIcon(new ImageIcon(mbImg1));
				jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}catch(Exception e){};
		}
		else if (stringobj1==jb2) {

			try
			{
				imgPath2 = "resources/images/mb2_active.png";
				Image mbImg2 = ImageIO.read(getClass().getResource(imgPath2));
				jb2.setIcon(new ImageIcon(mbImg2));
				jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}catch(Exception e){};
		} 
		else if (stringobj1==jb3) {

			try
			{
				imgPath3 = "resources/images/mb3_active.png";
				Image mbImg3 = ImageIO.read(getClass().getResource(imgPath3));
				jb3.setIcon(new ImageIcon(mbImg3));
				jb3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}catch(Exception e){};
		} 
		else if (stringobj1==jb4) {

			try
			{
				imgPath4 = "resources/images/mb4_active.png";
				Image mbImg4 = ImageIO.read(getClass().getResource(imgPath4));
				jb4.setIcon(new ImageIcon(mbImg4));
				jb4.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}catch(Exception e){};
		}  
	}
	public void mouseExited(MouseEvent me) { 

		Object stringobj2 = me.getSource();
		if (stringobj2==jb1) {
			try
			{
				imgPath1 = "resources/images/mb1.png";
				Image mbImg1 = ImageIO.read(getClass().getResource(imgPath1));
				jb1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				jb1.setIcon(new ImageIcon(mbImg1));
			}catch(Exception e){};
		}
		if (stringobj2==jb2) {
			try
			{
				imgPath2 = "resources/images/mb2.png";
				Image mbImg1 = ImageIO.read(getClass().getResource(imgPath2));
				jb2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				jb2.setIcon(new ImageIcon(mbImg1));
			}catch(Exception e){};
		} 
		if (stringobj2==jb3) {
			try
			{
				imgPath3 = "resources/images/mb3.png";
				Image mbImg1 = ImageIO.read(getClass().getResource(imgPath3));
				jb3.setCursor(new Cursor(Cursor.HAND_CURSOR));
				jb3.setIcon(new ImageIcon(mbImg1));
			}catch(Exception e){};
		} 
		if (stringobj2==jb4) {
			try
			{
				imgPath4 = "resources/images/mb4.png";
				Image mbImg1 = ImageIO.read(getClass().getResource(imgPath4));
				jb4.setCursor(new Cursor(Cursor.HAND_CURSOR));
				jb4.setIcon(new ImageIcon(mbImg1));
			}catch(Exception e){};
		}  

	}

	public void mouseClicked(MouseEvent me){ 

		Object stringobj3 = me.getSource();
		if (stringobj3==jb1){
			GamePlay gmp = new GamePlay();
			sm.setVisible(false);
		}

		if (stringobj3==jb2){

			hsc = new HighScoreScreen ();
			hsc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			hsc.setUndecorated(true);
			hsc.setExtendedState(JFrame.MAXIMIZED_BOTH);
			hsc.setVisible(true);
			sm.setVisible(false);
			sm.dispose();
			if(!(hsc.smnh==null))
			{
				hsc.smnh.setVisible(false);
				hsc.smnh.dispose();
			}
		}
		if (stringobj3==jb3){

			isc = new InstructionsScreen ();
			isc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			isc.setUndecorated(true);
			isc.setExtendedState(JFrame.MAXIMIZED_BOTH);
			isc.setVisible(true);
			sm.setVisible(false);
			sm.dispose();
			if(!(isc.smn==null))
			{
				isc.smn.setVisible(false);
				isc.smn.dispose();
			}
		}
		if (stringobj3==jb4) {
			System.exit(1);
		}


	}
	public void mousePressed(MouseEvent me) { }
	public void mouseReleased(MouseEvent me) { }

}//SuperMario class ends here







