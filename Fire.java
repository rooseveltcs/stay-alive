import javax.swing.ImageIcon; 
import java.awt.*;

public class Fire extends Base_Object{
   
   boolean left = true;
   boolean down = true;
   
  
   public Fire(){
      image = new ImageIcon(this.getClass().getResource("fire.png")).getImage();
      this.w = image.getWidth(null);
      this.h = image.getHeight(null);
   }
   
   //move
   public void addX(){
      if(left){
         this.x++;
         if(this.x==650){
            left = false;
         }
      }else{
         this.x--;
         if(this.x==0){
            left = true;
         }
      }
      
   }
   
   public void addY(){
      if(down){
         this.y++;
         if(this.y==600){
            down = false;
         }
      }else{
         this.y--;
         if(this.y==50){
            down = true;
         }
      }
      
   }
   
   
    
}