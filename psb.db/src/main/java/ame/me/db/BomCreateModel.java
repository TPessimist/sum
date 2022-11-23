package ame.me.db;

import java.util.ArrayList;
import java.util.List;


public class BomCreateModel {

    public String product;

    public List<BomInfo> bomInfoList;

    public BomCreateModel() {
        this.bomInfoList = new ArrayList<>();
    }
}
