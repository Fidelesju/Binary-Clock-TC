package com.totalcross;
import totalcross.ui.MainWindow;
import totalcross.ui.dialog.MessageBox;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.ui.Button;


import totalcross.sys.Settings;
public class BinaryClockTC extends MainWindow {


    Button btnMinutes1,btnMinutes2,btnMinutes3,btnMinutes4,btnMinutes5,btnMinutes6,btnHours1,btnHours2,btnHours3,
    btnHours4,btnHours5,btnSeconds1,btnSeconds2,btnSeconds3,btnSeconds4,btnSeconds5,btnSeconds6;
    public static Image background;
    int seconds = 0, minutes = 1, hours = 1;
    boolean[] positionsSeconds = new boolean[6];
    boolean[] positionsMinutes = new boolean[6];
    boolean[] positionsHours = new boolean[5];

    public BinaryClockTC() {
        setUIStyle(Settings.MATERIAL_UI);
    }

    @Override
    public void initUI() {
        try {
            background = new Image("src/images/Binary-Clock.jpeg");
            System.out.println("entrou imagem");
        }
        catch (Exception e) {
            MessageBox.showException(e, true);
        }
        CreateButton();
        Thread t = new Thread(()->{
            Score();   
          });
          t.start();
          
    }
    //Criando 
    public void CreateButton(){

        btnHours1 = new Button("1H");
        btnHours2 = new Button("2H");
        btnHours3 = new Button("3H");
        btnHours4 = new Button("4H");
        btnHours5 = new Button("5H");
        btnMinutes1 = new Button("1M");
        btnMinutes2 = new Button("2M");
        btnMinutes3 = new Button("3M");
        btnMinutes4 = new Button("4M");
        btnMinutes5 = new Button("5M");
        btnMinutes6 = new Button("6M");
        btnSeconds1 = new Button("1S");
        btnSeconds2 = new Button("2S");
        btnSeconds3 = new Button("3S");
        btnSeconds4 = new Button("4S");
        btnSeconds5 = new Button("5S");
        btnSeconds6 = new Button("6S");
    
        add(btnHours1,LEFT,TOP);
        add(btnHours2,LEFT + 80,TOP);
        add(btnHours3,LEFT + 160,TOP);
        add(btnHours4,LEFT + 240,TOP);
        add(btnHours5,LEFT + 320 ,TOP);
        add(btnMinutes1,LEFT,TOP + 50);
        add(btnMinutes2,LEFT + 80,TOP + 50);
        add(btnMinutes3,LEFT + 160,TOP + 50);
        add(btnMinutes4,LEFT + 240,TOP + 50);
        add(btnMinutes5,LEFT + 320,TOP + 50);
        add(btnMinutes6,LEFT + 400,TOP + 50);
        add(btnSeconds1,LEFT ,TOP + 100);
        add(btnSeconds2,LEFT +  80,TOP + 100);
        add(btnSeconds3,LEFT + 160,TOP + 100);
        add(btnSeconds4,LEFT + 240,TOP + 100);
        add(btnSeconds5,LEFT + 320,TOP + 100);
        add(btnSeconds6,LEFT + 400,TOP + 100);
        
        btnHours1.setBackColor(Color.DARK);
        btnHours2.setBackColor(Color.DARK);
        btnHours3.setBackColor(Color.DARK);
        btnHours4.setBackColor(Color.DARK);
        btnHours5.setBackColor(Color.DARK);
        btnMinutes1.setBackColor(Color.DARK);
        btnMinutes2.setBackColor(Color.DARK);
        btnMinutes3.setBackColor(Color.DARK);
        btnMinutes4.setBackColor(Color.DARK);
        btnMinutes5.setBackColor(Color.DARK);
        btnMinutes6.setBackColor(Color.DARK);
        btnSeconds1.setBackColor(Color.DARK);
        btnSeconds2.setBackColor(Color.DARK);
        btnSeconds3.setBackColor(Color.DARK);
        btnSeconds4.setBackColor(Color.DARK);
        btnSeconds5.setBackColor(Color.DARK);
        btnSeconds6.setBackColor(Color.DARK);

        btnHours1.setEnabled(false);
        btnHours2.setEnabled(false);
        btnHours3.setEnabled(false);
        btnHours4.setEnabled(false);
        btnHours5.setEnabled(false);
        btnMinutes1.setEnabled(false);
        btnMinutes2.setEnabled(false);
        btnMinutes3.setEnabled(false);
        btnMinutes4.setEnabled(false);
        btnMinutes5.setEnabled(false);
        btnMinutes6.setEnabled(false);
        btnSeconds1.setEnabled(false);
        btnSeconds2.setEnabled(false);
        btnSeconds3.setEnabled(false);
        btnSeconds4.setEnabled(false);
        btnSeconds5.setEnabled(false);
        btnSeconds6.setEnabled(false);
    }
    
    public void VerificationSeconds(){
        //Segundos casa 6
        if (positionsSeconds[0] == true) {
            btnSeconds6.setBackColor(Color.RED);
        } else{
            btnSeconds6.setBackColor(Color.DARK);
        }
        //Segundos casa 5
        if (positionsSeconds[1] == true) {
            btnSeconds5.setBackColor(Color.RED);
        } else{
            btnSeconds5.setBackColor(Color.DARK);
        }
        //Segundos casa 4
        if (positionsSeconds[2] == true) {
            btnSeconds4.setBackColor(Color.RED);
        } else{
            btnSeconds4.setBackColor(Color.DARK);
        }
        //Segundos casa 3
        if (positionsSeconds[3] == true) {
            btnSeconds3.setBackColor(Color.RED);
        } else{
            btnSeconds3.setBackColor(Color.DARK);
        }
        //Segundos casa 2
        if (positionsSeconds[4] == true) {
            btnSeconds2.setBackColor(Color.RED);
        } else{
            btnSeconds2.setBackColor(Color.DARK);
        }
        //Segundos casa 1
        if (positionsSeconds[5] == true) {
            btnSeconds1.setBackColor(Color.RED);
        } else{
            btnSeconds1.setBackColor(Color.DARK);
        }
        
    }
    
    public void VerificationMinutes(){
        //Minutos casa 6
        if (positionsMinutes[0] == true) {
            btnMinutes6.setBackColor(Color.RED);
        } else{
            btnMinutes6.setBackColor(Color.DARK);
        }
        //Minutos casa 5
        if (positionsMinutes[1] == true) {
            btnMinutes5.setBackColor(Color.RED);
        } else{
            btnMinutes5.setBackColor(Color.DARK);
        }
        //Minutos casa 4
        if (positionsMinutes[2] == true) {
            btnMinutes4.setBackColor(Color.RED);
        } else{
            btnMinutes4.setBackColor(Color.DARK);
        }
        //Minutos casa 3
        if (positionsMinutes[3] == true) {
            btnMinutes3.setBackColor(Color.RED);
        } else{
            btnMinutes3.setBackColor(Color.DARK);
        }
        //Minutos casa 2
        if (positionsMinutes[4] == true) {
            btnMinutes2.setBackColor(Color.RED);
        } else{
            btnMinutes2.setBackColor(Color.DARK);
        }
        //Minutos casa 1
        if (positionsMinutes[5] == true) {
            btnMinutes1.setBackColor(Color.RED);
        } else{
            btnMinutes1.setBackColor(Color.DARK);
        }    
    }
    
    public void VerificationHours(){
        //Horas casa 5
        if (positionsHours[0] == true) {
            btnHours5.setBackColor(Color.RED);
        } else{
            btnHours5.setBackColor(Color.DARK);
        }
        //Horas casa 4
        if (positionsHours[1] == true) {
            btnHours4.setBackColor(Color.RED);
        } else{
            btnHours4.setBackColor(Color.DARK);
        }
        //Horas casa 3
        if (positionsHours[2] == true) {
            btnHours3.setBackColor(Color.RED);
        } else{
            btnHours3.setBackColor(Color.DARK);
        }
        //Horas casa 2
        if (positionsHours[3] == true) {
            btnHours2.setBackColor(Color.RED);
        } else{
            btnHours2.setBackColor(Color.DARK);
        }
        //Horas casa 1
        if (positionsHours[4] == true) {
            btnHours1.setBackColor(Color.RED);
        } else{
            btnHours1.setBackColor(Color.DARK);
        }
         
    }
     
    public void Score(){
        while (true) {   
            //Contagem dos segundos
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("Segundos: " + seconds);
            for (int i = 0; i < 6; i++) {
                positionsSeconds[i] = (((seconds >> i)&0x1)==1);
                
            }
            for (int i = 5; i >=0; i--) {   
               VerificationSeconds();
                System.out.print(positionsSeconds[i]?1:0);
            }
            System.out.println();
            seconds++;
            seconds = seconds!=60?seconds:0;
            
            //Contagem dos minutos
            if(seconds == 59){
               
                System.out.println("Minutos: " + minutes);
                for (int i = 0; i < 6; i++) {
                    positionsMinutes[i] = (((minutes >> i)&0x1)==1);
                }
                for (int i = 5; i >=0; i--) {
                  VerificationMinutes();
                    System.out.print(positionsMinutes[i]?1:0);
                }
                System.out.println();
                minutes++;
                minutes = minutes!=60?minutes:0;
                //Contando horas
                    if(minutes == 59){
                        minutes = 1;
                        System.out.println("Horas: " + hours);
                   for (int i = 0; i < 5; i++) {
                    positionsHours[i] = (((hours >> i)&0x1)==1);
                    }
                   for (int i = 0; i < 4; i++) {
                       VerificationMinutes();
                       System.out.print(positionsHours[i]?1:0);
                   }
                   System.out.println();
                   hours++;
                   hours = hours!=24?hours:0;
                    }
               }
            
        }
        
        
    }
}
