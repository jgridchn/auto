package YYGL_Common;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import YYGL_Login.Login;

public class Mthead {

	// Login lo = new Login();

	public static Logger logger = Logger.getLogger(Mthead.class);

	public static WebElement WaitEle(final By by) {

		WebDriverWait wait = new WebDriverWait(Login.driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					Login.driver.findElement(by).isDisplayed();
					return true;
				} catch (Exception e) {
					logger.error("元素不存在" + by);
					return false;
				}
			}
		});
		// 等待元素可见且可被单击   有些下拉框为display:none 为不可见，所以不能执行下面这句方法
		wait.until(ExpectedConditions.elementToBeClickable(Login.driver.findElement(by)));
		return Login.driver.findElement(by);

	}
	
	
	public static WebElement Wait_special_ele(final By by) {

		WebDriverWait wait = new WebDriverWait(Login.driver, 10);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					Login.driver.findElement(by).isDisplayed();
					// System.out.println("1111");
					return true;
				} catch (Exception e) {
					// System.out.println("元素不存在");
					logger.error("元素不存在" + by);
					return false;
				}
			}
		});
		return Login.driver.findElement(by);
	}

	// 页面点击事件
	public static void OnClick(WebElement web_box) {
		logger.info("点击" + web_box);
		web_box.click();

	}

	public static void Iframe(WebElement web_box) {
		
		logger.info("进入iframe" + web_box);
		Login.driver.switchTo().frame(web_box);
	}

	// 页面输入输入事件
	public static void SendKey(WebElement web_box, String values) {
		web_box.clear();
		web_box.sendKeys(values);
	}

	// 下拉框选取
	public static void Select_default(WebElement web_box, int index) {
		Select Selected = new Select(web_box);
		// 默认选择第一个
		System.out.println(Selected+"  "+index+"----------------");
		Selected.selectByIndex(index);

	}

	// 元素的属性值获取
	public static void GetAttr(WebElement web_box, String value) {
	
		web_box.getAttribute(value);

	}

	public static String GetText(WebElement web_box) {
		
		return web_box.getText();
	}

	// 新增页面是否存在
	public static boolean Add_Page(WebElement web_box, WebElement web_box2) {
		Login.driver.switchTo().defaultContent();
		
		// Login.driver.switchTo().frame(Login.driver.findElement(By.xpath("//iframe[contains(@src,'CreateIncome')]")));
		Login.driver.switchTo().frame(web_box);
		try {
			// if(Login.driver.findElement(By.xpath("/html/body/form/div[1]/div")).isDisplayed());
			if (web_box2.isDisplayed());
			return true;
		} catch (Exception e) {
			logger.error("新增页面未打开");
			return false;
		}
	}

	// 列表页是否存在
	public static boolean List(WebElement web_box) {
		try {
			// if(Login.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/span")).isDisplayed());
			if (web_box.isDisplayed())
				;
			return true;
		} catch (Exception e) {
			// System.out.println("列表页打开失败");
			logger.error("列表页打开失败");
			return false;
		}
	}
	
	//指定元素双击
	public static void Action_Oper(WebElement web_box){
		Actions action=new Actions(Login.driver);
		action.doubleClick(web_box).perform();
	}

}
