package ame.psb.db;

import java.util.List;
import java.util.Map;

public class ViewBinMapRule extends BinMapRule {

  private List<BinMapInvalidDieDef> invalidDieDefs;

  private List<BinMapGoodDieDef> goodDieDefs;

  private List<BinMapBadDieDef> badDieDefs;

  private List<BinMapAlignmentDieDef> alignmentDieDefs;

  private List<BinMapInkRuleDef> inkRuleDefs;

  private List<BinMapAreaReplaceDef> areaReplaceDefs;

  private Map<String, String> bySfcInkMap;

  private List<ShiftAlignmentDieDef> shiftAlignmentDieDefs;

  public List<BinMapInvalidDieDef> getInvalidDieDefs() {
    return this.invalidDieDefs;
  }

  public void setInvalidDieDefs(List<BinMapInvalidDieDef> invalidDieDefs) {
    this.invalidDieDefs = invalidDieDefs;
  }

  public List<BinMapGoodDieDef> getGoodDieDefs() {
    return this.goodDieDefs;
  }

  public void setGoodDieDefs(List<BinMapGoodDieDef> goodDieDefs) {
    this.goodDieDefs = goodDieDefs;
  }

  public List<BinMapBadDieDef> getBadDieDefs() {
    return this.badDieDefs;
  }

  public void setBadDieDefs(List<BinMapBadDieDef> badDieDefs) {
    this.badDieDefs = badDieDefs;
  }

  public List<BinMapAlignmentDieDef> getAlignmentDieDefs() {
    return this.alignmentDieDefs;
  }

  public void setAlignmentDieDefs(List<BinMapAlignmentDieDef> alignmentDieDefs) {
    this.alignmentDieDefs = alignmentDieDefs;
  }

  public List<BinMapInkRuleDef> getInkRuleDefs() {
    return inkRuleDefs;
  }

  public void setInkRuleDefs(List<BinMapInkRuleDef> inkRuleDefs) {
    this.inkRuleDefs = inkRuleDefs;
  }

  public List<BinMapAreaReplaceDef> getAreaReplaceDefs() {
    return areaReplaceDefs;
  }

  public void setAreaReplaceDefs(List<BinMapAreaReplaceDef> areaReplaceDefs) {
    this.areaReplaceDefs = areaReplaceDefs;
  }

  public List<ShiftAlignmentDieDef> getShiftAlignmentDieDefs() {
    return shiftAlignmentDieDefs;
  }

  public void setShiftAlignmentDieDefs(List<ShiftAlignmentDieDef> shiftAlignmentDieDefs) {
    this.shiftAlignmentDieDefs = shiftAlignmentDieDefs;
  }

  public Map<String, String> getBySfcInkMap() {
    return bySfcInkMap;
  }

  public void setBySfcInkMap(Map<String, String> bySfcInkMap) {
    this.bySfcInkMap = bySfcInkMap;
  }
}
