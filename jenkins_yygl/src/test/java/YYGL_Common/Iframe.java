package YYGL_Common;

import java.io.File;

import org.openqa.selenium.WebElement;

import yygl_Utity.YamlUtil;

import YYGL_Login.Login;

public class Iframe {

	private static YamlUtil myYaml;

	public static void iframe(String key) {
		
		myYaml = new YamlUtil(Login.driver,System.getProperty("user.dir") + File.separator +"src/test/java/test.yaml");
		switch (key) {
		case "接车量日报":
             Mthead.Iframe(myYaml.getElement("Reporter_car_iframe"));
			break;
		case "接车奖励月报":
			Mthead.Iframe(myYaml.getElement("Reporter_carMonth_iframe"));
			break;
		case "创收挽回日报":
			Mthead.Iframe(myYaml.getElement("Reporter_carIncome_iframe"));
			break;
		case "创收挽回奖励月报":
			Mthead.Iframe(myYaml.getElement("Reporter_carIncomeMonth_iframe"));
			break;

		case "创收奖励数据明细表":
			Mthead.Iframe(myYaml.getElement("Reporter_carIncomeDetail_iframe"));
			break;
		case "绿通违规月报表":
			Mthead.Iframe(myYaml.getElement("Reporter_carIncomeIllegal_iframe"));
			break;
		case "混装车辆明细表":
			Mthead.Iframe(myYaml.getElement("Reporter_carMixedDetail_iframe"));
			break;
		case "修正率统计月报表":
			Mthead.Iframe(myYaml.getElement("Reporter_carFillInfo_iframe"));
			break;

		case "违规分员报表":
			Mthead.Iframe(myYaml.getElement("Reporter_IllegalMinute_iframe"));
			break;
//		default:
//			break;
		}
	}

}
