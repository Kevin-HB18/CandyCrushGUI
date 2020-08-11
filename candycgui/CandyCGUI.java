
package candycgui;

import javax.swing.JOptionPane;

public class CandyCGUI {

   
    public static void main(String[] args) {
        String nombre;
        nombre=JOptionPane.showInputDialog(null, "Digite su nombre: ", "Candy Crush", 1);        
        Tablero a = new Tablero(nombre);
        if(a.points()==false){
            JOptionPane.showMessageDialog(null,"¡HAS PERDIDO!", "Candy Crush", 0);
        }
        a.setVisible(true);
        
    }
}
