package ame.psb.db;

import ame.htks.db.ViewTool;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class ViewOperationTool extends ViewTool {

    private String operationBo;



    public ViewOperationTool() {
    }	

    public ViewOperationTool(ViewOperationTool data) {
        this.operationBo = data.operationBo;

    }	

    @Override
    public ViewOperationTool clone() {
    	return new ViewOperationTool(this);
    }

}
