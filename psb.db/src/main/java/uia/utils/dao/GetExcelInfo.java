/*
package uia.utils.dao;

import ame.psb.db.conf.Hana;
import ame.psb.db.conf.Oracle;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
*/
/**
 * GetExcelInfo class
 *
 * @author CoffeeCao
 * @date 2018/3/02
 *//*

public class GetExcelInfo {

    public static void main(String[] args) throws SQLException {
        GetExcelInfo obj = new GetExcelInfo();
        // 此处为我创建Excel路径：
        File file = new File("C:/Users/Coffee/Desktop/test.xls");
        //File file = new File(obj.getPath());
        System.out.println(obj.getPath());
        Sheet sheets = obj.readExcel(file);
        String db = sheets.getCell(1, 0).getContents();
        System.out.println(db);
        List<String> data = new ArrayList<String>();
        for (int i = 0; i < sheets.getRows(); i++) {
            String a = sheets.getCell(0, i).getContents();
            System.out.println(a);
            data.add(a);
        }
        switch (db) {
            case "HANAPRD":
                try (Connection conn = Hana.createProd()) {
                    GetExcelInfo dao = new GetExcelInfo(conn);
                    dao.update(data);
                }
                break;
            case "HANAQAS":
                try (Connection conn = Hana.createTest()) {
                    GetExcelInfo dao = new GetExcelInfo(conn);
                    dao.update(data);
                }
                break;
            case "HANA56":
                try (Connection conn = Hana.createDev()) {
                    GetExcelInfo dao = new GetExcelInfo(conn);
                    dao.update(data);
                }
                break;
            case "ORACLE49":
                try (Connection conn = Oracle.create()) {
                    GetExcelInfo dao = new GetExcelInfo(conn);
                    dao.update(data);
                }
                break;
            default:
        }
    }

    public Sheet readExcel(File file) throws SQLException {
        Sheet sheet = null;
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheetSize = wb.getNumberOfSheets();
            for (int index = 0; index < sheetSize; index++) {
                // 每个页签创建一个Sheet对象
                sheet = wb.getSheet(index);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sheet;
    }

    public String getPath() throws SQLException {
        String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.substring(1, path.length());
        int endIndex = path.lastIndexOf("/");
        path = path.substring(0, endIndex);
        try {
            path = java.net.URLDecoder.decode(path, "utf-8") + "/test.xls";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return path;
    }

    private Connection conn;

    public GetExcelInfo() {
    }

    public GetExcelInfo(Connection conn) {
        this.conn = conn;
    }

    private static final String SQL_UPD = "UPDATE ACTIVITY_GROUP SET MODIFIED_DATE_TIME=? WHERE ACTIVITY_GROUP=?";

    public int update(List<String> data) throws SQLException {
        if (data.size() == 0) {
            return 0;
        }
        try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
            for (String a : data) {
                ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                ps.setString(2, a);
                ps.addBatch();
            }
            return ps.executeBatch().length;
        }
    }
}

*/
