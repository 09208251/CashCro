package com.CashKro_Login;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.ThreeDEval;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CashKro_login extends Constants {

	@BeforeTest
	public void app_Lunch() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\chromee\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://cashkaro.iamsavings.co.uk/index.php");
		

		if (driver.findElement(By.xpath("//a[@id='link_signin']")).isDisplayed()) {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("D:/launchpass.png"));
		
		} else {

			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("D:/launchfail.png"));

		}
	}

	@Test
	public void app_Login() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//a[@id='link_signin']")).click();

		
		driver.findElement(By.xpath("//input[@id='uname']")).sendKeys("bharath.aut739@gmail.com");

		

		try {
			driver.findElement(By.xpath("//input[@id='spwd-txt']")).sendKeys("123456");
		} catch (Exception e) {
			driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("123456");
		}
		
		/*
		 *                           (OR)
		 *  DRIVER.FINDELEMENT(BY.XPATH("//INPUT[@ID='UNAME']")).SENDKEYS("BHARATH.AUT739@GMAIL.COM",KEYS.TAB,"123456");
		 */
		
		

		driver.findElement(By.xpath("//button[@id='btnLayoutSignIn']")).click();

		if (driver.findElement(By.xpath("//a[@id='link_myaccount']")).isDisplayed()) {

			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("D:/pass.png"));
			System.out.println("Login Succefull");

		} else {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("D:/fail.png"));
			System.out.println("Login Faild");
		}
	}
}
