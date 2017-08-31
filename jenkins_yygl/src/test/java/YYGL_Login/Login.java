package YYGL_Login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import YYGL_Common.Mthead;

import yygl_Constant.Constants;


public class Login {

	public static  WebDriver driver;

	public void StartLogin() {
		driver = new ChromeDriver();
		driver.get(Constants.URL);
		// 窗口最大化
		driver.manage().window().maximize();
	}

	// 文本框先清理在输入值
	public void EleInput(By box, String value) {
		driver.findElement(box).clear();
		driver.findElement(box).sendKeys(value);
	}

	// button单击事件
	public void ClickButton(WebElement web_box) {
		Mthead.logger.info("点击按钮属性"+web_box);
		web_box.click();
	}

	// 判断首页元素是否存在
	public void FirstEle(By box) {
		try {

			driver.findElement(box).isDisplayed();
			
			Mthead.logger.info("检测到ID元素值，登录首页成功");
			Assert.assertTrue(true);
		} catch (Exception e) {
			Mthead.logger.info("未检测到ID元素值，登录首页失败");
			Assert.assertTrue(false);
		}
	}

	// 浏览器的关闭
	public void closer() {
		driver.close();
	}

}
