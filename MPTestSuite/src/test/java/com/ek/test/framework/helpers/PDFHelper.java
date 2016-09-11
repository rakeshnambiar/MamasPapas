package com.ek.test.framework.helpers;

import com.ek.test.framework.hooks.ScenarioHook;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.WebDriver;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by S714848 on 24/03/2016.
 */
public class PDFHelper {
    public static WebDriver driver;
    public static boolean VerifyPDFText(String FileName, String strExpectedVal) {
        int iterator;
        boolean Found = false;
        try {
            WaitHelper.waitFor(1000);
            String[] ExpVal = strExpectedVal.split("\\|");
            //driver.get("file:///D:/ASUI_DEV/Lounge%20PDF.pdf"); //http://www.emirates.com/english/images/conditions-of-contract_tcm233-431995.pdf    http://twiki.org/p/pub/TWiki/GoodStyle/selenium.pdf
           // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           // driver.manage().window().maximize();
           // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           // URL url = new URL(driver.getCurrentUrl());
            //BufferedInputStream fileToParse=new BufferedInputStream(FileName);
            FileInputStream fin = new FileInputStream(FileName);
            BufferedInputStream fileToParse = new BufferedInputStream(fin);

            PDFParser parser = new PDFParser(fileToParse);
            parser.parse();
            String output = new PDFTextStripper().getText(parser.getPDDocument());
            System.out.println(output);
            for (iterator = 0; iterator < ExpVal.length; iterator++) {
                //ScenarioHook.getScenario().write("Verifying the Value : " + ExpVal[iterator] + "<br/>");
                if (output.toLowerCase().contains(ExpVal[iterator].toLowerCase())) {
                    Found = true;
                    ScenarioHook.getScenario().write("Found the Value : " + ExpVal[iterator] + "<br/>");
                } else {
                    Found = false;
                    ScenarioHook.getScenario().write("Not Found the Value : " + ExpVal[iterator] + "<br/>");
                }
            }
            parser.getPDDocument().close();
            //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        } catch (Exception e) {
            ScenarioHook.getScenario().write("PDF validation error : " + e.toString());
            System.out.println("PDF validation error : " + e.toString());

        }
        return Found;
    }
}
