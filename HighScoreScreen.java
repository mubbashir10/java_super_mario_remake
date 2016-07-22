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
class HighScorePanel extends JPanel{ 
	
	//creating refrences variables for image       
	BufferedImage bimg;
	FileInputStream fis;
	File ff = new File("score.txt");
	char ch [];
	byte b[] ;
	String sc;
	JLabel lb = new JLabel();
	int sint;

	//contructor
	HighScorePanel(){
		setLayout(null);
		lb.setBounds(520,350,500,100);
	try	{
		fis = new FileInputStream(ff);
		} catch(Exception e){}
	
if(ff.exists()){
				b = new byte[(int)ff.length()];
				ch = new char[(char)b.length];
		try {
				fis.read(b);
			 }catch(Exception e){}
		
	
}
	for (int m=0;m<ch.length;m++){
		ch [m] = (char) b[m];
		
	} 
	sc = new String(ch);
	lb.setFont(new Font ("Andalus",Font.BOLD,50));	
	lb.setText("Your Score: " + sc);
	add(lb);
	sint = Integer.parseInt(sc);

		//setting background
		try{
			bimg = ImageIO.read(new File("resources/images/hs-bg.jpg"));
		}catch (Exception e){}    

	  }

	//drawing background
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bimg,0,0,null);
		
	}
	
	




}//ends HighScorePanel here


//main class starts here
public class HighScoreScreen extends JFrame implements MouseListener{

	JButton jbtnback; 
	static SuperMario smnh;
	Image mbImg1;
	String imgPath1;

	HighScoreScreen()
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
		HighScorePanel mp = new HighScorePanel();
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

		Object stringobj5 = me.getSource();
       	if (stringobj5==jbtnback) {
        	
        		smnh = new SuperMario();
        		smnh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				smnh.setUndecorated(true);
				smnh.setExtendedState(JFrame.MAXIMIZED_BOTH);
				smnh.clip.close();
				smnh.setVisible(true);
				smnh.hsc.setVisible(false);
				smnh.hsc.dispose();
        }

    }
    public void mousePressed(MouseEvent me) { }
    public void mouseReleased(MouseEvent me) { }

}//HighScoreScreen class ends here







