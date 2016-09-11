package com.ek.test.framework.helpers;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by S714848 on 24/03/2016.
 */
public class TaskKillHelper {
    public static WebDriver driver;

    public static void taskkill(String strProcessName) {
        String strCmdLine = null;
        strCmdLine = String.format("taskkill -f -im " + strProcessName + ".exe");

        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(strCmdLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}