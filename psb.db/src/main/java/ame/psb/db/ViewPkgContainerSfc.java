package ame.psb.db;

import java.util.Date;

public class ViewPkgContainerSfc extends PkgContainerSfc implements
    Comparable<ViewPkgContainerSfc> {

  private String itemBo;

  private String itemGroupBo;

  private String operationBo;

  private String itemLevel;

  private String packingPlanBo;

  private String containerGoodBad;

  private String containerType;

  private Date createdTime;

  public ViewPkgContainerSfc() {
  }

  public ViewPkgContainerSfc(ViewPkgContainerSfc data) {
    super(data);
    this.itemBo = data.itemBo;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.itemLevel = data.itemLevel;
    this.packingPlanBo = data.packingPlanBo;
    this.containerGoodBad = data.containerGoodBad;
    this.containerType = data.containerType;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getItemLevel() {
    return this.itemLevel;
  }

  public void setItemLevel(String itemLevel) {
    this.itemLevel = itemLevel;
  }

  public String getPackingPlanBo() {
    return this.packingPlanBo;
  }

  public void setPackingPlanBo(String packingPlanBo) {
    this.packingPlanBo = packingPlanBo;
  }

  public String getContainerGoodBad() {
    return this.containerGoodBad;
  }

  public void setContainerGoodBad(String containerGoodBad) {
    this.containerGoodBad = containerGoodBad;
  }

  public String getContainerType() {
    return this.containerType;
  }

  public void setContainerType(String containerType) {
    this.containerType = containerType;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  @Override
  public int compareTo(ViewPkgContainerSfc o) {
    // TODO Auto-generated method stub

    if (null == o.getCreatedTime() || null == getCreatedTime()) {
      return -1;
    }

    return o.getCreatedTime().compareTo(getCreatedTime()) * -1;

//		if(null != o.getCreatedTime() && null != getCreatedTime() )
//		{
//			if(o.getCreatedTime() == getCreatedTime() ) {
//				return 0;
//			}
//			
//			return o.getCreatedTime().before(getCreatedTime()) ? 1 : -1; 
//		}
//		else {
//			return 0;
//		}
//		
  }


}
