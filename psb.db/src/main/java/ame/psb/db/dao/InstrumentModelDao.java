package ame.psb.db.dao;

import ame.psb.db.InstrumentModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class InstrumentModelDao {

  private static final String SQL_INS = "INSERT INTO zd_instrument_model(uuid,instrument_code,instrument_name,instrument_maker,instrument_model,description,value,update_time,update_user) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_instrument_model SET instrument_code=?,instrument_name=?,instrument_maker=?,instrument_model=?,description=?,value=?,update_time=?,update_user=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,instrument_code,instrument_name,instrument_maker,instrument_model,description,value,update_time,update_user FROM zd_instrument_model ";

  private final Connection conn;

  public InstrumentModelDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(InstrumentModel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getInstrumentCode());
      ps.setString(3, data.getInstrumentName());
      ps.setString(4, data.getInstrumentMaker());
      ps.setString(5, data.getInstrumentModel());
      ps.setString(6, data.getDescription());
      ps.setString(7, data.getValue());
      DateUtils.setDateTz(ps, 8, data.getUpdateTime());
      ps.setString(9, data.getUpdateUser());

      return ps.executeUpdate();
    }
  }

  public int insert(List<InstrumentModel> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InstrumentModel data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getInstrumentCode());
        ps.setString(3, data.getInstrumentName());
        ps.setString(4, data.getInstrumentMaker());
        ps.setString(5, data.getInstrumentModel());
        ps.setString(6, data.getDescription());
        ps.setString(7, data.getValue());
        DateUtils.setDateTz(ps, 8, data.getUpdateTime());
        ps.setString(9, data.getUpdateUser());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InstrumentModel data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getInstrumentCode());
      ps.setString(2, data.getInstrumentName());
      ps.setString(3, data.getInstrumentMaker());
      ps.setString(4, data.getInstrumentModel());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getValue());
      DateUtils.setDateTz(ps, 7, data.getUpdateTime());
      ps.setString(8, data.getUpdateUser());
      ps.setString(9, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<InstrumentModel> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InstrumentModel data : dataList) {
        ps.setString(1, data.getInstrumentCode());
        ps.setString(2, data.getInstrumentName());
        ps.setString(3, data.getInstrumentMaker());
        ps.setString(4, data.getInstrumentModel());
        ps.setString(5, data.getDescription());
        ps.setString(6, data.getValue());
        DateUtils.setDateTz(ps, 7, data.getUpdateTime());
        ps.setString(8, data.getUpdateUser());
        ps.setString(9, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_instrument_model WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<InstrumentModel> selectAll() throws SQLException {
    ArrayList<InstrumentModel> result = new ArrayList<InstrumentModel>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public InstrumentModel selectByPK(String uuid) throws SQLException {
    InstrumentModel result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<InstrumentModel> selectByInstrumentCode(String instrumentCode) throws SQLException {
    ArrayList<InstrumentModel> result = new ArrayList<InstrumentModel>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT DISTINCT instrument_code,instrument_name,instrument_maker FROM zd_instrument_model WHERE instrument_code=?")) {
      ps.setString(1, instrumentCode);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert2(rs));
      }
      return result;
    }
  }

  public List<InstrumentModel> selectByInstrumentMaker(String instrumentCode,
      String instrumentMaker) throws SQLException {
    ArrayList<InstrumentModel> result = new ArrayList<InstrumentModel>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT DISTINCT instrument_code,instrument_name,instrument_maker,instrument_model FROM zd_instrument_model WHERE instrument_code=? AND instrument_maker=? ")) {
      ps.setString(1, instrumentCode);
      ps.setString(2, instrumentMaker);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert3(rs));
      }
      return result;
    }
  }

  private InstrumentModel convert(ResultSet rs) throws SQLException {
    InstrumentModel data = new InstrumentModel();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setInstrumentCode(rs.getString(index++));
    data.setInstrumentName(rs.getString(index++));
    data.setInstrumentMaker(rs.getString(index++));
    data.setInstrumentModel(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setUpdateTime(DateUtils.getDateTz(rs, index++));
    data.setUpdateUser(rs.getString(index++));

    return data;
  }

  private InstrumentModel convert2(ResultSet rs) throws SQLException {
    InstrumentModel data = new InstrumentModel();

    int index = 1;
    data.setInstrumentCode(rs.getString(index++));
    data.setInstrumentName(rs.getString(index++));
    data.setInstrumentMaker(rs.getString(index++));

    return data;
  }

  private InstrumentModel convert3(ResultSet rs) throws SQLException {
    InstrumentModel data = new InstrumentModel();

    int index = 1;
    data.setInstrumentCode(rs.getString(index++));
    data.setInstrumentName(rs.getString(index++));
    data.setInstrumentMaker(rs.getString(index++));
    data.setInstrumentModel(rs.getString(index++));

    return data;
  }
}
