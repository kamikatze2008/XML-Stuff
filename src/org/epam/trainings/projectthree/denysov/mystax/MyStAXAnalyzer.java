package org.epam.trainings.projectthree.denysov.mystax;

import generated.Plant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by asus on 07.01.2015.
 */
public class MyStAXAnalyzer {
    public static ArrayList<Plant> parseStAX(){
        ArrayList<Plant> plants = null;
        try {
            MyStAXLogic myStAXLogic = new MyStAXLogic();
            InputStream inputStream = new FileInputStream("flower.xml");
            myStAXLogic.parse(inputStream);
            plants = myStAXLogic.getPlants();
        } catch (IOException e){
            e.printStackTrace();
        }
        return plants;
    }
}
