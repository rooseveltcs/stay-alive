import javax.swing.ImageIcon; 
import java.awt.*;

public class Player{
   
   private Image image1 =  new ImageIcon(this.getClass().getResource("PlayerIcon1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); 
   private Image image2 =  new ImageIcon(this.getClass().getResource("PLayerIcon2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); 
   private int xplus = 0;
   private int yplus = 0;
   private int xminus = 0;
   private int yminus = 0;
   private int x = 10;
   private int y = 50;
   private int score = 0;
   private int w , h;
   private int lives = 3;
   private int speedAdj = 5;
      
   public Player(){ 
      w = image1.getWidth(null);
      h = image1.getHeight(null);
   }    
      
   public int getX(){
      return this.x;
   }
   
   public int getY(){
      return this.y;
   }
   
   public int getW(){
      return 30;
   }
  
   public int getH(){
      return 3;
   }
   
   public Image getImage1(){
      return this.image1;
   } 
   
   public Image getImage2(){
      return this.image2;
   } 
 
 //When ever a the player presses a key, the player will move, speedAdj to adjust speed
   public void addX(){
      xplus++;
      if(xplus%speedAdj == 0){   
         this.x++;
      }   
   }
   
   public void addY(){
      yplus++;
      if(yplus%speedAdj == 0){  
         this.y++;
      } 
   } 
   
   public void subX(){
      xminus++;
      
      if(xminus%speedAdj == 0){  
         this.x--;
      }   
   }
   
   
   public void subY(){   
      yminus++;
      
      if(yminus%speedAdj == 0){
         this.y--;
      } 
   }
   
   public int getScore(){
      return this.score;
   }
   
   public void addScore(){
      this.score++;
   } 

   public void loseLife(){
      this.lives--;
   }
  
   public void addLife(){
      this.lives++;
   }
   
   public int getLives(){
      return this.lives;
   }             
        
}