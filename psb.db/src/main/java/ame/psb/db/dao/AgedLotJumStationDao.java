package ame.psb.db.dao;

import ame.psb.db.AgedLotJumStation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class AgedLotJumStationDao {

  private static final String SQL_INS = "INSERT INTO zr_cp_aged_lot_jump_station(request_id,sfc_bo,sfc_name,carrier_bo,carrier_name,begin_operation,end_operation,customer,department,hold_code,holde_comment,status,message,action_content,update_user,update_time,reverse1,reverse2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_cp_aged_lot_jump_station SET sfc_bo=?,sfc_name=?,carrier_bo=?,carrier_name=?,begin_operation=?,end_operation=?,customer=?,department=?,hold_code=?,holde_comment=?,status=?,message=?,action_content=?,update_user=?,update_time=?,reverse1=?,reverse2=? WHERE request_id=?";

  private static final String SQL_SEL = "SELECT request_id,sfc_bo,sfc_name,carrier_bo,carrier_name,begin_operation,end_operation,customer,department,hold_code,holde_comment,status,message,action_content,update_user,update_time,reverse1,reverse2 FROM zr_cp_aged_lot_jump_station ";

  private final Connection conn;

  public AgedLotJumStationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(AgedLotJumStation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getRequestId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getSfcName());
      ps.setString(4, data.getCarrierBo());
      ps.setString(5, data.getCarrierName());
      ps.setString(6, data.getBeginOperation());
      ps.setString(7, data.getEndOperation());
      ps.setString(8, data.getCustomer());
      ps.setString(9, data.getDepartment());
      ps.setString(10, data.getHoldCode());
      ps.setString(11, data.getHoldeComment());
      ps.setString(12, data.getStatus());
      ps.setString(13, data.getMessage());
      ps.setString(14, data.getActionContent());
      ps.setString(15, data.getUpdateUser());
      DateUtils.setDateTz(ps, 16, data.getUpdateTime());
      ps.setString(17, data.getReverse1());
      ps.setString(18, data.getReverse2());

      return ps.executeUpdate();
    }
  }

  public int insert(List<AgedLotJumStation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (AgedLotJumStation data : dataList) {
        ps.setString(1, data.getRequestId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getSfcName());
        ps.setString(4, data.getCarrierBo());
        ps.setString(5, data.getCarrierName());
        ps.setString(6, data.getBeginOperation());
        ps.setString(7, data.getEndOperation());
        ps.setString(8, data.getCustomer());
        ps.setString(9, data.getDepartment());
        ps.setString(10, data.getHoldCode());
        ps.setString(11, data.getHoldeComment());
        ps.setString(12, data.getStatus());
        ps.setString(13, data.getMessage());
        ps.setString(14, data.getActionContent());
        ps.setString(15, data.getUpdateUser());
        DateUtils.setDateTz(ps, 16, data.getUpdateTime());
        ps.setString(17, data.getReverse1());
        ps.setString(18, data.getReverse2());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(AgedLotJumStation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getSfcName());
      ps.setString(3, data.getCarrierBo());
      ps.setString(4, data.getCarrierName());
      ps.setString(5, data.getBeginOperation());
      ps.setString(6, data.getEndOperation());
      ps.setString(7, data.getCustomer());
      ps.setString(8, data.getDepartment());
      ps.setString(9, data.getHoldCode());
      ps.setString(10, data.getHoldeComment());
      ps.setString(11, data.getStatus());
      ps.setString(12, data.getMessage());
      ps.setString(13, data.getActionContent());
      ps.setString(14, data.getUpdateUser());
      DateUtils.setDateTz(ps, 15, data.getUpdateTime());
      ps.setString(16, data.getReverse1());
      ps.setString(17, data.getReverse2());
      ps.setString(18, data.getRequestId());

      return ps.executeUpdate();
    }
  }

  public int update(List<AgedLotJumStation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (AgedLotJumStation data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getSfcName());
        ps.setString(3, data.getCarrierBo());
        ps.setString(4, data.getCarrierName());
        ps.setString(5, data.getBeginOperation());
        ps.setString(6, data.getEndOperation());
        ps.setString(7, data.getCustomer());
        ps.setString(8, data.getDepartment());
        ps.setString(9, data.getHoldCode());
        ps.setString(10, data.getHoldeComment());
        ps.setString(11, data.getStatus());
        ps.setString(12, data.getMessage());
        ps.setString(13, data.getActionContent());
        ps.setString(14, data.getUpdateUser());
        DateUtils.setDateTz(ps, 15, data.getUpdateTime());
        ps.setString(16, data.getReverse1());
        ps.setString(17, data.getReverse2());
        ps.setString(18, data.getRequestId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String requestId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_cp_aged_lot_jump_station WHERE request_id=?")) {
      ps.setString(1, requestId);

      return ps.executeUpdate();
    }
  }

  public List<AgedLotJumStation> selectAll() throws SQLException {
    ArrayList<AgedLotJumStation> result = new ArrayList<AgedLotJumStation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public AgedLotJumStation selectByPK(String requestId) throws SQLException {
    AgedLotJumStation result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE request_id=?")) {
      ps.setString(1, requestId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public AgedLotJumStation selectBySfcAndStatus(String sfcBo, String status) throws SQLException {
    AgedLotJumStation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? AND status=? ")) {
      ps.setString(1, sfcBo);
      ps.setString(2, status);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private AgedLotJumStation convert(ResultSet rs) throws SQLException {
    AgedLotJumStation data = new AgedLotJumStation();

    int index = 1;
    data.setRequestId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setSfcName(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setCarrierName(rs.getString(index++));
    data.setBeginOperation(rs.getString(index++));
    data.setEndOperation(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setDepartment(rs.getString(index++));
    data.setHoldCode(rs.getString(index++));
    data.setHoldeComment(rs.getString(index++));
    data.setStatus(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setActionContent(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setReverse1(rs.getString(index++));
    data.setReverse2(rs.getString(index++));

    return data;
  }
}
