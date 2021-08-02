package com.totalcross.util;

import totalcross.ui.dialog.MessageBox;
import totalcross.ui.image.Image;

public class Images {
    public static Image background,ledRed,ledDark;

    public Images(){

    }
    public static void loadImage() {
        try {
            background = new Image("src/images/Binary-Clock.png");   
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
    public static void loadLed() {
        try {
            ledRed = new Image("src/Images/LedVermelho.jpg");    
            ledDark = new Image("src/Images/LedDark.jpg"); 

        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
}
