package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class RecipeMatrixRecipe {

  private String recipeMatrix;

  private String recipe;

  public String getRecipeMatrix() {
    return this.recipeMatrix;
  }

  public void setRecipeMatrix(String recipeMatrix) {
    this.recipeMatrix = recipeMatrix;
  }

  public String getRecipe() {
    return this.recipe;
  }

  public void setRecipe(String recipe) {
    this.recipe = recipe;
  }

}
