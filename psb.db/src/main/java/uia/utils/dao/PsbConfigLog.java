package uia.utils.dao;

public class PsbConfigLog<T> {

  public String action;

  public T value;

  public PsbConfigLog(String action, T value) {
    this.action = action;
    this.value = value;
  }
}
