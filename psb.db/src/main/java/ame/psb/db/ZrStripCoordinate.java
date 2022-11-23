package ame.psb.db;

import java.util.Date;

public class ZrStripCoordinate {

    private String stripId;

    private Integer fx;

    private Integer fy;

    private Integer tx;

    private Integer ty;


    public ZrStripCoordinate() {
    }	

    public ZrStripCoordinate(ZrStripCoordinate data) {
        this.stripId = data.stripId;
        this.fx = data.fx;
        this.fy = data.fy;
        this.tx = data.tx;
        this.ty = data.ty;
    }

    public String getStripId() {
		return stripId;
	}

	public void setStripId(String stripId) {
		this.stripId = stripId;
	}

	public Integer getFx() {
		return fx;
	}

	public void setFx(Integer fx) {
		this.fx = fx;
	}

	public Integer getFy() {
		return fy;
	}

	public void setFy(Integer fy) {
		this.fy = fy;
	}

	public Integer getTx() {
		return tx;
	}

	public void setTx(Integer tx) {
		this.tx = tx;
	}

	public Integer getTy() {
		return ty;
	}

	public void setTy(Integer ty) {
		this.ty = ty;
	}

	@Override
    public ZrStripCoordinate clone() {
    	return new ZrStripCoordinate(this);
    }

    @Override
    public String toString() {
        return this.stripId + ", " + this.tx + ", " + this.ty;
    }
}
