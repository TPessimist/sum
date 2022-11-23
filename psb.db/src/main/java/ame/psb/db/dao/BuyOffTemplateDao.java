package ame.psb.db.dao;

import ame.psb.db.BuyOffTemplate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BuyOffTemplateDao {

  private static final String SQL_INS = "INSERT INTO zd_buyoff_template_factor(id,factor_name,factor_type,custom_props,operation_bo,validator,seq,buyoff_type,role_type,by_type,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_buyoff_template_factor SET factor_name=?,factor_type=?,custom_props=?,operation_bo=?,validator=?,seq=?,buyoff_type=?,role_type=?,by_type=?,updated_user=?,updated_time=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,factor_name,factor_type,custom_props,operation_bo,validator,seq,buyoff_type,role_type,by_type,updated_user,updated_time FROM zd_buyoff_template_factor ";

  private final Connection conn;

  public BuyOffTemplateDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BuyOffTemplate data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getFactorName());
      ps.setString(3, data.getFactorType());
      ps.setString(4, data.getCustomProps());
      ps.setString(5, data.getOperationBo());
      ps.setString(6, data.getValidator());
      ps.setString(7, data.getSeq());
      ps.setString(8, data.getBuyoffType());
      ps.setString(9, data.getRoleType());
      ps.setString(10, data.getByType());
      ps.setString(11, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BuyOffTemplate> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BuyOffTemplate data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getFactorName());
        ps.setString(3, data.getFactorType());
        ps.setString(4, data.getCustomProps());
        ps.setString(5, data.getOperationBo());
        ps.setString(6, data.getValidator());
        ps.setString(7, data.getSeq());
        ps.setString(8, data.getBuyoffType());
        ps.setString(9, data.getRoleType());
        ps.setString(10, data.getByType());
        ps.setString(11, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 12, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(BuyOffTemplate data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFactorName());
      ps.setString(2, data.getFactorType());
      ps.setString(3, data.getCustomProps());
      ps.setString(4, data.getOperationBo());
      ps.setString(5, data.getValidator());
      ps.setString(6, data.getSeq());
      ps.setString(7, data.getBuyoffType());
      ps.setString(8, data.getRoleType());
      ps.setString(9, data.getByType());
      ps.setString(10, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BuyOffTemplate> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BuyOffTemplate data : dataList) {
        ps.setString(1, data.getFactorName());
        ps.setString(2, data.getFactorType());
        ps.setString(3, data.getCustomProps());
        ps.setString(4, data.getOperationBo());
        ps.setString(5, data.getValidator());
        ps.setString(6, data.getSeq());
        ps.setString(7, data.getBuyoffType());
        ps.setString(8, data.getRoleType());
        ps.setString(9, data.getByType());
        ps.setString(10, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 11, data.getUpdatedTime());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_buyoff_template_factor WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<BuyOffTemplate> selectAll() throws SQLException {
    ArrayList<BuyOffTemplate> result = new ArrayList<BuyOffTemplate>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<BuyOffTemplate> selectByOperation(String operationBo, String buyOffType,
      String byType) throws SQLException {
    ArrayList<BuyOffTemplate> result = new ArrayList<BuyOffTemplate>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + " where operation_bo = ? and buyoff_type=? and by_type=? order by seq ")) {

      ps.setString(1, operationBo);
      ps.setString(2, buyOffType);
      ps.setString(3, byType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BuyOffTemplate selectByPK(String id) throws SQLException {
    BuyOffTemplate result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private BuyOffTemplate convert(ResultSet rs) throws SQLException {
    BuyOffTemplate data = new BuyOffTemplate();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setFactorName(rs.getString(index++));
    data.setFactorType(rs.getString(index++));
    data.setCustomProps(rs.getString(index++));
    data.setOperationBo(rs.getString(index++));
    data.setValidator(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setBuyoffType(rs.getString(index++));
    data.setRoleType(rs.getString(index++));
    data.setByType(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
