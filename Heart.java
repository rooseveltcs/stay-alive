import javax.swing.ImageIcon; 
import java.awt.*;

public class Heart extends Base_Object{
 
   public Heart(){
     this.h = 30;
     this.w =30;
     image = new ImageIcon(this.getClass().getResource("HeartImage.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
   }  
               
}