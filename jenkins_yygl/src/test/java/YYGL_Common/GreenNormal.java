package YYGL_Common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;

import yygl_Utity.YamlUtil;
import yygl_mysql.Mysql;
import YYGL_Login.Login;

public class GreenNormal {
	
	public static String w_date=Now_date();
	public static String w_station="";
	public static String w_operator="";
//	public   String w_lane=""+(int) (10+ Math.random()*90);
//	public  String w_serial=""+(int) (10+ Math.random()*90);
	public static String w_class="";
	public static String w_license_color="";
//	public static String w_vehicle_license="浙A12345";
	//小类
	public static String w_violation_type="";
	public static String w_save_loss="10.55";
	public static String w_category="";
	//车型
	public static String w_vehicle_class="";
	public static String w_card=""+(int)(1+Math.random()*10000);
	public static String w_mark="test"+(int)(1+Math.random()*100);
	public static String w_img="";
	
	static YamlUtil myYaml=new YamlUtil(Login.driver, System.getProperty("user.dir") + File.separator +"src/test/java/W_Reporter.yaml");
	private static long date;
	
	
	
	public  static String Now_date(){
		date = System.currentTimeMillis();
		Date dt=new Date(date);
	DateFormat df = new SimpleDateFormat("YYYYMMdd");
	 w_date = df.format(dt);
	return w_date;
	}
	
	public static void  W_GreenNormal() throws InterruptedException{
		
		String w_lane=""+(int) (10+ Math.random()*90);
		String w_serial=""+(int) (10+ Math.random()*90);
		
		  String w_vehicle_license="浙A"+(int)(10000+Math.random()*89999);
		
		Mthead.SendKey(myYaml.getElement("w_date"), w_date);
		//js效果要先点击一下
		Mthead.OnClick(myYaml.getElement("w_station"));
		Mthead.OnClick(myYaml.getElement("w_station_selection"));
		
		Mthead.OnClick(myYaml.getElement("w_operator"));
		Login.driver.switchTo().defaultContent();
		Mthead.Iframe(myYaml.getElement("w_Oper_iframe"));
		Mthead.OnClick(myYaml.getElement("w_select_operator"));
		Mthead.OnClick(myYaml.getElement("w_select_oper_btn"));
		Login.driver.switchTo().defaultContent();
		
		
		Mthead.Iframe(myYaml.getElement("Green_input_iframe"));
		
		Mthead.SendKey(myYaml.getElement("w_lane"), w_lane);
		
		Mthead.SendKey(myYaml.getElement("w_serial"), w_serial);
		
		Mthead.OnClick(myYaml.getElement("w_class"));
		Mthead.OnClick(myYaml.getElement("w_class_select"));
		
		Mthead.OnClick(myYaml.getElement("w_license_color"));
		Mthead.OnClick(myYaml.getElement("w_license_color_select"));	
		Mthead.SendKey(myYaml.getElement("w_vehicle_license"), w_vehicle_license);
		//客货
		Mthead.OnClick(myYaml.getElement("w_category"));
		Mthead.OnClick(myYaml.getElement("w_category_select"));
		//车型
		Mthead.OnClick(myYaml.getElement("w_vehicle_class"));
		Mthead.OnClick(myYaml.getElement("w_vehicle_class_select"));
		
		Mthead.SendKey(myYaml.getElement("w_card"), w_card);
		Mthead.SendKey(myYaml.getElement("w_mark"),w_mark);
//		WebElement  file =Login.driver.findElement(By.id("SWFUpload_0"));
//		file.sendKeys("E:/test.jpg");
		Mthead.OnClick(myYaml.getElement("w_btn"));
//		Mthead.SendKey(myYaml.getElement(""), w_date);
		
		
		Login.driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//验证弹出框
		Assert.assertTrue(Login.driver.getPageSource().contains("新增成功"));
		Mthead.OnClick(myYaml.getElement("w_alter_btn"));
		
		
		
		 try {
			   Assert.assertEquals(w_date, Mysql.Query3("n_date"));
//			   Assert.assertEquals(w_time, Mysql.Query1("n_time"));
			   Assert.assertEquals("岭下朱1511", Mysql.Query3("vc_station_name"));
			   Assert.assertEquals("何华", Mysql.Query3("vc_op_name"));
			   Assert.assertEquals(w_lane, Mysql.Query3("n_lane"));
			   Assert.assertEquals(w_serial, Mysql.Query3("n_serial"));
			   //班次 
			   Assert.assertEquals("1", Mysql.Query3("n_shift_code"));
			   Assert.assertEquals("1", Mysql.Query3("vc_vehicle_license_color"));
			   Assert.assertEquals(w_vehicle_license, Mysql.Query3("vc_vehicle_license"));
			   Assert.assertEquals("0", Mysql.Query3("c_category"));
			   Assert.assertEquals("3", Mysql.Query3("c_vehicle_class"));
			   Assert.assertEquals(w_card, Mysql.Query3("vc_card_id"));
			   Assert.assertEquals(w_mark, Mysql.Query3("vc_marks"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
