package ame.psb.db.dao;

import ame.psb.db.AutoInstock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class AutoInstockDao {

  private static final String SQL_INS = "INSERT INTO zd_auto_instock(item_group_bo,item_group_name,operation_bo,operation_name,flag,content,value,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_auto_instock SET item_group_name=?,operation_name=?,flag=?,content=?,value=?,updated_user=?,updated_time=? WHERE item_group_bo=? AND operation_bo=?";

  private static final String SQL_SEL = "SELECT item_group_bo,item_group_name,operation_bo,operation_name,flag,content,value,updated_user,updated_time FROM zd_auto_instock ";

  private final Connection conn;

  public AutoInstockDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(AutoInstock data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getItemGroupName());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getOperationName());
      ps.setString(5, data.getFlag());
      ps.setString(6, data.getContent());
      ps.setString(7, data.getValue());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<AutoInstock> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (AutoInstock data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getItemGroupName());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getOperationName());
        ps.setString(5, data.getFlag());
        ps.setString(6, data.getContent());
        ps.setString(7, data.getValue());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(AutoInstock data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupName());
      ps.setString(2, data.getOperationName());
      ps.setString(3, data.getFlag());
      ps.setString(4, data.getContent());
      ps.setString(5, data.getValue());
      ps.setString(6, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
      ps.setString(8, data.getItemGroupBo());
      ps.setString(9, data.getOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<AutoInstock> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (AutoInstock data : dataList) {
        ps.setString(1, data.getItemGroupName());
        ps.setString(2, data.getOperationName());
        ps.setString(3, data.getFlag());
        ps.setString(4, data.getContent());
        ps.setString(5, data.getValue());
        ps.setString(6, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 7, data.getUpdatedTime());
        ps.setString(8, data.getItemGroupBo());
        ps.setString(9, data.getOperationBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String operationBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_auto_instock WHERE item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      return ps.executeUpdate();
    }
  }

  public List<AutoInstock> selectAll() throws SQLException {
    ArrayList<AutoInstock> result = new ArrayList<AutoInstock>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public AutoInstock selectByPK(String itemGroupBo, String operationBo) throws SQLException {
    AutoInstock result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private AutoInstock convert(ResultSet rs) throws SQLException {
    AutoInstock data = new AutoInstock();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setItemGroupName(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
