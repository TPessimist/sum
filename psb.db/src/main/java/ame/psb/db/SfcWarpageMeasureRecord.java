package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class SfcWarpageMeasureRecord {

    private String sfcBo;

    private BigDecimal measureData1;

    private BigDecimal measureData2;

    private BigDecimal measureData3;

    private BigDecimal measureData4;

    private BigDecimal measureData5;

    private String reserveField1;

    private String reserveField2;

    private String updatedUser;

    private Date updatedTime;


    public SfcWarpageMeasureRecord() {
    }	

    public SfcWarpageMeasureRecord(SfcWarpageMeasureRecord data) {
        this.sfcBo = data.sfcBo;
        this.measureData1 = data.measureData1;
        this.measureData2 = data.measureData2;
        this.measureData3 = data.measureData3;
        this.measureData4 = data.measureData4;
        this.measureData5 = data.measureData5;
        this.reserveField1 = data.reserveField1;
        this.reserveField2 = data.reserveField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public SfcWarpageMeasureRecord clone() {
    	return new SfcWarpageMeasureRecord(this);
    }

    @Override
    public String toString() {
        return this.sfcBo;
    }
}
