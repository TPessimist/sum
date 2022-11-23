package ame.psb.db;

import java.util.ArrayList;
import java.util.List;

public class pmsPlanChangeQueryResult {

  public final List<PmsPlanChange> editable;

  public final List<PmsPlanChange> online;

  public pmsPlanChangeQueryResult() {
    this.editable = new ArrayList<PmsPlanChange>();
    this.online = new ArrayList<PmsPlanChange>();
  }

}
