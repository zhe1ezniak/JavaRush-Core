package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    private static ImageReader o;
    public static ImageReader getImageReader(ImageTypes imageTypes){
        if (!(imageTypes instanceof ImageTypes)) throw new IllegalArgumentException();
        try{
            if (imageTypes == ImageTypes.JPG) o = new JpgReader();
            if (imageTypes == ImageTypes.BMP) o = new BmpReader();
            if (imageTypes == ImageTypes.PNG) o = new PngReader();
        } catch (IllegalArgumentException e ){
            System.out.println("Неизвестный тип картинки");
        } catch (Exception e){
            System.out.println("Неизвестный тип картинки");
        }
        return o;
    }
}
