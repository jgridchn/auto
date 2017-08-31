package yygl_flow;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import yygl_Constant.Constants;

import yygl_Utity.YamlUtil;
import YYGL_Common.Iframe;
import YYGL_Common.Mthead;
import YYGL_Common.Refresh;
import YYGL_Login.Login;

public class UICheck {
	public YamlUtil myYaml;
	public WebDriver Driver;
	Login lo = new Login();

	@Test(dataProvider = "dp0")
	public void Test_01_Login(int j) throws Exception {
		Mthead.logger
				.info("*********************************************************************");
		myYaml = new YamlUtil(Login.driver, "./src/test/java/test.yaml");
		// myYaml = new YamlUtil(Login.driver,
		// "D:\\Android\\YYGL\\src\\test.yaml");
		Mthead.SendKey(myYaml.getElement("yygl_login_input"),
				Constants.Username);
		Mthead.SendKey(myYaml.getElement("yygl_password_input"),
				Constants.Password);
		Mthead.OnClick(myYaml.getElement("yygl_login_button"));
		Thread.sleep(3000);
		// 验证是否成功登录首页存在该元素
		lo.FirstEle(Constants.ID_property);
		Mthead.logger
				.info("*********************************************************************");

	}

	// 正常绿通
	@Test(dataProvider = "green", enabled = true)
	public void Test_02_green_Reporter(int j) {
		// 调用封装的onclick方法
		Mthead.logger
				.info("*********************************************************************");
		// Login.driver.navigate().refresh();
		// Mthead.OnClick(myYaml.getElement("tag_delete"));
		Mthead.OnClick(myYaml.getElement("Green_Pass"));
		// 进入iframe
		Mthead.Iframe(myYaml.getElement("Green_iframe"));
		Assert.assertTrue(Login.driver.getPageSource().contains("搜索日期"));
		Login.driver.switchTo().defaultContent();
		Mthead.logger
				.info("*********************************************************************");
	}

	// 创收数据报表
	@Test(dataProvider = "dp", enabled = true)
	public void Test_03_Shaper_Reporter(int j) {
		// 调用封装的onclick方法
		Mthead.logger
				.info("*********************************************************************");
		Mthead.OnClick(myYaml.getElement("Create_Change"));
		// 进入iframe
		Mthead.Iframe(myYaml.getElement("first_iframe"));
		Assert.assertTrue(Login.driver.getPageSource().contains("搜索日期"));
		// 点击新增按钮
		lo.ClickButton(myYaml.getElement("Add_Bot"));
		System.out.println("退出该frame");
		Login.driver.switchTo().defaultContent();
		// 验证是否弹出新增页面
		Mthead.Iframe(myYaml.getElement("Change_input_iframe"));
		Assert.assertTrue(Login.driver.getPageSource()
				.contains("请上传小于10M的图片文件"));
		Mthead.OnClick(myYaml.getElement("Back_Bot"));
		// 退出内层iframe
		Login.driver.switchTo().defaultContent();
		Mthead.logger
				.info("*********************************************************************");
	}

	// 创收数据报表
	@Test(dataProvider = "Illegal", enabled = true)
	public void Test_04_Illegal_Reporter(int j, String k)
			throws TimeoutException, Throwable {
		Mthead.logger
				.info("*********************************************************************");
		Refresh.Tag_Refresh();
		// Mthead.OnClick(myYaml.getElement("tag_delete"));
		// 调用封装的onclick方法
		String[] replace = { j + "" };
		Mthead.OnClick(myYaml.getValueByKey("Illegal_index", replace));
		// 进入iframe
		Mthead.Iframe(myYaml.getElement("Illegal_iframe"));
		Mthead.WaitEle(myYaml.getBy("Search_text"));
		// Assert.assertTrue(Login.driver.getPageSource().contains("搜索日期"));
		// 点击新增按钮
		lo.driver.findElement(By.id("btnAdd")).click();
		Login.driver.switchTo().defaultContent();
		System.out.println("退出该frame");
		// 验证是否弹出新增页面
		Mthead.Iframe(myYaml.getElement("Illegal_input_iframe"));
		Assert.assertTrue(Login.driver.getPageSource()
				.contains("请上传小于10M的图片文件"));
		Mthead.OnClick(myYaml.getElement("Back_Bot"));
		// 退出内层iframe
		Login.driver.switchTo().defaultContent();

		Mthead.logger
				.info("*********************************************************************");
	}

	// 创收数据填补
	@Test(dataProvider = "Fill", enabled = true)
	public void Test_05_Create_Fill(int j, String k) throws Exception {

		Mthead.logger
				.info("*********************************************************************");
		Refresh.Tag_Refresh();
		// Mthead.OnClick(myYaml.getElement("tag_delete"));
		Mthead.OnClick(myYaml.getElement("Fill"));
		// 调用封装的onclick方法
		String[] replace = { j + "" };
		// Thread.sleep(2000);
		Mthead.OnClick(myYaml.getValueByKey("Fill_index", replace));
		Mthead.Iframe(myYaml.getElement("Fill_other_iframe"));
		Mthead.WaitEle(myYaml.getBy("Search_text"));
		// Assert.assertTrue(Login.driver.getPageSource().contains("搜索日期"));
		Login.driver.switchTo().defaultContent();
		Mthead.logger
				.info("*********************************************************************");
	}

	// 数据审核
	@Test(dataProvider = "Verify", enabled = true)
	public void Test_06_Create_Verify(int j, String k) throws Exception {
		Mthead.logger
				.info("*********************************************************************");
		Refresh.Tag_Refresh();
		// Mthead.OnClick(myYaml.getElement("tag_delete"));
		Mthead.OnClick(myYaml.getElement("Verify"));
		// 调用封装的onclick方法
		String[] replace = { j + "" };
		// Thread.sleep(2000);
		Mthead.OnClick(myYaml.getValueByKey("Verify_index", replace));
		Mthead.Iframe(myYaml.getElement("Verify_other_iframe"));
		// Assert.assertTrue(Login.driver.getPageSource().contains("审核状态"));
		Mthead.WaitEle(myYaml.getBy("Search_text"));
		Login.driver.switchTo().defaultContent();
		Mthead.logger
				.info("*********************************************************************");
	}

	// 统计报表
	@Test(dataProvider = "Reporter", enabled = true)
	public void Test_06_Reporter(int j, String k) throws Exception {
		Mthead.logger
				.info("*********************************************************************");
		Refresh.Tag_Refresh();
		// Mthead.OnClick(myYaml.getElement("tag_delete"));
		Mthead.OnClick(myYaml.getElement("Reporter"));
		// 调用封装的onclick方法

		String[] replace = { j + "" };
		// Thread.sleep(2000);
		Mthead.OnClick(myYaml.getValueByKey("Reporter_index", replace));
		Iframe.iframe(Mthead.GetText(myYaml.getValueByKey("Reporter_index",
				replace)));
		Mthead.WaitEle(myYaml.getBy("Search_text"));
		// Assert.assertTrue(Login.driver.getPageSource().contains("导出"));

		Login.driver.switchTo().defaultContent();
		Mthead.logger
				.info("*********************************************************************");
	}

	@DataProvider
	public Object[][] dp0() {
		return new Object[][] { new Object[] { 0 }, };
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1 }, };
	}

	@DataProvider
	public Object[][] green() {
		return new Object[][] { new Object[] { 1 }, };
	}

	@DataProvider
	public Object[][] Illegal() {
		return new Object[][] { new Object[] { 4, "违规绿通" },
				new Object[] { 5, "冲跳磅" }, new Object[] { 6, "改胎型" },
				new Object[] { 7, "换卡" }, new Object[] { 8, "假冒免费" },
				new Object[] { 9, "违规ETC" }, new Object[] { 10, "无理由" }, };
	}

	@DataProvider
	public Object[][] Fill() {
		return new Object[][] { new Object[] { 3, "违规绿通补填" },
				new Object[] { 4, "冲跳磅补填" }, new Object[] { 5, "改胎型补填" },
				new Object[] { 6, "换卡补填" }, new Object[] { 7, "假冒免费补填" },
				new Object[] { 8, "违规ETC补填" }, new Object[] { 9, "无理由" } };
	}

	@DataProvider
	public Object[][] Verify() {
		return new Object[][] { new Object[] { 2, "违规绿通审核" },
				new Object[] { 3, "冲跳磅审核" }, new Object[] { 4, "改胎型审核" },
				new Object[] { 5, "换卡审核" }, new Object[] { 6, "假冒免费审核" },
				new Object[] { 7, "违规ETC审核" }, new Object[] { 8, "无理由审核" } };
	}

	@DataProvider
	public Object[][] Reporter() {

		return new Object[][] { new Object[] { 0, "接车量日报" },
				new Object[] { 1, "接车奖励月报" }, new Object[] { 2, "创收奖励日报" },
				new Object[] { 3, "创收挽回奖励月报" }, new Object[] { 4, "数据明细表" },
				new Object[] { 5, "绿通违规月报" }, new Object[] { 6, "混装车明细表" },
				new Object[] { 7, "修正率统计" }, new Object[] { 8, "违规分员" } };
	}

	@BeforeClass
	public void beforeClass() {

		// 打开浏览器
		lo.StartLogin();

	}

	@AfterClass
	public void afterClass() {
		// 关闭浏览器
		lo.closer();

	}

}
