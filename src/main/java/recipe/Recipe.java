package recipe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Recipe implements Cloneable {
    private BigDecimal id;
    private String equpimentId;
    private BigDecimal parentId;
    private String recipeName;
    private int[] temp = null;
    private static Recipe recipe = new Recipe();
    private List<Map<String,String>> recipeList = new ArrayList<>();
    private String isXml = "no";

    public static Recipe getOneRecipeWithRegularData(BigDecimal id,String equpimentId, BigDecimal parentId, String recipeName, List<Map<String,String>> recipeList){
        try {
            Recipe temRecipe = (Recipe) recipe.clone();
            temRecipe.id = id;
            temRecipe.equpimentId =equpimentId;
            temRecipe.parentId = parentId;
            temRecipe.recipeName = recipeName;
            temRecipe.recipeList = recipeList;
            return temRecipe;
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
    //克隆xml格式recipe并标记
    public static Recipe getOneRecipeWithXmlData(BigDecimal id,String equpimentId, BigDecimal parentId, String recipeName, List<Map<String,String>> recipeList){
        try {
            Recipe temRecipe = (Recipe) recipe.clone();
            temRecipe.id = id;
            temRecipe.equpimentId =equpimentId;
            temRecipe.parentId = parentId;
            temRecipe.recipeName = recipeName;
            temRecipe.recipeList = recipeList;
            temRecipe.isXml = "yes";
            return temRecipe;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Recipe getOneRecipe() {
        try {
            return (Recipe) recipe.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Recipe(){

    }

    public int[] getTemp() {
        return this.temp;
    }

    public void setTemp(int[] temp) {
        this.temp = temp;
    }

    public BigDecimal getId() {
        return this.id;
    }

    public String getEqupimentId(){
        return this.equpimentId;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public BigDecimal getParentId() {
        return this.parentId;
    }

    public List<Map<String, String>> getRecipeList() {
        return this.recipeList;
    }

    public String isXml(){
        return this.isXml;
    }

}
