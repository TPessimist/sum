package ame.psb.db.dao;

import ame.psb.db.DcPlan;
import ame.psb.db.ViewDcPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import uia.utils.dao.DateUtils;

public class DcPlanDao {

  private static final String SQL_INS = "INSERT INTO zr_dc_plan(id,dcop_bo,operation_bo,resource_bo,dc_time,state_name,dpt_no,updated_user,updated_time,hold_resource_bo,hold_operation_bo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_dc_plan SET dcop_bo=?,operation_bo=?,resource_bo=?,dc_time=?,state_name=?,dpt_no=?,updated_user=?,updated_time=?,hold_resource_bo=?,hold_operation_bo=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,dcop_bo,operation_bo,resource_bo,dc_time,state_name,dpt_no,updated_user,updated_time,hold_resource_bo,hold_operation_bo,dc_group_bo,dc_count,die_count,item_group_bo,dc_group,dc_group_revision,description,resource_name FROM view_dc_plan ";

  private final Connection conn;

  public DcPlanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DcPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDcopBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getResourceBo());
      DateUtils.setDateTz(ps, 5, data.getDcTime());
      ps.setString(6, data.getStateName());
      ps.setString(7, data.getDptNo());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getHoldResourceBo());
      ps.setString(11, data.getHoldOperationBo());

      return ps.executeUpdate();
    }
  }

  public int update(DcPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDcopBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getResourceBo());
      DateUtils.setDateTz(ps, 4, data.getDcTime());
      ps.setString(5, data.getStateName());
      ps.setString(6, data.getDptNo());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getHoldResourceBo());
      ps.setString(10, data.getHoldOperationBo());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int updateStateById(String stateName, String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zr_dc_plan SET state_name =? WHERE id=?")) {
      ps.setString(1, stateName);
      ps.setString(2, id);
      return ps.executeUpdate();
    }
  }

  public ViewDcPlan selectByPK(String id) throws SQLException {
    ViewDcPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * by dcop_bo和站点查询最新的一笔记录
   * */
  public ViewDcPlan selectByDcopBoAndOperationBo(String dcop_bo, String operation_bo)
      throws SQLException {
    ViewDcPlan result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + " WHERE dcop_bo=? and operation_bo = ? order by updated_time desc ")) {
      ps.setString(1, dcop_bo);
      ps.setString(2, operation_bo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewDcPlan convert(ResultSet rs) throws SQLException {
    ViewDcPlan data = new ViewDcPlan();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDcopBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setDcTime(DateUtils.getDateTz(rs, index++));
    data.setStateName(rs.getString(index++));
    data.setDptNo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setHoldResourceBo(rs.getString(index++));
    data.setHoldOperationBo(rs.getString(index++));

    data.setDcGroupBo(rs.getString(index++));
    data.setDcCount(rs.getBigDecimal(index++));
    data.setDieCount(rs.getBigDecimal(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setDcGroup(rs.getString(index++));
    data.setDcGroupRevision(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setResourceName(rs.getString(index++));

    return data;
  }
}
