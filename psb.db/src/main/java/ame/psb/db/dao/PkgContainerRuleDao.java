package ame.psb.db.dao;

import ame.psb.db.PkgContainerRule;
import ame.psb.db.ViewPkgContainerRule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgContainerRuleDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_container_rule(item_group_bo,operation_bo,item_level,updated_user,updated_time,pkg_limit_tag_bo) VALUES (?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_container_rule SET item_level=?,updated_user=?,updated_time=? ,pkg_limit_tag_bo = ? WHERE item_group_bo=? AND operation_bo=?";

  private static final String SQL_UPDBYPK = "UPDATE zd_pkg_container_rule SET item_level=?,updated_user=?,updated_time=? ,pkg_limit_tag_bo = ? WHERE item_group_bo=? AND operation_bo=? and item_level =? and pkg_limit_tag_bo =?  ";

  private static final String SQL_SEL = "SELECT item_group_bo,operation_bo,site,item_level,updated_user,updated_time,item_group,item_group_description,operation,pkg_limit_tag_bo FROM view_pkg_container_rule ";

  private static final String SQL_SEL_OPERATION_DEF = "SELECT item_group_bo,operation_bo,site,item_level,updated_user,updated_time,item_group,item_group_description,value,pkg_limit_tag_bo FROM VIEW_PKG_CONTAINER_RULE_OPERATION_DEF ";


  private final Connection conn;

  public PkgContainerRuleDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgContainerRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {

      //先删除为空项
      PreparedStatement ps1 = this.conn.prepareStatement(
          "DELETE FROM zd_pkg_container_rule WHERE item_group_bo=? AND operation_bo=? and pkg_limit_tag_bo is null");
      ps1.setString(1, data.getItemGroupBo());
      ps1.setString(2, data.getOperationBo());
      ps1.executeUpdate();

      PreparedStatement ps2 = this.conn.prepareStatement(
          "DELETE FROM zd_pkg_container_rule WHERE item_group_bo=? AND operation_bo=? and pkg_limit_tag_bo = ''");
      ps2.setString(1, data.getItemGroupBo());
      ps2.setString(2, data.getOperationBo());
      ps2.executeUpdate();

      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getItemLevel());
      ps.setString(4, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 5, data.getUpdatedTime());
      ps.setString(6, data.getPkgLimitTagBo());
      return ps.executeUpdate();
    }
  }

  public int update(PkgContainerRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemLevel());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getPkgLimitTagBo());
      ps.setString(5, data.getItemGroupBo());
      ps.setString(6, data.getOperationBo());
      return ps.executeUpdate();
    }
  }


  public int updateByPK(PkgContainerRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPDBYPK)) {
      ps.setString(1, data.getItemLevel());
      ps.setString(2, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 3, data.getUpdatedTime());
      ps.setString(4, data.getPkgLimitTagBo());
      ps.setString(5, data.getItemGroupBo());
      ps.setString(6, data.getOperationBo());
      ps.setString(7, data.getItemLevel());
      ps.setString(8, data.getPkgLimitTagBo());
      return ps.executeUpdate();
    }
  }


  public int delete(String itemGroupBo, String operationBo, String pkg_limit_tag_bo)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_pkg_container_rule WHERE item_group_bo=? AND operation_bo=? and pkg_limit_tag_bo =?")) {

      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, pkg_limit_tag_bo);

      //先删除为空项
      PreparedStatement ps1 = this.conn.prepareStatement(
          "DELETE FROM zd_pkg_container_rule WHERE item_group_bo=? AND operation_bo=? and pkg_limit_tag_bo is null");
      ps1.setString(1, itemGroupBo);
      ps1.setString(2, operationBo);
      ps1.executeUpdate();

      PreparedStatement ps2 = this.conn.prepareStatement(
          "DELETE FROM zd_pkg_container_rule WHERE item_group_bo=? AND operation_bo=? and pkg_limit_tag_bo = ''");
      ps2.setString(1, itemGroupBo);
      ps2.setString(2, operationBo);
      ps2.executeUpdate();

      return ps.executeUpdate();
    }
  }

  public int deleteByDevice(String item) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pkg_container_rule WHERE item_group_bo=?")) {
      ps.setString(1, item);

      return ps.executeUpdate();
    }
  }

  public ViewPkgContainerRule selectByPK(String itemGroupBo, String operationBo)
      throws SQLException {
    ViewPkgContainerRule result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND operation_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }

    return result;
  }

  public ViewPkgContainerRule selectByPKComplex(String itemGroupBo, String operationBo,
      String pkgLimitTag) throws SQLException {
    ViewPkgContainerRule result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND pkg_limit_tag_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, pkgLimitTag);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }

    return result;
  }

  public ViewPkgContainerRule selectByPKAndLevelAndTag(String itemGroupBo, String operationBo,
      String level, String pkgLimitTag) throws SQLException {
    ViewPkgContainerRule result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_group_bo=? AND operation_bo=? AND ITEM_LEVEL=? AND pkg_limit_tag_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, level);
      ps.setString(4, pkgLimitTag);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }

    return result;
  }

  public ViewPkgContainerRule selectByDeviceAndPkgLimitTag(String itemGroupBo, String operationBo,
      String pkgLimitTag) throws SQLException {
    ViewPkgContainerRule result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND pkg_limit_tag_bo=?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, operationBo);
      ps.setString(3, pkgLimitTag);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
    }

    return result;
  }

  public List<ViewPkgContainerRule> selectByDevice(String itemGroupBo) throws SQLException {
    ArrayList<ViewPkgContainerRule> result = new ArrayList<ViewPkgContainerRule>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? ORDER BY operation_bo")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerRule> selectByOperation(String operationBo) throws SQLException {
    ArrayList<ViewPkgContainerRule> result = new ArrayList<ViewPkgContainerRule>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_bo=? ORDER BY item_group_bo")) {
      ps.setString(1, operationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ViewPkgContainerRule> selectByOperationAndDevice(String operationBo, String device)
      throws SQLException {
    ArrayList<ViewPkgContainerRule> result = new ArrayList<ViewPkgContainerRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE operation_bo=? and ITEM_GROUP_BO=?  ORDER BY item_group_bo")) {
      ps.setString(1, operationBo);
      ps.setString(2, device);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerRule> selectOperationDefByItemGroupAndOperationType(
      String itemGroupBo, String type) throws SQLException {
    ArrayList<ViewPkgContainerRule> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_OPERATION_DEF + "WHERE ITEM_GROUP_BO=? and value = ?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, type);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerRule> selectAll() throws SQLException {
    ArrayList<ViewPkgContainerRule> result = new ArrayList<ViewPkgContainerRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ViewPkgContainerRule convert(ResultSet rs) throws SQLException {
    ViewPkgContainerRule data = new ViewPkgContainerRule();

    int index = 1;
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setItemLevel(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setItemGroup(rs.getString(index++));
    data.setItemGroupDescription(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setPkgLimitTagBo(rs.getString(index++));

    return data;
  }
}
