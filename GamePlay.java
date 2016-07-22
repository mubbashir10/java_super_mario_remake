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

//panel class starts here
class GamePanel extends JPanel implements KeyListener,MouseListener{
	HighScorePanel hsp = new HighScorePanel();
	//variables for framesets
	BufferedImage frame1;
	String frame1Path;
	BufferedImage frame2;
	String frame2Path;
	BufferedImage frame3;
	String frame3Path;
	BufferedImage frame4;
	String frame4Path;
	BufferedImage frame5;
	String frame5Path;
	BufferedImage frame6;
	String frame6Path;
	int f1x=0;
	int f2x=1366;
	int f3x=2732;
	int f4x=4098;
	int f5x=5458;
	int f6x=6825;
	int temp1;
	int temp2;
	int temp3;
	int temp4;
	int temp5;
	String s="Score";
	Writer w ;

	//drawing labels of score , lives and number of coins
	JLabel lb1 = new JLabel(); 
	JLabel lb2 = new JLabel();
	JLabel lb3 = new JLabel();
	JLabel lb4 = new JLabel();
	JLabel lb5 = new JLabel(new ImageIcon(this.getClass().getResource("resources/images/coin11.gif")));
	JLabel lb6 = new JLabel(new ImageIcon(this.getClass().getResource("resources/images/coin11.gif")));
	JLabel lb7 = new JLabel(new ImageIcon(this.getClass().getResource("resources/images/spin.gif")));
	JLabel lb8 = new JLabel(new ImageIcon(this.getClass().getResource("resources/images/star.gif")));
	//jump variables
	int jump=0;int jDown=0;int jUp=0;

	//variables for images for mario movement
	BufferedImage stillRight;
	String stillRightPath;
	BufferedImage moveRight;
	String moveRightPath;
	BufferedImage jumpRight;
	String jumpRightPath;
	BufferedImage duckRight;
	String duckRightPath;
	BufferedImage stillLeft;
	String stillLeftPath;
	BufferedImage moveLeft;
	String moveLeftPath;
	BufferedImage jumpLeft;
	String jumpLeftPath;
	BufferedImage duckLeft;
	String duckLeftPath;
	BufferedImage direction;
	int runRight;
	int runLeft;
	int xPos=12;
	int yPos=613;
	int xInc=10;
	int arc=0;
	int score=0;
	int exd = 1020;
	int eyd = 625;
	int cd = 761;
	int cd2 = 1111;
	int cd3 = 433+1366;
	int cd4 = 869+1366;

	//for collision detection
	int obx [] = new int [100];
	int oby [] = new int [100];
	Rectangle2D r [] = new Rectangle2D [100];


	//variables for objects
	int check[] = new int[100];
	BufferedImage coinUsed;
	String coinUsedPath;
	BufferedImage coinAnim;
	String coinAnimPath;
	BufferedImage brickBroke;
	String brickBrokePath;
	BufferedImage muimg;
	String mupath;
	BufferedImage eimg;
	String epath;
	BufferedImage pimg;
	String ppath;


	//Constructor of nested panel class
	GamePanel(){
		lb1.setFont(new Font ("Andalus",Font.BOLD,35));
		lb1.setText(s +":");
		lb2.setFont(new Font ("Andalus",Font.BOLD,35));
		lb2.setText("Lives:");
		lb3.setFont(new Font ("Andalus",Font.BOLD,35));
		lb3.setText("*1");
		lb4.setFont(new Font ("Andalus",Font.BOLD,35));
		lb4.setText("" + score);




		//setting path for images of  objects,charcaters etc
		frame1Path ="resources/images/framesets/1.jpg";
		frame2Path ="resources/images/framesets/2.jpg";
		frame3Path ="resources/images/framesets/3.jpg";
		frame4Path ="resources/images/framesets/4.jpg";
		frame5Path ="resources/images/framesets/5.jpg";
		frame6Path ="resources/images/framesets/6.jpg";



		//setting path for movement images
		stillRightPath = "resources/images/sprites/mario/still_right.png";
		moveRightPath = "resources/images/sprites/mario/move_right.png";
		duckRightPath = "resources/images/sprites/mario/duck_right.png";
		jumpRightPath = "resources/images/sprites/mario/jump_right.png";
		stillLeftPath = "resources/images/sprites/mario/still_left.png";
		moveLeftPath = "resources/images/sprites/mario/move_left.png";
		duckLeftPath = "resources/images/sprites/mario/duck_left.png";
		jumpLeftPath = "resources/images/sprites/mario/jump_left.png";
		mupath = "resources/images/mushroom.png";
		epath = "resources/images/enemy1.png";
		ppath = "resources/images/plant.png";


		//collision detection
		obx[0] = 343; 
		oby[0] = 528;
		obx[1] = 480;
		oby[1] = 528;
		obx[2] = 514;
		oby[2] = 528;
		obx[3] = 546;
		oby[3] = 528;
		obx[4] = 582;
		oby[4] = 528;
		obx[5] = 614;
		oby[5] = 528;
		obx[6] = 750;
		oby[6] = 620;
		obx[7] = 1092;
		oby[7] = 569;
		obx[8] = 80+1366;
		oby[8] = 515;
		obx[9] = 235+1366;
		oby[9] = 644;
		obx[10] = 420+1366;
		oby[10] = 522;
		obx[11] = 793+1366;
		oby[11] = 522;
		obx[12] = 977+1366;
		oby[12] = 520;
		obx[13] = 1170+1366;
		oby[13] = 597;
		obx[14] = 567+1366;
		oby[14] = 669;
		obx[15] = 176+(2*1366);
		oby[15] = 545;
		obx[16] = 280+(2*1366);
		oby[16] = 476;
		obx[17] = 315+(2*1366);
		oby[17] = 476;
		obx[18] = 348+(2*1366);
		oby[18] = 476;
		obx[19] = 381+(2*1366);
		oby[19] = 476;
		obx[20] = 414+(2*1366);
		oby[20] = 476;
		obx[21] = 444+(2*1366);
		oby[21] = 476;
		obx[22] = 477+(2*1366);
		oby[22] = 476;
		obx[23] = 1079+(2*1366);
		oby[23] = 601;
		obx[24] = 785+(2*1366);
		oby[24] = 668;
		obx[25] = 1218+(3*1366);
		oby[25] = 560;
		obx[26] = 755;
		oby[26] = 513;
		obx[27] = 1009;
		oby[27] = 650;
		obx[28] = 1069;
		oby[28] = 650; 
		obx[29] = 1023;
		oby[29] = 615;
		obx[30] = 1111;
		oby[30] = 500;
		obx[31] = 816;
		oby[31] = 633;
		obx[32] = 231+1366;
		oby[32] = 582;
		obx[33] = 579+1366;
		oby[33] = 667;
		obx[34] = 1366+870;
		oby[34] = 548;
		obx[35] = 870+1366;
		oby[35] = 521;
		obx[36] = 870+1366;
		obx[36] = 455;


		//doing image IO
		try{

			//mario movement images
			stillRight=ImageIO.read(new File (stillRightPath));
			moveRight=ImageIO.read(new File (moveRightPath));
			jumpRight=ImageIO.read(new File (jumpRightPath));
			duckRight=ImageIO.read(new File (duckRightPath));
			stillLeft=ImageIO.read(new File (stillLeftPath));
			moveLeft=ImageIO.read(new File (moveLeftPath));
			jumpLeft=ImageIO.read(new File (jumpLeftPath));
			duckLeft=ImageIO.read(new File (duckLeftPath));
			direction = stillRight;
			muimg = ImageIO.read(new File(mupath));
			eimg = ImageIO.read(new File(epath));
			pimg = ImageIO.read(new File(ppath));


			//Image IO for framesets
			frame1=ImageIO.read(new File(frame1Path));
			frame2=ImageIO.read(new File(frame2Path));
			frame3=ImageIO.read(new File(frame3Path));
			frame4=ImageIO.read(new File(frame4Path));
			frame5=ImageIO.read(new File(frame5Path));
			frame6=ImageIO.read(new File(frame6Path));

		} catch (Exception e){}


		//configuring panel
		setFocusable(true);
		setRequestFocusEnabled(true);
		grabFocus();
		setLayout(null);
		this.addKeyListener(this);
		this.addMouseListener(this);
		lb1.setBounds(10,5,200,100);
		lb2.setBounds(600,5,200,100);
		lb3.setBounds(790,5,200,100);
		lb4.setBounds(120,5,200,100);

		add(lb1); add(lb2); add(lb3);  add(lb4);
		add(lb5); add(lb6); add(lb7);  add(lb8);
	}//constructor ends 



	//drawing images, objects and shapes
	public void paintComponent(Graphics g){
		r[0] = new Rectangle2D.Double(xPos+5,yPos,30,57);
		r[1] = new Rectangle2D.Double(obx[0],oby[0],36,36);
		r[2] = new Rectangle2D.Double(obx[1],oby[1],32,33);
		r[3] = new Rectangle2D.Double(obx[2],oby[2],32,33);
		r[4] = new Rectangle2D.Double(obx[3],oby[3],32,33);
		r[5] = new Rectangle2D.Double(obx[4],oby[4],32,33);
		r[6] = new Rectangle2D.Double(obx[5],oby[5],32,33);
		r[7] = new Rectangle2D.Double(obx[6],oby[6],10,40);
		r[8] = new Rectangle2D.Double(obx[7],oby[7]+40,20,30);
		r[9] = new Rectangle2D.Double(obx[8],oby[8],36,36);
		r[10] = new Rectangle2D.Double(obx[9],oby[9],37,40);
		r[11] = new Rectangle2D.Double(obx[10],oby[10],35,35);
		r[12] = new Rectangle2D.Double(obx[11],oby[11],36,36);
		r[13] = new Rectangle2D.Double(obx[12],oby[12],36,36);
		r[14] = new Rectangle2D.Double(obx[13],oby[13],70,70);
		r[15] = new Rectangle2D.Double(obx[14],oby[14],110,105);
		r[16] = new Rectangle2D.Double(obx[15],oby[15],35,35);
		r[17] = new Rectangle2D.Double(obx[16],oby[16],35,35);
		r[18] = new Rectangle2D.Double(obx[17],oby[17],35,35);
		r[19] = new Rectangle2D.Double(obx[18],oby[18],35,35);
		r[20] = new Rectangle2D.Double(obx[19],oby[19],35,35);
		r[21] = new Rectangle2D.Double(obx[20],oby[20],35,35);
		r[22] = new Rectangle2D.Double(obx[21],oby[21],35,35);
		r[23] = new Rectangle2D.Double(obx[22],oby[22],35,35);
		r[24] = new Rectangle2D.Double(obx[23],oby[23],70,70);
		r[25] = new Rectangle2D.Double(obx[24],oby[24],99,103);
		r[26] = new Rectangle2D.Double(obx[25],oby[25],142,69);
		r[27] = new Rectangle2D.Double(obx[26],oby[26]+15,40,25);
		r[28] = new Rectangle2D.Double(obx[27]-40,oby[27],10,10);
		r[29] = new Rectangle2D.Double(obx[28]-40,oby[28],10,10);
		r[30] = new Rectangle2D.Double(obx[29]-30,oby[29],30,10);
		r[31] = new Rectangle2D.Double(obx[30],oby[30],40,10);
		r[32] = new Rectangle2D.Double(obx[31],oby[31],10,20);
		r[33] = new Rectangle2D.Double(obx[32],oby[32],40,50);

		//for 1st jump
		r[34] = new Rectangle2D.Double(obx[33],oby[33],82,10);
				//
				r[35] = new Rectangle2D.Double(obx[34],oby[34],31,5);
				r[36] = new Rectangle2D.Double(obx[35],oby[35],31,20);
				//calling super to clean slate
				super.paintComponent(g); 

				//casting from graphics to graphics2d
				Graphics2D g2d = (Graphics2D) g;

				lb5.setBounds(cd,520,53,61);
				lb6.setBounds(cd2,500,53,61);
				lb7.setBounds(cd3-45,490,100,100);
				lb8.setBounds(cd4,510,30,30);
				//drawing rectangle for collision detection

				for(int i=0; i<=36; i++){
					g2d.draw(r[i]);
				} 

				//drawing framesets
				g2d.drawImage(frame2,f2x,0,null);
				g2d.drawImage(frame3,f3x,0,null);
				g2d.drawImage(frame4,f4x,0,null);
				g2d.drawImage(frame5,f5x,0,null);
				g2d.drawImage(frame6,f6x,0,null);
				g2d.drawImage(frame1,f1x,0,null);
				g2d.drawImage(muimg,708,10,null);
				g2d.drawImage(eimg,exd-35,eyd,null);


				//drawing mario
				g2d.drawImage(direction,xPos,yPos,null);

				//jumping
				if((yPos>510)&&(jDown==0)&&arc==0){
					yPos += jump;
				}
				else if((yPos>510)&&(jDown==0)&&arc==1){
					yPos += jump;
					xPos += 1 ;

					System.out.println("arc: " +arc);
				}
				else if((yPos<=509||jDown==1)&&jUp==0&&arc==1){
					yPos -= jump;
					jDown=1;
					xPos += 2 ;
					//setting jump face
					if(direction==jumpRight){
						direction = stillRight;
					}
					if(direction==jumpLeft){
						direction = stillLeft;
					}
					if(yPos==613){
						jUp=1;
					}
				}
				else if((yPos<=509||jDown==1)&&jUp==0){
					yPos -= jump;
					jDown=1;
					//setting jump face
					if(direction==jumpRight){
						direction = stillRight;
					}
					if(direction==jumpLeft){
						direction = stillLeft;
					}
					if(yPos==613){
						jUp=1;
					}
				}



				//collision detrection starts here
				if(r[0].intersects(r[35])==true){
					check[29]=1;
					jDown=1;
					jUp=0;

					try{

						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();
					}catch(Exception e){}
				}
				if(check[29]==1){

					try{ 
						coinUsedPath = "resources/images/sprites/objects/block.png";
						coinUsed=ImageIO.read(new File(coinUsedPath));
						g2d.drawImage(coinUsed,obx[34],oby[34]-25,null);
					}catch(Exception e){}
				}

				if(r[0].intersects(r[34])==true){
					System.out.println("Died");
				}




				if(r[0].intersects(r[33])==true){
					System.out.println("Died");
				}

				if(r[0].intersects(r[31])==true){
					score+=5;
					lb4.setText(""+score);
					check[28] = 1;
					try{
						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();

					}catch (Exception e){}    
				}
				if(check[28]==1){
					lb6.setLocation(-1000,-1000);
				}



				if(r[0].intersects(r[30])==true){
					System.out.print(" Enemy Died");
					score+=5;
					eyd = 600;
					epath = "resources/images/denemy.png";

					try{
						eimg = ImageIO.read(new File(epath));
					} catch (Exception e){}

					while(yPos>512){
						yPos--;
					}
					if(yPos<=512){
						yPos++;
					}

					try {
						w = new FileWriter("Score.txt");
						if(score>=hsp.sint){
							w.write(""+score);
						} 
						else {  
							w.write(""+hsp.sint);
						}
						w.close();
					} catch(Exception we){}
				}




				if(r[0].intersects(r[29])==true){
					System.out.print("Died");
					try {
						w = new FileWriter("Score.txt");
						if(score>=hsp.sint){
							w.write(""+score);
						} 
						else {  
							w.write(""+hsp.sint);
						}
						w.close();
					} catch(Exception we){}
					System.exit(1);
				}


				if(r[0].intersects(r[28])==true){
					System.out.print("Died");
					try {
						w = new FileWriter("Score.txt");
						if(score>=hsp.sint){
							w.write(""+score);  
						} 
						else {  
							w.write(""+hsp.sint);
						}
						w.close();
					} catch(Exception we){}
					System.exit(1);
				}

				if(r[0].intersects(r[27])==true){
					score+=5;
					lb4.setText(""+score);
					check[27] = 1;
					try{
						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();

					}catch (Exception e){}    
				}
				if(check[27]==1){
					lb5.setLocation(-1000,-1000);
				}




				if(r[0].intersects(r[1])==true){

					jDown=1;
					jUp=0;
					check[0]=1;
					try{

						coinAnimPath = "resources/images/sprites/objects/coin_anim.png";
						coinAnim=ImageIO.read(new File(coinAnimPath));
						g2d.drawImage(coinAnim,obx[0],oby[0]-50,null); 
						score+=5;
						lb4.setText(""+score);

						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();

					}catch (Exception e){}    
				}
				if(r[0].intersects(r[2])==true){

					jDown=1;
					jUp=0;
					check[1]=1;
					try
					{  
						File bFile=new File("resources/sounds/block.wav");
						score+=6;
						lb4.setText(""+score);
						AudioInputStream bstream;
						AudioFormat bformat;
						DataLine.Info binfo;
						Clip block1;

						bstream = AudioSystem.getAudioInputStream(bFile);
						bformat = bstream.getFormat();
						binfo = new DataLine.Info(Clip.class,bformat);
						block1 = (Clip) AudioSystem.getLine(binfo);
						block1.open(bstream);
						block1.loop(0);
						block1.start();
					}catch (Exception e){}
				}
				if(r[0].intersects(r[3])==true){

					jDown=1;
					jUp=0;
					check[2]=1;
					try{

						coinAnimPath = "resources/images/sprites/objects/coin_anim.png";
						score+=3;
						lb4.setText(""+score);
						coinAnim=ImageIO.read(new File(coinAnimPath));
						g2d.drawImage(coinAnim,obx[3]-30,oby[3]-50,null);

						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();
					}catch(Exception e){}
				}
				if(r[0].intersects(r[4])==true){

					jDown=1;
					jUp=0;
					check[3]=1;
					try
					{  
						File bFile=new File("resources/sounds/block.wav");
						score+=6;
						lb4.setText(""+score);
						AudioInputStream bstream;
						AudioFormat bformat;
						DataLine.Info binfo;
						Clip block1;

						bstream = AudioSystem.getAudioInputStream(bFile);
						bformat = bstream.getFormat();
						binfo = new DataLine.Info(Clip.class,bformat);
						block1 = (Clip) AudioSystem.getLine(binfo);
						block1.open(bstream);
						block1.loop(0);
						block1.start();
					}catch (Exception e){}
				}
				if(r[0].intersects(r[5])==true){

					jDown=1;
					jUp=0;
					check[4]=1;
					try{

						coinAnimPath = "resources/images/sprites/objects/coin_anim.png";
						score+=3;
						lb4.setText(""+score);
						coinAnim=ImageIO.read(new File(coinAnimPath));
						g2d.drawImage(coinAnim,obx[5]-30,oby[5]-50,null);

						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();

					}catch(Exception e){}
				}
				if(r[0].intersects(r[6])==true){

					jDown=1;
					jUp=0;
					check[5]=1;
					try
					{  
						File bFile=new File("resources/sounds/block.wav");
						score+=6;
						lb4.setText(""+score);
						AudioInputStream bstream;
						AudioFormat bformat;
						DataLine.Info binfo;
						Clip block1;

						bstream = AudioSystem.getAudioInputStream(bFile);
						bformat = bstream.getFormat();
						binfo = new DataLine.Info(Clip.class,bformat);
						block1 = (Clip) AudioSystem.getLine(binfo);
						block1.open(bstream);
						block1.loop(0);
						block1.start();
					}catch (Exception e){}
				}
				if(r[0].intersects(r[7])==true){

					check[7]=1;
				}
				if(r[0].intersects(r[8])==true){

					check[8]=1;

				}
				if(r[0].intersects(r[9])==true){

					jDown=1;
					jUp=0;
					check[9]=1;
					try
					{  
						File bFile=new File("resources/sounds/block.wav");
						score+=6;
						lb4.setText(""+score);
						AudioInputStream bstream;
						AudioFormat bformat;
						DataLine.Info binfo;
						Clip block1;

						bstream = AudioSystem.getAudioInputStream(bFile);
						bformat = bstream.getFormat();
						binfo = new DataLine.Info(Clip.class,bformat);
						block1 = (Clip) AudioSystem.getLine(binfo);
						block1.open(bstream);
						block1.loop(0);
						block1.start();
					}catch (Exception e){}
				}
				if(r[0].intersects(r[10])==true){

					check[10]=1;

				}
				if(r[0].intersects(r[11])==true){

					jDown=1;
					jUp=0;
					check[11]=1;
					try{

						coinAnimPath = "resources/images/sprites/objects/coin_anim.png";
						score+=3;
						lb4.setText(""+score);
						coinAnim=ImageIO.read(new File(coinAnimPath));
						g2d.drawImage(coinAnim,obx[10],oby[10]-50,null);

						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();

					}catch(Exception e){}
				}
				if(r[0].intersects(r[12])==true){

					jDown=1;
					jUp=0;
					check[12]=1;
					try{

						coinAnimPath = "resources/images/sprites/objects/coin_anim.png";
						score+=3;
						lb4.setText(""+score);
						coinAnim=ImageIO.read(new File(coinAnimPath));
						g2d.drawImage(coinAnim,obx[11],oby[11]-50,null);

						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();

					}catch(Exception e){}
				}
				if(r[0].intersects(r[13])==true){

					jDown=1;
					jUp=0;
					check[13]=1;
					try
					{  
						File bFile=new File("resources/sounds/block.wav");
						score+=6;
						lb4.setText(""+score);
						AudioInputStream bstream;
						AudioFormat bformat;
						DataLine.Info binfo;
						Clip block1;

						bstream = AudioSystem.getAudioInputStream(bFile);
						bformat = bstream.getFormat();
						binfo = new DataLine.Info(Clip.class,bformat);
						block1 = (Clip) AudioSystem.getLine(binfo);
						block1.open(bstream);
						block1.loop(0);
						block1.start();
					}catch (Exception e){}
				}
				if(r[0].intersects(r[14])==true){

					check[14]=1;

				}
				if(r[0].intersects(r[16])==true){

					jDown=1;
					jUp=0;
					check[16]=1;
					try
					{  
						File bFile=new File("resources/sounds/block.wav");
						score+=6;
						lb4.setText(""+score);
						AudioInputStream bstream;
						AudioFormat bformat;
						DataLine.Info binfo;
						Clip block1;

						bstream = AudioSystem.getAudioInputStream(bFile);
						bformat = bstream.getFormat();
						binfo = new DataLine.Info(Clip.class,bformat);
						block1 = (Clip) AudioSystem.getLine(binfo);
						block1.open(bstream);
						block1.loop(0);
						block1.start();
					}catch (Exception e){}
				}
				if(r[0].intersects(r[17])==true){

					jDown=1;
					jUp=0;
					check[17]=1;
					try
					{  
						File bFile=new File("resources/sounds/block.wav");
						score+=6;
						lb4.setText(""+score);
						AudioInputStream bstream;
						AudioFormat bformat;
						DataLine.Info binfo;
						Clip block1;

						bstream = AudioSystem.getAudioInputStream(bFile);
						bformat = bstream.getFormat();
						binfo = new DataLine.Info(Clip.class,bformat);
						block1 = (Clip) AudioSystem.getLine(binfo);
						block1.open(bstream);
						block1.loop(0);
						block1.start();
					}catch (Exception e){}
				}
				if(r[0].intersects(r[18])==true){

					jDown=1;
					jUp=0;
					check[18]=1;
					try{

						coinAnimPath = "resources/images/sprites/objects/coin_anim.png";
						score+=3;
						lb4.setText(""+score);
						coinAnim=ImageIO.read(new File(coinAnimPath));
						g2d.drawImage(coinAnim,obx[17],oby[17]-50,null);

						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();

					}catch(Exception e){}
				}
				if(r[0].intersects(r[19])==true){

					jDown=1;
					jUp=0;
					check[19]=1;
					try
					{  
						File bFile=new File("resources/sounds/block.wav");
						score+=6;
						lb4.setText(""+score);
						AudioInputStream bstream;
						AudioFormat bformat;
						DataLine.Info binfo;
						Clip block1;

						bstream = AudioSystem.getAudioInputStream(bFile);
						bformat = bstream.getFormat();
						binfo = new DataLine.Info(Clip.class,bformat);
						block1 = (Clip) AudioSystem.getLine(binfo);
						block1.open(bstream);
						block1.loop(0);
						block1.start();
					}catch (Exception e){}
				}
				if(r[0].intersects(r[20])==true){

					jDown=1;
					jUp=0;
					check[20]=1;
					try{

						coinAnimPath = "resources/images/sprites/objects/coin_anim.png";
						score+=3;
						lb4.setText(""+score);
						coinAnim=ImageIO.read(new File(coinAnimPath));
						g2d.drawImage(coinAnim,obx[19],oby[19]-50,null);

						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();

					}catch(Exception e){}
				}
				if(r[0].intersects(r[21])==true){

					jDown=1;
					jUp=0;
					check[21]=1;
					try
					{  
						File bFile=new File("resources/sounds/block.wav");
						score+=6;
						lb4.setText(""+score);
						AudioInputStream bstream;
						AudioFormat bformat;
						DataLine.Info binfo;
						Clip block1;

						bstream = AudioSystem.getAudioInputStream(bFile);
						bformat = bstream.getFormat();
						binfo = new DataLine.Info(Clip.class,bformat);
						block1 = (Clip) AudioSystem.getLine(binfo);
						block1.open(bstream);
						block1.loop(0);
						block1.start();
					}catch (Exception e){}
				}
				if(r[0].intersects(r[22])==true){

					jDown=1;
					jUp=0;
					check[22]=1;
					try{

						coinAnimPath = "resources/images/sprites/objects/coin_anim.png";
						score+=3;
						lb4.setText(""+score);
						coinAnim=ImageIO.read(new File(coinAnimPath));
						g2d.drawImage(coinAnim,obx[21],oby[21]-50,null);

						Clip coin;
						File cFile=new File("resources/sounds/coin.wav");
						AudioInputStream cstream;
						AudioFormat cformat;
						DataLine.Info cinfo;
						cstream = AudioSystem.getAudioInputStream(cFile);
						cformat = cstream.getFormat();
						cinfo = new DataLine.Info(Clip.class, cformat);
						coin = (Clip) AudioSystem.getLine(cinfo);
						coin.open(cstream);
						coin.loop(0);
						coin.start();

					}catch(Exception e){}
				}
				if(r[0].intersects(r[23])==true){

					jDown=1;
					jUp=0;
					check[23]=1;
					try
					{  
						File bFile=new File("resources/sounds/block.wav");
						score+=6;
						lb4.setText(""+score);
						AudioInputStream bstream;
						AudioFormat bformat;
						DataLine.Info binfo;
						Clip block1;

						bstream = AudioSystem.getAudioInputStream(bFile);
						bformat = bstream.getFormat();
						binfo = new DataLine.Info(Clip.class,bformat);
						block1 = (Clip) AudioSystem.getLine(binfo);
						block1.open(bstream);
						block1.loop(0);
						block1.start();
					}catch (Exception e){}
				}



				//drawing secondary objects
				if(check[0]==1){
					try{ 
						coinUsedPath = "resources/images/sprites/objects/block.png";
						coinUsed=ImageIO.read(new File(coinUsedPath));
						g2d.drawImage(coinUsed,obx[0],oby[0],null);
					}catch(Exception e){}
				} 
				if(check[1]==1){
					try{ 
						brickBrokePath = "resources/images/sprites/objects/broken.png";
						brickBroke=ImageIO.read(new File(brickBrokePath));
						g2d.drawImage(brickBroke,obx[1],oby[1],null);
					}catch(Exception e){}
				}
				if(check[2]==1){
					try{ 
						coinUsedPath = "resources/images/sprites/objects/block.png";
						coinUsed=ImageIO.read(new File(coinUsedPath));
						g2d.drawImage(coinUsed,obx[2],oby[2],null);
					}catch(Exception e){}
				} 
				if(check[3]==1){
					try{ 
						brickBrokePath = "resources/images/sprites/objects/broken.png";
						brickBroke=ImageIO.read(new File(brickBrokePath));
						g2d.drawImage(brickBroke,obx[3],oby[3],null);
					}catch(Exception e){}
				}
				if(check[4]==1){
					try{ 
						coinUsedPath = "resources/images/sprites/objects/block.png";
						coinUsed=ImageIO.read(new File(coinUsedPath));
						g2d.drawImage(coinUsed,obx[4],oby[4],null);
					}catch(Exception e){}
				}
				if(check[5]==1){
					try{ 
						brickBrokePath = "resources/images/sprites/objects/broken.png";
						brickBroke=ImageIO.read(new File(brickBrokePath));
						g2d.drawImage(brickBroke,obx[5],oby[5],null);
					}catch(Exception e){}
				}
				if(check[9]==1){
					try{ 
						brickBrokePath = "resources/images/sprites/objects/broken.png";
						brickBroke=ImageIO.read(new File(brickBrokePath));
						g2d.drawImage(brickBroke,obx[8],oby[8],null);
					}catch(Exception e){}
				}
				if(check[11]==1){
					try{ 
						coinUsedPath = "resources/images/sprites/objects/block.png";
						coinUsed=ImageIO.read(new File(coinUsedPath));
						g2d.drawImage(coinUsed,obx[10],oby[10],null);
					}catch(Exception e){}
				}
				if(check[12]==1){
					try{ 
						coinUsedPath = "resources/images/sprites/objects/block.png";
						coinUsed=ImageIO.read(new File(coinUsedPath));
						g2d.drawImage(coinUsed,obx[11],oby[11],null);
					}catch(Exception e){}
				}
				if(check[13]==1){
					try{ 
						brickBrokePath = "resources/images/sprites/objects/broken.png";
						brickBroke=ImageIO.read(new File(brickBrokePath));
						g2d.drawImage(brickBroke,obx[12],oby[12],null);
					}catch(Exception e){}
				}
				if(check[16]==1){
					try{ 
						brickBrokePath = "resources/images/sprites/objects/broken.png";
						brickBroke=ImageIO.read(new File(brickBrokePath));
						g2d.drawImage(brickBroke,obx[15],oby[15],null);
					}catch(Exception e){}
				}
				if(check[17]==1){
					try{ 
						brickBrokePath = "resources/images/sprites/objects/broken.png";
						brickBroke=ImageIO.read(new File(brickBrokePath));
						g2d.drawImage(brickBroke,obx[16],oby[16],null);
					}catch(Exception e){}
				}
				if(check[18]==1){
					try{ 
						coinUsedPath = "resources/images/sprites/objects/block.png";
						coinUsed=ImageIO.read(new File(coinUsedPath));
						g2d.drawImage(coinUsed,obx[17],oby[17],null);
					}catch(Exception e){}
				}
				if(check[19]==1){
					try{ 
						brickBrokePath = "resources/images/sprites/objects/broken.png";
						brickBroke=ImageIO.read(new File(brickBrokePath));
						g2d.drawImage(brickBroke,obx[18],oby[18],null);
					}catch(Exception e){}
				}
				if(check[20]==1){
					try{ 
						coinUsedPath = "resources/images/sprites/objects/block.png";
						coinUsed=ImageIO.read(new File(coinUsedPath));
						g2d.drawImage(coinUsed,obx[19],oby[19],null);
					}catch(Exception e){}
				}
				if(check[21]==1){
					try{ 
						brickBrokePath = "resources/images/sprites/objects/broken.png";
						brickBroke=ImageIO.read(new File(brickBrokePath));
						g2d.drawImage(brickBroke,obx[20],oby[20],null);
					}catch(Exception e){}
				}
				if(check[22]==1){
					try{ 
						coinUsedPath = "resources/images/sprites/objects/block.png";
						coinUsed=ImageIO.read(new File(coinUsedPath));
						g2d.drawImage(coinUsed,obx[21],oby[21],null);
					}catch(Exception e){}
				}
				if(check[23]==1){
					try{ 
						brickBrokePath = "resources/images/sprites/objects/broken.png";
						brickBroke=ImageIO.read(new File(brickBrokePath));
						g2d.drawImage(brickBroke,obx[22],oby[22],null);
					}catch(Exception e){}
				}

				repaint();
	}

	//keylistening for key pressed
	public void keyPressed(KeyEvent e) {

		if((e.getKeyCode()==KeyEvent.VK_RIGHT)){

			//moving frameset
			f1x=f1x-xInc;
			f2x=f2x-xInc;
			f3x=f3x-xInc;
			exd-=xInc;
			temp1=1;
			temp2=1;
			temp3=1;
			cd-=xInc;
			cd2-=xInc;
			cd3-=xInc;
			cd4-=xInc;
			score+=1;
			try {
				w = new FileWriter("Score.txt");
				if(score>=hsp.sint){
					w.write(""+score);
				} 
				else {  
					w.write(""+hsp.sint);
				}
				w.close();
			} catch(Exception we){}
			lb4.setText(""+score);
			if(f4x>5){
				f4x=f4x-xInc;
			}
			//collision detection
			for(int i=0; i<=95; i++){
				obx[i]=obx[i]-xInc;
			}

			//moving mario
			xPos += 1;
			runLeft=4;


			//right movement 
			if(runRight==2){
				direction = moveRight;
			}
			else if(runRight==4){

				direction = stillRight;
			}
			runRight++;
			if(runRight>4){
				runRight=0;
			}


			//collision with pipe

			if(r[0].intersects(r[7])==true){

				System.out.println("pipe");
				xPos=obx[6]-50;
				xInc=0;

			}
			if(r[0].intersects(r[8])==true){

				System.out.println("pipe");
				xPos=obx[7]-50;
				xInc=0;

			}
			if(r[0].intersects(r[10])==true){

				System.out.println("pipe");
				xPos=obx[9]-50;
				xInc=0;

			}
			if(r[0].intersects(r[14])==true){

				System.out.println("pipe");
				xPos=obx[13]-50;
				xInc=0;

			}
			if(r[0].intersects(r[24])==true){

				System.out.println("pipe");
				xPos=obx[23]-50;
				xInc=0;

			}


			//calling repaint
			repaint();


		}

		if((e.getKeyCode()==KeyEvent.VK_LEFT)){

			if(r[0].intersects(r[32])==true){

				System.out.println("pipe");
				xPos=obx[31]+50;
				xInc=0;
			}
			//forMovement
			runRight=4;

			//moving mario
			xPos -= 8;

			//left movement 
			if(runLeft==2){
				direction = moveLeft;
			}
			else if(runLeft==4){

				direction = stillLeft;
			}
			runLeft++;
			if(runLeft>4){
				runLeft=0;
			}

			//calling repaint
			repaint();
		}

		if(e.getKeyCode()==KeyEvent.VK_UP){
			try {
				Clip jump;
				File jFile=new File("resources/sounds/jump.wav");
				AudioInputStream jstream;
				AudioFormat jformat;
				DataLine.Info jinfo;
				jstream = AudioSystem.getAudioInputStream(jFile);
				jformat = jstream.getFormat();
				jinfo = new DataLine.Info(Clip.class, jformat);
				jump = (Clip) AudioSystem.getLine(jinfo);
				jump.open(jstream);
				jump.loop(0);
				jump.start();

			}catch(Exception je){}

			//setting jump face
			if(direction==stillRight||direction==moveRight||direction==duckRight){
				direction = jumpRight;
			}
			if(direction==stillLeft||direction==moveLeft||direction==duckLeft){
				direction = jumpLeft;
			}

			//doing jump
			jump = -2;
			jDown=0;
			jUp=0;
			arc=0;

			//calling repaint
			repaint(); 

		}
		if(e.getKeyCode()==32){


			//setting jump face
			if(direction==stillRight||direction==moveRight||direction==duckRight){
				direction = jumpRight;
			}
			if(direction==stillLeft||direction==moveLeft||direction==duckLeft){
				direction = jumpLeft;
			}

			//doing jump
			jump = -2;
			jDown=0;
			jUp=0;
			arc=1;
			try {
				Clip jump;
				File jFile=new File("resources/sounds/jump.wav");
				AudioInputStream jstream;
				AudioFormat jformat;
				DataLine.Info jinfo;
				jstream = AudioSystem.getAudioInputStream(jFile);
				jformat = jstream.getFormat();
				jinfo = new DataLine.Info(Clip.class, jformat);
				jump = (Clip) AudioSystem.getLine(jinfo);
				jump.open(jstream);
				jump.loop(0);
				jump.start();

			}catch(Exception je){}

			//restoring xInc
			xInc=10;

			//calling repaint
			repaint(); 

		}


		if((e.getKeyCode()==KeyEvent.VK_DOWN)){

			//ducking
			if(direction==stillRight||direction==moveRight){
				direction = duckRight;
			}
			if(direction==stillLeft||direction==moveLeft){
				direction = duckLeft;
			}

			//repaint
			repaint();
		}
	}

	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e) {}

	//Mouselistening starts
	public void mouseClicked(MouseEvent me){
		int xp=0;
		int yp=0;
		xp=me.getX();
		yp=me.getY();
		System.out.println(""+ xp + ","+ yp);
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseDragged(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}

}//end panel class    


//main class starts here
public class GamePlay extends JFrame{


	//main class constructor
	GamePlay(){

		GamePanel gp = new GamePanel();
		add(gp);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true); 
	}

	//method main starts here
	public static void main (String[] args){

		GamePlay gmp = new GamePlay();

	} 

}