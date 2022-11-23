package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.SWRHandleInfo;
import uia.utils.dao.DateUtils;

public class SWRHandleInfoDao {

  private static final String SQL_INS = "INSERT INTO zr_swr_handle(id,sfc_bo,customer_item_bo,hold_code,operation_bo,item_group_bo,oa_id,oa_status,release_flag,rerl_id,inner_box_id,outer_box_id,reverse_field1,reverse_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_swr_handle SET sfc_bo=?,customer_item_bo=?,hold_code=?,operation_bo=?,item_group_bo=?,oa_id=?,oa_status=?,release_flag=?,rerl_id=?,inner_box_id=?,outer_box_id=?,reverse_field1=?,reverse_field2=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc_bo,customer_item_bo,hold_code,operation_bo,item_group_bo,oa_id,oa_status,release_flag,rerl_id,inner_box_id,outer_box_id,reverse_field1,reverse_field2,updated_user,updated_time FROM zr_swr_handle ";

  private final Connection conn;

  public SWRHandleInfoDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(SWRHandleInfo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getCustomerItemBo());
      ps.setString(4, data.getHoldCode());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getItemGroupBo());
      ps.setString(7, data.getOaId());
      ps.setString(8, data.getOaStatus());
      ps.setString(9, data.getReleaseFlag());
      ps.setString(10, data.getRerlId());
      ps.setString(11, data.getInnerBoxId());
      ps.setString(12, data.getOuterBoxId());
      ps.setString(13, data.getReverseField1());
      ps.setString(14, data.getReverseField2());
      ps.setString(15, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 16, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SWRHandleInfo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SWRHandleInfo data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfcBo());
        ps.setString(3, data.getCustomerItemBo());
        ps.setString(4, data.getHoldCode());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getItemGroupBo());
        ps.setString(7, data.getOaId());
        ps.setString(8, data.getOaStatus());
        ps.setString(9, data.getReleaseFlag());
        ps.setString(10, data.getRerlId());
        ps.setString(11, data.getInnerBoxId());
        ps.setString(12, data.getOuterBoxId());
        ps.setString(13, data.getReverseField1());
        ps.setString(14, data.getReverseField2());
        ps.setString(15, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 16, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SWRHandleInfo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfcBo());
      ps.setString(2, data.getCustomerItemBo());
      ps.setString(3, data.getHoldCode());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getItemGroupBo());
      ps.setString(6, data.getOaId());
      ps.setString(7, data.getOaStatus());
      ps.setString(8, data.getReleaseFlag());
      ps.setString(9, data.getRerlId());
      ps.setString(10, data.getInnerBoxId());
      ps.setString(11, data.getOuterBoxId());
      ps.setString(12, data.getReverseField1());
      ps.setString(13, data.getReverseField2());
      ps.setString(14, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 15, data.getUpdatedTime());
      ps.setString(16, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<SWRHandleInfo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SWRHandleInfo data : dataList) {
        ps.setString(1, data.getSfcBo());
        ps.setString(2, data.getCustomerItemBo());
        ps.setString(3, data.getHoldCode());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getItemGroupBo());
        ps.setString(6, data.getOaId());
        ps.setString(7, data.getOaStatus());
        ps.setString(8, data.getReleaseFlag());
        ps.setString(9, data.getRerlId());
        ps.setString(10, data.getInnerBoxId());
        ps.setString(11, data.getOuterBoxId());
        ps.setString(12, data.getReverseField1());
        ps.setString(13, data.getReverseField2());
        ps.setString(14, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 15, data.getUpdatedTime());
        ps.setString(16, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateOperation(String oaId, String operation) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_swr_handle SET reverse_field2=? WHERE oa_id=?")) {
      ps.setString(1, operation);
      ps.setString(2, oaId);

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_swr_handle WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<SWRHandleInfo> selectAll() throws SQLException {
    ArrayList<SWRHandleInfo> result = new ArrayList<SWRHandleInfo>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SWRHandleInfo> selectByOAId(String oaId) throws SQLException {
    ArrayList<SWRHandleInfo> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where OA_ID = ?")) {
      ps.setString(1, oaId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<SWRHandleInfo> selectBySfcBo(String sfcBo) throws SQLException {
    ArrayList<SWRHandleInfo> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " where SFC_BO = ?")) {
      ps.setString(1, sfcBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public SWRHandleInfo selectByPK(String id) throws SQLException {
    SWRHandleInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public SWRHandleInfo selectByWafer(String waferBo) throws SQLException {
    SWRHandleInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE customer_item_bo=?")) {
      ps.setString(1, waferBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private SWRHandleInfo convert(ResultSet rs) throws SQLException {
    SWRHandleInfo data = new SWRHandleInfo();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setHoldCode(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOaId(rs.getString(index++));
    data.setOaStatus(rs.getString(index++));
    data.setReleaseFlag(rs.getString(index++));
    data.setRerlId(rs.getString(index++));
    data.setInnerBoxId(rs.getString(index++));
    data.setOuterBoxId(rs.getString(index++));
    data.setReverseField1(rs.getString(index++));
    data.setReverseField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
