
package candycgui;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Candy extends JButton  {
    ImageIcon icon = new ImageIcon();
    
    public Candy(String pic){               
       icon = new ImageIcon(pic);        
    }  

    public ImageIcon getIcon() {
        return icon;
    }
    

    
    
    
    
    
}
