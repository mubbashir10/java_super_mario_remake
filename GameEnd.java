/***********************************
Author: Mubbashir10
Web: http://mubbashir10.com
Description: A remake of super mario game in JAVA. A starter program that can help you learn gaming in java and it can be extended to a full game.
***********************************/
//importing required classesf
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
import java.util.*;
public class GameEnd extends JFrame{
			
		GameEnd(){

        GameE gE = new GameE();
        add(gE);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true); 
    }

    //method main starts here
    public static void main (String[] args){
        
        GameEnd ge = new GameEnd();
         
    } 

}
class GameE extends JPanel{
	BufferedImage goimg;
     GameE(){
     		try{
     			goimg = ImageIO.read(new File("resources/images/framesets/gameover.jpg"));
     		} catch(Exception e){}
		}
	public void paint(Graphics g){
			
			g.drawImage(goimg,1366,768,null);
		}
	}
