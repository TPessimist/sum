package dataProcessing;

import java.util.*;

/**
 * 处理常规recipe
 * author 沈宇
 * version 1.0
 */
public class SyRegularRecipeUtils {
    public static List<Map<String, String>> killRegularRecipe(String recipeString) throws Exception {
        try {
            List<Map<String, String>> recipeMapList = new ArrayList<>();
            //去掉空格并分割
            if (recipeString != null) {
                List<String> afterString = Arrays.asList(recipeString.replaceAll(" ", "").replace("\r","").split("\\n"));
                //再次分割获取属性与值并存放至map中
                for (int i = 0; i < afterString.size(); i++) {
                    List<String> single = Arrays.asList(afterString.get(i).split("="));
                    Map<String, String> map = new HashMap<>();
                    if (single.size() == 2) {
                        map.put(single.get(0), single.get(1));
                        recipeMapList.add(map);
                    } else {
                        map.put(single.get(0), "");
                    }
                }
                return recipeMapList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
