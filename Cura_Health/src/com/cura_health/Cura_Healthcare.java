package com.cura_health;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cura_Healthcare {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://katalon-demo-cura.herokuapp.com");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#btn-make-appointment")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#txt-username")).sendKeys("John Doe");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#txt-password")).sendKeys("ThisIsNotAPassword");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.switchTo().alert().dismiss();
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='combo_facility']"));
		Select s = new Select(dropdown);
		s.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='radio_program_medicaid']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#txt_visit_date")).sendKeys("28/07/2025");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@class='form-control']"))
				.sendKeys("The appointment is booked for the neck pain. Hope doctor will resolve that problem.");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
		System.out.println(driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']")).getText());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\appointment.jpg"));
		Thread.sleep(3000);
		driver.quit();
	}

}
