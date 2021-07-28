package com.totalcross.util;

import totalcross.ui.dialog.MessageBox;
import totalcross.ui.image.Image;

public class Images {
    public static Image background;

    public Images(){

    }
    public static void loadImage() {
        try {
            background = new Image("src/images/Binary-Clock.png");   
        } catch (Exception e) {
            MessageBox.showException(e, true);
        }
    }
}
