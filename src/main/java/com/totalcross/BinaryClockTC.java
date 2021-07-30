package com.totalcross;
import totalcross.ui.MainWindow;
import totalcross.ui.gfx.Color;
import totalcross.ui.Button;
import totalcross.ui.ImageControl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.totalcross.util.Images;

import totalcross.sys.Settings;
public class BinaryClockTC extends MainWindow {


    Button btnMinutes1,btnMinutes2,btnMinutes3,btnMinutes4,btnMinutes5,btnMinutes6,btnHours1,btnHours2,btnHours3,
    btnHours4,btnHours5,btnSeconds1,btnSeconds2,btnSeconds3,btnSeconds4,btnSeconds5,btnSeconds6;

    int seconds = 0, minutes = 1, hours = 1;
    int setSeconds,setMinutes,setHours;
    boolean[] positionsSeconds = new boolean[6];
    boolean[] positionsMinutes = new boolean[6];
    boolean[] positionsHours = new boolean[5];
    String arrayHours[] = new String[3];
    String getHours,getMinutes,getSeconds;
    private ImageControl imageControl;
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
        CreateButton();
        Thread thread = new Thread(()->{
            Score();   
          });
          thread.start(); 
 
          
          
    }
    //Criando 
    public void CreateButton(){

        //Criando botões
        btnHours1 = new Button("");
        btnHours2 = new Button("");
        btnHours3 = new Button("");
        btnHours4 = new Button("");
        btnHours5 = new Button("");
        btnMinutes1 = new Button("");
        btnMinutes2 = new Button("");
        btnMinutes3 = new Button("");
        btnMinutes4 = new Button("");
        btnMinutes5 = new Button("");
        btnMinutes6 = new Button("");
        btnSeconds1 = new Button("");
        btnSeconds2 = new Button("");
        btnSeconds3 = new Button("");
        btnSeconds4 = new Button("");
        btnSeconds5 = new Button("");
        btnSeconds6 = new Button("");
    
        //Adicionando ao Layout, posicionando e dimensionando tamanhos
        add(btnHours1,LEFT + 140,TOP + 200,btnHours1.getPreferredWidth() >=  55  ? DP +  40: btnHours1.getPreferredWidth(),DP +  45);
        add(btnHours2,LEFT + 190,TOP + 200,btnHours2.getPreferredWidth() >=  55  ? DP +  40: btnHours2.getPreferredWidth(),DP +  45);
        add(btnHours3,LEFT + 240,TOP + 200,btnHours3.getPreferredWidth() >=  55  ? DP +  40: btnHours3.getPreferredWidth(),DP +  45);
        add(btnHours4,LEFT + 290,TOP + 200,btnHours4.getPreferredWidth() >=  55  ? DP +  40: btnHours4.getPreferredWidth(),DP +  45);
        add(btnHours5,LEFT + 340,TOP + 200,btnHours5.getPreferredWidth() >=  55  ? DP +  40: btnHours5.getPreferredWidth(),DP +  45);

        add(btnMinutes1,LEFT + 140,TOP + 250,btnMinutes1.getPreferredWidth() >=  55  ? DP +  40: btnMinutes1.getPreferredWidth(),DP +  45);
        add(btnMinutes2,LEFT + 190,TOP + 250,btnMinutes2.getPreferredWidth() >=  55  ? DP +  40: btnMinutes2.getPreferredWidth(),DP +  45);
        add(btnMinutes3,LEFT + 240,TOP + 250,btnMinutes3.getPreferredWidth() >=  55  ? DP +  40: btnMinutes3.getPreferredWidth(),DP +  45);
        add(btnMinutes4,LEFT + 290,TOP + 250,btnMinutes4.getPreferredWidth() >=  55  ? DP +  40: btnMinutes4.getPreferredWidth(),DP +  45);
        add(btnMinutes5,LEFT + 340,TOP + 250,btnMinutes5.getPreferredWidth() >=  55  ? DP +  40: btnMinutes5.getPreferredWidth(),DP +  45);
        add(btnMinutes6,LEFT + 390,TOP + 250,btnMinutes6.getPreferredWidth() >=  55  ? DP +  40: btnMinutes6.getPreferredWidth(),DP +  45);

        add(btnSeconds1,LEFT + 140,TOP + 300,btnSeconds1.getPreferredWidth() >=  55  ? DP +  40: btnSeconds1.getPreferredWidth(),DP +  45);
        add(btnSeconds2,LEFT + 190,TOP + 300,btnSeconds2.getPreferredWidth() >=  55  ? DP +  40: btnSeconds2.getPreferredWidth(),DP +  45);
        add(btnSeconds3,LEFT + 240,TOP + 300,btnSeconds3.getPreferredWidth() >=  55  ? DP +  40: btnSeconds3.getPreferredWidth(),DP +  45);
        add(btnSeconds4,LEFT + 290,TOP + 300,btnSeconds4.getPreferredWidth() >=  55  ? DP +  40: btnSeconds4.getPreferredWidth(),DP +  45);
        add(btnSeconds5,LEFT + 340,TOP + 300,btnSeconds5.getPreferredWidth() >=  55  ? DP +  40: btnSeconds5.getPreferredWidth(),DP +  45);
        add(btnSeconds6,LEFT + 390,TOP + 300,btnSeconds6.getPreferredWidth() >=  55  ? DP +  40: btnSeconds6.getPreferredWidth(),DP +  45);
        
        //Configurando cores padrão
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
    }
    
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

          seconds = setSeconds;
          minutes = setMinutes;
          hours = setHours;
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
