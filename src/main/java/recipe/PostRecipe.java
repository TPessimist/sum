package recipe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PostRecipe {

    public static  Connection initConn() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test?"
                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("成功建立数据库连接...\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (Exception connE) {
            connE.printStackTrace();
        }
        return null;
    }

    public static void postRecipe(List<Recipe> recipes,Connection conn) throws SQLException {
        //数据库建立连接
//        Connection conn = initConn();

        String prefix = "INSERT INTO recipe_test (RECIPE_ID, PARENT_ID, EQUPIMENT_ID,RECIPE_NAME, KEY_NAME,VALUE,ISXML) VALUES ";
        System.out.println("正在处理即将传入数据库的数据...\n");

        try {
            System.out.print("正在建立SQL语句...\n");
            StringBuffer suffix = new StringBuffer();
            //关闭自动提交
            conn.setAutoCommit(false);
            PreparedStatement pst = conn.prepareStatement(prefix);
            Iterator<Recipe> integer = recipes.iterator();
            while (integer.hasNext()) {
                //拿到单个recipe对象
                Recipe recipe = integer.next();
                List<Map<String, String>> mapList = recipe.getRecipeList();
                Iterator<Map<String, String>> mapIterator = mapList.iterator();

                while (mapIterator.hasNext()) {
                    //拿到recipe对象中的recipeMap
                    Map<String, String> recipeMap = mapIterator.next();
                    //获取所有键名
                    Set<String> keySet = recipeMap.keySet();

                    for (String key : keySet) {
                        suffix.append("(" + recipe.getId() + ","
                                + recipe.getParentId() + ",'"
                                + recipe.getEqupimentId() + "','"
                                + recipe.getRecipeName() + "','"
                                + key + "','"
                                + recipeMap.get(key) + "','"
                                + recipe.isXml() + "'"
                                + "),");
                    }
                }
            }
            String sql = prefix + suffix.substring(0, suffix.length() - 1);
            System.out.print("SQL语句整合成功...\n");
            pst.addBatch(sql);
            pst.executeBatch();
            conn.commit();
            pst.close();
//            conn.close();
            System.out.print("数据插入结束...\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
