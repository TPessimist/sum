package ame.psb.db.dao;

import ame.psb.db.FODeductionBean;
import ame.psb.db.ReportMoveDw;
import ame.psb.db.SendingPrint;
import ame.psb.db.WaferDeductionProduct;
import ame.psb.db.WaferDeductionReport;
import ame.psb.db.conf.Hana;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendingPrintDao {

  private static final String SQL_INS = "INSERT INTO vh_sending_print(rsnum,bdmng,charg,licha,vfdat,hsdat,zzcnlh) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE vh_sending_print SET rsnum=?,bdmng=?,licha=?,vfdat=?,hsdat=?,zzcnlh=? WHERE charg=?";

  private static final String SQL_SEL = "SELECT rsnum,bdmng,charg,licha,vfdat,hsdat,zzcnlh FROM vh_sending_print ";

  private final Connection conn;

  public SendingPrintDao() throws SQLException {
    this.conn = Hana.createDw();
  }

  public int insert(SendingPrint data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getRsnum());
      ps.setBigDecimal(2, data.getBdmng());
      ps.setString(3, data.getCharg());
      ps.setString(4, data.getLicha());
      ps.setString(5, data.getVfdat());
      ps.setString(6, data.getHsdat());
      ps.setString(7, data.getZzcnlh());

      return ps.executeUpdate();
    }
  }

  public int insert(List<SendingPrint> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (SendingPrint data : dataList) {
        ps.setString(1, data.getRsnum());
        ps.setBigDecimal(2, data.getBdmng());
        ps.setString(3, data.getCharg());
        ps.setString(4, data.getLicha());
        ps.setString(5, data.getVfdat());
        ps.setString(6, data.getHsdat());
        ps.setString(7, data.getZzcnlh());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(SendingPrint data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getRsnum());
      ps.setBigDecimal(2, data.getBdmng());
      ps.setString(3, data.getLicha());
      ps.setString(4, data.getVfdat());
      ps.setString(5, data.getHsdat());
      ps.setString(6, data.getZzcnlh());
      ps.setString(7, data.getCharg());

      return ps.executeUpdate();
    }
  }

  public int update(List<SendingPrint> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (SendingPrint data : dataList) {
        ps.setString(1, data.getRsnum());
        ps.setBigDecimal(2, data.getBdmng());
        ps.setString(3, data.getLicha());
        ps.setString(4, data.getVfdat());
        ps.setString(5, data.getHsdat());
        ps.setString(6, data.getZzcnlh());
        ps.setString(7, data.getCharg());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String charg) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM vh_sending_print WHERE charg=?")) {
      ps.setString(1, charg);

      return ps.executeUpdate();
    }
  }

  public List<SendingPrint> selectAll() throws SQLException {
    ArrayList<SendingPrint> result = new ArrayList<SendingPrint>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public SendingPrint selectByPK(String charg) throws SQLException {
    SendingPrint result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE charg=?")) {
      ps.setString(1, charg);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<SendingPrint> selectById(String rsnum) throws SQLException {
    ArrayList<SendingPrint> result = new ArrayList<SendingPrint>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE rsnum=?")) {
      ps.setString(1, rsnum);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ReportMoveDw> selectReportMove(String product, String stage) throws SQLException {
    ArrayList<ReportMoveDw> result = new ArrayList<ReportMoveDw>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT  XX.MATNR,XX.ZZCNLH , XX.STAGE ,XX.ALPGR,XX1.MATNR1,XX1.ZZCNLH1,xx.CLABS FROM (SELECT  XX.MATNR,XX.ZZCNLH , XX.STAGE , "
            +
            " XX.ALPGR,max(xx.CLABS) AS CLABS FROM (SELECT DISTINCT t4.MATNR, t4.ZZCNLH ,  t6.MATNR MATNR1, t6.ZZCNLH ZZCNLH1, t3.STAGE , CASE WHEN t2.ALPGR = '' THEN t6.ZZCNLH ELSE t2.ALPGR END AS ALPGR, "
            +
            " ifnull(t7.CLABS,0) AS CLABS FROM mast t1 INNER JOIN  stpo t2 ON t1.STLNR  = t2.STLNR   "
            +
            " and t2.LKENZ <> 'X' INNER JOIN  ZKTPP0002 t3 ON t2.SORTF  = t3.ARBPL   " +
            " INNER JOIN  mara t4 ON t1.MATNR = t4.MATNR   " +
            " INNER JOIN  mara t6 ON t2.IDNRK  = t6.MATNR   " +
            " LEFT JOIN  (SELECT sum(CLABS) AS CLABS,MATNR FROM MCHB  WHERE  LGORT LIKE '4%' GROUP BY MATNR) t7 ON t6.MATNR  = t7.MATNR   "
            +
            " WHERE t1.WERKS  = '1200' AND t2.ALPGR <> '') XX   " +
            " GROUP BY  XX.MATNR, XX.ZZCNLH , XX.STAGE , XX.ALPGR HAVING count(1) > 1)XX INNER JOIN  "
            +
            " ( SELECT  DISTINCT t4.MATNR, t4.ZZCNLH ,  t6.MATNR MATNR1, t6.ZZCNLH ZZCNLH1, t3.STAGE , "
            +
            " CASE WHEN t2.ALPGR = '' THEN t6.ZZCNLH ELSE t2.ALPGR END AS ALPGR, ifnull(t7.CLABS,0) AS CLABS "
            +
            " FROM mast t1 INNER JOIN  stpo t2 ON t1.STLNR  = t2.STLNR  and t2.LKENZ <> 'X'  " +
            " INNER JOIN  ZKTPP0002 t3 ON t2.SORTF  = t3.ARBPL  " +
            " INNER JOIN  mara t4 ON t1.MATNR = t4.MATNR  " +
            " INNER JOIN  mara t6 ON t2.IDNRK  = t6.MATNR   " +
            " LEFT JOIN  (SELECT sum(CLABS) AS CLABS,MATNR FROM MCHB  WHERE  LGORT LIKE '4%' GROUP BY MATNR) t7 ON t6.MATNR  = t7.MATNR  "
            +
            "  WHERE t1.WERKS  = '1200' )XX1 ON XX.MATNR = XX1.MATNR AND XX.ZZCNLH = XX1.ZZCNLH AND XX.STAGE = XX1.STAGE AND XX.ALPGR = XX1.ALPGR AND xx.CLABS =XX1.CLABS  "
            +
            " AND xx.CLABS <>0 AND XX.ZZCNLH=? AND XX.STAGE=? " +
            " ORDER BY XX.MATNR,XX.ALPGR ")) {
      ps.setString(1, product);
      ps.setString(2, stage);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert2(rs));
      }
      return result;
    }
  }

  public FODeductionBean selectFoResponse(String charg) throws SQLException {
    FODeductionBean result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT MATNR,CHARG,ZWAFER_LOT,ZWAFER_ID, LGORT,ZBIN_NO,ZGROSS_DIE_QTY,ZDIE_QTY," +
            "ZDIE_QTY_GI,ZDIE_QTY-ZDIE_QTY_GI AS QTY,LIFNR,INSMK FROM ZKTMM0001 z WHERE CHARG =? ")) {
      ps.setString(1, charg);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert3(rs);
      }
      return result;
    }
  }

  public WaferDeductionReport selectWaferResponse(String wafer) throws SQLException {
    WaferDeductionReport result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT MATNR,CHARG,ZWAFER_LOT,ZWAFER_ID, LGORT,ZBIN_NO,ZGROSS_DIE_QTY,ZDIE_QTY," +
            "ZDIE_QTY_GI,ZDIE_QTY-ZDIE_QTY_GI AS QTY,LIFNR,INSMK FROM ZKTMM0001 z WHERE ZWAFER_ID =? ")) {
      ps.setString(1, wafer);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert4(rs);
      }
      return result;
    }
  }

  public WaferDeductionReport selectWaferResponseByProduct(String wafer, String sapProduct)
      throws SQLException {
    WaferDeductionReport result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT MATNR,CHARG,ZWAFER_LOT,ZWAFER_ID, LGORT,ZBIN_NO,ZGROSS_DIE_QTY,ZDIE_QTY," +
            "ZDIE_QTY_GI,ZDIE_QTY-ZDIE_QTY_GI AS QTY,LIFNR,INSMK FROM ZKTMM0001 z WHERE ZWAFER_ID =? AND MATNR =? ")) {
      ps.setString(1, wafer);
      ps.setString(2, sapProduct);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert4(rs);
      }
      return result;
    }
  }

  public WaferDeductionProduct selectProductResponse(String product) throws SQLException {
    WaferDeductionProduct result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT MATNR,ERSDA,MTART,MATKL,ZZKHDM,ZZHTXH,ZZFHFS,ZZBASESOMO FROM MARA WHERE MATNR =? ")) {
      ps.setString(1, product);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert5(rs);
      }
      return result;
    }
  }
  public String selectProductMap(String product) throws SQLException {
    String  result = "";
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT  DISTINCT ZZTYPE FROM MARA WHERE ZZCNLH = ? ")) {
      ps.setString(1, product);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result= rs.getString(0);
      }
      return result;
    }
  }



  private SendingPrint convert(ResultSet rs) throws SQLException {
    SendingPrint data = new SendingPrint();

    int index = 1;
    data.setRsnum(rs.getString(index++));
    data.setBdmng(rs.getBigDecimal(index++));
    data.setCharg(rs.getString(index++));
    data.setLicha(rs.getString(index++));
    data.setVfdat(rs.getString(index++));
    data.setHsdat(rs.getString(index++));
    data.setZzcnlh(rs.getString(index++));

    return data;
  }

  private ReportMoveDw convert2(ResultSet rs) throws SQLException {
    ReportMoveDw data = new ReportMoveDw();

    int index = 1;
    data.setMatnr(rs.getString(index++));
    data.setZzcnlh(rs.getString(index++));
    data.setStage(rs.getString(index++));
    data.setAlpgr(rs.getString(index++));
    data.setMatnr1(rs.getString(index++));
    data.setZzcnlh1(rs.getString(index++));
    data.setClabs(rs.getBigDecimal(index++));

    return data;
  }

  private FODeductionBean convert3(ResultSet rs) throws SQLException {
    FODeductionBean data = new FODeductionBean();

    int index = 1;
    data.setMatnr(rs.getString(index++));
    data.setCharg(rs.getString(index++));
    data.setZwafer_lot(rs.getString(index++));
    data.setZwafer_id(rs.getString(index++));
    data.setLgort(rs.getString(index++));
    data.setZbin_no(rs.getString(index++));
    data.setZgross_die_qty(rs.getBigDecimal(index++));
    data.setZdie_qty(rs.getBigDecimal(index++));
    data.setZdie_qty_gi(rs.getBigDecimal(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setLifnr(rs.getString(index++));
    data.setInsmk(rs.getString(index++));

    return data;
  }

  private WaferDeductionReport convert4(ResultSet rs) throws SQLException {
    WaferDeductionReport data = new WaferDeductionReport();

    int index = 1;
    data.setMatnr(rs.getString(index++));
    data.setCharg(rs.getString(index++));
    data.setZwafer_lot(rs.getString(index++));
    data.setZwafer_id(rs.getString(index++));
    data.setLgort(rs.getString(index++));
    data.setZbin_no(rs.getString(index++));
    data.setZgross_die_qty(rs.getBigDecimal(index++));
    data.setZdie_qty(rs.getBigDecimal(index++));
    data.setZdie_qty_gi(rs.getBigDecimal(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setLifnr(rs.getString(index++));
    data.setInsmk(rs.getString(index++));

    return data;
  }

  private WaferDeductionProduct convert5(ResultSet rs) throws SQLException {
    WaferDeductionProduct data = new WaferDeductionProduct();

    int index = 1;
    data.setMatnr(rs.getString(index++));
    data.setErsda(rs.getString(index++));
    data.setMtart(rs.getString(index++));
    data.setMatkl(rs.getString(index++));
    data.setZzkhdm(rs.getString(index++));
    data.setZzhtxh(rs.getString(index++));
    data.setZzfhfs(rs.getString(index++));
    data.setZzbasesomo(rs.getString(index++));

    return data;
  }

  public void close() throws Exception {
    if (this.conn != null) {
      this.conn.close();
    }
  }
}
