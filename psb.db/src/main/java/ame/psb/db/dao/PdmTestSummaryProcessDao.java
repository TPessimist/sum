package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.PdmTestSummaryProcess;
import uia.utils.dao.DateUtils;

public class PdmTestSummaryProcessDao {

  private static final String SQL_INS = "INSERT INTO zm_pdm_test_summary_process(factory_matnr,factory_device,factory_process,cust_process,testing_frequency,creater,create_time) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zm_pdm_test_summary_process SET factory_device=?,factory_process=?,cust_process=?,testing_frequency=?,creater=?,create_time=? WHERE factory_matnr=?";

  private static final String SQL_SEL = "SELECT factory_matnr,factory_device,factory_process,cust_process,testing_frequency,creater,create_time FROM zm_pdm_test_summary_process ";

  private final Connection conn;

  public PdmTestSummaryProcessDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PdmTestSummaryProcess data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getFactoryMatnr());
      ps.setString(2, data.getFactoryDevice());
      ps.setString(3, data.getFactoryProcess());
      ps.setString(4, data.getCustProcess());
      ps.setString(5, data.getTestingFrequency());
      ps.setString(6, data.getCreater());
      DateUtils.setDateTz(ps, 7, data.getCreateTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PdmTestSummaryProcess> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PdmTestSummaryProcess data : dataList) {
        ps.setString(1, data.getFactoryMatnr());
        ps.setString(2, data.getFactoryDevice());
        ps.setString(3, data.getFactoryProcess());
        ps.setString(4, data.getCustProcess());
        ps.setString(5, data.getTestingFrequency());
        ps.setString(6, data.getCreater());
        DateUtils.setDateTz(ps, 7, data.getCreateTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PdmTestSummaryProcess data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getFactoryDevice());
      ps.setString(2, data.getFactoryProcess());
      ps.setString(3, data.getCustProcess());
      ps.setString(4, data.getTestingFrequency());
      ps.setString(5, data.getCreater());
      DateUtils.setDateTz(ps, 6, data.getCreateTime());
      ps.setString(7, data.getFactoryMatnr());

      return ps.executeUpdate();
    }
  }

  public int update(List<PdmTestSummaryProcess> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PdmTestSummaryProcess data : dataList) {
        ps.setString(1, data.getFactoryDevice());
        ps.setString(2, data.getFactoryProcess());
        ps.setString(3, data.getCustProcess());
        ps.setString(4, data.getTestingFrequency());
        ps.setString(5, data.getCreater());
        DateUtils.setDateTz(ps, 6, data.getCreateTime());
        ps.setString(7, data.getFactoryMatnr());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String factoryMatnr) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zm_pdm_test_summary_process WHERE factory_matnr=?")) {
      ps.setString(1, factoryMatnr);

      return ps.executeUpdate();
    }
  }

  public List<PdmTestSummaryProcess> selectAll() throws SQLException {
    ArrayList<PdmTestSummaryProcess> result = new ArrayList<PdmTestSummaryProcess>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<PdmTestSummaryProcess> selectByPK(String factoryMatnr) throws SQLException {
    List<PdmTestSummaryProcess> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE FACTORY_DEVICE=?")) {
      ps.setString(1, factoryMatnr);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private PdmTestSummaryProcess convert(ResultSet rs) throws SQLException {
    PdmTestSummaryProcess data = new PdmTestSummaryProcess();

    int index = 1;
    data.setFactoryMatnr(rs.getString(index++));
    data.setFactoryDevice(rs.getString(index++));
    data.setFactoryProcess(rs.getString(index++));
    data.setCustProcess(rs.getString(index++));
    data.setTestingFrequency(rs.getString(index++));
    data.setCreater(rs.getString(index++));
    data.setCreateTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
