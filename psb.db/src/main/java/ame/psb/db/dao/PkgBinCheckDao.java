package ame.psb.db.dao;

import ame.psb.db.PkgBinCheck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class PkgBinCheckDao { //xf20201022 新建的数据表zr_pkg_bincheck

  private static final String SQL_INS = "INSERT INTO zr_pkg_bincheck(uuid,lotid,reelid,gradeid,die_qty,good_die,bad_die,recipe,result,personid,action_time,comment,description,value) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_bincheck SET lotid=?,reelid=?,gradeid=?,die_qty=?,good_die=?,bad_die=?,recipe=?,result=?,personid=?,action_time=?,comment=?,description=?,value=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,lotid,reelid,gradeid,die_qty,good_die,bad_die,recipe,result,personid,action_time,comment,description,value FROM zr_pkg_bincheck ";

  private final Connection conn;

  public PkgBinCheckDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgBinCheck data) throws SQLException { //插入一条记录
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getLotid());
      ps.setString(3, data.getReelid());
      ps.setString(4, data.getGradeid());
      ps.setString(5, data.getDieQty());
      ps.setString(6, data.getGoodDie());
      ps.setString(7, data.getBadDie());
      ps.setString(8, data.getRecipe());
      ps.setString(9, data.getResult());
      ps.setString(10, data.getPersonid());
      DateUtils.setDateTz(ps, 11, data.getActionTime());
      ps.setString(12, data.getComment());
      ps.setString(13, data.getDescription());
      ps.setString(14, data.getValue());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgBinCheck> dataList) throws SQLException { //插入多条记录
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgBinCheck data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getLotid());
        ps.setString(3, data.getReelid());
        ps.setString(4, data.getGradeid());
        ps.setString(5, data.getDieQty());
        ps.setString(6, data.getGoodDie());
        ps.setString(7, data.getBadDie());
        ps.setString(8, data.getRecipe());
        ps.setString(9, data.getResult());
        ps.setString(10, data.getPersonid());
        DateUtils.setDateTz(ps, 11, data.getActionTime());
        ps.setString(12, data.getComment());
        ps.setString(13, data.getDescription());
        ps.setString(14, data.getValue());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgBinCheck data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getLotid());
      ps.setString(2, data.getReelid());
      ps.setString(3, data.getGradeid());
      ps.setString(4, data.getDieQty());
      ps.setString(5, data.getGoodDie());
      ps.setString(6, data.getBadDie());
      ps.setString(7, data.getRecipe());
      ps.setString(8, data.getResult());
      ps.setString(9, data.getPersonid());
      DateUtils.setDateTz(ps, 10, data.getActionTime());
      ps.setString(11, data.getComment());
      ps.setString(12, data.getDescription());
      ps.setString(13, data.getValue());
      ps.setString(14, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgBinCheck> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgBinCheck data : dataList) {
        ps.setString(1, data.getLotid());
        ps.setString(2, data.getReelid());
        ps.setString(3, data.getGradeid());
        ps.setString(4, data.getDieQty());
        ps.setString(5, data.getGoodDie());
        ps.setString(6, data.getBadDie());
        ps.setString(7, data.getRecipe());
        ps.setString(8, data.getResult());
        ps.setString(9, data.getPersonid());
        DateUtils.setDateTz(ps, 10, data.getActionTime());
        ps.setString(11, data.getComment());
        ps.setString(12, data.getDescription());
        ps.setString(13, data.getValue());
        ps.setString(14, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException { //根据主键删除一条记录
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_bincheck WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<PkgBinCheck> selectAll() throws SQLException { //查询全部记录
    ArrayList<PkgBinCheck> result = new ArrayList<PkgBinCheck>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public PkgBinCheck selectByPK(String uuid) throws SQLException { //根据主键查一条记录
    PkgBinCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgBinCheck selectByLotAndReel(String lotid, String reelid)
      throws SQLException { //根据批次号和卷盘号查一条记录
    PkgBinCheck result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE lotid=? and reelid=?")) {
      ps.setString(1, lotid);
      ps.setString(2, reelid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgBinCheck selectByLot(String lotid) throws SQLException { //根据批次号查多条记录
    PkgBinCheck result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE lotid=?")) {
      ps.setString(1, lotid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private PkgBinCheck convert(ResultSet rs) throws SQLException { //查询结果处理
    PkgBinCheck data = new PkgBinCheck();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setLotid(rs.getString(index++));
    data.setReelid(rs.getString(index++));
    data.setGradeid(rs.getString(index++));
    data.setDieQty(rs.getString(index++));
    data.setGoodDie(rs.getString(index++));
    data.setBadDie(rs.getString(index++));
    data.setRecipe(rs.getString(index++));
    data.setResult(rs.getString(index++));
    data.setPersonid(rs.getString(index++));
    data.setActionTime(DateUtils.getDateTz(rs, index++));
    data.setComment(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setValue(rs.getString(index++));

    return data;
  }
}
