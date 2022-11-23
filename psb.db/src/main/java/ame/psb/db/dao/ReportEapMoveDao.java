package ame.psb.db.dao;

import ame.psb.db.ReportEapMove;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportEapMoveDao {

  private static final String SQL_INS = "INSERT INTO zr_report_eap_move(id,sfc,send_date,shop_order,sap_order,site,die_qty,vgw01,vge01,item_list,item,value,comment,description) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_report_eap_move SET sfc=?,send_date=?,shop_order=?,sap_order=?,site=?,die_qty=?,vgw01=?,vge01=?,item_list=?,item=?,value=?,comment=?,description=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,sfc,send_date,shop_order,sap_order,site,die_qty,vgw01,vge01,item_list,item,value,comment,description FROM zr_report_eap_move ";

  private static final String SQL_UPD2 = " UPDATE zr_report_eap_move SET  value=?,comment=?,description=? WHERE shop_order=? and sap_order=? and site=? ";

  private final Connection conn;

  public ReportEapMoveDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ReportEapMove data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getSfc());
      ps.setString(3, data.getSendDate());
      ps.setString(4, data.getShopOrder());
      ps.setString(5, data.getSapOrder());
      ps.setString(6, data.getSite());
      ps.setString(7, data.getDieQty());
      ps.setString(8, data.getVgw01());
      ps.setString(9, data.getVge01());
      ps.setString(10, data.getItemList());
      ps.setString(11, data.getItem());
      ps.setString(12, data.getValue());
      ps.setString(13, data.getComment());
      ps.setString(14, data.getDescription());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ReportEapMove> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ReportEapMove data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getSfc());
        ps.setString(3, data.getSendDate());
        ps.setString(4, data.getShopOrder());
        ps.setString(5, data.getSapOrder());
        ps.setString(6, data.getSite());
        ps.setString(7, data.getDieQty());
        ps.setString(8, data.getVgw01());
        ps.setString(9, data.getVge01());
        ps.setString(10, data.getItemList());
        ps.setString(11, data.getItem());
        ps.setString(12, data.getValue());
        ps.setString(13, data.getComment());
        ps.setString(14, data.getDescription());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ReportEapMove data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSfc());
      ps.setString(2, data.getSendDate());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getSapOrder());
      ps.setString(5, data.getSite());
      ps.setString(6, data.getDieQty());
      ps.setString(7, data.getVgw01());
      ps.setString(8, data.getVge01());
      ps.setString(9, data.getItemList());
      ps.setString(10, data.getItem());
      ps.setString(11, data.getValue());
      ps.setString(12, data.getComment());
      ps.setString(13, data.getDescription());
      ps.setString(14, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<ReportEapMove> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ReportEapMove data : dataList) {
        ps.setString(1, data.getSfc());
        ps.setString(2, data.getSendDate());
        ps.setString(3, data.getShopOrder());
        ps.setString(4, data.getSapOrder());
        ps.setString(5, data.getSite());
        ps.setString(6, data.getDieQty());
        ps.setString(7, data.getVgw01());
        ps.setString(8, data.getVge01());
        ps.setString(9, data.getItemList());
        ps.setString(10, data.getItem());
        ps.setString(11, data.getValue());
        ps.setString(12, data.getComment());
        ps.setString(13, data.getDescription());
        ps.setString(14, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateByOrderAndSite(List<ReportEapMove> dataList) throws SQLException { //按照工单和站点更新状态
    for (ReportEapMove reportEapMove : dataList) {
      try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD2)) {
        ps.setString(1, reportEapMove.getValue());
        ps.setString(2, reportEapMove.getComment());
        ps.setString(3, reportEapMove.getDescription());
        ps.setString(4, reportEapMove.getShopOrder());
        ps.setString(5, reportEapMove.getSapOrder());
        ps.setString(6, reportEapMove.getSite());

        ps.executeUpdate();
      }
    }
    return 50;
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_report_eap_move WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public List<ReportEapMove> selectAll() throws SQLException {
    ArrayList<ReportEapMove> result = new ArrayList<ReportEapMove>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ReportEapMove selectByPK(String id) throws SQLException {
    ReportEapMove result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ReportEapMove> selectByState(String state) throws SQLException { //通过状态查询待发送的报工信息
    ArrayList<ReportEapMove> result = new ArrayList<ReportEapMove>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE value =? and sap_order is not null ")) {
      ps.setString(1, state);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ReportEapMove> selectAllWaitOrder() throws SQLException { //查询待发送的报工信息，按照工单、站点做汇总
    ArrayList<ReportEapMove> result = new ArrayList<ReportEapMove>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        " SELECT max(SFC) AS SFC,max(SEND_DATE) AS SEND_DATE , SHOP_ORDER ,SAP_ORDER ,SITE ,sum(CAST(substr(DIE_QTY ,1,locate(DIE_QTY ,'.')-1) AS INTEGER)) AS DIE_QTY "
            +
            " FROM zr_report_eap_move  where VALUE ='WAIT' AND SAP_ORDER IS NOT NULL  GROUP BY SHOP_ORDER ,SAP_ORDER ,SITE ")) {
      ps.setMaxRows(100000);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        result.add(convert2(rs));
      }
      return result;
    }
  }

  public List<ReportEapMove> selectAllWaitOrderAfter23()
      throws SQLException { //查询待发送的报工信息，按照工单、站点做汇总
    ArrayList<ReportEapMove> result = new ArrayList<ReportEapMove>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "     SELECT SFC,SEND_DATE,SHOP_ORDER,SAP_ORDER,SITE,DIE_QTY from( SELECT  max(b.SFC) AS SFC, "
            +
            "    SUBSTR(max(a.BEGIN_TIME),1,4)||SUBSTR(max(a.BEGIN_TIME),6,2)||SUBSTR(max(a.BEGIN_TIME),9,2) AS SEND_DATE, "
            +
            "    SUBSTR(b.SHOP_ORDER_BO,18,18) AS SHOP_ORDER, " +
            "    c.VALUE AS SAP_ORDER, " +
            "    SUBSTR(a.OPERATION_BO,18,locate(a.OPERATION_BO,',#')-18) AS SITE, " +
            "    sum(SFC_QTY) AS DIE_QTY " +
            "    FROM zr_run_sfc a,sfc b,CUSTOM_FIELDS c " +
            "    WHERE a.SFC_BO =b.HANDLE AND b.SHOP_ORDER_BO =c.HANDLE AND c.ATTRIBUTE ='SAP_SHOP_ORDER' "
            +
            "    AND a.BEGIN_TIME>'2021-01-23 00:00:00' " +
            "    GROUP BY b.SHOP_ORDER_BO ,c.VALUE ,a.OPERATION_BO ) " +
            "    WHERE (SHOP_ORDER,SAP_ORDER,SITE) NOT in(SELECT shop_order,sap_order,SITE FROM zr_report_eap_move WHERE SAP_ORDER IS NOT NULL )")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert2(rs));
      }
      return result;
    }
  }

  public List<ReportEapMove> selectAllWaitOrderAfter0123()
      throws SQLException { //20210210add 对QS环境进行报工，不检查是否进行过报工
    ArrayList<ReportEapMove> result = new ArrayList<ReportEapMove>();
    try (PreparedStatement ps = this.conn.prepareStatement(" SELECT  max(b.SFC) AS SFC, " +
        "    SUBSTR(max(a.BEGIN_TIME),1,4)||SUBSTR(max(a.BEGIN_TIME),6,2)||SUBSTR(max(a.BEGIN_TIME),9,2) AS SEND_DATE, "
        +
        "    SUBSTR(b.SHOP_ORDER_BO,18,18) AS SHOP_ORDER, " +
        "    c.VALUE AS SAP_ORDER, " +
        "    SUBSTR(a.OPERATION_BO,18,locate(a.OPERATION_BO,',#')-18) AS SITE, " +
        "    sum(SFC_QTY) AS DIE_QTY " +
        "    FROM zr_run_sfc a,sfc b,CUSTOM_FIELDS c " +
        "    WHERE a.SFC_BO =b.HANDLE AND b.SHOP_ORDER_BO =c.HANDLE AND c.ATTRIBUTE ='SAP_SHOP_ORDER' "
        +
        "    AND a.BEGIN_TIME>'2021-01-23 00:00:00' " +
        "    GROUP BY b.SHOP_ORDER_BO ,c.VALUE ,a.OPERATION_BO  ")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert2(rs));
      }
      return result;
    }
  }


  public List<ReportEapMove> selectByStateTop500(String state)
      throws SQLException { //通过状态查询待发送的报工信息，按时间从早到晚排序前50条
    ArrayList<ReportEapMove> result = new ArrayList<ReportEapMove>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE value =? and sap_order is not null ORDER BY send_date asc limit 500 ")) {
      ps.setString(1, state);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ReportEapMove> selectOrderByTestTable() throws SQLException { //对临时表中的工单进行查找sfc及出站记录
    ArrayList<ReportEapMove> result = new ArrayList<ReportEapMove>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        " SELECT a.SFC_BO AS sfc,a.SHOP_ORDER_NAME AS shop_order,c.OPERATION AS site,''||c.qty AS die_qty,b.TEST_COLUMN2 AS sap_order "
            +
            " FROM view_sfc a,ZR_TEST_XUFENG b,activity_log c  " +
            " WHERE a.SHOP_ORDER_NAME =b.NAME AND a.SFC_NAME =c.sfc  ")) {
      ps.setMaxRows(100000);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        result.add(convert3(rs));
      }
      return result;
    }
  }

  public ReportEapMove selectBySfcAndSite(String sfc, String shopOrder, String site)
      throws SQLException {
    ReportEapMove result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE sfc=? and shop_order=? and site=? ")) {
      ps.setString(1, sfc);
      ps.setString(2, shopOrder);
      ps.setString(3, site);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ReportEapMove convert(ResultSet rs) throws SQLException {
    ReportEapMove data = new ReportEapMove();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setSfc(rs.getString(index++));
    data.setSendDate(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setSapOrder(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setDieQty(rs.getString(index++));
    data.setVgw01(rs.getString(index++));
    data.setVge01(rs.getString(index++));
    data.setItemList(rs.getString(index++));
    data.setItem(rs.getString(index++));
    data.setValue(rs.getString(index++));
    data.setComment(rs.getString(index++));
    data.setDescription(rs.getString(index++));

    return data;
  }

  private ReportEapMove convert2(ResultSet rs) throws SQLException { //汇总报工使用到的数据封装方法
    ReportEapMove data = new ReportEapMove();

    int index = 1;
    data.setSfc(rs.getString(index++));
    data.setSendDate(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setSapOrder(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setDieQty(rs.getString(index++));

    return data;
  }

  private ReportEapMove convert3(ResultSet rs) throws SQLException {
    ReportEapMove data = new ReportEapMove();

    int index = 1;
    data.setSfc(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setDieQty(rs.getString(index++));
    data.setSapOrder(rs.getString(index++));

    return data;
  }
}
