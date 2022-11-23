package recipeMain;

import recipe.Recipe;

import java.util.List;

import static recipe.GetRecipe.getRecipe;
import static thread.InsertRecipeByThread.threadInsertRecipe;


public class main {

    public static void main(String args[]) throws Exception {
        Long begin = System.currentTimeMillis();
        try {
            List<Recipe> recipes = getRecipe();
            System.out.print("RECIPE数据处理成功...\n");
//            List<Map<String, String>> mapList = recipes.get(5).getRecipeList();
////            for(int i =0;i<mapList.size();i++){
////                System.out.print(mapList.get(i)+"\n");
////            }
//            postRecipe(recipes);
            threadInsertRecipe(recipes);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        Long end = System.currentTimeMillis();

        System.out.println("结束,共计耗时"+(end - begin)/1000+"s");
    }
}
