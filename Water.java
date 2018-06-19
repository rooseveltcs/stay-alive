import javax.swing.ImageIcon; 
import java.awt.*;

//Water object information
public class Water extends Base_Object{
 //Create a Water 
   public Water(){
     this.h = 30;
     this.w =30;
     image = new ImageIcon(this.getClass().getResource("WaterImage.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
   }  
               
}