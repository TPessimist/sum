package ame.psb.db.dao;

import ame.psb.db.ZhNpiLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZhNpiLogDao {

  private static final String SQL_INS = "INSERT INTO zh_npi_log(id,product,router_name,router_version,seq,package_name,common_info,final_stages,stage_factors,stage_rule_result,operation_rule_result,modle_json_string,original_operations,final_operations,auto_contain_operaions,auto_remove_operations,manual_add_operations,manual_cut_operations,filename,import_falg,demo,log_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_npi_log SET product=?,router_name=?,router_version=?,seq=?,package_name=?,common_info=?,final_stages=?,stage_factors=?,stage_rule_result=?,operation_rule_result=?,modle_json_string=?,original_operations=?,final_operations=?,auto_contain_operaions=?,auto_remove_operations=?,manual_add_operations=?,manual_cut_operations=?,filename=?,import_falg=?,demo=?,log_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,product,router_name,router_version,seq,package_name,common_info,final_stages,stage_factors,stage_rule_result,operation_rule_result,modle_json_string,original_operations,final_operations,auto_contain_operaions,auto_remove_operations,manual_add_operations,manual_cut_operations,filename,import_falg,demo,log_time FROM zh_npi_log ";

  private final Connection conn;

  public ZhNpiLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZhNpiLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getProduct());
      ps.setString(3, data.getRouterName());
      ps.setString(4, data.getRouterVersion());
      ps.setInt(5, data.getSeq());
      ps.setString(6, data.getPackageName());
      ps.setString(7, data.getCommonInfo());
      ps.setString(8, data.getFinalStages());
      ps.setString(9, data.getStageFactors());
      ps.setString(10, data.getStageRuleResult());
      ps.setString(11, data.getOperationRuleResult());
      ps.setString(12, data.getModleJsonString());
      ps.setString(13, data.getOriginalOperations());
      ps.setString(14, data.getFinalOperations());
      ps.setString(15, data.getAutoContainOperaions());
      ps.setString(16, data.getAutoRemoveOperations());
      ps.setString(17, data.getManualAddOperations());
      ps.setString(18, data.getManualCutOperations());
      ps.setString(19, data.getFilename());
      ps.setString(20, data.getImportFalg());
      ps.setString(21, data.getDemo());
      DateUtils.setDateTz(ps, 22, data.getLogTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZhNpiLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZhNpiLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getProduct());
        ps.setString(3, data.getRouterName());
        ps.setString(4, data.getRouterVersion());
        ps.setInt(5, data.getSeq());
        ps.setString(6, data.getPackageName());
        ps.setString(7, data.getCommonInfo());
        ps.setString(8, data.getFinalStages());
        ps.setString(9, data.getStageFactors());
        ps.setString(10, data.getStageRuleResult());
        ps.setString(11, data.getOperationRuleResult());
        ps.setString(12, data.getModleJsonString());
        ps.setString(13, data.getOriginalOperations());
        ps.setString(14, data.getFinalOperations());
        ps.setString(15, data.getAutoContainOperaions());
        ps.setString(16, data.getAutoRemoveOperations());
        ps.setString(17, data.getManualAddOperations());
        ps.setString(18, data.getManualCutOperations());
        ps.setString(19, data.getFilename());
        ps.setString(20, data.getImportFalg());
        ps.setString(21, data.getDemo());
        DateUtils.setDateTz(ps, 22, data.getLogTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZhNpiLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getProduct());
      ps.setString(2, data.getRouterName());
      ps.setString(3, data.getRouterVersion());
      ps.setInt(4, data.getSeq());
      ps.setString(5, data.getPackageName());
      ps.setString(6, data.getCommonInfo());
      ps.setString(7, data.getFinalStages());
      ps.setString(8, data.getStageFactors());
      ps.setString(9, data.getStageRuleResult());
      ps.setString(10, data.getOperationRuleResult());
      ps.setString(11, data.getModleJsonString());
      ps.setString(12, data.getOriginalOperations());
      ps.setString(13, data.getFinalOperations());
      ps.setString(14, data.getAutoContainOperaions());
      ps.setString(15, data.getAutoRemoveOperations());
      ps.setString(16, data.getManualAddOperations());
      ps.setString(17, data.getManualCutOperations());
      ps.setString(18, data.getFilename());
      ps.setString(19, data.getImportFalg());
      ps.setString(20, data.getDemo());
      DateUtils.setDateTz(ps, 21, data.getLogTime());
      ps.setString(22, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZhNpiLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZhNpiLog data : dataList) {
        ps.setString(1, data.getProduct());
        ps.setString(2, data.getRouterName());
        ps.setString(3, data.getRouterVersion());
        ps.setInt(4, data.getSeq());
        ps.setString(5, data.getPackageName());
        ps.setString(6, data.getCommonInfo());
        ps.setString(7, data.getFinalStages());
        ps.setString(8, data.getStageFactors());
        ps.setString(9, data.getStageRuleResult());
        ps.setString(10, data.getOperationRuleResult());
        ps.setString(11, data.getModleJsonString());
        ps.setString(12, data.getOriginalOperations());
        ps.setString(13, data.getFinalOperations());
        ps.setString(14, data.getAutoContainOperaions());
        ps.setString(15, data.getAutoRemoveOperations());
        ps.setString(16, data.getManualAddOperations());
        ps.setString(17, data.getManualCutOperations());
        ps.setString(18, data.getFilename());
        ps.setString(19, data.getImportFalg());
        ps.setString(20, data.getDemo());
        DateUtils.setDateTz(ps, 21, data.getLogTime());
        ps.setString(22, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM zh_npi_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ZhNpiLog> selectAll() throws SQLException {
    ArrayList<ZhNpiLog> result = new ArrayList<ZhNpiLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZhNpiLog selectByPK(String id) throws SQLException {
    ZhNpiLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ZhNpiLog> selectByPackageName(String packageName) throws SQLException {
    List<ZhNpiLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE PACKAGE_NAME=?")) {
      ps.setString(1, packageName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ZhNpiLog convert(ResultSet rs) throws SQLException {
    ZhNpiLog data = new ZhNpiLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setProduct(rs.getString(index++));
    data.setRouterName(rs.getString(index++));
    data.setRouterVersion(rs.getString(index++));
    data.setSeq(rs.getInt(index++));
    data.setPackageName(rs.getString(index++));
    data.setCommonInfo(rs.getString(index++));
    data.setFinalStages(rs.getString(index++));
    data.setStageFactors(rs.getString(index++));
    data.setStageRuleResult(rs.getString(index++));
    data.setOperationRuleResult(rs.getString(index++));
    data.setModleJsonString(rs.getString(index++));
    data.setOriginalOperations(rs.getString(index++));
    data.setFinalOperations(rs.getString(index++));
    data.setAutoContainOperaions(rs.getString(index++));
    data.setAutoRemoveOperations(rs.getString(index++));
    data.setManualAddOperations(rs.getString(index++));
    data.setManualCutOperations(rs.getString(index++));
    data.setFilename(rs.getString(index++));
    data.setImportFalg(rs.getString(index++));
    data.setDemo(rs.getString(index++));
    data.setLogTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
