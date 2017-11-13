package com.endre.java;

import com.j256.ormlite.logger.LocalLog;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) {
        try {
            System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR");

            ApplicationImplementation applicationImplementation = new ApplicationImplementation("DatabaseProperties.properties");

            applicationImplementation.createDB();

            applicationImplementation.publishToDB();

            applicationImplementation.readFromDB();

            applicationImplementation.updateValueInDB();

            applicationImplementation.deleteFromDB();


        } catch (IOException ioE) {
            System.out.println(ioE.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
