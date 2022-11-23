package ame.psb.db.dao;

import ame.psb.db.ProductMapCombineOperationDef;
import ame.psb.db.ViewProductMapCombineOperationDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductMapCombineOperationDefDao {

  private static final String SQL_INS = "INSERT INTO zd_prod_map_combine_op_def(id,sequence,prod_map_def_bo,operation_bo,operation_type,file_type,file_path,map_rule_bo,force_flag,golden_type,o_golden_map_rule_bo,o_golden_map_file_name,o_golden_map_rule_tmpl,eap_load_map_operation,inherit_device_bo,inherit_operation_bo,inherit_map_rule_bo,combine_flag) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_prod_map_combine_op_def SET sequence=?,prod_map_def_bo=?,operation_bo=?,operation_type=?,file_type=?,file_path=?,map_rule_bo=?,force_flag=?,golden_type=?,o_golden_map_rule_bo=?,o_golden_map_file_name=?,o_golden_map_rule_tmpl=?,eap_load_map_operation=?,inherit_device_bo=?,inherit_operation_bo=?,inherit_map_rule_bo=?,combine_flag=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sequence,prod_map_def_bo,operation_bo,operation_type,file_type,file_path,operation_name,map_rule_bo,force_flag,golden_type,o_golden_map_rule_bo,o_golden_map_file_name,o_golden_map_rule_tmpl,eap_load_map_operation,inherit_device_bo,inherit_operation_bo,inherit_map_rule_bo,combine_flag FROM VIEW_PROD_MAP_COMBINE_OP_DEF ";

  private final Connection conn;

  public ProductMapCombineOperationDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ProductMapCombineOperationDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setInt(2, data.getSequence());
      ps.setString(3, data.getProdMapDefBo());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getOperationType());
      ps.setString(6, data.getFileType());
      ps.setString(7, data.getFilePath());
      ps.setString(8, data.getMapRuleBo());
      ps.setString(9, data.getForceFlag());
      ps.setString(10, data.getGoldenType());
      ps.setString(11, data.getoGoldenMapRuleBo());
      ps.setString(12, data.getoGoldenMapFileName());
      ps.setString(13, data.getoGoldenMapRuleTmpl());
      ps.setString(14, data.getEapLoadMapOperation());
      ps.setString(15, data.getInheritDeviceBo());
      ps.setString(16, data.getInheritOperationBo());
      ps.setString(17, data.getInheritMapRuleBo());
      ps.setString(18, data.getCombineFlag());
      return ps.executeUpdate();
    }
  }

  public int insert(List<ProductMapCombineOperationDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ProductMapCombineOperationDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setInt(2, data.getSequence());
        ps.setString(3, data.getProdMapDefBo());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getOperationType());
        ps.setString(6, data.getFileType());
        ps.setString(7, data.getFilePath());
        ps.setString(8, data.getMapRuleBo());
        ps.setString(9, data.getForceFlag());
        ps.setString(10, data.getGoldenType());
        ps.setString(11, data.getoGoldenMapRuleBo());
        ps.setString(12, data.getoGoldenMapFileName());
        ps.setString(13, data.getoGoldenMapRuleTmpl());
        ps.setString(14, data.getEapLoadMapOperation());
        ps.setString(15, data.getInheritDeviceBo());
        ps.setString(16, data.getInheritOperationBo());
        ps.setString(17, data.getInheritMapRuleBo());
        ps.setString(18, data.getCombineFlag());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ProductMapCombineOperationDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getSequence());
      ps.setString(2, data.getProdMapDefBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getOperationType());
      ps.setString(5, data.getFileType());
      ps.setString(6, data.getFilePath());
      ps.setString(7, data.getMapRuleBo());
      ps.setString(8, data.getForceFlag());

      ps.setString(9, data.getGoldenType());
      ps.setString(10, data.getoGoldenMapRuleBo());
      ps.setString(11, data.getoGoldenMapFileName());
      ps.setString(12, data.getoGoldenMapRuleTmpl());
      ps.setString(13, data.getEapLoadMapOperation());
      ps.setString(14, data.getInheritDeviceBo());
      ps.setString(15, data.getInheritOperationBo());
      ps.setString(16, data.getInheritMapRuleBo());
      ps.setString(17, data.getCombineFlag());

      ps.setString(18, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ProductMapCombineOperationDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ProductMapCombineOperationDef data : dataList) {
        ps.setInt(1, data.getSequence());
        ps.setString(2, data.getProdMapDefBo());
        ps.setString(3, data.getOperationBo());
        ps.setString(4, data.getOperationType());
        ps.setString(5, data.getFileType());
        ps.setString(6, data.getFilePath());
        ps.setString(7, data.getMapRuleBo());
        ps.setString(8, data.getForceFlag());

        ps.setString(9, data.getGoldenType());
        ps.setString(10, data.getoGoldenMapRuleBo());
        ps.setString(11, data.getoGoldenMapFileName());
        ps.setString(12, data.getoGoldenMapRuleTmpl());
        ps.setString(13, data.getEapLoadMapOperation());
        ps.setString(14, data.getInheritDeviceBo());
        ps.setString(15, data.getInheritOperationBo());
        ps.setString(16, data.getInheritMapRuleBo());

        ps.setString(17, data.getCombineFlag());
        ps.setString(18, data.getId());
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_prod_map_combine_op_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByMaster(String masterId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_prod_map_combine_op_def WHERE prod_map_def_bo=?")) {
      ps.setString(1, masterId);

      return ps.executeUpdate();
    }
  }

  public List<ViewProductMapCombineOperationDef> selectAll() throws SQLException {
    ArrayList<ViewProductMapCombineOperationDef> result = new ArrayList<ViewProductMapCombineOperationDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewProductMapCombineOperationDef> selectByMaster(String masterId)
      throws SQLException {
    ArrayList<ViewProductMapCombineOperationDef> result = new ArrayList<ViewProductMapCombineOperationDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE prod_map_def_bo=?")) {
      ps.setString(1, masterId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewProductMapCombineOperationDef> selectOperationDefByMaster(String masterId)
      throws SQLException {
    ArrayList<ViewProductMapCombineOperationDef> result = new ArrayList<ViewProductMapCombineOperationDef>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE prod_map_def_bo=? and operation_type='I' ")) {
      ps.setString(1, masterId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewProductMapCombineOperationDef> selectByOperationBo(String operationBo)
      throws SQLException {
    ArrayList<ViewProductMapCombineOperationDef> result = new ArrayList<ViewProductMapCombineOperationDef>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE OPERATION_BO=? and operation_type='I' ")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewProductMapCombineOperationDef> selectByOutgoingRule(String outgoingRuleName)
      throws SQLException {
    ArrayList<ViewProductMapCombineOperationDef> result = new ArrayList<ViewProductMapCombineOperationDef>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE MAP_RULE_BO=? and operation_type='O' ")) {
      ps.setString(1, outgoingRuleName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewProductMapCombineOperationDef selectByMasterAndOperation(String operatonType,
      String operationBo, String id) throws SQLException {
    ViewProductMapCombineOperationDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE operation_type=? and operation_bo=? and map_rule_bo=?")) {
      ps.setString(1, operatonType);
      ps.setString(2, operationBo);
      ps.setString(3, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewProductMapCombineOperationDef selectByMasterAndOperation(String operationBo,
      String masterId) throws SQLException {
    ViewProductMapCombineOperationDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE operation_type='I' and operation_bo=? and prod_map_def_bo=?")) {
      ps.setString(1, operationBo);
      ps.setString(2, masterId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ArrayList<ViewProductMapCombineOperationDef> selectListByMasterAndOperation(
      String operationBo,
      String masterId) throws SQLException {
    ArrayList<ViewProductMapCombineOperationDef> result = new ArrayList<ViewProductMapCombineOperationDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL
            + "WHERE operation_type='I' and operation_bo=? and prod_map_def_bo=? ORDER BY sequence asc")) {
      ps.setString(1, operationBo);
      ps.setString(2, masterId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewProductMapCombineOperationDef selectByOperation(String operationBo, String masterId)
      throws SQLException {
    ViewProductMapCombineOperationDef result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_bo=? and prod_map_def_bo=? ")) {
      ps.setString(1, operationBo);
      ps.setString(2, masterId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewProductMapCombineOperationDef selectByCombineOperation(String operationBo,
      String masterId)
      throws SQLException {
    ViewProductMapCombineOperationDef result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE operation_bo=? and prod_map_def_bo=? and OPERATION_TYPE = 'O'")) {
      ps.setString(1, operationBo);
      ps.setString(2, masterId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewProductMapCombineOperationDef selectByPK(String id) throws SQLException {
    ViewProductMapCombineOperationDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewProductMapCombineOperationDef convert(ResultSet rs) throws SQLException {
    ViewProductMapCombineOperationDef data = new ViewProductMapCombineOperationDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setProdMapDefBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setOperationType(rs.getString(index++));
    data.setFileType(rs.getString(index++));
    data.setFilePath(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setMapRuleBo(rs.getString(index++));
    data.setForceFlag(rs.getString(index++));
    data.setGoldenType(rs.getString(index++));
    data.setoGoldenMapRuleBo(rs.getString(index++));
    data.setoGoldenMapFileName(rs.getString(index++));
    data.setoGoldenMapRuleTmpl(rs.getString(index++));
    data.setEapLoadMapOperation(rs.getString(index++));
    data.setInheritDeviceBo(rs.getString(index++));
    data.setInheritOperationBo(rs.getString(index++));
    data.setInheritMapRuleBo(rs.getString(index++));
    data.setCombineFlag(rs.getString(index++));

    return data;
  }

  private ProductMapCombineOperationDef convertProductMapCombineOperationDef(ResultSet rs)
      throws SQLException {
    ProductMapCombineOperationDef data = new ProductMapCombineOperationDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSequence(rs.getInt(index++));
    data.setProdMapDefBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setOperationType(rs.getString(index++));
    data.setFileType(rs.getString(index++));
    data.setFilePath(rs.getString(index++));
    data.setMapRuleBo(rs.getString(index++));
    data.setForceFlag(rs.getString(index++));

    return data;
  }

  public List<ProductMapCombineOperationDef> selectByProdMapDefBo(String productMapDefId)
      throws SQLException {
    String sql = "select * from zd_prod_map_combine_op_def where prod_map_def_bo = ?";
    List<ProductMapCombineOperationDef> list = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
      ps.setString(1, productMapDefId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convertProductMapCombineOperationDef(rs));
      }
      return list;
    }
  }
}
