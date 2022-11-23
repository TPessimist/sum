package ame.psb.db.dao;

import ame.psb.db.ViewManualHoldOcap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewManualHoldOcapDao {

  private static final String SQL_SEL = "SELECT hold_detail_bo,sfc,shop_order,customer,itemset_name,department,item,value,carrier_bo,item_group,state_name,operation,run_user,comments,flag,requestid FROM v_manual_hold_ocap ";

  private final Connection conn;

  public ViewManualHoldOcapDao(Connection conn) {
    this.conn = conn;
  }

  public List<ViewManualHoldOcap> selectAll() throws SQLException {
    ArrayList<ViewManualHoldOcap> result = new ArrayList<ViewManualHoldOcap>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewManualHoldOcap> selectByPK(String holdDetailBo) throws SQLException {
    ArrayList<ViewManualHoldOcap> result = new ArrayList<ViewManualHoldOcap>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE hold_detail_bo=?")) {
      ps.setString(1, holdDetailBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private ViewManualHoldOcap convert(ResultSet rs) throws SQLException {
    ViewManualHoldOcap data = new ViewManualHoldOcap();

    int index = 1;
    data.setHoldDetailBo(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setItemsetName(rs.getString(index++));
    data.setDepartment(rs.getString(index++));
    data.setItem(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setCarrierBo(rs.getString(index++));
    data.setItemGroup(rs.getString(index++));
    data.setStateName(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setRunUser(rs.getString(index++));
    data.setComments(rs.getString(index++));
    data.setFlag(rs.getString(index++));
    data.setRequestid(rs.getString(index++));

    return data;
  }
}
