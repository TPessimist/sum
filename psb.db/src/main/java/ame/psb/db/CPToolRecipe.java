package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class CPToolRecipe {

  private String itemGroupBo;

  private String operationBo;

  private String toolNumberBo;

  private String recipeName;

  private String stateName;

  private String updatedUser;

  private Date updatedDateTime;

  private String testModle;

  private String boardId;

  public CPToolRecipe() {
  }

  public CPToolRecipe(CPToolRecipe data) {
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.toolNumberBo = data.toolNumberBo;
    this.recipeName = data.recipeName;
    this.stateName = data.stateName;
    this.updatedUser = data.updatedUser;
    this.updatedDateTime = data.updatedDateTime;
  }

  public boolean isEnabled() {
    return "Y".equals(this.stateName);
  }

  @Override
  public CPToolRecipe clone() {
    return new CPToolRecipe(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.operationBo + ", " + this.toolNumberBo;
  }

}
