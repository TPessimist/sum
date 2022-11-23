package ame.psb.db.dao;

import ame.psb.db.FutureActionResource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FutureActionResourceDao {

  private static final String SQL_INS = "INSERT INTO zd_future_action_resource(future_action_bo,resource_bo,recipe_name) VALUES (?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_future_action_resource SET recipe_name=? WHERE future_action_bo=? and resource_bo=?";

  private static final String SQL_SEL = "SELECT future_action_bo,resource_bo,recipe_name FROM zd_future_action_resource ";

  private final Connection conn;

  public FutureActionResourceDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FutureActionResource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getFutureActionBo());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getRecipeName());

      return ps.executeUpdate();
    }
  }

  public int update(FutureActionResource data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getRecipeName());
      ps.setString(2, data.getFutureActionBo());
      ps.setString(3, data.getResourceBo());

      return ps.executeUpdate();
    }
  }

  public int deleteByAction(String futureActionBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_future_action_resource WHERE future_action_bo=?")) {
      ps.setString(1, futureActionBo);
      return ps.executeUpdate();
    }
  }

  public List<FutureActionResource> selectAll() throws SQLException {
    ArrayList<FutureActionResource> result = new ArrayList<FutureActionResource>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FutureActionResource> selectByAction(String futureActionBo) throws SQLException {
    ArrayList<FutureActionResource> result = new ArrayList<FutureActionResource>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE future_action_bo=?")) {
      ps.setString(1, futureActionBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private FutureActionResource convert(ResultSet rs) throws SQLException {
    FutureActionResource data = new FutureActionResource();

    data.setFutureActionBo(rs.getString(1));
    data.setResourceBo(rs.getString(2));
    data.setRecipeName(rs.getString(3));

    return data;
  }
}
