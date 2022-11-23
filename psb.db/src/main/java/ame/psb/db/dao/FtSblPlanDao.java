package ame.psb.db.dao;

import ame.psb.db.FtSblPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class FtSblPlanDao {

  private static final String SQL_INS = "INSERT INTO zd_ft_sbl_plan(item_group_bo,operation_bo,sbl_param_bo,sbl_param_desc,sbl_file_sourece,sbl_file_type,sbl_formula,sbl_usl,sbl_lsl,memo,updated_user,updated_time, RESOURCE_TYPE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ft_sbl_plan SET sbl_param_desc=?,sbl_file_sourece=?,sbl_file_type=?,sbl_formula=?,sbl_usl=?,sbl_lsl=?,memo=?,updated_user=?,updated_time=? WHERE item_group_bo=? AND operation_bo=? AND sbl_param_bo=?, AND RESOURCE_TYPE=? ";

  private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,sbl_param_bo,sbl_param_desc,sbl_file_sourece,sbl_file_type,sbl_formula,sbl_usl,sbl_lsl,memo,updated_user,updated_time, RESOURCE_TYPE FROM zd_ft_sbl_plan ";

  private final Connection conn;

  public FtSblPlanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(FtSblPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getSblParamBo());
      ps.setString(4, data.getSblParamDesc());
      ps.setString(5, data.getSblFileSourece());
      ps.setString(6, data.getSblFileType());
      ps.setString(7, data.getSblFormula());
      ps.setBigDecimal(8, data.getSblUsl());
      ps.setBigDecimal(9, data.getSblLsl());
      ps.setString(10, data.getMemo());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      ps.setString(13, data.getResourceType());
      return ps.executeUpdate();
    }
  }

  public int insert(List<FtSblPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (FtSblPlan data : dataList) {
        ps.setString(1, data.getItemGroupBo());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getSblParamBo());
        ps.setString(4, data.getSblParamDesc());
        ps.setString(5, data.getSblFileSourece());
        ps.setString(6, data.getSblFileType());
        ps.setString(7, data.getSblFormula());
        ps.setBigDecimal(8, data.getSblUsl());
        ps.setBigDecimal(9, data.getSblLsl());
        ps.setString(10, data.getMemo());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
        ps.setString(13, data.getResourceType());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(FtSblPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSblParamDesc());
      ps.setString(2, data.getSblFileSourece());
      ps.setString(3, data.getSblFileType());
      ps.setString(4, data.getSblFormula());
      ps.setBigDecimal(5, data.getSblUsl());
      ps.setBigDecimal(6, data.getSblLsl());
      ps.setString(7, data.getMemo());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getItemGroupBo());
      ps.setString(11, data.getOperationBo());
      ps.setString(12, data.getSblParamBo());
      ps.setString(13, data.getResourceType());

      if (ps.executeUpdate() == 0) {
        insert(data);
      }
      return 0;
    }
  }

  public int update(List<FtSblPlan> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (FtSblPlan data : dataList) {
        ps.setString(1, data.getSblParamDesc());
        ps.setString(2, data.getSblFileSourece());
        ps.setString(3, data.getSblFileType());
        ps.setString(4, data.getSblFormula());
        ps.setBigDecimal(5, data.getSblUsl());
        ps.setBigDecimal(6, data.getSblLsl());
        ps.setString(7, data.getMemo());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
        ps.setString(10, data.getItemGroupBo());
        ps.setString(11, data.getOperationBo());
        ps.setString(12, data.getSblParamBo());
        ps.setString(13, data.getResourceType());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemGroupBo, String operationBo, String sblParamBo, String resourceType)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_ft_sbl_plan WHERE item_group_bo=? AND operation_bo=? AND sbl_param_bo=?  AND resource_type = ?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, sblParamBo);
      ps.setString(4, resourceType);

      return ps.executeUpdate();
    }
  }

  public void deleteByDevice(String itemGroupBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_ft_sbl_plan WHERE item_group_bo=? ")) {
      ps.setString(1, itemGroupBo);
      ps.executeUpdate();
    }
  }

  public List<FtSblPlan> selectAll() throws SQLException {
    ArrayList<FtSblPlan> result = new ArrayList<FtSblPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public FtSblPlan selectByPK(String itemGroupBo, String operationBo, String sblParamBo,
      String resourceType) throws SQLException {
    FtSblPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_group_bo=? AND operation_bo=? AND sbl_param_bo=? AND RESOURCE_TYPE=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, sblParamBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<FtSblPlan> selectByDevice(String itemGroupBo) throws SQLException {
    ArrayList<FtSblPlan> result = new ArrayList<FtSblPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_group_bo=?")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<FtSblPlan> selectByUpdateTime(String beginDate, String endDate) throws SQLException {
    ArrayList<FtSblPlan> result = new ArrayList<FtSblPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE updated_time >= ? AND updated_time <= ?")) {
      ps.setString(1, beginDate);
      ps.setString(2, endDate);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private FtSblPlan convert(ResultSet rs) throws SQLException {
    FtSblPlan data = new FtSblPlan();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setSblParamBo(rs.getString(index++));
    data.setSblParamDesc(rs.getString(index++));
    data.setSblFileSourece(rs.getString(index++));
    data.setSblFileType(rs.getString(index++));
    data.setSblFormula(rs.getString(index++));
    data.setSblUsl(rs.getBigDecimal(index++));
    data.setSblLsl(rs.getBigDecimal(index++));
    data.setMemo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setResourceType(rs.getString(index++));

    return data;
  }
}
