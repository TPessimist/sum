package ame.psb.db.dao;

import ame.psb.db.ZrSendingPrint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZrSendingPrintDao {

  private static final String SQL_INS = "INSERT INTO zr_sending_print(rsnum,zzcnlh,charg,licha,bdmng,vfdat,hsdat,label_qty,inventory_qty,content,value) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_sending_print SET zzcnlh=?,charg=?,licha=?,bdmng=?,vfdat=?,hsdat=?,label_qty=?,inventory_qty=?,content=?,value=? WHERE rsnum=?";

  private static final String SQL_SEL = "SELECT rsnum,zzcnlh,charg,licha,bdmng,vfdat,hsdat,label_qty,inventory_qty,content,value FROM zr_sending_print ";

  private final Connection conn;

  public ZrSendingPrintDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ZrSendingPrint data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getRsnum());
      ps.setString(2, data.getZzcnlh());
      ps.setString(3, data.getCharg());
      ps.setString(4, data.getLicha());
      ps.setString(5, data.getBdmng());
      ps.setString(6, data.getVfdat());
      ps.setString(7, data.getHsdat());
      ps.setString(8, data.getLabelQty());
      ps.setString(9, data.getInventoryQty());
      ps.setString(10, data.getContent());
      ps.setString(11, data.getValue());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ZrSendingPrint> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ZrSendingPrint data : dataList) {
        ps.setString(1, data.getRsnum());
        ps.setString(2, data.getZzcnlh());
        ps.setString(3, data.getCharg());
        ps.setString(4, data.getLicha());
        ps.setString(5, data.getBdmng());
        ps.setString(6, data.getVfdat());
        ps.setString(7, data.getHsdat());
        ps.setString(8, data.getLabelQty());
        ps.setString(9, data.getInventoryQty());
        ps.setString(10, data.getContent());
        ps.setString(11, data.getValue());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ZrSendingPrint data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getZzcnlh());
      ps.setString(2, data.getCharg());
      ps.setString(3, data.getLicha());
      ps.setString(4, data.getBdmng());
      ps.setString(5, data.getVfdat());
      ps.setString(6, data.getHsdat());
      ps.setString(7, data.getLabelQty());
      ps.setString(8, data.getInventoryQty());
      ps.setString(9, data.getContent());
      ps.setString(10, data.getValue());
      ps.setString(11, data.getRsnum());

      return ps.executeUpdate();
    }
  }

  public int update(List<ZrSendingPrint> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ZrSendingPrint data : dataList) {
        ps.setString(1, data.getZzcnlh());
        ps.setString(2, data.getCharg());
        ps.setString(3, data.getLicha());
        ps.setString(4, data.getBdmng());
        ps.setString(5, data.getVfdat());
        ps.setString(6, data.getHsdat());
        ps.setString(7, data.getLabelQty());
        ps.setString(8, data.getInventoryQty());
        ps.setString(9, data.getContent());
        ps.setString(10, data.getValue());
        ps.setString(11, data.getRsnum());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String rsnum) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_sending_print WHERE rsnum=?")) {
      ps.setString(1, rsnum);

      return ps.executeUpdate();
    }
  }

  public List<ZrSendingPrint> selectAll() throws SQLException {
    ArrayList<ZrSendingPrint> result = new ArrayList<ZrSendingPrint>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ZrSendingPrint selectByPK(String rsnum) throws SQLException {
    ZrSendingPrint result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE rsnum=?")) {
      ps.setString(1, rsnum);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ZrSendingPrint convert(ResultSet rs) throws SQLException {
    ZrSendingPrint data = new ZrSendingPrint();

    int index = 1;
    data.setRsnum(rs.getString(index++));
    data.setZzcnlh(rs.getString(index++));
    data.setCharg(rs.getString(index++));
    data.setLicha(rs.getString(index++));
    data.setBdmng(rs.getString(index++));
    data.setVfdat(rs.getString(index++));
    data.setHsdat(rs.getString(index++));
    data.setLabelQty(rs.getString(index++));
    data.setInventoryQty(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setValue(rs.getString(index++));

    return data;
  }
}
