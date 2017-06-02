package yygl_Constant;

import org.openqa.selenium.By;

public class Constants {
	// 测试访问地址
	public final static String URL = "http://xxxxx//Account/LogOn";
	
	public final static String Path_excel="D:\\Android\\YYGL\\src\\test.yaml";
//	public final static String URL = "http://114.55.1.85:9011/Account/LogOn";//JLW
//	public final static String URL="http://10.33.181.177:9004/Home/Index";//金丽温内网
	// 登录用户名、密码属性以及属性值
	public final static By Username_property = By.id("txtUsername");
	public final static By Passwrod_property = By.className("Password");
	public final static String Username = "xxxx";
	public final static String Password = "xxxx";
	//内网用户名密码
//	public final static String Username = "8888";
//	public final static String Password = "888888";
	// 首页登录按钮属性值
	public final static By Button_property = By.id("doLog");
	// 加载成功后页面元素ID唯一值判断
	public final static By ID_property = By.id("fm-top");
	
	// -----------------------------------------------------

	// -----------------------------------------------------
	// 小改大填报左侧菜单模块
//	public final static  By Shape_pro = By.
//			xpath("//*[@id='menu_content']/div[1]/ul/li["+CenterTestCase.i+"]/a/span");
	// 页面底部元素
	public final static By Botton_info = By
			.xpath("//*[@id='maingrid']/div[5]/div/div[1]/span");
	// 小改大新增页面元素、违规绿通各大类的新增id值
	public final static By Shaper_Add= By.id("btnAdd");
	
	// 数据填补模块
	public final static By Num_Fill=By.xpath("//*[@id='menu_content']/div[2]/div/div");
	
	//数据审核模块
	public final static By Ver_Create= By.xpath("//*[@id='menu_content']/div[3]/div/div");
}
