package ame.psb.db.dao;

import ame.psb.db.PkgContainerSfc;
import ame.psb.db.ViewPkgContainerSfc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgContainerSfcDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_container_sfc(container_bo,sfc_bo,good_bad,grades,die_qty,customer_item_name,good_die,bad_die1,bad_die2,packing_time) VALUES (?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_SEL = "SELECT container_bo,sfc_bo,good_bad,grades,die_qty,customer_item_name,item_bo,item_group_bo,operation_bo,item_level,packing_plan_bo,container_good_bad,container_type,good_die,bad_die1,bad_die2,packing_time FROM view_pkg_container_sfc ";

  private static final String SQL_SEL_CONTAINER = "SELECT container_bo FROM zr_pkg_container_sfc ";


  private final Connection conn;

  public PkgContainerSfcDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgContainerSfc data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getContainerBo());
      ps.setString(2, data.getSfcBo());
      ps.setString(3, data.getGoodBad());
      ps.setString(4, data.getGrades());
      ps.setInt(5, data.getDieQty());
      ps.setString(6, data.getCustomerItemName());
      ps.setInt(7, data.getGoodDie());
      ps.setInt(8, data.getBadDie1());
      ps.setInt(9, data.getBadDie2());

      // insert current time
      /*
       *
       * add by link hero
       * add time : 2019-06-011
       *
       * */
      DateUtils.setDate(ps, 10, new Date());

      return ps.executeUpdate();
    }
  }

  public int deleteByContainer(String containerBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_container_sfc WHERE container_bo=?")) {
      ps.setString(1, containerBo);
      return ps.executeUpdate();
    }
  }

  public List<ViewPkgContainerSfc> selectByContainer(String containerBo) throws SQLException {
    ArrayList<ViewPkgContainerSfc> result = new ArrayList<ViewPkgContainerSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? ORDER BY CREATED_DATE_TIME")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerSfc> selectByContainerOrderByItem(String containerBo)
      throws SQLException {
    ArrayList<ViewPkgContainerSfc> result = new ArrayList<ViewPkgContainerSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? ORDER BY packing_time asc ")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewPkgContainerSfc selectMainItemByContainer(String containerBo)
      throws SQLException {
    ViewPkgContainerSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? ORDER BY packing_time asc ")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewPkgContainerSfc> selectByContainerAndGrade(String containerBo, String grade)
      throws SQLException {
    ArrayList<ViewPkgContainerSfc> result = new ArrayList<ViewPkgContainerSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE container_bo=? and grades = ? ORDER BY CREATED_DATE_TIME")) {
      ps.setString(1, containerBo);
      ps.setString(2, grade);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  //order by created_date_time
  public List<ViewPkgContainerSfc> selectByContainerOrderByCreatedTime(String containerBo)
      throws SQLException {
    ArrayList<ViewPkgContainerSfc> result = new ArrayList<ViewPkgContainerSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? ORDER BY created_date_time")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewPkgContainerSfc selectByPK(String conatinerBo, String sfcBo) throws SQLException {
    ViewPkgContainerSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? AND sfc_bo=?")) {
      ps.setString(1, conatinerBo);
      ps.setString(2, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public String selectByWafers(String wafers) throws SQLException {
    String containerBo = "";
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_CONTAINER + "WHERE CUSTOMER_ITEM_NAME in ( " + wafers
            + " )  GROUP BY CONTAINER_BO HAVING count(1) > 1")) {
      // ps.setString(1,  wafers);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        containerBo = rs.getString(1);
      }
      return containerBo;
    }
  }

  public String selectContainerBySfc(String sfcStr) throws SQLException {
    String containerBo = "";
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL_CONTAINER + "WHERE SFC_BO like ? AND DIE_QTY = 200 ")) {
      ps.setString(1, sfcStr + "%");
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        containerBo = rs.getString(1);
      }
      return containerBo;
    }
  }

  public ArrayList<ViewPkgContainerSfc> selectByWafersAndQtys(String wafers, String qtys)
      throws SQLException {
    ArrayList<ViewPkgContainerSfc> result = new ArrayList<>();

    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE CUSTOMER_ITEM_NAME IN (" + wafers + ") AND DIE_QTY IN (" + qtys + ") ")) {
      // ps.setString(1,  wafers);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerSfc> selectByWafer(String waferId) throws SQLException {
    ArrayList<ViewPkgContainerSfc> result = new ArrayList<ViewPkgContainerSfc>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE customer_item_name=? ORDER BY created_date_time")) {
      ps.setString(1, waferId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerSfc> selectByWaferAndContainers(String waferId, String containers)
      throws SQLException {
    ArrayList<ViewPkgContainerSfc> result = new ArrayList<ViewPkgContainerSfc>();

    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE customer_item_name=? and container_bo in (" + containers
            + ") ORDER BY packing_time ")) {
      //containers = "(" + containers +")";
      ps.setString(1, waferId);
      //ps.setString(2, containers);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewPkgContainerSfc selectBySfc(String sfcBo) throws SQLException {
    ViewPkgContainerSfc result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo=?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ViewPkgContainerSfc selectGoodBySfc(String sfcBo) throws SQLException {
    ViewPkgContainerSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? and good_bad = 'G'")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * cc
   * 不良品container
   * */
  public ViewPkgContainerSfc selectBySfc2(String sfcBo) throws SQLException {
    ViewPkgContainerSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo=? and good_bad = 'B'")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public ViewPkgContainerSfc selectBysfcWaferList(String sfcBo, String wafer) throws SQLException {
    ViewPkgContainerSfc result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc_bo = ? and customer_item_name = ?")) {
      ps.setString(1, sfcBo);
      ps.setString(2, wafer);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ViewPkgContainerSfc> selectByAmbiguousSfc(String sfcBo) throws SQLException {
    ArrayList<ViewPkgContainerSfc> result = new ArrayList<ViewPkgContainerSfc>();
    sfcBo = "%" + sfcBo + "%";
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo like ?")) {
      ps.setString(1, sfcBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ViewPkgContainerSfc> selectBySfcForJump(String sfcBo) throws SQLException {
    ArrayList<ViewPkgContainerSfc> result = new ArrayList<ViewPkgContainerSfc>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE sfc_bo like ?")) {
      ps.setString(1, sfcBo + "%");
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  private ViewPkgContainerSfc convert(ResultSet rs) throws SQLException {
    ViewPkgContainerSfc data = new ViewPkgContainerSfc();

    int index = 1;
    data.setContainerBo(rs.getString(index++));
    data.setSfcBo(rs.getString(index++));
    data.setGoodBad(rs.getString(index++));
    data.setGrades(rs.getString(index++));
    data.setDieQty(rs.getInt(index++));
    data.setCustomerItemName(rs.getString(index++));
    data.setItemBo(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setItemLevel(rs.getString(index++));
    data.setPackingPlanBo(rs.getString(index++));
    data.setContainerGoodBad(rs.getString(index++));
    data.setContainerType(rs.getString(index++));
    data.setGoodDie(rs.getInt(index++));
    data.setBadDie1(rs.getInt(index++));
    data.setBadDie2(rs.getInt(index++));
    data.setCreatedTime(rs.getTimestamp(index++));

    return data;
  }
}
