package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class TestYkq {

    private String id;

    private String name;

    private String testColumn1;

    private String testColumn2;

    private String testColumn3;

    private String testColumn4;

    private String testColumn5;

    private String testColumn6;

    private String testColumn7;

    private String testColumn8;

    private String testColumn9;

    private String testColumn10;

    private String testColumn11;

    private String testColumn12;


    public TestYkq() {
    }	

    public TestYkq(TestYkq data) {
        this.id = data.id;
        this.name = data.name;
        this.testColumn1 = data.testColumn1;
        this.testColumn2 = data.testColumn2;
        this.testColumn3 = data.testColumn3;
        this.testColumn4 = data.testColumn4;
        this.testColumn5 = data.testColumn5;
        this.testColumn6 = data.testColumn6;
        this.testColumn7 = data.testColumn7;
        this.testColumn8 = data.testColumn8;
        this.testColumn9 = data.testColumn9;
        this.testColumn10 = data.testColumn10;
        this.testColumn11 = data.testColumn11;
        this.testColumn12 = data.testColumn12;
    }	

    @Override
    public TestYkq clone() {
    	return new TestYkq(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
