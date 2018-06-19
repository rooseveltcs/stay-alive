import javax.swing.*;
import java.awt.*;

//Main run 
/*Stay Alive! is a game where the player tries to stay alive as long as possible and gaining the most amount of score
/ The player gain score by moving with arrow keys.
/ If the player touches fire, player will lose a life and become invulunable for a period of time
/ Player could collect Items
/     - Heart to gain 1 life, lives are capped at 3
/     - Water to remove some of the fire 
*/
public class StayAlive extends JFrame{
  
   private Image gameIcon = new ImageIcon(this.getClass().getResource("GameIcon.png")).getImage(); 
  
   public StayAlive(){   
      this.setTitle("Stay Alive!");  
      this.setSize(new Dimension(690,700));
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setIconImage(gameIcon);
      this.getContentPane().setLayout(new BorderLayout()); 
      this.setBackground(new Color(185,122,87));
      this.add(new GamePanel());
      this.setVisible(true);
      this.setResizable(false);  
   }

   public static void main(String[] agrs){
      new StayAlive();
   }
}
 
   
   
          
   
   