package ame.psb.db.dao;

import ame.psb.db.McsLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class McsLayoutDao {

  private static final String SQL_INS = "INSERT INTO zd_mcs_layout(resource_bo,next_resource_bo,bay_bo,comment,updated_user,updated_time) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_mcs_layout SET next_resource_bo=?,comment=?,updated_user=?,updated_time=? WHERE resource_bo=? AND bay_bo=?";

  private static final String SQL_SEL = "SELECT resource_bo,next_resource_bo,bay_bo,comment,updated_user,updated_time FROM zd_mcs_layout ";

  private static final String SQL_SEL2 = "SELECT DISTINCT BAY_BO FROM zd_mcs_layout ";

  private static final String SQL_SEL_CENTRALBAY = "SELECT DISTINCT BAY_BO,LENGTH(BAY_BO) FROM ZD_MCS_LAYOUT ";


  private final Connection conn;

  public McsLayoutDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(McsLayout data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getNextResourceBo());
      ps.setString(3, data.getBayBo());
      ps.setString(4, data.getComment());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<McsLayout> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (McsLayout data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getNextResourceBo());
        ps.setString(3, data.getBayBo());
        ps.setString(4, data.getComment());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(McsLayout data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getNextResourceBo());
      ps.setString(2, data.getComment());
      ps.setString(3, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
      ps.setString(5, data.getResourceBo());
      ps.setString(6, data.getBayBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<McsLayout> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (McsLayout data : dataList) {
        ps.setString(1, data.getNextResourceBo());
        ps.setString(2, data.getComment());
        ps.setString(3, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 4, data.getUpdatedTime());
        ps.setString(5, data.getResourceBo());
        ps.setString(6, data.getBayBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String resourceBo, String bayBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_mcs_layout WHERE resource_bo=? AND bay_bo=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, bayBo);

      return ps.executeUpdate();
    }
  }

  public List<McsLayout> selectAll() throws SQLException {
    ArrayList<McsLayout> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<String> selectAllCentralBay() throws SQLException {
    ArrayList<String> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_CENTRALBAY + "WHERE LENGTH(BAY_BO) < 22")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString(1));
      }
      return result;
    }
  }

  public List<McsLayout> selectByResourceBo(String resourceBo) throws SQLException {
    List<McsLayout> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resource_bo=? ")) {
      ps.setString(1, resourceBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<McsLayout> selectByBayBo(String BayBo) throws SQLException {
    ArrayList<McsLayout> result = new ArrayList<McsLayout>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE BAY_BO = ? order by updated_time ")) {
      ps.setString(1, BayBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<McsLayout> selectAllBayBo() throws SQLException {
    ArrayList<McsLayout> result = new ArrayList<McsLayout>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL2)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert2(rs));
      }
      return result;
    }
  }

  public McsLayout selectByPK(String resourceBo, String bayBo) throws SQLException {
    McsLayout result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND bay_bo=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, bayBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public McsLayout selectByPK2(String resourceBo, String nextResourceBo, String bayBo)
      throws SQLException {
    McsLayout result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE resource_bo=? AND next_resource_bo =? AND bay_bo=?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, nextResourceBo);
      ps.setString(3, bayBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  //查询连续资源
  public List<McsLayout> selectByBayBoAndNextResource(String BayBo) throws SQLException {
    ArrayList<McsLayout> result = new ArrayList<McsLayout>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE BAY_BO = ? and next_resource_bo !='NULL' ")) {
      ps.setString(1, BayBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  //查询孤岛资源
  public List<McsLayout> selectByBayBoAndNextResource2(String BayBo) throws SQLException {
    ArrayList<McsLayout> result = new ArrayList<McsLayout>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE BAY_BO = ? and next_resource_bo ='NULL' ")) {
      ps.setString(1, BayBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public McsLayout selectByCurrentResourceAndOtherBay(String resourceBo, String bayBo)
      throws SQLException {
    McsLayout result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE resource_bo=? AND bay_bo != ?")) {
      ps.setString(1, resourceBo);
      ps.setString(2, bayBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }


  private McsLayout convert(ResultSet rs) throws SQLException {
    McsLayout data = new McsLayout();

    int index = 1;
    data.setResourceBo(rs.getString(index++));
    data.setNextResourceBo(rs.getString(index++));
    data.setBayBo(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }

  private McsLayout convert2(ResultSet rs) throws SQLException {
    McsLayout data = new McsLayout();

    int index = 1;
    data.setBayBo(rs.getString(index++));

    return data;
  }
}
