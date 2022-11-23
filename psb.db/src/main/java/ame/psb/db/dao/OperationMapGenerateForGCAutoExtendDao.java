package ame.psb.db.dao;

import ame.psb.db.OperationMapGenerateForGCAutoExtend;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperationMapGenerateForGCAutoExtendDao {

  private static final String SQL_INS = "INSERT INTO view_operation_map_generate_for_gc_autoextend(sfc_name,id,container_bo,container_name,content,customer,customer_item_bo,file_name) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE view_operation_map_generate_for_gc_autoextend SET id=?,container_bo=?,container_name=?,content=?,customer=?,customer_item_bo=?,file_name=? WHERE sfc_name=?";

  private static final String SQL_SEL = "SELECT sfc_name,id,container_bo,container_name,content,customer,customer_item_bo,file_name FROM view_operation_map_generate_for_gc_autoextend WHERE CUSTOMER_ITEM_BO LIKE 'UFK84612::1612601616579' ";

  private final Connection conn;

  public OperationMapGenerateForGCAutoExtendDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(OperationMapGenerateForGCAutoExtend data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getSfcName());
      ps.setString(2, data.getId());
      ps.setString(3, data.getContainerBo());
      ps.setString(4, data.getContainerName());
      ps.setString(5, data.getContent());
      ps.setString(6, data.getCustomer());
      ps.setString(7, data.getCustomerItemBo());
      ps.setString(8, data.getFileName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<OperationMapGenerateForGCAutoExtend> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (OperationMapGenerateForGCAutoExtend data : dataList) {
        ps.setString(1, data.getSfcName());
        ps.setString(2, data.getId());
        ps.setString(3, data.getContainerBo());
        ps.setString(4, data.getContainerName());
        ps.setString(5, data.getContent());
        ps.setString(6, data.getCustomer());
        ps.setString(7, data.getCustomerItemBo());
        ps.setString(8, data.getFileName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(OperationMapGenerateForGCAutoExtend data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getContainerBo());
      ps.setString(3, data.getContainerName());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getCustomer());
      ps.setString(6, data.getCustomerItemBo());
      ps.setString(7, data.getFileName());
      ps.setString(8, data.getSfcName());

      return ps.executeUpdate();
    }
  }

  public int update(List<OperationMapGenerateForGCAutoExtend> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (OperationMapGenerateForGCAutoExtend data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getContainerBo());
        ps.setString(3, data.getContainerName());
        ps.setString(4, data.getContent());
        ps.setString(5, data.getCustomer());
        ps.setString(6, data.getCustomerItemBo());
        ps.setString(7, data.getFileName());
        ps.setString(8, data.getSfcName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String sfcName) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM view_operation_map_generate_for_gc_autoextend WHERE sfc_name=?")) {
      ps.setString(1, sfcName);

      return ps.executeUpdate();
    }
  }

  public List<OperationMapGenerateForGCAutoExtend> selectAll() throws SQLException {
    ArrayList<OperationMapGenerateForGCAutoExtend> result = new ArrayList<OperationMapGenerateForGCAutoExtend>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public OperationMapGenerateForGCAutoExtend selectByPK(String sfcName) throws SQLException {
    OperationMapGenerateForGCAutoExtend result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_name=?")) {
      ps.setString(1, sfcName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private OperationMapGenerateForGCAutoExtend convert(ResultSet rs) throws SQLException {
    OperationMapGenerateForGCAutoExtend data = new OperationMapGenerateForGCAutoExtend();

    int index = 1;
    data.setSfcName(rs.getString(index++));
    data.setId(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setFileName(rs.getString(index++));

    return data;
  }
}
