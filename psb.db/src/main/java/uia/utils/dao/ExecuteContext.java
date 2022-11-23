package uia.utils.dao;

import java.sql.Connection;

public class ExecuteContext {

  public Connection conn;

  public String user;


  public ExecuteContext(String user, Connection conn) {
    this.conn = conn;
    this.user = user;
  }
}
