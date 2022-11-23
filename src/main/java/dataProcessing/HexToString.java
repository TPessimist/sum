package dataProcessing;

public class HexToString {
    /**
     * 16进制转字符串
     * @param s
     * @return
     */
    public static String toStringHex(String s) {
        if (s!=null && "0x".equals(s.substring(0, 2))) {

            s = s.substring(2);

        }
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
                        i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "GB2312");//
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

//    public static String hexStr2Str(String hex) {
//        String hexStr = "";
//        String str = "0123456789ABCDEF"; //16进制能用到的所有字符 0-15
//        for(int i=0;i<hex.length();i++){
//            String s = hex.substring(i, i+1);
////            if(s.equals("a")||s.equals("b")||s.equals("c")||s.equals("d")||s.equals("e")||s.equals("f")){
////                s=s.toUpperCase().substring(0, 1);
////            }
//            hexStr+=s;
//        }
//
//        char[] hexs = hexStr.toCharArray();//toCharArray() 方法将字符串转换为字符数组。
//        int length = (hexStr.length() / 2);//1个byte数值 -> 两个16进制字符
//        byte[] bytes = new byte[length];
//        int n;
//        for (int i = 0; i < bytes.length; i++) {
//            int position = i * 2;//两个16进制字符 -> 1个byte数值
//            n = str.indexOf(hexs[position]) * 16;
//            n += str.indexOf(hexs[position + 1]);
//            // 保持二进制补码的一致性 因为byte类型字符是8bit的  而int为32bit 会自动补齐高位1  所以与上0xFF之后可以保持高位一致性
//            //当byte要转化为int的时候，高的24位必然会补1，这样，其二进制补码其实已经不一致了，&0xff可以将高的24位置为0，低8位保持原样，这样做的目的就是为了保证二进制数据的一致性。
//            bytes[i] = (byte) (n & 0xff);
//        }
//        String name = "";
//        try {
//            name = new String(bytes,"UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return name;
//    }
}
