package cn.tjuscs.selenium;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;

public class LabTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.gecko.driver", "/Users/sisilee/Downloads/geckodriver");
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void lab() {
	  boolean flag = true;
	  driver.get("http://103.120.226.190/selenium-demo/git-repo");
	  driver.manage().window().setSize(new Dimension(1440, 900));
	  try {
          XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("/Users/sisilee/Downloads/Selenium+Lab2020.xlsx"));
          XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
          String[] cells = new String[2];
          for (int row = 0; row <= 20; row++) {
              cells[0] = sheet.getRow(row).getCell(1).getStringCellValue();
              cells[1] = sheet.getRow(row).getCell(2).getStringCellValue();
	          driver.findElement(By.name("user_number")).click();
	          driver.findElement(By.name("user_number")).sendKeys(cells[0]);
	          driver.findElement(By.name("password")).click();
	          driver.findElement(By.name("password")).sendKeys(cells[1]);
	          driver.findElement(By.cssSelector(".btn")).click();
	          assertThat(driver.findElement(By.cssSelector(".mb-2:nth-child(6) > code")).getText(), is(cells[1]));
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}
