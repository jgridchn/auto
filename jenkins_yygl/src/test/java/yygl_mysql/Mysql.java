package yygl_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql {

	public static int count;

//	 static Connection conn = null;
	String sql;
	static String sql_01;
	static String sql_02;
	static String url = "jdbc:mysql://rm-bp1c0xb0vs8a0sh4ro.mysql.rds.aliyuncs.com:3306/odms_debug_jlw?"
			+ "user=xxxx&password=xxxx";

	 static String sql_type;

	public static String type_value;

	public static  void ExcuteSql() throws Exception {
		// 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
		// 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
		Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
		// or:
		// com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
		// or：
		// new com.mysql.jdbc.Driver();

		System.out.println("成功加载MySQL驱动程序");
		
		
//System.out.println(conn);

	}

	// 查询操作
	public static void Query() throws Exception {
		Connection conn = null;
		try {
			ExcuteSql();
			// 一个Connection代表一个数据库连接
						conn = DriverManager.getConnection(url);
			// 小改大查询当月数量集
			sql_01 = "SELECT count(*) from gl_bd_passcardillegal where n_audit_state!=-1  and n_date BETWEEN \"20161201\" and \"20161231\"";
			sql_02 = "select * from gl_al_create_income";
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery(sql_01);

			while (rs1.next()) {
				count = rs1.getInt(1);
				System.out.print("查询结果：" + rs1.getInt(1) + "\t");// 入如果返回的是int类型可以用getInt(1)//
																	// + "\t" +
																	// rs.getInt(2)
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	
	//查询操作
	public static String Query1(String type)throws Exception{
		Statement stmt = null;
		ResultSet rs1 = null;
		Connection conn = null;
		try {
			ExcuteSql();
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			// 小改大查询当月数量集
			sql_type = "SELECT "+type+" from gl_bd_passcardillegal  GROUP BY dt_add_time desc limit 1";
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			 stmt = conn.createStatement();
			 rs1 = stmt.executeQuery(sql_type);

			while (rs1.next()) {
				type_value = rs1.getString(1);
				
				System.out.print("查询结果：" + type_value + "\t");// 入如果返回的是int类型可以用getInt(1)//
																	// + "\t" +
																	// rs.getInt(2)
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs1.close();
			stmt.close();
			conn.close();
		}
//		System.out.println(conn);
		return type_value.trim();
	}
	
	
	//查询操作
		public static String Query2(String type)throws Exception{
			Statement stmt = null;
			ResultSet rs1 = null;
			Connection conn = null;
			try {
				ExcuteSql();
				// 一个Connection代表一个数据库连接
				conn = DriverManager.getConnection(url);
				// 小改大查询当月数量集
				sql_type = "SELECT "+type+" from gl_bd_create_income  GROUP BY dt_add_time desc limit 1";
				// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
				 stmt = conn.createStatement();
				 rs1 = stmt.executeQuery(sql_type);

				while (rs1.next()) {
					type_value = rs1.getString(1);
					System.out.print("查询结果：" + type_value + "\t");// 入如果返回的是int类型可以用getInt(1)//
																		// + "\t" +
																		// rs.getInt(2)
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			finally {
				rs1.close();
				stmt.close();
				conn.close();
			}
//			System.out.println(conn);
			return type_value.trim();
		}
		
		
		public static String Query3(String type)throws Exception{
			Statement stmt=null;
			ResultSet rs1=null;
			Connection conn = null;
			try {
				ExcuteSql();
				// 一个Connection代表一个数据库连接
				conn = DriverManager.getConnection(url);
				// 小改大查询当月数量集
				sql_type = "SELECT "+type+" from gl_bd_create_income_normal  GROUP BY dt_add_time desc limit 1";
				// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
				 stmt = conn.createStatement();
				 rs1 = stmt.executeQuery(sql_type);

				while (rs1.next()) {
					type_value = rs1.getString(1);
					System.out.print("查询结果：" + type_value + "\t");// 入如果返回的是int类型可以用getInt(1)//
																		// + "\t" +
																		// rs.getInt(2)
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			finally {
				
				rs1.close();
				stmt.close();
				conn.close();
			}
//			System.out.println(conn);
			return type_value.trim();
		}

	// 数据库插入操作
	public static void InsertNum() throws Exception {
		Connection conn = null;
		try {
			ExcuteSql();
			// 小改大插入随机10条
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			for (int i = 1; i <= 10; i++) {
				System.out.println("新增第" + i + "条数据");
				String sql_up = "INSERT INTO `odms_debug`.`gl_bd_passcardillegal` "
						+ "values"
						+ "("
						+ String.valueOf((int) (Math.random() * 2000))
						+ ", '20161205', '90', "
						+ String.valueOf(100 + (int) (Math.random() * 1000))
						+ ", '1110', '1117', '次坞', '1', '4', '次坞_test', '0', '111', '客车小改大', NULL, '', '111.00', '222.00', '111.00', '0', '3', NULL, '', NULL, '', '0', '2016-11-22 11:10:34', '5ba740e9-35c3-4d43-a26c-7f1422f0264e', '营运部', NULL, NULL, NULL, '0',null)";
				System.out.println(sql_up);
				int rs1 = stmt.executeUpdate(sql_up);
			}
			Query();

			sql_02 = "select * from gl_al_create_income";
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
	

	// 删除操作
	public static void Delete_num() throws Exception {
		ExcuteSql();
		
		Connection conn = null;
		try {
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
			// 删除新增的10条数据
			
			String sql_de = "DELETE from gl_bd_passcardillegal where n_date='20161205' and n_lane='90'";
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			Statement stmt = conn.createStatement();
			int rs1 = stmt.executeUpdate(sql_de);
			System.out.println("删除" + rs1 + "条数据");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

}
