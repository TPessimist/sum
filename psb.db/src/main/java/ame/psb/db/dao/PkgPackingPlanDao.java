package ame.psb.db.dao;

import ame.psb.db.PkgPackingPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgPackingPlanDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_packing_plan(id,item_group_bo,operation_bo,packing_type,good_bad,good_types,bad_types,max_qty,good_bad_type_ref,prev_operation_bo,state,updated_user,updated_time,min_qty) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_packing_plan SET item_group_bo=?,operation_bo=?,packing_type=?,good_bad=?,good_types=?,bad_types=?,max_qty=?,good_bad_type_ref=?,prev_operation_bo=?,state=?,updated_user=?,updated_time=?,min_qty=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,item_group_bo,operation_bo,packing_type,good_bad,good_types,bad_types,max_qty,good_bad_type_ref,prev_operation_bo,state,updated_user,updated_time,min_qty FROM zd_pkg_packing_plan ";

  private final Connection conn;

  public PkgPackingPlanDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgPackingPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getItemGroupBo());
      ps.setString(3, data.getOperationBo());
      ps.setString(4, data.getPackingType());
      ps.setString(5, data.getGoodBad());
      ps.setString(6, data.getGoodTypes());
      ps.setString(7, data.getBadTypes());
      ps.setInt(8, data.getMaxQty());
      ps.setString(9, data.getGoodBadTypeRef());
      ps.setString(10, data.getPrevOperationBo());
      ps.setString(11, data.getState());
      ps.setString(12, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 13, data.getUpdatedTime());
      ps.setInt(14, data.getMinQty());

      return ps.executeUpdate();
    }
  }

  public int update(PkgPackingPlan data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemGroupBo());
      ps.setString(2, data.getOperationBo());
      ps.setString(3, data.getPackingType());
      ps.setString(4, data.getGoodBad());
      ps.setString(5, data.getGoodTypes());
      ps.setString(6, data.getBadTypes());
      ps.setInt(7, data.getMaxQty());
      ps.setString(8, data.getGoodBadTypeRef());
      ps.setString(9, data.getPrevOperationBo());
      ps.setString(10, data.getState());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());
      ps.setInt(13, data.getMinQty());
      ps.setString(14, data.getId());

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pkg_packing_plan WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByItem(String item) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pkg_packing_plan WHERE item_group_bo=?")) {
      ps.setString(1, item);

      return ps.executeUpdate();
    }
  }

  public int invalid(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_pkg_packing_plan SET STATE = 'N' WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<PkgPackingPlan> selectAll() throws SQLException {
    ArrayList<PkgPackingPlan> result = new ArrayList<PkgPackingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgPackingPlan> selectByOperation(String currOperationBo) throws SQLException {
    ArrayList<PkgPackingPlan> result = new ArrayList<PkgPackingPlan>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE operation_bo=? AND STATE='Y' ORDER BY id")) {
      ps.setString(1, currOperationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgPackingPlan> selectByItem(String item) throws SQLException {
    ArrayList<PkgPackingPlan> result = new ArrayList<PkgPackingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_group_bo=?")) {
      ps.setString(1, item);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgPackingPlan> selectByOperation(String itemGroupBo, String currOperationBo)
      throws SQLException {
    ArrayList<PkgPackingPlan> result = new ArrayList<PkgPackingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND STATE='Y' ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, currOperationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgPackingPlan> selectByDeOp(String itemGroupBo, String currOperationBo)
      throws SQLException {
    ArrayList<PkgPackingPlan> result = new ArrayList<PkgPackingPlan>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? ORDER BY state")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, currOperationBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgPackingPlan> selectByDevice(String itemGroupBo, String packingType)
      throws SQLException {
    ArrayList<PkgPackingPlan> result = new ArrayList<PkgPackingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND packing_type=? AND STATE='Y' ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, packingType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgPackingPlan> selectByDevice(String itemGroupBo)
      throws SQLException {
    ArrayList<PkgPackingPlan> result = new ArrayList<PkgPackingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND STATE='Y' ORDER BY id")) {
      ps.setString(1, itemGroupBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgPackingPlan> selectByOperation(String itemGroupBo, String currOperationBo,
      String prevOperatoinBo) throws SQLException {
    ArrayList<PkgPackingPlan> result = new ArrayList<PkgPackingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_group_bo=? AND operation_bo=? AND prev_operation_bo=? AND STATE='Y' ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, currOperationBo);
      ps.setString(3, prevOperatoinBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgPackingPlan> selectByPackingType(String itemGroupBo, String currOperationBo,
      String packingType) throws SQLException {
    ArrayList<PkgPackingPlan> result = new ArrayList<PkgPackingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_group_bo=? AND operation_bo=? AND packing_type=? AND STATE='Y' ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, currOperationBo);
      ps.setString(3, packingType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<PkgPackingPlan> selectByPackingType(String itemGroupBo, String packingType)
      throws SQLException {
    ArrayList<PkgPackingPlan> result = new ArrayList<PkgPackingPlan>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=?  AND packing_type=? AND STATE='Y' ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, packingType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgPackingPlan selectByItemGroupAndTypeAndGB(String itemGroupBo, String packingType,
      String gb) throws SQLException {
    PkgPackingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_group_bo=?  AND packing_type=? and good_bad = ? AND STATE='Y' ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, packingType);
      ps.setString(3, gb);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public PkgPackingPlan selectByItemGroupAndTypeAndGBAndE(String itemGroupBo, String packingType,
      String gb) throws SQLException {
    PkgPackingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_group_bo=?  AND packing_type=? and good_bad = ?  AND bad_types = 'E' AND STATE='Y' ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, packingType);
      ps.setString(3, gb);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgPackingPlan selectById(String id) throws SQLException {
    PkgPackingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id = ?")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public PkgPackingPlan selectByPackingGrade(String itemGroupBo, String currOperationBo,
      String grade) throws SQLException {
    PkgPackingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_group_bo=? AND operation_bo=? AND good_types = ? AND STATE='Y' ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, currOperationBo);
      ps.setString(3, grade);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgPackingPlan selectByPackingBGrade(String itemGroupBo, String currOperationBo,
      String grade) throws SQLException {
    PkgPackingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "WHERE item_group_bo=? AND operation_bo=? AND bad_types = ? AND STATE='Y' ORDER BY id")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, currOperationBo);
      ps.setString(3, grade);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgPackingPlan selectByGBPackingGrade(String itemGroupBo, String currOperationBo,
      String grade) throws SQLException {
    PkgPackingPlan result1 = selectByPackingGrade(itemGroupBo, currOperationBo, grade);
    PkgPackingPlan result2 = selectByPackingBGrade(itemGroupBo, currOperationBo, grade);
    PkgPackingPlan result = null == result1 ? result2 : result1;
    return result;
  }


  public PkgPackingPlan selectOneBySfcPacking(String itemGroupBo, String currOperationBo,
      String goodBad) throws SQLException {
    PkgPackingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE item_group_bo=? AND operation_bo=? AND good_bad like ? AND STATE='Y'")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, currOperationBo);
      ps.setString(3, "%" + goodBad + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgPackingPlan selectByPK(String id) throws SQLException {
    PkgPackingPlan result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgPackingPlan convert(ResultSet rs) throws SQLException {
    PkgPackingPlan data = new PkgPackingPlan();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setItemGroupBo(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setPackingType(rs.getString(index++));
    data.setGoodBad(rs.getString(index++));
    data.setGoodTypes(rs.getString(index++));
    data.setBadTypes(rs.getString(index++));
    data.setMaxQty(rs.getInt(index++));
    data.setGoodBadTypeRef(rs.getString(index++));
    data.setPrevOperationBo(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setMinQty(rs.getInt(index++));

    return data;
  }
}
