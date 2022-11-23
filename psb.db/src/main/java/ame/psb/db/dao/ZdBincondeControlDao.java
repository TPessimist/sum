package ame.psb.db.dao;

import ame.psb.db.ZdBincondeControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ZdBincondeControlDao {

  private static final String SQL_INS = "INSERT INTO zd_bincode_control(id,control_type,item_group_bo,item_group_name,operation_bo,operation_name,shop_order_bo,shop_order_name,customer_item_bo,customer_item_name,bin_code,bin_code_offset,wafer_ucl,wafer_lcl,wafer_ucl_count,wafer_lcl_count,update_user,update_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_bincode_control SET control_type=?,item_group_bo=?,item_group_name=?,operation_bo=?,operation_name=?,shop_order_bo=?,shop_order_name=?,customer_item_bo=?,customer_item_name=?,bin_code=?,bin_code_offset=?,wafer_ucl=?,wafer_lcl=?,wafer_ucl_count=?,wafer_lcl_count=?,update_user=?,update_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,control_type,item_group_bo,item_group_name,operation_bo,operation_name,shop_order_bo,shop_order_name,customer_item_bo,customer_item_name,bin_code,bin_code_offset,wafer_ucl,wafer_lcl,wafer_ucl_count,wafer_lcl_count,update_user,update_time FROM zd_bincode_control ";

  private final Connection conn;

  public ZdBincondeControlDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZdBincondeControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getControlType());
      ps.setString(3, data.getItemGroupBo());
      ps.setString(4, data.getItemGroupName());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getOperationName());
      ps.setString(7, data.getShopOrderBo());
      ps.setString(8, data.getShopOrderName());
      ps.setString(9, data.getCustomerItemBo());
      ps.setString(10, data.getCustomerItemName());
      ps.setString(11, data.getBinCode());
      ps.setBigDecimal(12, data.getBinCodeOffset());
      ps.setBigDecimal(13, data.getWaferUcl());
      ps.setBigDecimal(14, data.getWaferLcl());
      ps.setBigDecimal(15, data.getWaferUclCount());
      ps.setBigDecimal(16, data.getWaferLclCount());
      ps.setString(17, data.getUpdateUser());
      DateUtils.setDateTz(ps, 18, data.getUpdateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZdBincondeControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZdBincondeControl data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getControlType());
        ps.setString(3, data.getItemGroupBo());
        ps.setString(4, data.getItemGroupName());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getOperationName());
        ps.setString(7, data.getShopOrderBo());
        ps.setString(8, data.getShopOrderName());
        ps.setString(9, data.getCustomerItemBo());
        ps.setString(10, data.getCustomerItemName());
        ps.setString(11, data.getBinCode());
        ps.setBigDecimal(12, data.getBinCodeOffset());
        ps.setBigDecimal(13, data.getWaferUcl());
        ps.setBigDecimal(14, data.getWaferLcl());
        ps.setBigDecimal(15, data.getWaferUclCount());
        ps.setBigDecimal(16, data.getWaferLclCount());
        ps.setString(17, data.getUpdateUser());
        DateUtils.setDateTz(ps, 18, data.getUpdateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZdBincondeControl data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getControlType());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getItemGroupName());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getOperationName());
      ps.setString(6, data.getShopOrderBo());
      ps.setString(7, data.getShopOrderName());
      ps.setString(8, data.getCustomerItemBo());
      ps.setString(9, data.getCustomerItemName());
      ps.setString(10, data.getBinCode());
      ps.setBigDecimal(11, data.getBinCodeOffset());
      ps.setBigDecimal(12, data.getWaferUcl());
      ps.setBigDecimal(13, data.getWaferLcl());
      ps.setBigDecimal(14, data.getWaferUclCount());
      ps.setBigDecimal(15, data.getWaferLclCount());
      ps.setString(16, data.getUpdateUser());
      DateUtils.setDateTz(ps, 17, data.getUpdateTime());
      ps.setString(18, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZdBincondeControl> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZdBincondeControl data : dataList) {
        ps.setString(1, data.getControlType());
        ps.setString(2, data.getItemGroupBo());
        ps.setString(3, data.getItemGroupName());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getOperationName());
        ps.setString(6, data.getShopOrderBo());
        ps.setString(7, data.getShopOrderName());
        ps.setString(8, data.getCustomerItemBo());
        ps.setString(9, data.getCustomerItemName());
        ps.setString(10, data.getBinCode());
        ps.setBigDecimal(11, data.getBinCodeOffset());
        ps.setBigDecimal(12, data.getWaferUcl());
        ps.setBigDecimal(13, data.getWaferLcl());
        ps.setBigDecimal(14, data.getWaferUclCount());
        ps.setBigDecimal(15, data.getWaferLclCount());
        ps.setString(16, data.getUpdateUser());
        DateUtils.setDateTz(ps, 17, data.getUpdateTime());
        ps.setString(18, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_bincode_control WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ZdBincondeControl> selectAll() throws SQLException {
    ArrayList<ZdBincondeControl> result = new ArrayList<ZdBincondeControl>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZdBincondeControl> selectByDeviceType(String deviceBo, String type,
      String operationBo)
      throws SQLException {
    ArrayList<ZdBincondeControl> result = new ArrayList<ZdBincondeControl>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE ITEM_GROUP_BO=? AND CONTROL_TYPE =? AND operation_bo =?")) {
      ps.setString(1, deviceBo);
      ps.setString(2, type);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ZdBincondeControl> selectByWaferType(String wafer, String type, String operationBo)
      throws SQLException {
    ArrayList<ZdBincondeControl> result = new ArrayList<ZdBincondeControl>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE CUSTOMER_ITEM_BO=? AND CONTROL_TYPE =?  AND operation_bo =?")) {
      ps.setString(1, wafer);
      ps.setString(2, type);
      ps.setString(3, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZdBincondeControl selectByPK(String id) throws SQLException {
    ZdBincondeControl result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZdBincondeControl selectByBinTypeDevice(String binCode, String type, String decviceBo,
      String operationBo)
      throws SQLException {
    ZdBincondeControl result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE bin_code=? AND CONTROL_TYPE =? and ITEM_GROUP_BO=? AND operation_bo =?")) {
      ps.setString(1, binCode);
      ps.setString(2, type);
      ps.setString(3, decviceBo);
      ps.setString(4, operationBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZdBincondeControl selectByBinTypeWafer(String binCode, String type, String decviceBo,
      String operationBo)
      throws SQLException {
    ZdBincondeControl result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL
                + "WHERE bin_code=? AND CONTROL_TYPE =? and CUSTOMER_ITEM_BO=? AND operation_bo =?")) {
      ps.setString(1, binCode);
      ps.setString(2, type);
      ps.setString(3, decviceBo);
      ps.setString(4, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZdBincondeControl convert(ResultSet rs) throws SQLException {
    ZdBincondeControl data = new ZdBincondeControl();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setControlType(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setItemGroupName(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setOperationName(rs.getString(index++));
    data.setShopOrderBo(rs.getString(index++));
    data.setShopOrderName(rs.getString(index++));
    data.setCustomerItemBo(rs.getString(index++));
    data.setCustomerItemName(rs.getString(index++));
    data.setBinCode(rs.getString(index++));
    data.setBinCodeOffset(rs.getBigDecimal(index++));
    data.setWaferUcl(rs.getBigDecimal(index++));
    data.setWaferLcl(rs.getBigDecimal(index++));
    data.setWaferUclCount(rs.getBigDecimal(index++));
    data.setWaferLclCount(rs.getBigDecimal(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
