package ame.me.db;

import java.math.BigDecimal;

public class NcDisposalRouter {

  private String handle;

  private String ncCodeDefBo;

  private String routerOrGroupGbo;

  private BigDecimal sequence;

  public NcDisposalRouter() {
  }

  public NcDisposalRouter(NcDisposalRouter data) {
    this.handle = data.handle;
    this.ncCodeDefBo = data.ncCodeDefBo;
    this.routerOrGroupGbo = data.routerOrGroupGbo;
    this.sequence = data.sequence;
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getNcCodeDefBo() {
    return this.ncCodeDefBo;
  }

  public void setNcCodeDefBo(String ncCodeDefBo) {
    this.ncCodeDefBo = ncCodeDefBo;
  }

  public String getRouterOrGroupGbo() {
    return this.routerOrGroupGbo;
  }

  public void setRouterOrGroupGbo(String routerOrGroupGbo) {
    this.routerOrGroupGbo = routerOrGroupGbo;
  }

  public BigDecimal getSequence() {
    return this.sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  @Override
  public NcDisposalRouter clone() {
    return new NcDisposalRouter(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}