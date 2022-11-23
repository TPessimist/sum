package ame.psb.db;

//import java.util.Date;

public class LPType {

  private String PrinterNameID;

  private String BartenderName;

  private String Content;

  private String Content2;

  private String Content3;

  private String Flag;

  private String EVENTSOURCE;

  private String EVENTID;

  private String LABELID;

  private String PRINTQTY;

  /*
   * <CONTAINER_ID> <CONTAINER_NAME> <PRINT_TIME> <PRINT_QTY> <LABEL_ID>
   */
  public LPType() {
  }

  public LPType(LPType data) {
    this.PrinterNameID = data.PrinterNameID;
    this.BartenderName = data.BartenderName;
    this.Content = data.Content;
    this.Content2 = data.Content2;
    this.Content3 = data.Content3;
    this.Flag = data.Flag;
    this.EVENTSOURCE = data.EVENTSOURCE;
    this.EVENTID = data.EVENTID;
    this.PRINTQTY = data.PRINTQTY;
  }

  public String getPrinterNameID() {
    return PrinterNameID;
  }

  public void setPrinterNameID(String printerNameID) {
    PrinterNameID = printerNameID;
  }

  public String getBartenderName() {
    return BartenderName;
  }

  public void setBartenderName(String bartenderName) {
    BartenderName = bartenderName;
  }

  public String getContent() {
    return Content;
  }

  public void setContent(String content) {
    Content = content;
  }

  public String getContent2() {
    return Content2;
  }

  public void setContent2(String content2) {
    Content2 = content2;
  }

  public String getContent3() {
    return Content3;
  }

  public void setContent3(String content3) {
    Content3 = content3;
  }

  public String getFlag() {
    return Flag;
  }

  public void setFlag(String flag) {
    Flag = flag;
  }

  public String getEVENTSOURCE() {
    return EVENTSOURCE;
  }

  public void setEVENTSOURCE(String eVENTSOURCE) {
    EVENTSOURCE = eVENTSOURCE;
  }

  public String getEVENTID() {
    return EVENTID;
  }

  public void setEVENTID(String eVENTID) {
    EVENTID = eVENTID;
  }

  public String getPRINTQTY() {
    return PRINTQTY;
  }

  public void setPRINTQTY(String pRINTQTY) {
    PRINTQTY = pRINTQTY;
  }

  public String getLABELID() {
    return LABELID;
  }

  public void setLABELID(String lABELID) {
    LABELID = lABELID;
  }

}