package uia.utils.dao;

import java.util.ArrayList;
import java.util.List;

public class CompareResult {

  public final String tableName;
  private final List<String> messages;
  private boolean passed;

  public CompareResult(String tableName) {
    this.tableName = tableName;
    this.passed = true;
    this.messages = new ArrayList<String>();
  }

  public boolean isPassed() {
    return this.passed;
  }

  public void setPassed(boolean passed) {
    this.passed = passed;
  }

  public void addMessage(String message) {
    this.messages.add(message);
  }

  public List<String> getMessages() {
    return this.messages;
  }

  @Override
  public String toString() {
    return this.tableName + " compare passed:" + this.passed + "\n  " + String
        .join("\n  ", this.messages);
  }
}
