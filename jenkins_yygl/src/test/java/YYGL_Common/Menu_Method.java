package YYGL_Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Menu_Method {
	public static By Shape_pro;
	public static By Num_pro;
	public static By Verfiy_pro;

	public static void MenuMethod(int key) {
		switch (key) {
		case 1:
			Shape_pro = By.xpath("//*[@id='menutree']//li[1]//ul[1]/li["+key+"]");
			Num_pro = By.xpath("//*[@id='menutree']//li[2]//ul[1]/li["+key+"]");
			Verfiy_pro = By.xpath("//*[@id='menutree']//li[3]//ul[1]/li["+key+"]");
			break;
		case 2:
			Shape_pro = By.xpath("//*[@id='menutree']//li[1]//ul[1]/li["+key+"]");
			Num_pro = By.xpath("//*[@id='menutree']//li[2]//ul[1]/li["+key+"]");
			Verfiy_pro = By.xpath("//*[@id='menutree']//li[3]//ul[1]/li["+key+"]");
			break;
		case 3:
			Shape_pro = By.xpath("//*[@id='menutree']//li[1]//ul[1]/li["+key+"]");
			Num_pro = By.xpath("//*[@id='menutree']//li[2]//ul[1]/li["+key+"]");
			Verfiy_pro = By.xpath("//*[@id='menutree']//li[3]//ul[1]/li["+key+"]");
			break;
		case 4:
			Shape_pro = By.xpath("//*[@id='menutree']//li[1]//ul[1]/li["+key+"]");
			Num_pro = By.xpath("//*[@id='menutree']//li[2]//ul[1]/li["+key+"]");
			Verfiy_pro = By.xpath("//*[@id='menutree']//li[3]//ul[1]/li["+key+"]");
			break;
		case 5:
			Shape_pro = By.xpath("//*[@id='menutree']//li[1]//ul[1]/li["+key+"]");
			Num_pro = By.xpath("//*[@id='menutree']//li[2]//ul[1]/li["+key+"]");
			Verfiy_pro = By.xpath("//*[@id='menutree']//li[3]//ul[1]/li["+key+"]");
			break;
		case 6:
			Shape_pro = By.xpath("//*[@id='menutree']//li[1]//ul[1]/li["+key+"]");
			Num_pro = By.xpath("//*[@id='menutree']//li[2]//ul[1]/li["+key+"]");
			Verfiy_pro = By.xpath("//*[@id='menutree']//li[3]//ul[1]/li["+key+"]");
			break;

		default:
			Shape_pro = By.xpath("//*[@id='menutree']//li[1]//ul[1]/li["+key+"]");
			Num_pro = By.xpath("//*[@id='menutree']//li[2]//ul[1]/li["+key+"]");
			Verfiy_pro = By.xpath("//*[@id='menutree']//li[3]//ul[1]/li["+key+"]");
			break;
		}
	}
}
