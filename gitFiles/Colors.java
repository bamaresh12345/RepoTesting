package ZSeleniumProject.PracticeMethods;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import zPlayWrightProject.baseClass.BaseClass;

import java.time.Duration;




public class Colors  extends BaseClass {

/*
  How to get Elelment color in selenium
  1. background color
  2. Broder color
  3. Text Color

  Identidy webelement to find the color and use getCssValue() Method and mention what we want background-color or border-color
  or text-color ,it will strong it rgb string format
  used Color.fromString(rgbabackgroundColor) convert from string value  into to as HexaFromat //Color color = Color.fromString(rgbaColor);
  then convert Hexa to Stirng format and compare the values  --> String hexbackgroundColor = color.asHex();

  https://www.youtube.com/watch?v=Wglx7O4XzWg --> check

 */
    WebDriver driver = new ChromeDriver();


    @Test
    public void verify_color() throws InterruptedException {
        driver.get("https://www.yatra.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String expectedColor ="#ffe7e3"; // Hexformat color
        //String expectedColor ="#29a0c4"; // Hexformat color

        /* Identidy webelement to find the color and use getCssValue Mehtod and mention what we want background-color or border-color
         or text-color ,it will strong it rgb string format
         used Color.fromString(rgbabackgroundColor) convert from string value  into to as HexaFromat
         then convert Hexa to Stirng forrtmant and compare the values   String hexborderColor = borderColor.asHex();
         */
        String rgbabackgroundColor = driver.findElement(By.xpath("//button[@aria-label='Flights']")).getCssValue("background-color");
        String rgbaBorderColor = driver.findElement(By.xpath("//button[@aria-label='Flights']")).getCssValue("border-color");
        String rgbaTextColor = driver.findElement(By.xpath("//button[@aria-label='Flights']")).getCssValue("Text-color");



        System.out.println("rgbabackgroundColor" + rgbabackgroundColor);   //rgba(43, 166, 203, 1)
        System.out.println("rgbaBorderColor" + rgbaBorderColor);   //rgba(43, 166, 203, 1)
        System.out.println("rgbaTextColor " + rgbaTextColor);   //rgba(43, 166, 203, 1)

        Color backGroundcolor = Color.fromString(rgbabackgroundColor); // import org.openqa.selenium.support.Color;
        Color borderColor = Color.fromString(rgbaBorderColor); // import org.openqa.selenium.support.Color;
        Color TextColor = Color.fromString(rgbaTextColor); // import org.openqa.selenium.support.Color;

        System.out.println("Color.fromString(rgbabackgroundColor) " + backGroundcolor); //rgba(255, 231, 227, 1)
        System.out.println("Color.fromString(rgbaBorderColor) " + borderColor); //rgba(255, 231, 227, 1)
        System.out.println("Color.fromString(rgbaTextColor) " + TextColor);  //rgba(255, 231, 227, 1)


        String hexBackGroundColor = backGroundcolor.asHex();
        String hexborderColor = borderColor.asHex();
        String hexTextColor = TextColor.asHex();

        System.out.println(hexBackGroundColor);  //#ffe7e3
        System.out.println(hexborderColor);  //#ffe7e3
        System.out.println(hexTextColor);   //#ffe7e3
        Assert.assertEquals(expectedColor,hexBackGroundColor);
        Assert.assertEquals(expectedColor,hexborderColor);
        Assert.assertEquals(expectedColor,hexTextColor);

        driver.quit();

    }
    @Test
    public void verify_color1() throws InterruptedException {
        driver.get("https://omayo.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String expectedColor ="#333333"; // Hexformat color
        //String expectedColor ="#29a0c4"; // Hexformat color

        // String rgbaColor = driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).getCssValue("background-color");
        String rgbaColor = driver.findElement(By.xpath("//div[@id='cssmenu']/ul")).getCssValue("background-color");


        System.out.println(rgbaColor);   //rgba(43, 166, 203, 1)

        Color color = Color.fromString(rgbaColor); // import org.openqa.selenium.support.Color;

        String hexAcutalColor = color.asHex();

        System.out.println(hexAcutalColor);
        Assert.assertEquals(expectedColor,hexAcutalColor);



    }


    public void verify_color2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


       String expectedColor ="#29a0c4"; // Hexformat color

        String rgbaColor = driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).getCssValue("background-color");


        System.out.println(rgbaColor);   //rgba(43, 166, 203, 1)

        Color color = Color.fromString(rgbaColor); // import org.openqa.selenium.support.Color;

        String hexAcutalColor = color.asHex();

        System.out.println(hexAcutalColor);
        Assert.assertEquals(expectedColor,hexAcutalColor);





    }

}
