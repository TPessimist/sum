package recipe;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static dataProcessing.HexToString.toStringHex;
import static dataProcessing.ClobToString.oracleClob2Str;
import static dataProcessing.SyRegularRecipeUtils.killRegularRecipe;
import static dataProcessing.SyXmlUtilsPlus.killXmlPlus;

public class GetRecipe {
    /**
     * 获取recipe
     * 利用克隆创建对象，将xml格式与正常格式的recipe进行处理后作为对象存入list中
     *
     * @param
     * @return
     * @toStringHex sy.HexToString.toStringHex 将十六进制字符串解码为字符串;
     * @oracleClob2Str sy.ClobToString.oracleClob2Str; clob类型转为字符串
     * @killXML sy.XMLUtils.killXML; xml格式的字符串，并取出里面所有节点
     */
    public static List<Recipe> getRecipe() throws Exception {
        System.out.print("正在获取RECIPE数据...\n");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "SELECT ID,EQUIPMENT_ID,RECIPE_NAME,PARENT_ID,RECIPE_BODY FROM RMS_RECIPE WHERE " +
                "(ID,RECIPE_NAME)IN" +
                "(SELECT ID,RECIPE_NAME FROM RMS_RECIPE WHERE EQUIPMENT_ID in ('BPLT01','BPLT02','BPLT03',\n" +
                "'BPLT05','BPLT06','BPLT07','BPLT09','BPLT11','BPLT12','BPLT13','BPLT16') AND " +
                "IS_DELETED IS NULL AND STATUS = 2 AND RECIPE_BODY IS NOT NULL GROUP BY ID,RECIPE_NAME)";
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@10.160.1.43:1521:orcl", "RMS", "RMS");
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //获取结果集
        ResultSet rs = st.executeQuery(sql);
        ResultSetMetaData md = rs.getMetaData();//获取键名
        int columnCount = md.getColumnCount();//获取列数量
        //list用于存放每一个recipe对象
        List<Recipe> list = new ArrayList<>();
        System.out.print("获取数据成功,正在处理数据...\n");
        //遍历结果集
        while (rs.next()) {
            Map rowData = new HashMap<>();//声明Map
            //结果集从1开始
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
            }
            //判断RECIPE_BODY是否为空,并进行初步解码
            if (rowData.get("RECIPE_BODY") != null) {
                //获取recipe_body并将其类型clob转换为字符串
                String recipeHexSting = oracleClob2Str((Clob) rowData.get("RECIPE_BODY"));
                //转义16进制字符串
                String recipeString = toStringHex(recipeHexSting);
                //处理xml格式,如果是则解析后存入recipe
                if (recipeString.charAt(0) == '<') {
                    List<Map<String, String>> recipeMapList = killXmlPlus(recipeString);
                    //添加至list中
                    list.add(Recipe.getOneRecipeWithXmlData((BigDecimal) rowData.get("ID"), (String) rowData.get("EQUIPMENT_ID"), (BigDecimal) rowData.get("PARENT_ID"),
                            (String) rowData.get("RECIPE_NAME"), recipeMapList));
                    //常规格式
                } else {

                    List<Map<String, String>> recipeMapList = killRegularRecipe(recipeString);

                    list.add(Recipe.getOneRecipeWithRegularData((BigDecimal) rowData.get("ID"), (String) rowData.get("EQUIPMENT_ID"), (BigDecimal) rowData.get("PARENT_ID"),
                            (String) rowData.get("RECIPE_NAME"), recipeMapList));
                }
            }
        }
        st.close();
        conn.close();
//        return recipes;
        return list;
    }

    //

}
