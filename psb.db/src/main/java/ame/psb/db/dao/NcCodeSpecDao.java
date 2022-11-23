package ame.psb.db.dao;

import ame.psb.db.NcCodeSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class NcCodeSpecDao {

  private static final String SQL_INS = "INSERT INTO zd_nc_code_spec(id,operation_bo,nc_code_bo,item_group_bo,shop_order_bo,customer_itemset_name,wafer_id,wafer_ucl,wafer_lcl,lot_ucl,lot_lcl,wafer_ucl_count,wafer_lcl_count,lot_ucl_count,lot_lcl_count,nc_code_name,nc_code_desc,remarks,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_nc_code_spec SET operation_bo=?,nc_code_bo=?,item_group_bo=?,shop_order_bo=?,customer_itemset_name=?,wafer_id=?,wafer_ucl=?,wafer_lcl=?,lot_ucl=?,lot_lcl=?,wafer_ucl_count=?,wafer_lcl_count=?,lot_ucl_count=?,lot_lcl_count=?,nc_code_name=?,nc_code_desc=?,remarks=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,operation_bo,nc_code_bo,item_group_bo,shop_order_bo,customer_itemset_name,wafer_id,wafer_ucl,wafer_lcl,lot_ucl,lot_lcl,wafer_ucl_count,wafer_lcl_count,lot_ucl_count,lot_lcl_count,nc_code_name,nc_code_desc,remarks,updated_user,updated_time FROM zd_nc_code_spec ";

  private final Connection conn;

  public NcCodeSpecDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(NcCodeSpec data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getNcCodeBo());
      ps.setString(4, data.getItemGroupBo());
      ps.setString(5, data.getShopOrderBo());
      ps.setString(6, data.getCustomerItemsetName());
      ps.setString(7, data.getWaferId());
      ps.setBigDecimal(8, data.getWaferUcl());
      ps.setBigDecimal(9, data.getWaferLcl());
      ps.setBigDecimal(10, data.getLotUcl());
      ps.setBigDecimal(11, data.getLotLcl());
      ps.setBigDecimal(12, data.getWaferUclCount());
      ps.setBigDecimal(13, data.getWaferLclCount());
      ps.setBigDecimal(14, data.getLotUclCount());
      ps.setBigDecimal(15, data.getLotLclCount());
      ps.setString(16, data.getNcCodeName());
      ps.setString(17, data.getNcCodeDesc());
      ps.setString(18, data.getRemarks());
      ps.setString(19, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 20, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<NcCodeSpec> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (NcCodeSpec data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getOperationBo());
        ps.setString(3, data.getNcCodeBo());
        ps.setString(4, data.getItemGroupBo());
        ps.setString(5, data.getShopOrderBo());
        ps.setString(6, data.getCustomerItemsetName());
        ps.setString(7, data.getWaferId());
        ps.setBigDecimal(8, data.getWaferUcl());
        ps.setBigDecimal(9, data.getWaferLcl());
        ps.setBigDecimal(10, data.getLotUcl());
        ps.setBigDecimal(11, data.getLotLcl());
        ps.setBigDecimal(12, data.getWaferUclCount());
        ps.setBigDecimal(13, data.getWaferLclCount());
        ps.setBigDecimal(14, data.getLotUclCount());
        ps.setBigDecimal(15, data.getLotLclCount());
        ps.setString(16, data.getNcCodeName());
        ps.setString(17, data.getNcCodeDesc());
        ps.setString(18, data.getRemarks());
        ps.setString(19, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 20, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(NcCodeSpec data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getOperationBo());
      ps.setString(2, data.getNcCodeBo());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getShopOrderBo());
      ps.setString(5, data.getCustomerItemsetName());
      ps.setString(6, data.getWaferId());
      ps.setBigDecimal(7, data.getWaferUcl());
      ps.setBigDecimal(8, data.getWaferLcl());
      ps.setBigDecimal(9, data.getLotUcl());
      ps.setBigDecimal(10, data.getLotLcl());
      ps.setBigDecimal(11, data.getWaferUclCount());
      ps.setBigDecimal(12, data.getWaferLclCount());
      ps.setBigDecimal(13, data.getLotUclCount());
      ps.setBigDecimal(14, data.getLotLclCount());
      ps.setString(15, data.getNcCodeName());
      ps.setString(16, data.getNcCodeDesc());
      ps.setString(17, data.getRemarks());
      ps.setString(18, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 19, data.getUpdatedTime());
      ps.setString(20, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<NcCodeSpec> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (NcCodeSpec data : dataList) {
        ps.setString(1, data.getOperationBo());
        ps.setString(2, data.getNcCodeBo());
        ps.setString(3, data.getItemGroupBo());
        ps.setString(4, data.getShopOrderBo());
        ps.setString(5, data.getCustomerItemsetName());
        ps.setString(6, data.getWaferId());
        ps.setBigDecimal(7, data.getWaferUcl());
        ps.setBigDecimal(8, data.getWaferLcl());
        ps.setBigDecimal(9, data.getLotUcl());
        ps.setBigDecimal(10, data.getLotLcl());
        ps.setBigDecimal(11, data.getWaferUclCount());
        ps.setBigDecimal(12, data.getWaferLclCount());
        ps.setBigDecimal(13, data.getLotUclCount());
        ps.setBigDecimal(14, data.getLotLclCount());
        ps.setString(15, data.getNcCodeName());
        ps.setString(16, data.getNcCodeDesc());
        ps.setString(17, data.getRemarks());
        ps.setString(18, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 19, data.getUpdatedTime());
        ps.setString(20, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_nc_code_spec WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public NcCodeSpec selectByPK(String id) throws SQLException {
    NcCodeSpec result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<NcCodeSpec> selectAll() throws SQLException {
    ArrayList<NcCodeSpec> result = new ArrayList<NcCodeSpec>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  //ncCode+工单+站点 删除
  public int deleteByShopOrder(String ncCodeBo, String shopOrder, String operationBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_nc_code_spec WHERE nc_code_bo=? AND shop_order_bo=? AND operation_bo=? ORDER BY updated_time desc ")) {
      ps.setString(1, ncCodeBo);
      ps.setString(2, shopOrder);
      ps.setString(3, operationBo);

      return ps.executeUpdate();
    }
  }

  //ncCode+客批+站点 删除
  public int deleteByCustomerItemsetName(String ncCodeBo, String customerItemsetName,
      String operationBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_nc_code_spec WHERE nc_code_bo=? AND customer_itemset_name=? AND operation_bo=? ORDER BY updated_time desc ")) {
      ps.setString(1, ncCodeBo);
      ps.setString(2, customerItemsetName);
      ps.setString(3, operationBo);

      return ps.executeUpdate();
    }
  }

  //ncCode+晶圆编号+站点 删除
  public int deleteByWaferId(String ncCodeBo, String waferId, String operationBo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_nc_code_spec WHERE nc_code_bo=? AND wafer_id=? AND operation_bo=? ORDER BY updated_time desc ")) {
      ps.setString(1, ncCodeBo);
      ps.setString(2, waferId);
      ps.setString(3, operationBo);

      return ps.executeUpdate();
    }
  }

  //工单+站点
  public List<NcCodeSpec> selectByShopAndOperation(String operation, String shopOrder)
      throws SQLException {
    ArrayList<NcCodeSpec> result = new ArrayList<NcCodeSpec>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where operation_bo=? and shop_order_bo=? ORDER BY nc_code_bo ")) {
      ps.setString(1, operation);
      ps.setString(2, shopOrder);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  //客批+站点
  public List<NcCodeSpec> selectByItemsetNameAndOperation(String operation, String itemsetName)
      throws SQLException {
    ArrayList<NcCodeSpec> result = new ArrayList<NcCodeSpec>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where operation_bo=? and customer_itemset_name=? ORDER BY nc_code_bo ")) {
      ps.setString(1, operation);
      ps.setString(2, itemsetName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  //晶圆编号+站点
  public List<NcCodeSpec> selectByWaferIdAndOperation(String operation, String waferId)
      throws SQLException {
    ArrayList<NcCodeSpec> result = new ArrayList<NcCodeSpec>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where operation_bo=? and wafer_id=? ORDER BY nc_code_bo ")) {
      ps.setString(1, operation);
      ps.setString(2, waferId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  //ncCodeBo+晶圆编号+站点 查询
  public NcCodeSpec selectByNcCodeAndWaferId(String ncCodeBo, String operation,
      String waferId)
      throws SQLException {
    NcCodeSpec result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where nc_code_bo=? and operation_bo=? and wafer_id=? ORDER BY updated_time desc ")) {
      ps.setString(1, ncCodeBo);
      ps.setString(2, operation);
      ps.setString(3, waferId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  //ncCodeBo+工单+站点 查询
  public NcCodeSpec selectByNcCodeAndShop(String ncCodeBo, String operation, String shopOrder)
      throws SQLException {
    NcCodeSpec result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where nc_code_bo=? and operation_bo=? and shop_order_bo=? ORDER BY updated_time desc ")) {
      ps.setString(1, ncCodeBo);
      ps.setString(2, operation);
      ps.setString(3, shopOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  //ncCodeBo+客批+站点 查询
  public NcCodeSpec selectByNcCodeAndItemsetName(String ncCodeBo, String operation,
      String customerItemsetName)
      throws SQLException {
    NcCodeSpec result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + " where nc_code_bo=? and operation_bo=? and customer_itemset_name=? ORDER BY updated_time desc ")) {
      ps.setString(1, ncCodeBo);
      ps.setString(2, operation);
      ps.setString(3, customerItemsetName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  //根据waferId查询
  public List<NcCodeSpec> selectByWaferId(String waferId, String itemGroupBo, String operation)
      throws SQLException {
    ArrayList<NcCodeSpec> result = new ArrayList<NcCodeSpec>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + " where wafer_id=? and item_group_bo=? and operation_bo=? ORDER BY nc_code_bo ")) {
      ps.setString(1, waferId);
      ps.setString(2, itemGroupBo);
      ps.setString(3, operation);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  //根据shopOrder查询
  public List<NcCodeSpec> selectByShopOrder(String shopOrder, String itemGroupBo, String operation)
      throws SQLException {
    ArrayList<NcCodeSpec> result = new ArrayList<NcCodeSpec>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + " where shop_order_bo=? and item_group_bo=? and operation_bo=? ORDER BY nc_code_bo ")) {
      ps.setString(1, shopOrder);
      ps.setString(2, itemGroupBo);
      ps.setString(3, operation);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  //根据客批查询
  public List<NcCodeSpec> selectByItemsetName(String customerItemsetName, String itemGroupBo,
      String operation)
      throws SQLException {
    ArrayList<NcCodeSpec> result = new ArrayList<NcCodeSpec>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + " where customer_itemset_name=? and item_group_bo=? and operation_bo=? ORDER BY nc_code_bo ")) {
      ps.setString(1, customerItemsetName);
      ps.setString(2, itemGroupBo);
      ps.setString(3, operation);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private NcCodeSpec convert(ResultSet rs) throws SQLException {
    NcCodeSpec data = new NcCodeSpec();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setNcCodeBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setCustomerItemsetName(rs.getString(index++));
    data.setWaferId(rs.getString(index++));
    data.setWaferUcl(rs.getBigDecimal(index++));
    data.setWaferLcl(rs.getBigDecimal(index++));
    data.setLotUcl(rs.getBigDecimal(index++));
    data.setLotLcl(rs.getBigDecimal(index++));
    data.setWaferUclCount(rs.getBigDecimal(index++));
    data.setWaferLclCount(rs.getBigDecimal(index++));
    data.setLotUclCount(rs.getBigDecimal(index++));
    data.setLotLclCount(rs.getBigDecimal(index++));
    data.setNcCodeName(rs.getString(index++));
    data.setNcCodeDesc(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
