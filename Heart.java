import javax.swing.ImageIcon; 
import java.awt.*;

//Heart object information
public class Heart extends Base_Object{
 //Create a heart
   public Heart(){
     this.h = 30;
     this.w =30;
     image = new ImageIcon(this.getClass().getResource("HeartImage.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
   }  
               
}