package dataProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobToString {

    public static String ClobToString(Clob clob) throws SQLException, IOException {

        String reString = "";
        Reader is = clob.getCharacterStream();// 得到流
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s + "\n");
            s = br.readLine();
        }
        reString = sb.toString();
        return reString;
    }

    public static String oracleClob2Str(Clob clob)  {
        try {
            return (clob != null ? clob.getSubString(1, (int) clob.length()) : null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String clobToStr(Clob clob){
        String s = "";
        try {
            int i = 0;
            if(clob != null){
                InputStream input = clob.getAsciiStream();
                int len = (int)clob.length();
                byte by[] = new byte[len];
                while(-1 != (i = input.read(by, 0, by.length))){
                    input.read(by, 0, i);
                }
                s = new String(by, "utf-8");
                input.close();
            }

            return s;
        }catch (Exception e){
            e.printStackTrace();
            return s;
        }
    }

}
