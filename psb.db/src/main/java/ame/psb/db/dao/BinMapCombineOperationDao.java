package ame.psb.db.dao;

import ame.psb.db.BinMapCombineOperation;
import ame.psb.db.ViewBinMapCombineOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BinMapCombineOperationDao {

  private static final String SQL_INS = "INSERT INTO zr_binmap_combine_operation(id,binmap_combine_bo,operation_bo, file_name) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_binmap_combine_operation SET binmap_combine_bo=?,operation_bo=?,file_name=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,binmap_combine_bo,operation_bo,customer_item_bo,customer_item_name,operation_name,file_name FROM view_binmap_combine_operation ";

  private final Connection conn;

  public BinMapCombineOperationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BinMapCombineOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getBinmapCombineBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getFileName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BinMapCombineOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BinMapCombineOperation data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getBinmapCombineBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getFileName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BinMapCombineOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBinmapCombineBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getFileName());
      ps.setString(4, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BinMapCombineOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BinMapCombineOperation data : dataList) {
        ps.setString(1, data.getBinmapCombineBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getFileName());
        ps.setString(4, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_binmap_combine_operation WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByMaster(String master) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_binmap_combine_operation WHERE binmap_combine_bo=?")) {
      ps.setString(1, master);

      return ps.executeUpdate();
    }
  }

  public List<ViewBinMapCombineOperation> selectAll() throws SQLException {
    ArrayList<ViewBinMapCombineOperation> result = new ArrayList<ViewBinMapCombineOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewBinMapCombineOperation selectByPK(String id) throws SQLException {
    ViewBinMapCombineOperation result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewBinMapCombineOperation selectByPK(String binmapCombineBo, String operationBo)
      throws SQLException {
    ViewBinMapCombineOperation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE binmap_combine_bo=? AND operation_bo=?")) {
      ps.setString(1, binmapCombineBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewBinMapCombineOperation> selectByMaster(String masterBo) throws SQLException {
    ArrayList<ViewBinMapCombineOperation> result = new ArrayList<ViewBinMapCombineOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE binmap_combine_bo=?")) {
      ps.setString(1, masterBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewBinMapCombineOperation convert(ResultSet rs) throws SQLException {
    ViewBinMapCombineOperation data = new ViewBinMapCombineOperation();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setBinmapCombineBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setCustomerItemName(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setFileName(rs.getString(index++));

    return data;
  }
}