package ame.psb.db.dao;

import ame.psb.db.PkgContainerLabelRule;
import ame.psb.db.ViewPkgContainerLabelRule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgContainerLabelRuleDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_container_label_rule(id,item_group_bo,operation_bo,packing_type,packing_plan,customer_of_customer,print_qty,label_bo,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_container_label_rule SET item_group_bo=?,operation_bo=?,packing_type=?,packing_plan=?,customer_of_customer=?,print_qty=?,label_bo=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_group_bo,operation_bo,packing_type,packing_plan,customer_of_customer,print_qty,label_bo,updated_user,updated_time,label_name,printer_id,template_id,item_group,item_group_description,operation FROM view_pkg_container_label_rule ";

  private final Connection conn;

  public PkgContainerLabelRuleDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgContainerLabelRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getPackingType());
      ps.setString(5, data.getPackingPlan());
      ps.setString(6, data.getCustomerOfCustomer());
      ps.setBigDecimal(7, data.getPrintQty());
      ps.setString(8, data.getLabelBo());
      ps.setString(9, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 10, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int update(PkgContainerLabelRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getPackingType());
      ps.setString(4, data.getPackingPlan());
      ps.setString(5, data.getCustomerOfCustomer());
      ps.setBigDecimal(6, data.getPrintQty());
      ps.setString(7, data.getLabelBo());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());
      ps.setString(10, data.getId());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pkg_container_label_rule WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByDevice(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pkg_container_label_rule WHERE item_group_bo=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public ViewPkgContainerLabelRule selectByPK(String id) throws SQLException {
    ViewPkgContainerLabelRule result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewPkgContainerLabelRule> selectAll() throws SQLException {
    ArrayList<ViewPkgContainerLabelRule> result = new ArrayList<ViewPkgContainerLabelRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "ORDER BY id")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerLabelRule> selectByItemGroup(String itemGroupBo) throws SQLException {
    ArrayList<ViewPkgContainerLabelRule> result = new ArrayList<ViewPkgContainerLabelRule>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? ORDER BY id")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerLabelRule> selectByItemGroup2(String itemGroup) throws SQLException {
    ArrayList<ViewPkgContainerLabelRule> result = new ArrayList<ViewPkgContainerLabelRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_group_bo=?")) {
      ps.setString(1, itemGroup);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerLabelRule> select(String itemGroupBo, String operationBo,
      String packingPlanBo) throws SQLException {
    ArrayList<ViewPkgContainerLabelRule> result = new ArrayList<ViewPkgContainerLabelRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND packing_plan=? ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, packingPlanBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewPkgContainerLabelRule selectByLabel(String itemGroupBo, String operationBo,
      String packingPlanBo, String labelBo) throws SQLException { //通过模板名获取记录 xf20210121add
    ViewPkgContainerLabelRule result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_group_bo=? AND operation_bo=? AND packing_plan=? AND label_bo=? ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, packingPlanBo);
      ps.setString(4, labelBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public List<ViewPkgContainerLabelRule> select(String itemGroupBo, String packingPlanBo)
      throws SQLException {
    ArrayList<ViewPkgContainerLabelRule> result = new ArrayList<ViewPkgContainerLabelRule>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=?  AND packing_plan=? ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, packingPlanBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  /**
   * ykq 2020-8-11 09点38分
   *
   * @param labelBo
   * @return
   * @throws SQLException
   */
  public List<ViewPkgContainerLabelRule> selectBylabelBo(String labelBo) throws SQLException {
    ArrayList<ViewPkgContainerLabelRule> result = new ArrayList<ViewPkgContainerLabelRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE LABEL_BO = ? ")) {
      ps.setString(1, labelBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private ViewPkgContainerLabelRule convert(ResultSet rs) throws SQLException {
    ViewPkgContainerLabelRule data = new ViewPkgContainerLabelRule();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setPackingType(rs.getString(index++));
    data.setPackingPlan(rs.getString(index++));
    data.setCustomerOfCustomer(rs.getString(index++));
    data.setPrintQty(rs.getBigDecimal(index++));
    data.setLabelBo(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    data.setLabelName(rs.getString(index++));
    data.setPrinterId(rs.getString(index++));
    data.setTemplateId(rs.getString(index++));
    data.setItemGroup(rs.getString(index++));
    data.setItemGroupDescription(rs.getString(index++));
    data.setOperation(rs.getString(index++));

    return data;
  }
}
