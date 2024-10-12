package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;

public class GoogleSearchTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        //Intialize the driver
        driver = new ChromeDriver();

        //Provide the implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Maximize the browser
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
    }
    @Test(priority = 1)
    public void searchProQuest() throws IOException {
        // Navigate to Google
        driver.get("https://www.google.com");

        //To accept the conset
        WebElement acceptAllButton = driver.findElement(By.id("L2AGLb"));
        acceptAllButton.click();
        // Perform a search for 'ProQuest'
        WebElement searchEng = driver.findElement(By.name("q"));
        //Enetering data and Performing Enter operation
        searchEng.sendKeys("ProQuest", Keys.ENTER);
        // Find all result titles
        List<WebElement> titles = driver.findElements(By.xpath("//h3"));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("GoogleSearchResults.txt"))) {
            for (WebElement title : titles) {
                writer.write(title.getText());
                writer.newLine();
            }
            System.out.println("Titles written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.findElement(By.partialLinkText("ProQuest")).click();
    }
    @Test(priority = 2)
    public void searchQAInProQuest() throws IOException {
        // Search for 'QA' in ProQuest's search bar
        WebElement searchBox = driver.findElement(By.id("searchTerm"));
        searchBox.sendKeys("QA");

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.findElement(By.id("searchTerm"));
        driver.findElement(By.xpath("//span[@class='uxf-icon uxf-search']")).click();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), new File("ProQuestSearchQA.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Screenshot saved successfully.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    }

