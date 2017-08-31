package YYGL_Common;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import yygl_Utity.YamlUtil;
import yygl_mysql.Mysql;
import YYGL_Login.Login;

public class PassIllegal {
	
	public static String w_date=Now_date();
	public static String w_time="1500";
	public static String w_station="";
	public static String w_operator="";
	public static String w_class="";
	public static String w_license_color="";
//	public static String w_vehicle_license="浙A12345";
	public static String w_type="";
	public static String w_before_income="10.11";
	public static String w_after_income="20.22";
	
//	public static String w_lane=""+(int) (10+Math.random()*90);
//	public static String w_serial=""+(int) (10+ Math.random()*90);
	public static String w_category="";
	public static String w_img="";
	
	static YamlUtil myYaml=new YamlUtil(Login.driver, System.getProperty("user.dir") + File.separator +"src/test/java/W_Reporter.yaml");
	public static long date;
	
	public  static String Now_date(){
		date = System.currentTimeMillis();
		Date dt=new Date(date);
	DateFormat df = new SimpleDateFormat("YYYYMMdd");
	 w_date = df.format(dt);
	return w_date;
	}
	
	public static void  W_PassIllegal(){
		  String w_lane=""+(int) (10+Math.random()*90);
		  
		  
		  String w_serial=""+(int) (10+ Math.random()*90);
		  
		  String w_vehicle_license="浙A"+(int)(10000+Math.random()*89999);
		
		  
		 double w_loss =Double.parseDouble(w_after_income)-Double.parseDouble(w_before_income);
		 String w_n_loss=String.valueOf(w_loss);
		Mthead.SendKey(myYaml.getElement("w_date"), w_date);
		//js效果要先点击一下
		Mthead.OnClick(myYaml.getElement("w_time"));
		Mthead.SendKey(myYaml.getElement("w_time"), w_time);
		Mthead.OnClick(myYaml.getElement("w_station"));
		Mthead.OnClick(myYaml.getElement("w_station_selection"));
		
		Mthead.OnClick(myYaml.getElement("w_operator"));
		Login.driver.switchTo().defaultContent();
		Mthead.Iframe(myYaml.getElement("w_Oper_iframe"));
		Mthead.OnClick(myYaml.getElement("w_select_operator"));
		Mthead.OnClick(myYaml.getElement("w_select_oper_btn"));
		Login.driver.switchTo().defaultContent();
		
		
		Mthead.Iframe(myYaml.getElement("Change_input_iframe"));
//		Mthead.Select_default(myYaml.getElement("w_class_select"), 1);
		Mthead.OnClick(myYaml.getElement("w_class"));
		Mthead.OnClick(myYaml.getElement("w_class_select"));
		
		Mthead.OnClick(myYaml.getElement("w_license_color"));
		Mthead.OnClick(myYaml.getElement("w_license_color_select"));
		Mthead.SendKey(myYaml.getElement("w_vehicle_license"), w_vehicle_license);
		
		Mthead.OnClick(myYaml.getElement("w_type"));
		Mthead.OnClick(myYaml.getElement("w_type_select"));
		
		Mthead.SendKey(myYaml.getElement("w_before_income"), w_before_income);
		Mthead.SendKey(myYaml.getElement("w_after_income"), w_after_income);
		Mthead.SendKey(myYaml.getElement("w_lane"), w_lane);
		Mthead.SendKey(myYaml.getElement("w_serial"), w_serial);
		
		Mthead.OnClick(myYaml.getElement("w_category"));
		Mthead.OnClick(myYaml.getElement("w_category_select"));
//		Mthead.OnClick(myYaml.getElement("w_category_select"));
//		WebElement  file =Login.driver.findElement(By.id("SWFUpload_0"));
//		file.sendKeys("E:/test.jpg");
		Mthead.OnClick(myYaml.getElement("w_btn"));
		Login.driver.switchTo().defaultContent();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//验证弹出框
		Assert.assertTrue(Login.driver.getPageSource().contains("新增成功"));
		Mthead.OnClick(myYaml.getElement("w_alter_btn"));
		
		//数据库层校验
   try {
	   Assert.assertEquals(w_date, Mysql.Query1("n_date"));
	   Assert.assertEquals(w_time, Mysql.Query1("n_time"));
	   Assert.assertEquals("岭下朱1511", Mysql.Query1("vc_station_name"));
	   Assert.assertEquals("何华", Mysql.Query1("vc_op_name"));
	   Assert.assertEquals("1", Mysql.Query1("n_shift_code"));
	   Assert.assertEquals("1", Mysql.Query1("vc_vehicle_license_color"));
	   Assert.assertEquals(w_vehicle_license, Mysql.Query1("vc_vehicle_license"));
	   Assert.assertEquals("客车小改大", Mysql.Query1("vc_change_type"));
	   Assert.assertEquals(w_before_income, Mysql.Query1("d_befor_price"));
	   Assert.assertEquals(w_after_income, Mysql.Query1("d_after_price"));
	   Assert.assertEquals(w_n_loss, Mysql.Query1("d_save_loss"));
	   Assert.assertEquals(w_lane, Mysql.Query1("n_lane"));
	   Assert.assertEquals(w_serial, Mysql.Query1("n_serial"));
	   Assert.assertEquals("0", Mysql.Query1("c_category"));
	
} catch (Exception e) {
	e.printStackTrace();
}
		
	}
	
}