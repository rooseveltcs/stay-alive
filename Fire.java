import javax.swing.ImageIcon; 
import java.awt.*;

//Fire object information, has movements
public class Fire extends Base_Object{
   
   boolean left = true;
   boolean down = true;
   
 //Create Fire 
   public Fire(){
      image = new ImageIcon(this.getClass().getResource("fire.png")).getImage();
      this.w = image.getWidth(null);
      this.h = image.getHeight(null);
   }
   
//Add/Sub x/y coordinate, bounce off when reach bounds
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
         if(this.y==45){
            down = true;
         }
      }
      
   }
   
   
    
}