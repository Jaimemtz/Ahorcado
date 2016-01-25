
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//1.TIENE QUE ELEGIR UN VALOR DE UN ARRAY DE STRINGS DE FORMA ALEATORIA 
//2.QUE EL JUEGO TERMINE
//3.QUE SE PINTE DE FORMA AUTOMATICA LOS GUIONES EN FUNCION DEL NUMERO DE LETRAS QUE TENGA LA PALABRA
//OCULTA SELECCIONADA.
/**
 *
 * @author Jaime
 */


public class VentanaAhorcado extends javax.swing.JFrame {

    String palabraOculta = "";
    
    // contador para saber el número de fallos
    int numeroFallos = 0;
    
    /**
     * Creates new form VentanaAhorcado
     */
    public VentanaAhorcado() {
        initComponents();
        //aquí va el código que poniamos en el run en ACM
        cambiaImagenAhorcado();
        eligePalabraOculta();
        
        pintaGuionesEnLabel();
    }
    
     private void eligePalabraOculta(){
        
        //Método básico de lectura de ficheros en Java
        File fichero = null;
        FileReader fr = null; 
        BufferedReader br = null;
        Random r = new Random();
        fichero = new File("src/lemario-20101017.txt");
        String linea = "";
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            
            int numeroLineasFichero = 0;
            
            while ( (linea = br.readLine()) != null ){
                numeroLineasFichero++;
            }
            System.out.println(numeroLineasFichero);
            int lineaSeleccionada = r.nextInt(numeroLineasFichero);
            System.out.println(lineaSeleccionada);
            
            fr.close();
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            
            for (int i=0; i<lineaSeleccionada; i++){
                linea = br.readLine();
            }
            System.out.println(linea);
            
        } catch (FileNotFoundException ex) {    
        }
          catch (IOException ex) {
        }
        palabraOculta = linea;
        
//        
//        String [] listaDePalabras = new String[10];
//        
//        
//        listaDePalabras[0] = "tal";
//        listaDePalabras[1] = "taluno";
//        listaDePalabras[2] = "taldos";
//        listaDePalabras[3] = "taltres";
//        listaDePalabras[4] = "talcuatro";
//        listaDePalabras[5] = "talcinco";
//        listaDePalabras[6] = "talseis";
//        listaDePalabras[7] = "talsiete";
//        listaDePalabras[8] = "talocho";
//        listaDePalabras[9] = "talnueve";
//
//        
//        palabraOculta = listaDePalabras[r.nextInt(9)];
//        System.out.println(palabraOculta);
    }
    
    private void pintaGuionesEnLabel(){
        jLabel1.setText("");
        for (int i=0; i<palabraOculta.length(); i++){
            jLabel1.setText(jLabel1.getText() + "_ ");
        }
    }
    private void cambiaImagenAhorcado(){
        
        String nombreImagen="";
        
         switch (numeroFallos){
                case 0:  nombreImagen = "/ahorcado_0.png"; break;
                case 1:  nombreImagen = "/ahorcado_1.png"; break;
                case 2:  nombreImagen = "/ahorcado_2.png"; break;
                case 3:  nombreImagen = "/ahorcado_3.png"; break;
                case 4:  nombreImagen = "/ahorcado_4.png"; break;
                case 5:  nombreImagen = "/ahorcado_5.png"; break;
                case 6:  nombreImagen = "/ahorcado_fin.png"; break;
                case -1:nombreImagen = "/acertasteTodo.png"; break;
                default :  nombreImagen = "/ahorcado_fin.png"; break;           
            }
         // después del switch, tendremos en nombreImagen el nombre correcto
         // de la imagen que tenemos que mostrar dependiendo del numero de fallos
         
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen));
        ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT));
        jLabel2.setIcon(icono);
           
    }
     private void chequeaLetra(JButton boton){
        if (boton.isEnabled()){
            //cambio a minúsculas la letra del botón
            String letra = boton.getText().toLowerCase();
            System.out.println(letra);
            boton.setEnabled(false);
            String palabraConGuiones = jLabel1.getText();

            if (palabraOculta.contains(letra)){
                for (int i=0; i< palabraOculta.length(); i++){
                   if (palabraOculta.charAt(i) == letra.charAt(0)){
                       palabraConGuiones = 
                                 palabraConGuiones.substring(0, 2*i)
                               + letra
                               + palabraConGuiones.substring(2*i +1);
                   }
                }
                jLabel1.setText(palabraConGuiones);
                
                //compruebo si en la palabraConGuiones hay guiones o no
                // si hay algún guión no hago nada porque no he adivinado todavia la partida
                // si no hay guiones, tengo que indicar de alguna forma que he ganado la partida
                if (!palabraConGuiones.contains("_")){
                    numeroFallos = -1;
                }
            }
            else{
                numeroFallos++;
                
            }
        }
        cambiaImagenAhorcado();
    }
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton12 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jButton12.setText("A");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton12MousePressed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("_ _ _ _ _");

        jButton1.setText("A");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setText("C");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jButton3.setText("B");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });

        jButton4.setText("D");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

        jButton5.setText("E");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("F");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("G");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("H");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton8MousePressed(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("I");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton9MousePressed(evt);
            }
        });

        jButton10.setText("J");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton10MousePressed(evt);
            }
        });

        jButton11.setText("K");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton11MousePressed(evt);
            }
        });

        jButton13.setText("L");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton13MousePressed(evt);
            }
        });

        jButton14.setText("M");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton14MousePressed(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("N");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton15MousePressed(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Ñ");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton16MousePressed(evt);
            }
        });

        jButton17.setText("O");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton17MousePressed(evt);
            }
        });

        jButton18.setText("P");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton18MousePressed(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Q");
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton19MousePressed(evt);
            }
        });
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("R");
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton20MousePressed(evt);
            }
        });

        jButton21.setText("S");
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton21MousePressed(evt);
            }
        });

        jButton22.setText("T");
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton22MousePressed(evt);
            }
        });

        jButton24.setText("X");
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton24MousePressed(evt);
            }
        });

        jButton25.setText("Y");
        jButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton25MousePressed(evt);
            }
        });

        jButton26.setText("Z");
        jButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton26MousePressed(evt);
            }
        });

        jButton27.setText("U");
        jButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton27MousePressed(evt);
            }
        });
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("V");
        jButton28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton28MousePressed(evt);
            }
        });

        jButton29.setText("W");
        jButton29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton29MousePressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
     chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
       chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
       chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
       chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton6MousePressed

    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MousePressed
      chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton7MousePressed

    private void jButton8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MousePressed
       chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton8MousePressed

    private void jButton9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MousePressed
       chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton9MousePressed

    private void jButton10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton10MousePressed

    private void jButton11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton11MousePressed

    private void jButton12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton12MousePressed

    private void jButton13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton13MousePressed

    private void jButton14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton14MousePressed

    private void jButton15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton15MousePressed

    private void jButton16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton16MousePressed

    private void jButton17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton17MousePressed

    private void jButton18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton18MousePressed

    private void jButton19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton19MousePressed

    private void jButton20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton20MousePressed

    private void jButton21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton21MousePressed

    private void jButton22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton22MousePressed

    private void jButton24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton24MousePressed

    private void jButton25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton25MousePressed

    private void jButton26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton26MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton26MousePressed

    private void jButton28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton28MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton28MousePressed

    private void jButton29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton29MousePressed
         chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton29MousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
     
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
      
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
     
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
       
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton27MousePressed
       chequeaLetra((JButton)evt.getSource());
    }//GEN-LAST:event_jButton27MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAhorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAhorcado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
