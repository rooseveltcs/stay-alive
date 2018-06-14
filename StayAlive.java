import javax.swing.*;
import java.awt.*;

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
 
   
   
          
   
   