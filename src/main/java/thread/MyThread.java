package thread;

import recipe.PostRecipe;
import recipe.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import static recipe.PostRecipe.postRecipe;

/**
 * 线程类
 */
public class MyThread implements Runnable {

    private List<Recipe> recipes;
    private Integer i;
    private CountDownLatch latch;
    private Connection conn;

    public MyThread(List<Recipe> recipes, CountDownLatch latch, Integer i,Connection conn){

        this.recipes = recipes;
        this.i = i;
        this.latch = latch;
        this.conn = conn;

    }


    @Override
    public void run(){

        String prefix = "INSERT INTO recipe_test (RECIPE_ID, PARENT_ID, EQUPIMENT_ID,RECIPE_NAME, KEY_NAME,VALUE,ISXML) VALUES ";
        System.out.println("正在处理即将传入数据库的数据...\n");

        System.out.println("线程" + i + "开始执行，当前数据大小：" + recipes.size());

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

//            postRecipe(recipes,conn);
            System.out.println("线程" + i + "开始执行，数据条数：" + recipes.size());


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            latch.countDown();
        }
    }
}
