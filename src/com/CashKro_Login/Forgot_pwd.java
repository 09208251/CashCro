package com.CashKro_Login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.emitter.EmitterException;

public class Forgot_pwd extends Constants {
	@BeforeTest
	public void app_Login() throws Exception {
		lg.app_Lunch();
		
		Select sc=new Select(driver.findElement(By.tagName("body")));
		
	}

	@Test
	public void forgot_Pwd() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='link_signin']")).click();
		driver.findElement(By.xpath("//a[@id='lnkLayoutForgotPassword']")).click();

		Thread.sleep(5000);
		driver.switchTo().frame(0);

		driver.findElement(By.xpath("//*[@id='from_email']")).click();
		driver.findElement(By.xpath("//*[@id='from_email']")).sendKeys("bharath.aut739@gmail.com");
		driver.findElement(By.xpath("//a[@id='submit_req']")).click();
		driver.switchTo().defaultContent();

	}

}
