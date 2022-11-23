package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class ResourceMaterialLife {

    private String resourceBo;

    private String itemBo;

    private BigDecimal lifeTime;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;


    public ResourceMaterialLife() {
    }	

    public ResourceMaterialLife(ResourceMaterialLife data) {
        this.resourceBo = data.resourceBo;
        this.itemBo = data.itemBo;
        this.lifeTime = data.lifeTime;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	


    @Override
    public ResourceMaterialLife clone() {
    	return new ResourceMaterialLife(this);
    }

    @Override
    public String toString() {
        return this.resourceBo + ", " + this.itemBo;
    }
}
