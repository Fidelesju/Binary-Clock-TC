package com.totalcross;
import totalcross.ui.MainWindow;
import totalcross.util.UnitsConverter;
import totalcross.ui.ImageControl;
import totalcross.sys.*;
import com.totalcross.util.Images;

import totalcross.ui.Container;
import totalcross.sys.Settings;
public class BinaryClockTC extends MainWindow {

    private ImageControl imageControl, ledSeconds1,ledSeconds2,ledSeconds3,ledSeconds4,ledSeconds5,
    ledSeconds6,ledMinutes1,ledMinutes2,ledMinutes3,ledMinutes4,ledMinutes5,ledMinutes6,ledHours1,ledHours2,ledHours3,
    ledHours4,ledHours5;
 
    static final int SIZE = 8;
    int seconds = 0, minutes = 1, hours = 1,verification = 0;
    int setSeconds,setMinutes,setHours;
    boolean[] positionsSeconds = new boolean[6];
    boolean[] positionsMinutes = new boolean[6];
    boolean[] positionsHours = new boolean[5];
    String arrayHours[] = new String[3];
    String getHours,getMinutes,getSeconds,format;

  
    public BinaryClockTC() {
        setUIStyle(Settings.MATERIAL_UI);
        setTitle("Binary Clock");
    }

    @Override
    public void initUI() { 
         Images.loadImage();

        imageControl = new ImageControl(Images.background);

        imageControl.scaleToFit = true;
        imageControl.strechImage = true;

        add(imageControl,LEFT,TOP,PARENTSIZE,PARENTSIZE); 

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
        Container container = new Container();
        add(container,CENTER,CENTER);

        container.add(ledHours1,LEFT,TOP);
        container.add(ledHours2,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledHours3,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledHours4,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledHours5,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        
        container.add(ledMinutes1,LEFT,AFTER + 10 );
        container.add(ledMinutes2,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledMinutes3,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledMinutes4,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledMinutes5,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledMinutes6,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);

        container.add(ledSeconds1,LEFT,AFTER + 10);
        container.add(ledSeconds2,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledSeconds3,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledSeconds4,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledSeconds5,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);
        container.add(ledSeconds6,AFTER + UnitsConverter.toPixels(DP + SIZE),SAME);

        container.resize();
        container.setRect(CENTER,CENTER,KEEP,KEEP);
        container.transparentBackground = true;
    }
    
    //Pegando a hora do sistema
    public void SetHours(){

       Time f24h = new Time();
        //SimpleDateFormat f24h = new SimpleDateFormat("hh:mm:ss"); 
          getHours = f24h.toString();

          for(int i = 0; i<3;i++){
            arrayHours = getHours.split(":");
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
                }
                for (int i = 0; i < 6; i++) {
                    positionsMinutes[i] = (((minutes >> i)&0x1)==1);
                }
                for (int i = 5; i >=0; i--) {
                    VerificationMinutes();
                }
                for (int i = 0; i < 5; i++) {
                    positionsHours[i] = (((hours >> i)&0x1)==1);
                    }
                   for (int i = 0; i < 4; i++) {
                       VerificationHours();
                      
                }
            verification++;
            }
            Vm.debug("Segundos: " + seconds);
            for (int i = 0; i < 6; i++) {
                positionsSeconds[i] = (((seconds >> i)&0x1)==1);
                
            }
            for (int i = 5; i >=0; i--) {   
               VerificationSeconds();
            }
            seconds++;
            seconds = seconds!=60?seconds:0;
            
            //Contagem dos minutos
            if(seconds == 60){
               
                Vm.debug("Minutos: " + minutes);
                for (int i = 0; i < 6; i++) {
                    positionsMinutes[i] = (((minutes >> i)&0x1)==1);
                }
                for (int i = 5; i >=0; i--) {
                    VerificationMinutes();
                   
                }
              
                minutes++;
                minutes = minutes!=60?minutes:0;
                //Contando horas
                    if(minutes == 59){
                        minutes = 1;
                        Vm.debug("Horas: " + hours);
                   for (int i = 0; i < 5; i++) {
                    positionsHours[i] = (((hours >> i)&0x1)==1);
                    }
                   for (int i = 0; i < 4; i++) {
                       VerificationHours();
                   
                   }
                
                   hours++;
                   hours = hours!=24?hours:0;
                    }
               }
            
        }
        
        
    }
}

