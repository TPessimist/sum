package ame.me.db;

public class resourceCapability {

  private String resource;

  private Boolean eight;

  private Boolean twelve;


  public resourceCapability() {
    super();
    this.eight = false;
    this.twelve = false;
  }

  public resourceCapability(String resource, Boolean eight, Boolean twelve) {
    super();
    this.resource = resource;
    this.eight = eight;
    this.twelve = twelve;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public Boolean getEight() {
    return eight;
  }

  public void setEight(Boolean eight) {
    this.eight = eight;
  }

  public Boolean getTwelve() {
    return twelve;
  }

  public void setTwelve(Boolean twelve) {
    this.twelve = twelve;
  }
	
	
/*
	public String getEight() {
		return eight;
	}

	public void setEight(String eight) {
		this.eight = eight;
	}

	public String getTwelve() {
		return twelve;
	}

	public void setTwelve(String twelve) {
		this.twelve = twelve;
	}
	*/
}
