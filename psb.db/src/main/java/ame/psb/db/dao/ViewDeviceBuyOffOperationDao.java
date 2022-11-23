package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.ViewDeviceBuyOffOperation;

public class ViewDeviceBuyOffOperationDao {

  private static final String SQL_SEL = "SELECT item_group_bo,start_operation_bo,end_operation_bo,recipe_operation_bo,STATE_NAME,sfc_qty,sfc_type,process_type,process_operation,recipe_buy_off_param,remark,id,reversed_field1,reversed_field2 FROM view_device_buyoff_operation ";

  private final Connection conn;

  public ViewDeviceBuyOffOperationDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewDeviceBuyOffOperation> selectAll() throws SQLException {
    ArrayList<ViewDeviceBuyOffOperation> result = new ArrayList<ViewDeviceBuyOffOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewDeviceBuyOffOperation> selectByPK(String itemGroupBo) throws SQLException {
    List<ViewDeviceBuyOffOperation> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? ")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewDeviceBuyOffOperation selectByPKItemGroupBoAndEndOperationBo(String itemGroupBo, String endOperationBo,String sfcType)
      throws SQLException {
    ViewDeviceBuyOffOperation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? and end_operation_bo = ? and SFC_TYPE = ?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, endOperationBo);
      ps.setString(3, sfcType);


      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }
  public List<ViewDeviceBuyOffOperation> selectByPKItemGroupBoAndStartOperationBo(String itemGroupBo, String endOperationBo)
      throws SQLException {
    List<ViewDeviceBuyOffOperation> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? and start_operation_bo = ? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, endOperationBo);



      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  public List<ViewDeviceBuyOffOperation> selectByPKItemGroupBoAndStartOperationBo(String itemGroupBo, String endOperationBo,String type)
      throws SQLException {
    List<ViewDeviceBuyOffOperation> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE ITEM_GROUP_BO=? and start_operation_bo = ? and SFC_TYPE = ? ")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, endOperationBo);
      ps.setString(3, type);


      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }
  private ViewDeviceBuyOffOperation convert(ResultSet rs) throws SQLException {
    ViewDeviceBuyOffOperation data = new ViewDeviceBuyOffOperation();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setStartOperationBo(rs.getString(index++));
    data.setEndOperationBo(rs.getString(index++));
    data.setRecipeOperationBo(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setSfcQty(rs.getBigDecimal(index++));
    data.setSfcType(rs.getString(index++));
    data.setProcessType(rs.getString(index++));
    data.setProcessOperation(rs.getString(index++));
    data.setRecipeBuyOffParam(rs.getString(index++));
    data.setRemark(rs.getString(index++));
    data.setId(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));

    return data;
  }
}
