package com.totalcross;
import totalcross.ui.MainWindow;
import totalcross.ui.ImageControl;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.totalcross.util.Images;

import totalcross.sys.Settings;
public class BinaryClockTC extends MainWindow {


    private ImageControl imageControl, ledSeconds1,ledSeconds2,ledSeconds3,ledSeconds4,ledSeconds5,
    ledSeconds6,ledMinutes1,ledMinutes2,ledMinutes3,ledMinutes4,ledMinutes5,ledMinutes6,ledHours1,ledHours2,ledHours3,
    ledHours4,ledHours5;
 

    int seconds = 0, minutes = 1, hours = 1,verification = 0;
    int setSeconds,setMinutes,setHours;
    boolean[] positionsSeconds = new boolean[6];
    boolean[] positionsMinutes = new boolean[6];
    boolean[] positionsHours = new boolean[5];
    String arrayHours[] = new String[3];
    String getHours,getMinutes,getSeconds;

  
    public BinaryClockTC() {
        setUIStyle(Settings.MATERIAL_UI);
        setTitle("Binary Clock");
    }

    @Override
    public void initUI() { 
         Images.loadImage();

        imageControl = new ImageControl(Images.background);

        imageControl.scaleToFit = true;
        imageControl.centerImage = true;

        add(imageControl,CENTER,CENTER); 

        SetHours();
        CreateLeds();

        Thread thread = new Thread(()->{
            Score();   
          });
          thread.start(); 
          
    }

    //Criando LED's
    public void CreateLeds(){

        Images.loadLed();
        ledHours1 = new ImageControl(Images.ledDark);
        ledHours2 = new ImageControl(Images.ledDark);
        ledHours3 = new ImageControl(Images.ledDark);
        ledHours4 = new ImageControl(Images.ledDark);
        ledHours5 = new ImageControl(Images.ledDark);
        ledMinutes1 = new ImageControl(Images.ledDark);
        ledMinutes2 = new ImageControl(Images.ledDark);
        ledMinutes3 = new ImageControl(Images.ledDark);
        ledMinutes4 = new ImageControl(Images.ledDark);
        ledMinutes5 = new ImageControl(Images.ledDark);
        ledMinutes6 = new ImageControl(Images.ledDark);
        ledSeconds1 = new ImageControl(Images.ledDark);
        ledSeconds2 = new ImageControl(Images.ledDark);
        ledSeconds3 = new ImageControl(Images.ledDark);
        ledSeconds4 = new ImageControl(Images.ledDark);
        ledSeconds5 = new ImageControl(Images.ledDark);
        ledSeconds6 = new ImageControl(Images.ledDark);


        //Criando botões
        add(ledHours1,LEFT + 140,TOP + 200);
        add(ledHours2,LEFT + 190,TOP + 200);
        add(ledHours3,LEFT + 240,TOP + 200);
        add(ledHours4,LEFT + 290,TOP + 200);
        add(ledHours5,LEFT + 340,TOP + 200);

        add(ledMinutes1,LEFT + 140,TOP + 250);
        add(ledMinutes2,LEFT + 190,TOP + 250);
        add(ledMinutes3,LEFT + 240,TOP + 250);
        add(ledMinutes4,LEFT + 290,TOP + 250);
        add(ledMinutes5,LEFT + 340,TOP + 250);
        add(ledMinutes6,LEFT + 390,TOP + 250);

        add(ledSeconds1,LEFT + 140,TOP + 300);
        add(ledSeconds2,LEFT + 190,TOP + 300);
        add(ledSeconds3,LEFT + 240,TOP + 300);
        add(ledSeconds4,LEFT + 290,TOP + 300);
        add(ledSeconds5,LEFT + 340,TOP + 300);
        add(ledSeconds6,LEFT + 390,TOP + 300);

    }
    
    //Pegando a hora do sistema
    public void SetHours(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); 
          getHours = sdf.format(new Date());
          for(int i = 0; i<3;i++){
            arrayHours = getHours.split(":");
            System.out.println(arrayHours[i]);
          }
          getHours = arrayHours[0];
          getMinutes = arrayHours[1];
          getSeconds = arrayHours[2];
          setHours = Integer.parseInt(getHours);
          setMinutes = Integer.parseInt(getMinutes);
          setSeconds = Integer.parseInt(getSeconds);

          
          seconds = setSeconds + 1;
          minutes = setMinutes + 1;
          hours = setHours;  
    }
    
    //Verificando os segundos
    public void VerificationSeconds(){
        //Segundos casa 6
        if (positionsSeconds[0] == true) {
           ledSeconds6.setImage(Images.ledRed);
        } else{
            ledSeconds6.setImage(Images.ledDark);
        }
        //Segundos casa 5
        if (positionsSeconds[1] == true) {
             ledSeconds5.setImage(Images.ledRed);
        } else{
            ledSeconds5.setImage(Images.ledDark);
        }
        //Segundos casa 4
        if (positionsSeconds[2] == true) {
             ledSeconds4.setImage(Images.ledRed);
        } else{
            ledSeconds4.setImage(Images.ledDark);
        }
        //Segundos casa 3
        if (positionsSeconds[3] == true) {
            ledSeconds3.setImage(Images.ledRed);
        } else{
            ledSeconds3.setImage(Images.ledDark);
        }
        //Segundos casa 2
        if (positionsSeconds[4] == true) {
            ledSeconds2.setImage(Images.ledRed);
        } else{
            ledSeconds2.setImage(Images.ledDark);
        }
        //Segundos casa 1
        if (positionsSeconds[5] == true) {
            ledSeconds1.setImage(Images.ledRed);
        } else{
            ledSeconds1.setImage(Images.ledDark);
        }
        
    }
    
    //Verificando os minutos
    public void VerificationMinutes(){
        //Minutos casa 6
        if (positionsMinutes[0] == true) {
            ledMinutes6.setImage(Images.ledRed);
        } else{
            ledMinutes6.setImage(Images.ledDark);
        }
        //Minutos casa 5
        if (positionsMinutes[1] == true) {
             ledMinutes5.setImage(Images.ledRed);
        } else{
            ledMinutes5.setImage(Images.ledDark);
        }
        //Minutos casa 4
        if (positionsMinutes[2] == true) {
             ledMinutes4.setImage(Images.ledRed);
        } else{
            ledMinutes4.setImage(Images.ledDark);
        }
        //Minutos casa 3
        if (positionsMinutes[3] == true) {
             ledMinutes3.setImage(Images.ledRed);
        } else{
            ledMinutes3.setImage(Images.ledDark);
        }
        //Minutos casa 2
        if (positionsMinutes[4] == true) {
             ledMinutes2.setImage(Images.ledRed);
        } else{
            ledMinutes2.setImage(Images.ledDark);
        }
        //Minutos casa 1
        if (positionsMinutes[5] == true) {
             ledMinutes1.setImage(Images.ledRed);
        } else{
            ledMinutes1.setImage(Images.ledDark);
        }    
    }
    
    //Verificando as horas
    public void VerificationHours(){
        //Horas casa 5
        if (positionsHours[0] == true) {
            ledHours5.setImage(Images.ledRed);
        } else{
            ledHours5.setImage(Images.ledDark);
        }
        //Horas casa 4
        if (positionsHours[1] == true) {
            ledHours4.setImage(Images.ledRed);
        } else{
            ledHours4.setImage(Images.ledDark);
        }
        //Horas casa 3
        if (positionsHours[2] == true) {
            ledHours3.setImage(Images.ledRed);
        } else{
            ledHours3.setImage(Images.ledDark);
        }
        //Horas casa 2
        if (positionsHours[3] == true) {
            ledHours2.setImage(Images.ledRed);
        } else{
            ledHours2.setImage(Images.ledDark);
        }
        //Horas casa 1
        if (positionsHours[4] == true) {
            ledHours1.setImage(Images.ledRed);
        } else{
            ledHours1.setImage(Images.ledDark);
        }
         
    }
    
    //Contando as horas
    public void Score(){

        while (true) {   
            //Contagem dos segundos
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if(verification == 0){
                for (int i = 0; i < 6; i++) {
                    positionsSeconds[i] = (((seconds >> i)&0x1)==1);
                    
                }
                for (int i = 5; i >=0; i--) {   
                   VerificationSeconds();
                    System.out.print(positionsSeconds[i]?1:0);
                }
                for (int i = 0; i < 6; i++) {
                    positionsMinutes[i] = (((minutes >> i)&0x1)==1);
                }
                for (int i = 5; i >=0; i--) {
                    VerificationMinutes();
                    System.out.print(positionsMinutes[i]?1:0);
                }
                for (int i = 0; i < 5; i++) {
                    positionsHours[i] = (((hours >> i)&0x1)==1);
                    }
                   for (int i = 0; i < 4; i++) {
                       VerificationHours();
                       System.out.print(positionsHours[i]?1:0);
                }
            verification++;
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
                       VerificationHours();
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

