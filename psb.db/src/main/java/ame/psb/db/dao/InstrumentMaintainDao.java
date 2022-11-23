package ame.psb.db.dao;

import ame.psb.db.InstrumentMaintain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class InstrumentMaintainDao { //ZD_INSTRUMENT_MAINTAIN表的dao层

  private static final String SQL_INS = "INSERT INTO zd_instrument_maintain(uuid,instrumentid,code,name,alias,resourcceid,onlinemonitor,calibrationcycle,state,calibrationdate,effectivedate,value,comment,description,remarks,note) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_instrument_maintain SET instrumentid=?,code=?,name=?,alias=?,resourcceid=?,onlinemonitor=?,calibrationcycle=?,state=?,calibrationdate=?,effectivedate=?,value=?,comment=?,description=?,remarks=?,note=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,instrumentid,code,name,alias,resourcceid,onlinemonitor,calibrationcycle,state,calibrationdate,effectivedate,value,comment,description,remarks,note FROM zd_instrument_maintain ";

  private final Connection conn;

  public InstrumentMaintainDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(InstrumentMaintain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getInstrumentid());
      ps.setString(3, data.getCode());
      ps.setString(4, data.getName());
      ps.setString(5, data.getAlias());
      ps.setString(6, data.getResourcceid());
      ps.setString(7, data.getOnlinemonitor());
      ps.setString(8, data.getCalibrationcycle());
      ps.setString(9, data.getState());
      DateUtils.setDateTz(ps, 10, data.getCalibrationdate());
      DateUtils.setDateTz(ps, 11, data.getEffectivedate());
      ps.setString(12, data.getValue());
      ps.setString(13, data.getComment());
      ps.setString(14, data.getDescription());
      ps.setString(15, data.getRemarks());
      ps.setString(16, data.getNote());

      return ps.executeUpdate();
    }
  }

  public int insert(List<InstrumentMaintain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (InstrumentMaintain data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getInstrumentid());
        ps.setString(3, data.getCode());
        ps.setString(4, data.getName());
        ps.setString(5, data.getAlias());
        ps.setString(6, data.getResourcceid());
        ps.setString(7, data.getOnlinemonitor());
        ps.setString(8, data.getCalibrationcycle());
        ps.setString(9, data.getState());
        DateUtils.setDateTz(ps, 10, data.getCalibrationdate());
        DateUtils.setDateTz(ps, 11, data.getEffectivedate());
        ps.setString(12, data.getValue());
        ps.setString(13, data.getComment());
        ps.setString(14, data.getDescription());
        ps.setString(15, data.getRemarks());
        ps.setString(16, data.getNote());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(InstrumentMaintain data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getInstrumentid());
      ps.setString(2, data.getCode());
      ps.setString(3, data.getName());
      ps.setString(4, data.getAlias());
      ps.setString(5, data.getResourcceid());
      ps.setString(6, data.getOnlinemonitor());
      ps.setString(7, data.getCalibrationcycle());
      ps.setString(8, data.getState());
      DateUtils.setDateTz(ps, 9, data.getCalibrationdate());
      DateUtils.setDateTz(ps, 10, data.getEffectivedate());
      ps.setString(11, data.getValue());
      ps.setString(12, data.getComment());
      ps.setString(13, data.getDescription());
      ps.setString(14, data.getRemarks());
      ps.setString(15, data.getNote());
      ps.setString(16, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<InstrumentMaintain> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (InstrumentMaintain data : dataList) {
        ps.setString(1, data.getInstrumentid());
        ps.setString(2, data.getCode());
        ps.setString(3, data.getName());
        ps.setString(4, data.getAlias());
        ps.setString(5, data.getResourcceid());
        ps.setString(6, data.getOnlinemonitor());
        ps.setString(7, data.getCalibrationcycle());
        ps.setString(8, data.getState());
        DateUtils.setDateTz(ps, 9, data.getCalibrationdate());
        DateUtils.setDateTz(ps, 10, data.getEffectivedate());
        ps.setString(11, data.getValue());
        ps.setString(12, data.getComment());
        ps.setString(13, data.getDescription());
        ps.setString(14, data.getRemarks());
        ps.setString(15, data.getNote());
        ps.setString(16, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_instrument_maintain WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public int deleteByInstrumentId(String instrumentId) throws SQLException { //根据计量器具编号删除记录
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_instrument_maintain WHERE instrumentid=?")) {
      ps.setString(1, instrumentId);

      return ps.executeUpdate();
    }
  }

  public List<InstrumentMaintain> selectAll() throws SQLException {
    ArrayList<InstrumentMaintain> result = new ArrayList<InstrumentMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public InstrumentMaintain selectByPK(String uuid) throws SQLException {
    InstrumentMaintain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public InstrumentMaintain selectByInstrumentId(String instrumentId)
      throws SQLException { //根据计量器具编号查询
    InstrumentMaintain result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE instrumentid=?")) {
      ps.setString(1, instrumentId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<InstrumentMaintain> selectByresourcceId(String resourceId)
      throws SQLException { //根据设备编号查
    ArrayList<InstrumentMaintain> result = new ArrayList<InstrumentMaintain>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE resourcceid=?")) {
      ps.setString(1, resourceId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public InstrumentMaintain selectInstrumentIdByCode(String code) throws SQLException { //根据类别代码查询记录
    InstrumentMaintain result = null;

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE code=? order by instrumentid desc limit 1")) {
      ps.setString(1, code);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private InstrumentMaintain convert(ResultSet rs) throws SQLException {
    InstrumentMaintain data = new InstrumentMaintain();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setInstrumentid(rs.getString(index++));
    data.setCode(rs.getString(index++));
    data.setName(rs.getString(index++));
    data.setAlias(rs.getString(index++));
    data.setResourcceid(rs.getString(index++));
    data.setOnlinemonitor(rs.getString(index++));
    data.setCalibrationcycle(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setCalibrationdate(DateUtils.getDateTz(rs, index++));
    data.setEffectivedate(DateUtils.getDateTz(rs, index++));
    data.setValue(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setNote(rs.getString(index++));

    return data;
  }
}
