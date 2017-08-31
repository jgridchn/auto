package YYGL_Common;


import org.openqa.selenium.By;

import YYGL_Login.Login;

public class Refresh {

	public static void Tag_Refresh () {
		
		Login.driver.navigate().refresh();
		try {
		Thread.sleep(2000);
		Login.driver.findElement(By.xpath("//*[@id='framecenter']/div[1]/ul/li[2]/div[3]")).isDisplayed();
			Login.driver.findElement(By.xpath("//*[@id='framecenter']/div[1]/ul/li[2]/div[3]")).click();
		
			
		} catch (Exception e) {
			System.out.println("");
		}
	}
}
