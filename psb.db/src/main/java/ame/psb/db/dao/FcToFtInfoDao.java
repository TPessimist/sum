package ame.psb.db.dao;

import ame.psb.db.FcToFtInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FcToFtInfoDao {

  private static final String SQL_INS = "INSERT INTO zd_fc_to_ft_info(batch_id,state,shop_order_bo,criteria,result,reverse_field1,reverse_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_fc_to_ft_info SET state=?,shop_order_bo=?,criteria=?,result=?,reverse_field1=?,reverse_field2=?,updated_user=?,updated_time=? WHERE batch_id=?";

  private static final String SQL_SEL = "SELECT batch_id,state,shop_order_bo,criteria,result,reverse_field1,reverse_field2,updated_user,updated_time FROM zd_fc_to_ft_info ";

  private static final String SQL_SEL_TOP1 = "SELECT  top 1 batch_id,state,shop_order_bo,criteria,result,reverse_field1,reverse_field2,updated_user,updated_time FROM zd_fc_to_ft_info ";

  private final Connection conn;

  public FcToFtInfoDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FcToFtInfo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getBatchId());
      ps.setString(2, data.getState());
      ps.setString(3, data.getShopOrderBo());
      ps.setString(4, data.getCriteria());
      ps.setString(5, data.getResult());
      ps.setString(6, data.getReverseField1());
      ps.setString(7, data.getReverseField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<FcToFtInfo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FcToFtInfo data : dataList) {
        ps.setString(1, data.getBatchId());
        ps.setString(2, data.getState());
        ps.setString(3, data.getShopOrderBo());
        ps.setString(4, data.getCriteria());
        ps.setString(5, data.getResult());
        ps.setString(6, data.getReverseField1());
        ps.setString(7, data.getReverseField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FcToFtInfo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getState());
      ps.setString(2, data.getShopOrderBo());
      ps.setString(3, data.getCriteria());
      ps.setString(4, data.getResult());
      ps.setString(5, data.getReverseField1());
      ps.setString(6, data.getReverseField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getBatchId());

      return ps.executeUpdate();
    }
  }

  public int update(List<FcToFtInfo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FcToFtInfo data : dataList) {
        ps.setString(1, data.getState());
        ps.setString(2, data.getShopOrderBo());
        ps.setString(3, data.getCriteria());
        ps.setString(4, data.getResult());
        ps.setString(5, data.getReverseField1());
        ps.setString(6, data.getReverseField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getBatchId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String batchId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_fc_to_ft_info WHERE batch_id=?")) {
      ps.setString(1, batchId);

      return ps.executeUpdate();
    }
  }

  public List<FcToFtInfo> selectAll() throws SQLException {
    ArrayList<FcToFtInfo> result = new ArrayList<FcToFtInfo>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public FcToFtInfo selectByState(String state) throws SQLException {
    FcToFtInfo result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_TOP1 + "WHERE state =? order by updated_time asc")) {
      ps.setString(1, state);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public FcToFtInfo selectByPK(String batchId) throws SQLException {
    FcToFtInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE batch_id=?")) {
      ps.setString(1, batchId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private FcToFtInfo convert(ResultSet rs) throws SQLException {
    FcToFtInfo data = new FcToFtInfo();

    int index = 1;
    data.setBatchId(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setCriteria(rs.getString(index++));
    data.setResult(rs.getString(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
