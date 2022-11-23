package ame.psb.db.dao;

import ame.psb.db.CustDeviceCt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustDeviceCtDao {

  private static final String SQL_INS = "INSERT INTO zm_custdevice_ct(cust_device,process,htks_ct,fixed,special,create_by,create_date) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zm_custdevice_ct SET process=?,htks_ct=?,fixed=?,special=?,create_by=?,create_date=? WHERE cust_device=?";

  private static final String SQL_SEL = "SELECT cust_device,process,htks_ct,fixed,special,create_by,create_date FROM zm_custdevice_ct ";

  private final Connection conn;

  public CustDeviceCtDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(CustDeviceCt data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getCustDevice());
      ps.setString(2, data.getProcess());
      ps.setString(3, data.getHtksCt());
      ps.setString(4, data.getFixed());
      ps.setString(5, data.getSpecial());
      ps.setString(6, data.getCreateBy());
      ps.setString(7, data.getCreateDate());

      return ps.executeUpdate();
    }
  }

  public int insert(List<CustDeviceCt> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (CustDeviceCt data : dataList) {
        ps.setString(1, data.getCustDevice());
        ps.setString(2, data.getProcess());
        ps.setString(3, data.getHtksCt());
        ps.setString(4, data.getFixed());
        ps.setString(5, data.getSpecial());
        ps.setString(6, data.getCreateBy());
        ps.setString(7, data.getCreateDate());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(CustDeviceCt data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getProcess());
      ps.setString(2, data.getHtksCt());
      ps.setString(3, data.getFixed());
      ps.setString(4, data.getSpecial());
      ps.setString(5, data.getCreateBy());
      ps.setString(6, data.getCreateDate());
      ps.setString(7, data.getCustDevice());

      return ps.executeUpdate();
    }
  }

  public int update(List<CustDeviceCt> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (CustDeviceCt data : dataList) {
        ps.setString(1, data.getProcess());
        ps.setString(2, data.getHtksCt());
        ps.setString(3, data.getFixed());
        ps.setString(4, data.getSpecial());
        ps.setString(5, data.getCreateBy());
        ps.setString(6, data.getCreateDate());
        ps.setString(7, data.getCustDevice());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String custDevice) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zm_custdevice_ct WHERE cust_device=?")) {
      ps.setString(1, custDevice);

      return ps.executeUpdate();
    }
  }

  public List<CustDeviceCt> selectAll() throws SQLException {
    ArrayList<CustDeviceCt> result = new ArrayList<CustDeviceCt>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<CustDeviceCt> select23567() throws SQLException {
    ArrayList<CustDeviceCt> result = new ArrayList<CustDeviceCt>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE CREATE_BY = '23567'")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public CustDeviceCt selectByPK(String custDevice) throws SQLException {
    CustDeviceCt result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE cust_device=?")) {
      ps.setString(1, custDevice);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public CustDeviceCt selectByPackage(String custDevice, String size) throws SQLException {
    CustDeviceCt result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE cust_device=? AND process=? AND CREATE_BY = '23567' ")) {
      ps.setString(1, custDevice);
      ps.setString(2, size);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private CustDeviceCt convert(ResultSet rs) throws SQLException {
    CustDeviceCt data = new CustDeviceCt();

    int index = 1;
    data.setCustDevice(rs.getString(index++));
    data.setProcess(rs.getString(index++));
    data.setHtksCt(rs.getString(index++));
    data.setFixed(rs.getString(index++));
    data.setSpecial(rs.getString(index++));
    data.setCreateBy(rs.getString(index++));
    data.setCreateDate(rs.getString(index++));

    return data;
  }
}
