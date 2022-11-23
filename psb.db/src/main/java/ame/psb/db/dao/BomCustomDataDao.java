package ame.psb.db.dao;

import ame.psb.db.BomCustomData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BomCustomDataDao {

  private static final String SQL_INS = "INSERT INTO zd_bom_custom_data(item_bo,attribute,bom_bo,value,created_user,created_date_time,modified_date_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_bom_custom_data SET value=?,created_user=?,created_date_time=?,modified_date_time=? WHERE item_bo=? AND attribute=? AND bom_bo=?";

  private static final String SQL_SEL = "SELECT item_bo,attribute,bom_bo,value,created_user,created_date_time,modified_date_time FROM zd_bom_custom_data ";

  private final Connection conn;

  public BomCustomDataDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BomCustomData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getItemBo());
      ps.setString(2, data.getAttribute());
      ps.setString(3, data.getBomBo());
      ps.setString(4, data.getValue());
      ps.setString(5, data.getCreatedUser());
      ps.setTimestamp(6, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(7, new Timestamp(data.getModifiedDateTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<BomCustomData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BomCustomData data : dataList) {
        ps.setString(1, data.getItemBo());
        ps.setString(2, data.getAttribute());
        ps.setString(3, data.getBomBo());
        ps.setString(4, data.getValue());
        ps.setString(5, data.getCreatedUser());
        ps.setTimestamp(6, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setTimestamp(7, new Timestamp(data.getModifiedDateTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BomCustomData data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getValue());
      ps.setString(2, data.getCreatedUser());
      ps.setTimestamp(3, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(4, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(5, data.getItemBo());
      ps.setString(6, data.getAttribute());
      ps.setString(7, data.getBomBo());

      return ps.executeUpdate();
    }
  }

  public int update(List<BomCustomData> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BomCustomData data : dataList) {
        ps.setString(1, data.getValue());
        ps.setString(2, data.getCreatedUser());
        ps.setTimestamp(3, new Timestamp(data.getCreatedDateTime().getTime()));
        ps.setTimestamp(4, new Timestamp(data.getModifiedDateTime().getTime()));
        ps.setString(5, data.getItemBo());
        ps.setString(6, data.getAttribute());
        ps.setString(7, data.getBomBo());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String itemBo, String attribute, String bomBo) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_bom_custom_data WHERE item_bo=? AND attribute=? AND bom_bo=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, attribute);
      ps.setString(3, bomBo);

      return ps.executeUpdate();
    }
  }

  public List<BomCustomData> selectAll() throws SQLException {
    ArrayList<BomCustomData> result = new ArrayList<BomCustomData>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {
      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BomCustomData selectByPK(String itemBo, String attribute, String bomBo)
      throws SQLException {
    BomCustomData result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_bo=? AND attribute=? AND bom_bo=?")) {
      ps.setString(1, itemBo);
      ps.setString(2, attribute);
      ps.setString(3, bomBo);

      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public BomCustomData selectTop1ByItem(String itemBo, String attribute) throws SQLException {
    BomCustomData result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE item_bo=? AND attribute=? ")) {
      ps.setString(1, itemBo);
      ps.setString(2, attribute);

      ps.setMaxRows(ame.psb.db.conf.Hana.getMaxRow());
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private BomCustomData convert(ResultSet rs) throws SQLException {
    BomCustomData data = new BomCustomData();

    int index = 1;
    data.setItemBo(rs.getString(index++));
    data.setAttribute(rs.getString(index++));
    data.setBomBo(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setCreatedUser(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));

    return data;
  }
}
