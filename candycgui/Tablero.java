package candycgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JFrame implements ActionListener {
    
    private Jugador player;
    private Candy[] candies;   
    private JButton boton[][] = new JButton[9][9];
    private JLabel cabezal[] = new JLabel[4];
    JPanel inicio = new JPanel();
    JPanel board = new JPanel();
    public Tablero(String name){
        player = new Jugador(name,5,51);
        setSize(600,600);        
        setTitle("CandyCrush");      
        setLocationRelativeTo(null);//si pone null, entonces pone la ventana en el centro
        setResizable(false); //establecer si la ventana puede cambiar de tamaño o no    
        //Jugador player= new Jugador("name",5,50);
        candies= new Candy[5];
        candies[0] = new Candy("imagenes/bayern.png");
        candies[1] = new Candy("imagenes/corinthians.png");
        candies[2] = new Candy("imagenes/munited.png");
        candies[3] = new Candy("imagenes/real.png");
        candies[4] = new Candy("imagenes/river.jpg");       
        
        createPlayer();
        generarBoard();        
        moveCandies();        
        setDefaultCloseOperation(EXIT_ON_CLOSE );        
        
    }
   
    public void generarBoard(){
        int aux = 0; 
        int dado=0;       
                  
        board.setBounds(0, 100, 600,500);
        GridLayout mat = new GridLayout(boton.length,boton.length);           
        board.setLayout(mat);               
        for(int i=0;i<boton.length;i++){
            for(int j=0;j<boton[0].length;j++){               
	        dado=(int) Math.floor(Math.random()*5+1);               
                switch (dado) {
	            case 1:
                        boton[i][j]= new JButton(candies[0].getIcon());
                        boton[i][j].setSize(60,60);
                        boton[i][j].setName("bayer");
                        boton[i][j].setIcon(new ImageIcon(candies[0].getIcon().getImage().getScaledInstance(boton[i][j].getWidth(), boton[i][j].getHeight(), Image.SCALE_SMOOTH)));
                        board.add(boton[i][j]);                         
	               
	            break;
	            case 2:
                        boton[i][j] = new JButton(candies[1].getIcon());
                        boton[i][j].setSize(60,60);
                        boton[i][j].setName("Corinthians");                        
                        boton[i][j].setIcon(new ImageIcon(candies[1].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));
                        board.add( boton[i][j]);          
                    break;
	            case 3:
                         boton[i][j] = new JButton(candies[2].getIcon());
                         boton[i][j].setSize(60,60);
                         boton[i][j].setName("MUnitied");                         
                         boton[i][j].setIcon(new ImageIcon(candies[2].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));                        
                        board.add( boton[i][j]);          
	            break;
	            case 4:
                         boton[i][j] = new JButton(candies[3].getIcon());
                         boton[i][j].setSize(60,60);
                         boton[i][j].setName("Real");
                         boton[i][j].setIcon(new ImageIcon(candies[3].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));
                        board.add( boton[i][j]);          
	            break;
                    case 5:
                         boton[i][j] = new JButton(candies[4].getIcon());
                         boton[i][j].setSize(60,60);
                         boton[i][j].setName("river");
                         boton[i][j].setIcon(new ImageIcon(candies[4].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));
                        board.add( boton[i][j]);          
	            break;
	        }  
                      
                
            }
        }       
        quitarRepetidosVertical();
        quitarRepetidosHorizontal();
        for(int i=0;i<boton.length;i++){
            for(int j=0;j<boton[0].length;j++){
                boton[i][j].setBackground(Color.WHITE);
            }
        }                 
        this.getContentPane().add(board,BorderLayout.CENTER);//añadir panel              
    }//fin generarBoard
    
    public void createPlayer(){                  
        GridLayout start = new GridLayout(2,2);     
        inicio.setBounds(0, 0, 600, 100);
        inicio.setLayout(start);               
        this.getContentPane().add(inicio,BorderLayout.NORTH);        
        cabezal[0] = new JLabel("Nombre: "+player.getNombre());
        inicio.add(cabezal[0]);
        cabezal[1] = new JLabel("Vidas: "+player.getVidas());
        inicio.add(cabezal[1]);
        cabezal[2] = new JLabel("Puntos: "+player.getPuntos());
        inicio.add(cabezal[2]);
        cabezal[3] = new JLabel("Movimientos: "+player.getMovimientos());   
        inicio.add(cabezal[3]);
       
    }//fin createPlayer    
    
    public void quitarRepetidosVertical(){
       int aux=0;
       for(int i=1;i<boton.length-1;i++){
           for(int j=0;j<boton[0].length;j++){
               while(boton[i][j].getName().equals(boton[i-1][j].getName()) || boton[i][j].getName().equals(boton[i+1][j].getName())){
                   aux = (int) Math.floor(Math.random()*5+1);
                   
                    if(aux==1){
                        boton[i][j].setName("bayer");
                        boton[i][j].setIcon(candies[0].getIcon());
                    }else if(aux==2){
                        boton[i][j].setName("Corinthians");
                        boton[i][j].setIcon(candies[1].getIcon());
                    }else if(aux==3){
                        boton[i][j].setName("MUnitied");
                        boton[i][j].setIcon(candies[2].getIcon());
                    }else if(aux==4){
                        boton[i][j].setName("Real");
                        boton[i][j].setIcon(candies[3].getIcon());
                    }else if(aux==5){
                        boton[i][j].setName("river");
                        boton[i][j].setIcon(candies[4].getIcon());
                    }                             
                     boton[i][j].setIcon(new ImageIcon(candies[aux-1].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));
                                        
               }
           }
       }             
    }
    public void quitarRepetidosHorizontal(){
        int aux=0;
        for(int i=0;i<boton.length;i++){
            for(int j=1;j<boton[0].length-1;j++){
                if(i==0){
                    while(boton[i][j].getName().equals(boton[i][j+1].getName()) || boton[i][j].getName().equals(boton[i][j-1].getName())){
                        aux = (int) Math.floor(Math.random()*5+1);
                       // System.out.println("win");
                        if(aux==1){
                            boton[i][j].setName("bayer");
                            boton[i][j].setIcon(candies[0].getIcon());
                        }else if(aux==2){
                            boton[i][j].setName("Corinthians");
                            boton[i][j].setIcon(candies[1].getIcon());
                        }else if(aux==3){
                            boton[i][j].setName("MUnitied");
                            boton[i][j].setIcon(candies[2].getIcon());
                        }else if(aux==4){
                            boton[i][j].setName("Real");
                            boton[i][j].setIcon(candies[3].getIcon());
                        }else if(aux==5){
                            boton[i][j].setName("river");
                            boton[i][j].setIcon(candies[4].getIcon());
                        }
                        while(boton[i][j].getName().equals(boton[i+1][j].getName())){
                            aux = (int) Math.floor(Math.random()*5+1);
                            //System.out.println("won");
                            if(aux==1){
                                boton[i][j].setName("bayer");
                                boton[i][j].setIcon(candies[0].getIcon());
                            }else if(aux==2){
                                boton[i][j].setName("Corinthians");
                                boton[i][j].setIcon(candies[1].getIcon());
                            }else if(aux==3){
                                boton[i][j].setName("MUnitied");
                                boton[i][j].setIcon(candies[2].getIcon());
                            }else if(aux==4){
                                boton[i][j].setName("Real");
                                boton[i][j].setIcon(candies[3].getIcon());
                            }else if(aux==5){
                                boton[i][j].setName("river");
                                boton[i][j].setIcon(candies[4].getIcon());
                            }
                        }
                        boton[i][j].setIcon(new ImageIcon(candies[aux-1].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));

                    }
                }else if(i<boton.length-1 && i>0){
                    while(boton[i][j].getName().equals(boton[i][j+1].getName()) || boton[i][j].getName().equals(boton[i][j-1].getName())){
                        aux = (int) Math.floor(Math.random()*5+1);
                       // System.out.println("yeah");
                        if(aux==1){
                            boton[i][j].setName("bayer");
                            boton[i][j].setIcon(candies[0].getIcon());
                        }else if(aux==2){
                            boton[i][j].setName("Corinthians");
                            boton[i][j].setIcon(candies[1].getIcon());
                        }else if(aux==3){
                            boton[i][j].setName("MUnitied");
                            boton[i][j].setIcon(candies[2].getIcon());
                        }else if(aux==4){
                            boton[i][j].setName("Real");
                            boton[i][j].setIcon(candies[3].getIcon());
                        }else if(aux==5){
                            boton[i][j].setName("river");
                            boton[i][j].setIcon(candies[4].getIcon());
                        }
                        while(boton[i][j].getName().equals(boton[i+1][j].getName()) || boton[i][j].getName().equals(boton[i-1][j].getName())){                           
                             aux = (int) Math.floor(Math.random()*5+1);
                            // System.out.println("noah");
                            if(aux==1){
                                boton[i][j].setName("bayer");
                                boton[i][j].setIcon(candies[0].getIcon());
                            }else if(aux==2){
                                boton[i][j].setName("Corinthians");
                                boton[i][j].setIcon(candies[1].getIcon());
                            }else if(aux==3){
                                boton[i][j].setName("MUnitied");
                                boton[i][j].setIcon(candies[2].getIcon());
                            }else if(aux==4){
                                boton[i][j].setName("Real");
                                boton[i][j].setIcon(candies[3].getIcon());
                            }else if(aux==5){
                                boton[i][j].setName("river");
                                boton[i][j].setIcon(candies[4].getIcon());
                            }
                        }
                        boton[i][j].setIcon(new ImageIcon(candies[aux-1].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));

                    }
                    
                }else if(i==boton.length-1){
                    while(boton[i][j].getName().equals(boton[i][j+1].getName()) || boton[i][j].getName().equals(boton[i][j-1].getName())){
                        aux = (int) Math.floor(Math.random()*5+1);
                       // System.out.println("wiii");
                        if(aux==1){
                            boton[i][j].setName("bayer");
                            boton[i][j].setIcon(candies[0].getIcon());
                        }else if(aux==2){
                            boton[i][j].setName("Corinthians");
                            boton[i][j].setIcon(candies[1].getIcon());
                        }else if(aux==3){
                            boton[i][j].setName("MUnitied");
                            boton[i][j].setIcon(candies[2].getIcon());
                        }else if(aux==4){
                            boton[i][j].setName("Real");
                            boton[i][j].setIcon(candies[3].getIcon());
                        }else if(aux==5){
                            boton[i][j].setName("river");
                            boton[i][j].setIcon(candies[4].getIcon());
                        }
                        while(boton[i][j].getName().equals(boton[i-1][j].getName())){
                            aux = (int) Math.floor(Math.random()*5+1);
                        //    System.out.println("nooo");
                            if(aux==1){
                                boton[i][j].setName("bayer");
                                boton[i][j].setIcon(candies[0].getIcon());
                            }else if(aux==2){
                                boton[i][j].setName("Corinthians");
                                boton[i][j].setIcon(candies[1].getIcon());
                            }else if(aux==3){
                                boton[i][j].setName("MUnitied");
                                boton[i][j].setIcon(candies[2].getIcon());
                            }else if(aux==4){
                                boton[i][j].setName("Real");
                                boton[i][j].setIcon(candies[3].getIcon());
                            }else if(aux==5){
                                boton[i][j].setName("river");
                                boton[i][j].setIcon(candies[4].getIcon());
                            }
                        }
                        boton[i][j].setIcon(new ImageIcon(candies[aux-1].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));

                    }
                }
            }
        }       
    }
    public void moveCandies(){
        for(int i=0;i<boton.length;i++){
            for(int j=0;j<boton[0].length;j++){
                 boton[i][j].addActionListener(this);
            }
        }      
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     int x=0,y=0;
     int cont=0;
     
     for(int i=0;i<boton.length;i++){
         for(int j=0;j<boton[0].length;j++){
             if(e.getSource().equals(boton[i][j])){
                x=i;
                y=j;                     
            }
         }
     }     
     flechas(x,y);     
     x=0;
     y=0;
     
    }
    public void flechas(int x,int y){
       
       KeyListener fl = new KeyListener() {               
           @Override
           public void keyTyped(KeyEvent e) {
               //nada   
           }

           @Override
           public void keyPressed(KeyEvent e) {
               //nada
           }

           @Override
           public void keyReleased(KeyEvent e) {
              if(e.getKeyChar() == 'w'){
                  if((x!=0 && y!=0 && y<boton.length-1 && boton[x][y].getName().equals(boton[x-1][y-1].getName()) && boton[x][y].getName().equals(boton[x-1][y+1].getName()))
                    || (x!=0 && y<boton.length-2 && boton[x][y].getName().equals(boton[x-1][y+1].getName()) && boton[x][y].getName().equals(boton[x-1][y+2].getName()))
                    || (x!=0 && y>1 && boton[x][y].getName().equals(boton[x-1][y-1].getName()) && boton[x][y].getName().equals(boton[x-1][y-2].getName())) 
                    || (x>2 && boton[x][y].getName().equals(boton[x-2][y].getName()) && boton[x][y].getName().equals(boton[x-3][y].getName()))){                     
                  
                    JButton help = new JButton();
                    System.out.println("fue w");
                    help.setIcon(boton[x][y].getIcon());
                    help.setName(boton[x][y].getName());
                    boton[x][y].setIcon(boton[x-1][y].getIcon());
                    boton[x][y].setName(boton[x-1][y].getName());
                    boton[x-1][y].setIcon(help.getIcon());
                    boton[x-1][y].setName(help.getName());
                    points(); 
                  } 
              }else if(e.getKeyChar()=='s'){
                  if((x!=boton.length-1 && y!=0 && y<boton.length-1 && boton[x][y].getName().equals(boton[x+1][y-1].getName()) && boton[x][y].getName().equals(boton[x+1][y+1].getName()))
                     || (x!=boton.length-1 && y>1 && boton[x][y].getName().equals(boton[x+1][y-1].getName()) && boton[x][y].getName().equals(boton[x+1][y-2].getName()))
                     || (x!=boton.length-1 && y<boton.length-2 && boton[x][y].getName().equals(boton[x+1][y+1].getName()) && boton[x][y].getName().equals(boton[x+1][y+2].getName()))  
                     || (x<boton.length-3 && boton[x][y].getName().equals(boton[x+2][y].getName()) && boton[x][y].getName().equals(boton[x+3][y].getName()))){                    
                  
                    JButton help = new JButton();
                    System.out.println("fue s");
                    help.setIcon(boton[x][y].getIcon());
                    help.setName(boton[x][y].getName());
                    boton[x][y].setIcon(boton[x+1][y].getIcon());
                    boton[x][y].setName(boton[x+1][y].getName());
                    boton[x+1][y].setIcon(help.getIcon());
                    boton[x+1][y].setName(help.getName());
                    points();
                  }  
              }else if(e.getKeyChar()=='a'){
                  if((y!=0 && x>0 && x<boton.length-1 && boton[x][y].getName().equals(boton[x-1][y-1].getName()) && boton[x][y].getName().equals(boton[x+1][y-1].getName()))
                     || (y!=0 && x>1 && boton[x][y].getName().equals(boton[x-1][y-1].getName()) && boton[x][y].getName().equals(boton[x-2][y-1].getName()))  
                     || (y!=0 && x<boton.length-2 && boton[x][y].getName().equals(boton[x+1][y-1].getName()) && boton[x][y].getName().equals(boton[x+2][y-1].getName()))   
                     || (y>2 && boton[x][y].getName().equals(boton[x][y-2].getName()) && boton[x][y].getName().equals(boton[x][y-3].getName()))){                   
                  
                    JButton help = new JButton();
                    System.out.println("fue a");
                    help.setIcon(boton[x][y].getIcon());
                    help.setName(boton[x][y].getName());
                    boton[x][y].setIcon(boton[x][y-1].getIcon());
                    boton[x][y].setName(boton[x][y-1].getName());
                    boton[x][y-1].setIcon(help.getIcon());
                    boton[x][y-1].setName(help.getName());
                    points();
                  }
              }else if(e.getKeyChar()=='d'){
                  if((y!=boton.length-1 && x>0 && x<boton.length-1 && boton[x][y].getName().equals(boton[x-1][y+1].getName()) && boton[x][y].getName().equals(boton[x+1][y+1].getName()))
                     || (y!=boton.length-1 && x>1 && boton[x][y].getName().equals(boton[x-1][y+1].getName()) && boton[x][y].getName().equals(boton[x-2][y+1].getName()))  
                     || (y!=boton.length-1 && x<boton.length-2 && boton[x][y].getName().equals(boton[x+1][y+1].getName()) && boton[x][y].getName().equals(boton[x+2][y+1].getName()))
                     || (y<boton.length-3 && boton[x][y].getName().equals(boton[x][y+2].getName()) && boton[x][y].getName().equals(boton[x][y+3].getName())) ){                      
                  
                    JButton help = new JButton();
                    System.out.println("fue d");
                    help.setIcon(boton[x][y].getIcon());
                    help.setName(boton[x][y].getName());
                    boton[x][y].setIcon(boton[x][y+1].getIcon());
                    boton[x][y].setName(boton[x][y+1].getName());
                    boton[x][y+1].setIcon(help.getIcon());
                    boton[x][y+1].setName(help.getName());  
                    points();
                  }  
              }    
           }           
       };         
        boton[x][y].addKeyListener(fl);        
       
    }
    public boolean points(){        
            boolean maspuntos=false;
            //para lo horizontal --------
            for(int i=0;i<boton.length;i++){
                for(int j=0;j<boton[0].length;j++){                
                    if(j<boton.length-5 && !boton[i][j].getName().equals("")){
                        if(boton[i][j].getName().equals(boton[i][j+1].getName()) && boton[i][j].getName().equals(boton[i][j+2].getName()) && boton[i][j].getName().equals(boton[i][j+3].getName()) && boton[i][j].getName().equals(boton[i][j+4].getName()) && boton[i][j].getName().equals(boton[i][j+5].getName()) ){
                            for(int k=j;k<=j+5;k++){                               
                                boton[i][k].setIcon(new ImageIcon());
                                boton[i][k].setName("");                                
                            }
                            player.addPuntos(400);   
                            cabezal[2].setText("Puntos: "+player.getPuntos());
                            maspuntos=true;
                        }          
                    }                       
                    if(j<boton.length-4 && !boton[i][j].getName().equals("")){
                        if(boton[i][j].getName().equals(boton[i][j+1].getName()) && boton[i][j].getName().equals(boton[i][j+2].getName()) && boton[i][j].getName().equals(boton[i][j+3].getName()) && boton[i][j].getName().equals(boton[i][j+4].getName()) ){
                            for(int k=j;k<=j+4;k++){                                
                                boton[i][k].setIcon(new ImageIcon());
                                boton[i][k].setName("");
                               
                            }
                             player.addPuntos(200);   
                             cabezal[2].setText("Puntos: "+player.getPuntos());
                              maspuntos=true;
                        }          
                    }        
                         
                    if(j<boton.length-3 && !boton[i][j].getName().equals("")){
                        if(boton[i][j].getName().equals(boton[i][j+1].getName()) && boton[i][j].getName().equals(boton[i][j+2].getName()) && boton[i][j].getName().equals(boton[i][j+3].getName()) ){
                            for(int k=j;k<=j+3;k++){
                                boton[i][k].setIcon(new ImageIcon());
                                boton[i][k].setName("");                               
                            }
                             player.addPuntos(100);   
                             cabezal[2].setText("Puntos: "+player.getPuntos());
                              maspuntos=true;
                        }          
                    }      
                           
                    if(j<boton.length-2 && !boton[i][j].getName().equals("")){
                        if(boton[i][j].getName().equals(boton[i][j+1].getName()) && boton[i][j].getName().equals(boton[i][j+2].getName()) ){
                            for(int k=j;k<=j+2;k++){
                                boton[i][k].setIcon(new ImageIcon());
                                boton[i][k].setName("");
                               
                            }
                             player.addPuntos(50);   
                             cabezal[2].setText("Puntos: "+player.getPuntos());
                              maspuntos=true;
                        }          
                    }
                }
            }//fin puntuación horizontal
            //inicio puntuación vertical
             for(int j=0;j<boton.length;j++){
                for(int i=0;i<boton[0].length;i++){                
                    if(i<boton.length-5 && !boton[i][j].getName().equals("")){
                        if(boton[i][j].getName().equals(boton[i+1][j].getName()) && boton[i][j].getName().equals(boton[i+2][j].getName()) && boton[i][j].getName().equals(boton[i+3][j].getName()) && boton[i][j].getName().equals(boton[i+4][j].getName()) && boton[i][j].getName().equals(boton[i+5][j].getName()) ){
                            for(int k=i;k<=i+5;k++){                               
                                boton[k][j].setIcon(new ImageIcon());
                                boton[k][j].setName("");                                
                            }
                            player.addPuntos(400);   
                            cabezal[2].setText("Puntos: "+player.getPuntos());
                            maspuntos=true;
                        }          
                    }                       
                    if(i<boton.length-4 && !boton[i][j].getName().equals("")){
                        if(boton[i][j].getName().equals(boton[i+1][j].getName()) && boton[i][j].getName().equals(boton[i+2][j].getName()) && boton[i][j].getName().equals(boton[i+3][j].getName()) && boton[i][j].getName().equals(boton[i+4][j].getName()) ){
                            for(int k=i;k<=i+4;k++){                                
                                boton[k][j].setIcon(new ImageIcon());
                                boton[k][j].setName("");
                               
                            }
                             player.addPuntos(200);   
                             cabezal[2].setText("Puntos: "+player.getPuntos());
                              maspuntos=true;
                        }          
                    }        
                         
                    if(i<boton.length-3 && !boton[i][j].getName().equals("")){
                        if(boton[i][j].getName().equals(boton[i+1][j].getName()) && boton[i][j].getName().equals(boton[i+2][j].getName()) && boton[i][j].getName().equals(boton[i+3][j].getName()) ){
                            for(int k=i;k<=i+3;k++){
                                boton[k][j].setIcon(new ImageIcon());
                                boton[k][j].setName("");                               
                            }
                             player.addPuntos(100);   
                             cabezal[2].setText("Puntos: "+player.getPuntos());
                              maspuntos=true;
                        }          
                    }      
                           
                    if(i<boton.length-2 && !boton[i][j].getName().equals("")){
                        if(boton[i][j].getName().equals(boton[i+1][j].getName()) && boton[i][j].getName().equals(boton[i+2][j].getName()) ){
                            for(int k=i;k<=i+2;k++){
                                boton[k][j].setIcon(new ImageIcon());
                                boton[k][j].setName("");
                               
                            }
                             player.addPuntos(50);   
                             cabezal[2].setText("Puntos: "+player.getPuntos());
                              maspuntos=true;
                        }          
                    }
                }
            }//fin puntuación vertical           
            //------------------------
            moverAbajo();
            llenarVacios();
            if(maspuntos==true){
                points();
            }else{
                player.lessMovimientos();
                cabezal[3].setText("Movimientos: "+player.getMovimientos());
                if(player.getMovimientos()==0){
                    player.lessVidas();
                    player.setMovimientos(50);
                }                
                
                cabezal[1].setText("Vidas: "+player.getVidas());
                System.out.println("puntos: "+player.getPuntos());
            }
            
            if(player.getVidas()==0){
                    return false;
            }else{
                return true;
            }
            
    }
    
    public void moverAbajo(){
        for(int i=0;i<boton.length;i++){
            for(int j=0;j<boton[0].length;j++){
                if(i!=boton.length-1){           
                
                    while(i!=boton.length && boton[i+1][j].getName().equals("") && !boton[i][j].getName().equals("")){
                        boton[i+1][j].setName(boton[i][j].getName());
                        boton[i+1][j].setIcon(boton[i][j].getIcon());
                        boton[i][j].setName("");
                        boton[i][j].setIcon(new ImageIcon());
                        i=0;
                        j=0;

                    }
                }
            }
        }
         
    }
    
    public void llenarVacios(){
        int aux = 0; 
        int dado=0;   
          for(int i=0;i<boton.length;i++){
            for(int j=0;j<boton[0].length;j++){ 
                if(boton[i][j].getName().equals("")){
                    dado=(int) Math.floor(Math.random()*5+1);
                    switch (dado) {
	            case 1:                  
                        boton[i][j].setSize(60,60);
                        boton[i][j].setName("bayer");
                        boton[i][j].setIcon(new ImageIcon(candies[0].getIcon().getImage().getScaledInstance(boton[i][j].getWidth(), boton[i][j].getHeight(), Image.SCALE_SMOOTH)));
                                                
	               
	            break;
	            case 2:
                        boton[i][j].setSize(60,60);
                        boton[i][j].setName("Corinthians");                        
                        boton[i][j].setIcon(new ImageIcon(candies[1].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));
                              
                    break;
	            case 3:
                         boton[i][j].setSize(60,60);
                         boton[i][j].setName("MUnitied");                         
                         boton[i][j].setIcon(new ImageIcon(candies[2].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));                        
                               
	            break;
	                case 4:
                         boton[i][j].setSize(60,60);
                         boton[i][j].setName("Real");
                         boton[i][j].setIcon(new ImageIcon(candies[3].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));
                        
	            break;
                        case 5:
                        
                         boton[i][j].setSize(60,60);
                         boton[i][j].setName("river");
                         boton[i][j].setIcon(new ImageIcon(candies[4].getIcon().getImage().getScaledInstance( boton[i][j].getWidth(),  boton[i][j].getHeight(), Image.SCALE_SMOOTH)));
                              
	            break;
                    }  
                }                          
            }
        }       
        for(int i=0;i<boton.length;i++){
            for(int j=0;j<boton[0].length;j++){
                boton[i][j].setBackground(Color.WHITE);
            }
        }                 
    }
   
}
