package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class IssueRecipeBoard {

    private String uuid;

    private String issueRecipeId;

    private String slotType;

    private String slotNo;

    private String boardName;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public IssueRecipeBoard() {
    }	

    public IssueRecipeBoard(IssueRecipeBoard data) {
        this.uuid = data.uuid;
        this.issueRecipeId = data.issueRecipeId;
        this.slotType = data.slotType;
        this.slotNo = data.slotNo;
        this.boardName = data.boardName;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public IssueRecipeBoard clone() {
    	return new IssueRecipeBoard(this);
    }

    @Override
    public String toString() {
        return this.uuid;
    }
}
