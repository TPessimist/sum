package ame.psb.db.dao;

import ame.psb.db.ProductMapDef;
import ame.psb.db.ViewProductMapDef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class ProductMapDefDao {

  private static final String SQL_INS = "INSERT INTO zd_prod_map_def(id,device_bo,item_bo,incoming_map_exists,incoming_map_count,incoming_map_rule_bo,golden_map_rule_bo,cp_map_rule_bo,out_going_map_rule_bo,incoming_defect_filter,alignment_filter,golden_map_rule_tmpl,cp_map_rule_tmpl,out_going_map_rule_tmpl,golden_map_file_name,out_going_map_file_name,updated_user,updated_time,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_prod_map_def SET device_bo=?,item_bo=?,incoming_map_exists=?,incoming_map_count=?,incoming_map_rule_bo=?,golden_map_rule_bo=?,cp_map_rule_bo=?,out_going_map_rule_bo=?,incoming_defect_filter=?,alignment_filter=?,golden_map_rule_tmpl=?,cp_map_rule_tmpl=?,out_going_map_rule_tmpl=?,golden_map_file_name=?,out_going_map_file_name=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,device_bo,item_bo,incoming_map_exists,incoming_map_count,incoming_map_rule_bo,golden_map_rule_bo,cp_map_rule_bo,out_going_map_rule_bo,incoming_defect_filter,alignment_filter,golden_map_rule_tmpl,cp_map_rule_tmpl,out_going_map_rule_tmpl,golden_map_file_name,out_going_map_file_name,device_name,item_name,item_description,updated_user,updated_time,status FROM view_prod_map_def ";

  private final Connection conn;

  public ProductMapDefDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ProductMapDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getDeviceBo());
      ps.setString(3, data.getItemBo());
      ps.setString(4, data.getIncomingMapExists());
      if (data.getIncomingMapCount() != null && data.getIncomingMapCount() > 0) {
        ps.setInt(5, data.getIncomingMapCount());
      } else {
        ps.setNull(5, Types.INTEGER);
      }
      ps.setString(6, data.getIncomingMapRuleBo());
      ps.setString(7, data.getGoldenMapRuleBo());
      ps.setString(8, data.getCpMapRuleBo());
      ps.setString(9, data.getOutGoingMapRuleBo());
      ps.setString(10, data.getIncomingDefectFilter());
      ps.setString(11, data.getAlignmentFilter());
      ps.setString(12, data.getGoldenMapRuleTmpl());
      ps.setString(13, data.getCpMapRuleTmpl());
      ps.setString(14, data.getOutGoingMapRuleTmpl());
      ps.setString(15, data.getGoldenMapFileName());
      ps.setString(16, data.getOutGoingMapFileName());
      ps.setString(17, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 18, data.getUpdatedTime());
      ps.setString(19, data.getStatus());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ProductMapDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ProductMapDef data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getDeviceBo());
        ps.setString(3, data.getItemBo());
        ps.setString(4, data.getIncomingMapExists());
        if (data.getIncomingMapCount() != null && data.getIncomingMapCount() > 0) {
          ps.setInt(5, data.getIncomingMapCount());
        } else {
          ps.setNull(5, Types.INTEGER);
        }
        ps.setString(6, data.getIncomingMapRuleBo());
        ps.setString(7, data.getGoldenMapRuleBo());
        ps.setString(8, data.getCpMapRuleBo());
        ps.setString(9, data.getOutGoingMapRuleBo());
        ps.setString(10, data.getIncomingDefectFilter());
        ps.setString(11, data.getAlignmentFilter());
        ps.setString(12, data.getGoldenMapRuleTmpl());
        ps.setString(13, data.getCpMapRuleTmpl());
        ps.setString(14, data.getOutGoingMapRuleTmpl());
        ps.setString(15, data.getGoldenMapFileName());
        ps.setString(16, data.getOutGoingMapFileName());
        ps.setString(17, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 18, data.getUpdatedTime());
        ps.setString(19, data.getStatus());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ProductMapDef data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDeviceBo());
      ps.setString(2, data.getItemBo());
      ps.setString(3, data.getIncomingMapExists());
      if (data.getIncomingMapCount() != null && data.getIncomingMapCount() > 0) {
        ps.setInt(4, data.getIncomingMapCount());
      } else {
        ps.setNull(4, Types.INTEGER);
      }
      ps.setString(5, data.getIncomingMapRuleBo());
      ps.setString(6, data.getGoldenMapRuleBo());
      ps.setString(7, data.getCpMapRuleBo());
      ps.setString(8, data.getOutGoingMapRuleBo());
      ps.setString(9, data.getIncomingDefectFilter());
      ps.setString(10, data.getAlignmentFilter());
      ps.setString(11, data.getGoldenMapRuleTmpl());
      ps.setString(12, data.getCpMapRuleTmpl());
      ps.setString(13, data.getOutGoingMapRuleTmpl());
      ps.setString(14, data.getGoldenMapFileName());
      ps.setString(15, data.getOutGoingMapFileName());
      ps.setString(16, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 17, data.getUpdatedTime());
      ps.setString(18, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ProductMapDef> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ProductMapDef data : dataList) {
        ps.setString(1, data.getDeviceBo());
        ps.setString(2, data.getItemBo());
        ps.setString(3, data.getIncomingMapExists());
        if (data.getIncomingMapCount() != null && data.getIncomingMapCount() > 0) {
          ps.setInt(4, data.getIncomingMapCount());
        } else {
          ps.setNull(4, Types.INTEGER);
        }
        ps.setString(5, data.getIncomingMapRuleBo());
        ps.setString(6, data.getGoldenMapRuleBo());
        ps.setString(7, data.getCpMapRuleBo());
        ps.setString(8, data.getOutGoingMapRuleBo());
        ps.setString(9, data.getIncomingDefectFilter());
        ps.setString(10, data.getAlignmentFilter());
        ps.setString(11, data.getGoldenMapRuleTmpl());
        ps.setString(12, data.getCpMapRuleTmpl());
        ps.setString(13, data.getOutGoingMapRuleTmpl());
        ps.setString(14, data.getGoldenMapFileName());
        ps.setString(15, data.getOutGoingMapFileName());
        ps.setString(16, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 17, data.getUpdatedTime());
        ps.setString(18, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_prod_map_def WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByDevice(String deviceBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_prod_map_def WHERE device_bo=?")) {
      ps.setString(1, deviceBo);

      return ps.executeUpdate();
    }
  }

  public int virtualDelete(String id, String user) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_prod_map_def SET status='D',updated_time=?,updated_user=? WHERE id=?")) {
      DateUtils.setDateTz(ps, 1, new Date());
      ps.setString(2, user);
      ps.setString(3, id);

      return ps.executeUpdate();
    }
  }

  public List<ViewProductMapDef> selectAll() throws SQLException {
    ArrayList<ViewProductMapDef> result = new ArrayList<ViewProductMapDef>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewProductMapDef selectByPK(String id) throws SQLException {
    ViewProductMapDef result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? and status<>'D'")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewProductMapDef> selectByGolden(String goldenRuleName) throws SQLException {
    List<ViewProductMapDef> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE GOLDEN_MAP_RULE_BO = ? and status<>'D'")) {
      ps.setString(1, goldenRuleName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewProductMapDef selectByPK(String id, boolean containsDeleted) throws SQLException {
    ViewProductMapDef result = null;
    String sql = SQL_SEL + "WHERE id=?";
    if (!containsDeleted) {
      sql += "AND status<>'D'";
    }
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {

      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewProductMapDef selectByDevice(String deviceBo) throws SQLException {
    ViewProductMapDef result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE device_bo=? and status<>'D'")) {
      ps.setString(1, deviceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewProductMapDef selectByItem(String itemBo) throws SQLException {
    ViewProductMapDef result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_bo=? and status<>'D'")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewProductMapDef selectByDeviceIgnoreSatus(String deviceBo) throws SQLException {
    ViewProductMapDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE device_bo=? ")) {
      ps.setString(1, deviceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewProductMapDef selectByItemIgnoreSatus(String itemBo) throws SQLException {
    ViewProductMapDef result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_bo=? ")) {
      ps.setString(1, itemBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewProductMapDef convert(ResultSet rs) throws SQLException {
    ViewProductMapDef data = new ViewProductMapDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setIncomingMapExists(rs.getString(index++));
    data.setIncomingMapCount(rs.getInt(index++));
    data.setIncomingMapRuleBo(rs.getString(index++));
    data.setGoldenMapRuleBo(rs.getString(index++));
    data.setCpMapRuleBo(rs.getString(index++));
    data.setOutGoingMapRuleBo(rs.getString(index++));
    data.setIncomingDefectFilter(rs.getString(index++));
    data.setAlignmentFilter(rs.getString(index++));
    data.setGoldenMapRuleTmpl(rs.getString(index++));
    data.setCpMapRuleTmpl(rs.getString(index++));
    data.setOutGoingMapRuleTmpl(rs.getString(index++));
    data.setGoldenMapFileName(rs.getString(index++));
    data.setOutGoingMapFileName(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setItemDescription(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    //data.setUpdatedTime(rs.getTimestamp(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setStatus(rs.getString(index++));

    return data;
  }

  private ProductMapDef convertProductMapDef(ResultSet rs) throws SQLException {
    ProductMapDef data = new ProductMapDef();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setIncomingMapExists(rs.getString(index++));
    data.setIncomingMapCount(rs.getInt(index++));
    data.setIncomingMapRuleBo(rs.getString(index++));
    data.setGoldenMapRuleBo(rs.getString(index++));
    data.setCpMapRuleBo(rs.getString(index++));
    data.setOutGoingMapRuleBo(rs.getString(index++));
    data.setIncomingDefectFilter(rs.getString(index++));
    data.setAlignmentFilter(rs.getString(index++));
    data.setGoldenMapRuleTmpl(rs.getString(index++));
    data.setCpMapRuleTmpl(rs.getString(index++));
    data.setOutGoingMapRuleTmpl(rs.getString(index++));
    data.setGoldenMapFileName(rs.getString(index++));
    data.setOutGoingMapFileName(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    //data.setUpdatedTime(rs.getTimestamp(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setStatus(rs.getString(index++));

    return data;
  }

  public int selectCountByItemGroup(String itemGroupBoTo) throws SQLException {
    String selSql = "select count(1) from zd_prod_map_def where device_bo = ?";
    int count = 0;
    try (PreparedStatement ps = this.conn.prepareStatement(selSql)) {
      ps.setString(1, itemGroupBoTo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        count = rs.getInt(1);
      }
      return count;
    }
  }


  public ProductMapDef select(Where where) throws SQLException {
    String sql = "SELECT id,device_bo,item_bo,incoming_map_exists,incoming_map_count,incoming_map_rule_bo,golden_map_rule_bo,cp_map_rule_bo,out_going_map_rule_bo,incoming_defect_filter,alignment_filter,golden_map_rule_tmpl,cp_map_rule_tmpl,out_going_map_rule_tmpl, golden_map_file_name,out_going_map_file_name, updated_user,updated_time,status FROM zd_prod_map_def ";
    ProductMapDef result = null;
    try (PreparedStatement ps = where.prepareStatement(this.conn, sql)) {

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convertProductMapDef(rs);
      }
      return result;
    }
  }
}