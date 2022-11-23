package ame.psb.db.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySql {
		public static int MAX_ROW=0;
		static {
			System.setProperty("maxrow", "10000");
			System.out.println(System.getProperties().get("maxrow"));
		}
		public static int getMaxRow() {
			if(MAX_ROW==0) {
				try {
					MAX_ROW = Integer.parseInt(System.getProperties().get("maxrow").toString());
				}catch(Exception ex) {
					MAX_ROW=10000;
				}
			}
			return MAX_ROW;
		}

    public static Connection mySqlDB(){
	    Connection con = null;// 创建一个数据库连接
	    try
	    {
	    	String driverName = "com.mysql.jdbc.Driver";  //加载JDBC驱动   
		    String dbURL = "jdbc:mysql://10.160.1.33:3306/HRS?useUnicode=true&characterEncoding=UTF-8&useServerPrepStmts=false&rewriteBatchedStatements=true&useCompression=false";  //连接服务器和数据库
		    //运行SQL语句  
		    String userName = "administrator_hr";  //默认用户名 
		    String userPwd = "xsw@cde3";  
		    Class.forName(driverName);
		    con = DriverManager.getConnection(dbURL, userName, userPwd);
	    	System.out.println("连接成功！");
			return con;
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	        return null;
	    }
	  }
    public static void main(String[] args) {
    	try(Connection conn = mySqlDB()){
    		String format = "select WXWORK_USERID from HRS.HRM_EMPLOYEE_INFO where EMPLOYEE_NUMBER = '%s'";    		
    		String sql = String.format(format, "18774");
    		String wxworkUserId = "";
    		try(PreparedStatement ps = conn.prepareStatement(sql)){
    			ResultSet rs = ps.executeQuery();
    			if(rs.next()) {
    				wxworkUserId= rs.getString(1);
    			}
    		}
    		System.out.println(wxworkUserId);
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    
}
