package ame.psb.db.dao;

import ame.psb.db.GoldenWaferResult;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class GoldenWaferResultDao {

  private static final String SQL_INS = "INSERT INTO zr_golden_wafer_result(id,resource_bo,customer_itemset_name,golden_wafer,map_result,update_user,update_time,reserve1,reserve2,effective_time,normal_customer_itemset_name) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_golden_wafer_result SET resource_bo=?,customer_itemset_name=?,golden_wafer=?,map_result=?,update_user=?,update_time=?,reserve1=?,reserve2=?,effective_time=?,normal_customer_itemset_name=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,resource_bo,customer_itemset_name,golden_wafer,map_result,update_user,update_time,reserve1,reserve2,effective_time,normal_customer_itemset_name FROM zr_golden_wafer_result ";

  private final Connection conn;

  public GoldenWaferResultDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(GoldenWaferResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getResourceBo());
      ps.setString(3, data.getCustomerItemsetName());
      ps.setString(4, data.getGoldenWafer());
      ps.setString(5, data.getMapResult());
      ps.setString(6, data.getUpdateUser());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());
      ps.setString(8, data.getReserve1());
      ps.setString(9, data.getReserve2());
      DateUtils.setDateTz(ps, 10, data.getEffectiveTime());
      ps.setString(11, data.getNormalCustomerItemsetName());

      return ps.executeUpdate();
    }
  }

  public int insert(List<GoldenWaferResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (GoldenWaferResult data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getResourceBo());
        ps.setString(3, data.getCustomerItemsetName());
        ps.setString(4, data.getGoldenWafer());
        ps.setString(5, data.getMapResult());
        ps.setString(6, data.getUpdateUser());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());
        ps.setString(8, data.getReserve1());
        ps.setString(9, data.getReserve2());
        DateUtils.setDateTz(ps, 10, data.getEffectiveTime());
        ps.setString(11, data.getNormalCustomerItemsetName());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(GoldenWaferResult data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getResourceBo());
      ps.setString(2, data.getCustomerItemsetName());
      ps.setString(3, data.getGoldenWafer());
      ps.setString(4, data.getMapResult());
      ps.setString(5, data.getUpdateUser());
      DateUtils.setDateTz(ps, 6, data.getUpdateTime());
      ps.setString(7, data.getReserve1());
      ps.setString(8, data.getReserve2());
      DateUtils.setDateTz(ps, 9, data.getEffectiveTime());
      ps.setString(10, data.getNormalCustomerItemsetName());
      ps.setString(11, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<GoldenWaferResult> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (GoldenWaferResult data : dataList) {
        ps.setString(1, data.getResourceBo());
        ps.setString(2, data.getCustomerItemsetName());
        ps.setString(3, data.getGoldenWafer());
        ps.setString(4, data.getMapResult());
        ps.setString(5, data.getUpdateUser());
        DateUtils.setDateTz(ps, 6, data.getUpdateTime());
        ps.setString(7, data.getReserve1());
        ps.setString(8, data.getReserve2());
        DateUtils.setDateTz(ps, 9, data.getEffectiveTime());
        ps.setString(10, data.getNormalCustomerItemsetName());
        ps.setString(11, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateReserve1State(String id,String reserve1) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "UPDATE zr_golden_wafer_result SET reserve1=? WHERE id=?")) {
      ps.setString(1, reserve1);
      ps.setString(2, id);

      return ps.executeUpdate();
    }
  }

  public int updateItemsetName(String id, String nomalItemsetName) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            "UPDATE zr_golden_wafer_result SET normal_customer_itemset_name=? WHERE id=?")) {
      ps.setString(1, nomalItemsetName);
      ps.setString(2, id);

      return ps.executeUpdate();
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_golden_wafer_result WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<GoldenWaferResult> selectAll() throws SQLException {
    ArrayList<GoldenWaferResult> result = new ArrayList<GoldenWaferResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public GoldenWaferResult selectByPK(String id) throws SQLException {
    GoldenWaferResult result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public GoldenWaferResult selectByResource(String resourceBo, String itemSetName,
      String goldenWafer, String reserve1) throws SQLException {
    GoldenWaferResult result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE resource_bo=? and customer_itemset_name=? and golden_wafer=? and reserve1=? order by update_time desc ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, itemSetName);
      ps.setString(3, goldenWafer);
      ps.setString(4, reserve1);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public GoldenWaferResult selectByResource(String resourceBo, String reserve1)
      throws SQLException {
    GoldenWaferResult result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + "WHERE resource_bo=? and reserve1=? order by update_time desc ")) {
      ps.setString(1, resourceBo);
      ps.setString(2, reserve1);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<GoldenWaferResult> selectByResource(String resource) throws SQLException {
    ArrayList<GoldenWaferResult> result = new ArrayList<GoldenWaferResult>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE resource_bo=? ")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private GoldenWaferResult convert(ResultSet rs) throws SQLException {
    GoldenWaferResult data = new GoldenWaferResult();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setResourceBo(rs.getString(index++));
    data.setCustomerItemsetName(rs.getString(index++)); //golden wafer的客批
    data.setGoldenWafer(rs.getString(index++));
    data.setMapResult(rs.getString(index++));
    data.setUpdateUser(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setReserve1(rs.getString(index++));
    data.setReserve2(rs.getString(index++));
    data.setEffectiveTime(DateUtils.getDateTz(rs, index++)); //有效期
    data.setNormalCustomerItemsetName(rs.getString(index++));

    return data;
  }
}
