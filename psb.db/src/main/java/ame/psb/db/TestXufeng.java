package ame.psb.db;

public class TestXufeng {

  private String id;

  private String name;

  private String testColumn1;

  private String testColumn2;

  private String response;

  private String request;


  public TestXufeng() {
  }

  public TestXufeng(TestXufeng data) {
    this.id = data.id;
    this.name = data.name;
    this.testColumn1 = data.testColumn1;
    this.testColumn2 = data.testColumn2;
    this.response = data.response;
    this.request = data.request;
  }

  @Override
  public TestXufeng clone() {
    return new TestXufeng(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTestColumn1() {
    return testColumn1;
  }

  public void setTestColumn1(String testColumn1) {
    this.testColumn1 = testColumn1;
  }

  public String getTestColumn2() {
    return testColumn2;
  }

  public void setTestColumn2(String testColumn2) {
    this.testColumn2 = testColumn2;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }
}
