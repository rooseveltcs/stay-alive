import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;



public class GamePanel extends JPanel{
   
   private Player player ;
   boolean key_right, key_left, key_down, key_up; 
   private ArrayList<Fire> fireRecord = new ArrayList<Fire>(); 
   private ArrayList<Heart> hearts = new ArrayList<Heart>();
   private ArrayList<Water> waters = new ArrayList<Water>();
   private int initScore, moveCount;
   private Image barImage  = new ImageIcon(this.getClass().getResource("Bar.png")).getImage(); 
   private boolean delay;
   private int click = 0;
   private boolean ended = false;
   private boolean atStartPanel = true;
   private int heartScore = 1;
   private int waterCap =0;
   private int speedAdj = 20;
   
   public GamePanel(){
      this.addKeyListener(new GameInput());
      addMouseListener(new MouseInput()); 
      
      setBounds(0,0,690,700);
      setLayout(null);
      setBackground(Color.BLACK);
      setDoubleBuffered(true);
      this.setFocusable(true);
      
      this.add(new StartPanel()); //START WITH A START MENUE
   }
//////////////////////////////////////////////////////////////   
////////////////////START A NEW GAME/////////////////////////////   
   public void newGame(){
      fireRecord.clear();
      hearts.clear();
      waters.clear();
      player = new Player();
      fireRecord.add(new Fire());
       
      delay = false;
      initScore= 0;
      moveCount = 0;
      heartScore = 0;
      waterCap = 0;
   }
////////////////////////////////////////////////////////////   
//////REMOVE GAMVEOVE, START A NEW GAME///////////////////////      
   public void reset(){
      newGame();
      removeAll();
      repaint();
      ended = false;
   } 
////////////////////////////////////////////////////////////////
/////////////////PAINT COMPONENTS ON THE PANEL///////////////   
   public void paintComponent(Graphics g){
      super.paintComponent(g); 
      g.drawImage(barImage,0,0,this);
      
      if(atStartPanel){ //default true, change to false if clicked once
         this.add(new StartPanel());
      }
      else{      //Start the game
         if(!ended){   
            if(delay){ 
               drawPlayer(g, player.getImage2()); 
            }
            else{
               drawPlayer(g, player.getImage1());
            } 
         
            drawFire(g);
            drawHearts(g);
            drawWaters(g);
         }
       
      
      //GameOver when lives reaches 0; 
         if(player.getLives() == 0){
            this.add(new GameOver(player.getScore())); 
            ended = true;  
         }
      }
      
        
   }  
////////////////////////////////////////////////// 
/////////////////REPAINT PLAYER AND THE OBJECTS///////////////
   private void drawPlayer(Graphics g, Image playerImage){
       
      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.PLAIN, 20)); 
      g.drawString(""+player.getScore(),25,23);
      g.drawString(""+player.getLives(),600,23);
      
      g.drawImage(playerImage, player.getX(), player.getY(), this); 
      
        
      if (key_down && player.getY()<620)  {
         player.addY();
         player.addScore();
      }
         
      if (key_up  && player.getY()>40)   {
         player.subY();
         player.addScore();
      } 
          
      if (key_right && player.getX()<650) {
         player.addX();
         player.addScore();
      }
         
      if (key_left && player.getX()>10) {
         player.subX();
         player.addScore();
      }
         
      moveCount++;
      repaint();
         
   }
//////////////////////////////////////////////////////////
/////////////REPAINT EACH FIRE AND TEST////////////////////   
   public void drawFire(Graphics g){
      
      if(player.getScore()>= initScore+1000){
         fireRecord.add(new Fire());
         initScore+=1000;
      }  
      
      for(int i=0; i<fireRecord.size(); i++){
         Fire current = fireRecord.get(i);
         boolean test = current.test(player.getX(), player.getY(), player.getW(), player.getH(),5);       
         if(!delay){
            if(test){
               player.loseLife();
               delay = true; //If player loses a life, become invulnerable for a short period of time
            }
         }
         
         if (moveCount%5000 == 0){ /// Delay after taking dmg
            delay = false;
         }        
          
         if(moveCount%speedAdj==0){ //Adjust Speed
            current.addX();
            current.addY();
                
         }
         g.drawImage(current.getImage(), current.getX(), current.getY(), this); 
      
      }  
           
   }
////////////////////////////////////////////////////////////////////   
////////////REPAINT HEARTS AND TEST////////////////////////////////
   public void drawHearts(Graphics g){
      
      if(player.getScore()>= 10000*heartScore ){
         hearts.add(new Heart());
         heartScore++;
      }  
      
      for(int i=0; i<hearts.size(); i++){
         Heart currentHeart = hearts.get(i);
         boolean test = currentHeart.test(player.getX(), player.getY(), player.getW(), player.getH(),-5);       
         
         if(test){
            if(player.getLives()<3){
               player.addLife();
            }
            hearts.remove(currentHeart);
           
         }   
        
         g.drawImage(currentHeart.getImage(), currentHeart.getX(), currentHeart.getY(), this); 
      
      }  
           
   }
////////////////////////////////////////////////////////////////
//////////////////REPAINT WATER AND TEST///////////////////////
   public void drawWaters(Graphics g){
      
      if(fireRecord.size() > 20+ (waterCap*3)){
         waters.add(new Water());
         waterCap++;
      }  
      
      for(int i=0; i<waters.size(); i++){
         Water currentWater = waters.get(i);
         boolean test = currentWater.test(player.getX(), player.getY(), player.getW(), player.getH(),-5);       
         
         if(test){
            if(fireRecord.size()>5){
               for(int k = 1; k<=5 ; k++){
                  fireRecord.remove(0);
               }
            }
            else{
               fireRecord.remove(0);      
            }
            waters.remove(currentWater);     
         }   
        
         g.drawImage(currentWater.getImage(), currentWater.getX(), currentWater.getY(), this); 
      }         
   }       
///////////////////////////////////////////////////////////
/////////////PRIVATE KEY LISTENER FOR THE PLAYER///////////
   private class GameInput implements KeyListener {  
      public void keyTyped(KeyEvent e) {}
      
      public void keyReleased(KeyEvent e) {  
         if (e.getKeyCode() == e.VK_DOWN) key_down = false;
         if (e.getKeyCode() == e.VK_UP) key_up = false;
         if (e.getKeyCode() == e.VK_RIGHT) key_right = false;
         if (e.getKeyCode() == e.VK_LEFT) key_left = false;   
      }
   
      public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == e.VK_DOWN) key_down = true;
         if (e.getKeyCode() == e.VK_UP) key_up = true;
         if (e.getKeyCode() == e.VK_RIGHT) key_right = true;
         if (e.getKeyCode() == e.VK_LEFT) key_left = true;
      }
   }
    
    
///////////////////////////////////////////////////////////
///////////PRIVATE MOUSE LISTENER FOR THE PLAYER///////////
   private class MouseInput implements MouseListener{
      public void mouseExited(MouseEvent e){}
      public void mouseEntered(MouseEvent e){}
      public void mouseReleased(MouseEvent e){}
      public void mousePressed(MouseEvent e){}
      
      public void mouseClicked(MouseEvent e){
         if(atStartPanel){
            atStartPanel = false;
            reset();
         }
            
         if(ended && !atStartPanel){
            click ++;
            if(click ==2){
               reset();
               click=0;
            }  
         }    
      }
   }
}