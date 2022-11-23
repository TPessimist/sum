package ame.sap.db.dao;

import ame.sap.db.ZktPP0006LogA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZktPP0006LogADao {

  private static final String SQL_INS = "INSERT INTO zktpp0006_loga(mandt,action_id,werks,crm_order,auart,aufnr,matnr,wafer_qty,lot_qty,menge,zzkhbt,strmp,etrmp,name1,prctr,aprio,creator,zzbasesomo,zzkhpo,zzkhpi,kdauf,kdpos,type,message,ernam,erdat,erzet,aenam,aedat,aezet,zzkhdm,zzcnlh,zzkhdc) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zktpp0006_loga SET auart=?,aufnr=?,matnr=?,wafer_qty=?,lot_qty=?,menge=?,zzkhbt=?,strmp=?,etrmp=?,name1=?,prctr=?,aprio=?,creator=?,zzbasesomo=?,zzkhpo=?,zzkhpi=?,kdauf=?,kdpos=?,type=?,message=?,ernam=?,erdat=?,erzet=?,aenam=?,aedat=?,aezet=?,zzkhdm=?,zzcnlh=?,zzkhdc=? WHERE mandt=? AND action_id=? AND werks=? AND crm_order=?";

  private static final String SQL_SEL = "SELECT mandt,action_id,werks,crm_order,auart,aufnr,matnr,wafer_qty,lot_qty,menge,zzkhbt,strmp,etrmp,name1,prctr,aprio,creator,zzbasesomo,zzkhpo,zzkhpi,kdauf,kdpos,type,message,ernam,erdat,erzet,aenam,aedat,aezet,zzkhdm,zzcnlh,zzkhdc FROM zktpp0006_loga ";

  private final Connection conn;

  public ZktPP0006LogADao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZktPP0006LogA data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getMandt());
      ps.setString(2, data.getActionId());
      ps.setString(3, data.getWerks());
      ps.setString(4, data.getCrmOrder());
      ps.setString(5, data.getAuart());
      ps.setString(6, data.getAufnr());
      ps.setString(7, data.getMatnr());
      ps.setLong(8, data.getWaferQty());
      ps.setLong(9, data.getLotQty());
      ps.setLong(10, data.getMenge());
      ps.setString(11, data.getZzkhbt());
      ps.setString(12, data.getStrmp());
      ps.setString(13, data.getEtrmp());
      ps.setString(14, data.getName1());
      ps.setString(15, data.getPrctr());
      ps.setString(16, data.getAprio());
      ps.setString(17, data.getCreator());
      ps.setString(18, data.getZzbasesomo());
      ps.setString(19, data.getZzkhpo());
      ps.setString(20, data.getZzkhpi());
      ps.setString(21, data.getKdauf());
      ps.setString(22, data.getKdpos());
      ps.setString(23, data.getType());
      ps.setString(24, data.getMessage());
      ps.setString(25, data.getErnam());
      ps.setString(26, data.getErdat());
      ps.setString(27, data.getErzet());
      ps.setString(28, data.getAenam());
      ps.setString(29, data.getAedat());
      ps.setString(30, data.getAezet());
      ps.setString(31, data.getZzkhdm());
      ps.setString(32, data.getZzcnlh());
      ps.setString(33, data.getZzkhdc());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZktPP0006LogA> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZktPP0006LogA data : dataList) {
        ps.setString(1, data.getMandt());
        ps.setString(2, data.getActionId());
        ps.setString(3, data.getWerks());
        ps.setString(4, data.getCrmOrder());
        ps.setString(5, data.getAuart());
        ps.setString(6, data.getAufnr());
        ps.setString(7, data.getMatnr());
        ps.setLong(8, data.getWaferQty());
        ps.setLong(9, data.getLotQty());
        ps.setLong(10, data.getMenge());
        ps.setString(11, data.getZzkhbt());
        ps.setString(12, data.getStrmp());
        ps.setString(13, data.getEtrmp());
        ps.setString(14, data.getName1());
        ps.setString(15, data.getPrctr());
        ps.setString(16, data.getAprio());
        ps.setString(17, data.getCreator());
        ps.setString(18, data.getZzbasesomo());
        ps.setString(19, data.getZzkhpo());
        ps.setString(20, data.getZzkhpi());
        ps.setString(21, data.getKdauf());
        ps.setString(22, data.getKdpos());
        ps.setString(23, data.getType());
        ps.setString(24, data.getMessage());
        ps.setString(25, data.getErnam());
        ps.setString(26, data.getErdat());
        ps.setString(27, data.getErzet());
        ps.setString(28, data.getAenam());
        ps.setString(29, data.getAedat());
        ps.setString(30, data.getAezet());
        ps.setString(31, data.getZzkhdm());
        ps.setString(32, data.getZzcnlh());
        ps.setString(33, data.getZzkhdc());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZktPP0006LogA data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getAuart());
      ps.setString(2, data.getAufnr());
      ps.setString(3, data.getMatnr());
      ps.setLong(4, data.getWaferQty());
      ps.setLong(5, data.getLotQty());
      ps.setLong(6, data.getMenge());
      ps.setString(7, data.getZzkhbt());
      ps.setString(8, data.getStrmp());
      ps.setString(9, data.getEtrmp());
      ps.setString(10, data.getName1());
      ps.setString(11, data.getPrctr());
      ps.setString(12, data.getAprio());
      ps.setString(13, data.getCreator());
      ps.setString(14, data.getZzbasesomo());
      ps.setString(15, data.getZzkhpo());
      ps.setString(16, data.getZzkhpi());
      ps.setString(17, data.getKdauf());
      ps.setString(18, data.getKdpos());
      ps.setString(19, data.getType());
      ps.setString(20, data.getMessage());
      ps.setString(21, data.getErnam());
      ps.setString(22, data.getErdat());
      ps.setString(23, data.getErzet());
      ps.setString(24, data.getAenam());
      ps.setString(25, data.getAedat());
      ps.setString(26, data.getAezet());
      ps.setString(27, data.getZzkhdm());
      ps.setString(28, data.getZzcnlh());
      ps.setString(29, data.getZzkhdc());
      ps.setString(30, data.getMandt());
      ps.setString(31, data.getActionId());
      ps.setString(32, data.getWerks());
      ps.setString(33, data.getCrmOrder());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZktPP0006LogA> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZktPP0006LogA data : dataList) {
        ps.setString(1, data.getAuart());
        ps.setString(2, data.getAufnr());
        ps.setString(3, data.getMatnr());
        ps.setLong(4, data.getWaferQty());
        ps.setLong(5, data.getLotQty());
        ps.setLong(6, data.getMenge());
        ps.setString(7, data.getZzkhbt());
        ps.setString(8, data.getStrmp());
        ps.setString(9, data.getEtrmp());
        ps.setString(10, data.getName1());
        ps.setString(11, data.getPrctr());
        ps.setString(12, data.getAprio());
        ps.setString(13, data.getCreator());
        ps.setString(14, data.getZzbasesomo());
        ps.setString(15, data.getZzkhpo());
        ps.setString(16, data.getZzkhpi());
        ps.setString(17, data.getKdauf());
        ps.setString(18, data.getKdpos());
        ps.setString(19, data.getType());
        ps.setString(20, data.getMessage());
        ps.setString(21, data.getErnam());
        ps.setString(22, data.getErdat());
        ps.setString(23, data.getErzet());
        ps.setString(24, data.getAenam());
        ps.setString(25, data.getAedat());
        ps.setString(26, data.getAezet());
        ps.setString(27, data.getZzkhdm());
        ps.setString(28, data.getZzcnlh());
        ps.setString(29, data.getZzkhdc());
        ps.setString(30, data.getMandt());
        ps.setString(31, data.getActionId());
        ps.setString(32, data.getWerks());
        ps.setString(33, data.getCrmOrder());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String mandt, String actionId, String werks, String crmOrder)
      throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zktpp0006_loga WHERE mandt=? AND action_id=? AND werks=? AND crm_order=?")) {
      ps.setString(1, mandt);
      ps.setString(2, actionId);
      ps.setString(3, werks);
      ps.setString(4, crmOrder);

      return ps.executeUpdate();
    }
  }

  public List<ZktPP0006LogA> selectAll() throws SQLException {
    ArrayList<ZktPP0006LogA> result = new ArrayList<ZktPP0006LogA>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZktPP0006LogA selectByPK(String mandt, String actionId, String werks, String crmOrder)
      throws SQLException {
    ZktPP0006LogA result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE mandt=? AND action_id=? AND werks=? AND crm_order=?")) {
      ps.setString(1, mandt);
      ps.setString(2, actionId);
      ps.setString(3, werks);
      ps.setString(4, crmOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ZktPP0006LogA selectByCrmOrder(String crmOrder) throws SQLException {
    ZktPP0006LogA result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE crm_order=?")) {
      ps.setString(1, crmOrder);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZktPP0006LogA convert(ResultSet rs) throws SQLException {
    ZktPP0006LogA data = new ZktPP0006LogA();

    int index = 1;
    data.setMandt(rs.getString(index++));
    data.setActionId(rs.getString(index++));
    data.setWerks(rs.getString(index++));
    data.setCrmOrder(rs.getString(index++));
    data.setAuart(rs.getString(index++));
    data.setAufnr(rs.getString(index++));
    data.setMatnr(rs.getString(index++));
    data.setWaferQty(rs.getLong(index++));
    data.setLotQty(rs.getLong(index++));
    data.setMenge(rs.getLong(index++));
    data.setZzkhbt(rs.getString(index++));
    data.setStrmp(rs.getString(index++));
    data.setEtrmp(rs.getString(index++));
    data.setName1(rs.getString(index++));
    data.setPrctr(rs.getString(index++));
    data.setAprio(rs.getString(index++));
    data.setCreator(rs.getString(index++));
    data.setZzbasesomo(rs.getString(index++));
    data.setZzkhpo(rs.getString(index++));
    data.setZzkhpi(rs.getString(index++));
    data.setKdauf(rs.getString(index++));
    data.setKdpos(rs.getString(index++));
    data.setType(rs.getString(index++));
    data.setMessage(rs.getString(index++));
    data.setErnam(rs.getString(index++));
    data.setErdat(rs.getString(index++));
    data.setErzet(rs.getString(index++));
    data.setAenam(rs.getString(index++));
    data.setAedat(rs.getString(index++));
    data.setAezet(rs.getString(index++));
    data.setZzkhdm(rs.getString(index++));
    data.setZzcnlh(rs.getString(index++));
    data.setZzkhdc(rs.getString(index++));

    return data;
  }
}
