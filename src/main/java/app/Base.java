package app;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public Properties props;

    public WebDriver initializeDriver() throws IOException {
        props = new Properties();
        FileInputStream fis = new FileInputStream("src\\main\\java\\resources\\data.properties");
        props.load(fis);
        String browser = props.getProperty("browser");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "dependencies\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "dependencies\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "IE":
                System.setProperty("webdriver.ie.driver", "dependencies\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new Error("Browser not identified");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("DRIVER INSTANCIADO NO BASE " + this.toString());
        return driver;
    }

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        System.out.println(source.getAbsoluteFile());
        String fileName = testCaseName + Long.toHexString(Double.doubleToLongBits(Math.random())) + ".png";

        String destinationFile = System.getProperty("user.dir")+"\\reports\\" + fileName;
        System.out.println(destinationFile);
        FileUtils.copyFile(source, new File(destinationFile));

        return destinationFile;
    }

    public String getScreenshotFilename(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        System.out.println(source.getAbsoluteFile());
        String fileName = testCaseName + Long.toHexString(Double.doubleToLongBits(Math.random())) + ".png";

        String destinationFile = System.getProperty("user.dir")+"\\reports\\" + fileName;
        System.out.println(destinationFile);
        FileUtils.copyFile(source, new File(destinationFile));

        return fileName;
    }
}
