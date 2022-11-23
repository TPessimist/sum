package ame.psb.db.dao;

import ame.psb.db.LabelInfoMaterialBindingDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LabelInfoMaterialBindingDetailDao {

  private static final String SQL_INS = "INSERT INTO zr_labelinfo_material_binding_detail(material_customer_itemset,statename,processcardrecipe,resource,reelid,updated_user,updated_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_labelinfo_material_binding_detail SET processcardrecipe=?,resource=?,updated_user=?,updated_time=? WHERE material_customer_itemset=? AND statename=? AND reelid=?";

  private static final String SQL_SEL = "SELECT material_customer_itemset,statename,processcardrecipe,resource,reelid,updated_user,updated_time FROM zr_labelinfo_material_binding_detail ";

  private final Connection conn;

  public LabelInfoMaterialBindingDetailDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(LabelInfoMaterialBindingDetail data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getMaterialCustomerItemset());
      ps.setString(2, data.getStatename());
      ps.setString(3, data.getProcesscardrecipe());
      ps.setString(4, data.getResource());
      ps.setString(5, data.getReelid());
      ps.setString(6, data.getUpdatedUser());
      ps.setTimestamp(7, new Timestamp(data.getUpdatedTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int insert(List<LabelInfoMaterialBindingDetail> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (LabelInfoMaterialBindingDetail data : dataList) {
        ps.setString(1, data.getMaterialCustomerItemset());
        ps.setString(2, data.getStatename());
        ps.setString(3, data.getProcesscardrecipe());
        ps.setString(4, data.getResource());
        ps.setString(5, data.getReelid());
        ps.setString(6, data.getUpdatedUser());
        ps.setTimestamp(7, new Timestamp(data.getUpdatedTime().getTime()));

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(LabelInfoMaterialBindingDetail data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getProcesscardrecipe());
      ps.setString(2, data.getResource());
      ps.setString(3, data.getUpdatedUser());
      ps.setTimestamp(4, new Timestamp(data.getUpdatedTime().getTime()));
      ps.setString(5, data.getMaterialCustomerItemset());
      ps.setString(6, data.getStatename());
      ps.setString(7, data.getReelid());

      return ps.executeUpdate();
    }
  }

  public int update(List<LabelInfoMaterialBindingDetail> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (LabelInfoMaterialBindingDetail data : dataList) {
        ps.setString(1, data.getProcesscardrecipe());
        ps.setString(2, data.getResource());
        ps.setString(3, data.getUpdatedUser());
        ps.setTimestamp(4, new Timestamp(data.getUpdatedTime().getTime()));
        ps.setString(5, data.getMaterialCustomerItemset());
        ps.setString(6, data.getStatename());
        ps.setString(7, data.getReelid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String materialCustomerItemset, String statename, String reelid)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zr_labelinfo_material_binding_detail WHERE material_customer_itemset=? AND statename=? AND reelid=?")) {
      ps.setString(1, materialCustomerItemset);
      ps.setString(2, statename);
      ps.setString(3, reelid);

      return ps.executeUpdate();
    }
  }

  public List<LabelInfoMaterialBindingDetail> selectAll() throws SQLException {
    ArrayList<LabelInfoMaterialBindingDetail> result = new ArrayList<LabelInfoMaterialBindingDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<LabelInfoMaterialBindingDetail> selectByStateAndMaterial(
      String materialCustomerItemset, String statename) throws SQLException {
    ArrayList<LabelInfoMaterialBindingDetail> result = new ArrayList<LabelInfoMaterialBindingDetail>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE material_customer_itemset=? AND statename=? ")) {
      ps.setString(1, materialCustomerItemset);
      ps.setString(2, statename);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<LabelInfoMaterialBindingDetail> selectBySfc(String sfc) throws SQLException {
    ArrayList<LabelInfoMaterialBindingDetail> result = new ArrayList<LabelInfoMaterialBindingDetail>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE reelid like ? ")) {
      ps.setString(1, "%" + sfc + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public LabelInfoMaterialBindingDetail selectByPK(String materialCustomerItemset, String statename,
      String reelid) throws SQLException {
    LabelInfoMaterialBindingDetail result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE material_customer_itemset=? AND statename=? AND reelid=?")) {
      ps.setString(1, materialCustomerItemset);
      ps.setString(2, statename);
      ps.setString(3, reelid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private LabelInfoMaterialBindingDetail convert(ResultSet rs) throws SQLException {
    LabelInfoMaterialBindingDetail data = new LabelInfoMaterialBindingDetail();

    int index = 1;
    data.setMaterialCustomerItemset(rs.getString(index++));
    data.setStatename(rs.getString(index++));
    data.setProcesscardrecipe(rs.getString(index++));
    data.setResource(rs.getString(index++));
    data.setReelid(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(rs.getTimestamp(index++));

    return data;
  }
}
