package ame.psb.db;

public class ResourceTypeResource {

  private String handle;

  private String resourceTypeBo;

  private String resourceBo;


  public ResourceTypeResource() {
  }

  public ResourceTypeResource(ResourceTypeResource data) {
    this.handle = data.handle;
    this.resourceTypeBo = data.resourceTypeBo;
    this.resourceBo = data.resourceBo;
  }

  @Override
  public ResourceTypeResource clone() {
    return new ResourceTypeResource(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getResourceTypeBo() {
    return resourceTypeBo;
  }

  public void setResourceTypeBo(String resourceTypeBo) {
    this.resourceTypeBo = resourceTypeBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }


}
