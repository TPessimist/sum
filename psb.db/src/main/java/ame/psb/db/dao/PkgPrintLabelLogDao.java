package ame.psb.db.dao;

import ame.psb.db.PkgPrintLabelLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class PkgPrintLabelLogDao {

  private static final String SQL_INS = "INSERT INTO zr_pkg_print_label_log(id,container_bo,container_name,seq,content,reprint_flag,print_qty,reserve_field1,reserve_field2,print_time,print_user,date_code,qrcode, newest_print) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_pkg_print_label_log SET container_bo=?,container_name=?,seq=?,content=?,reprint_flag=?,print_qty=?,reserve_field1=?,reserve_field2=?,print_time=?,print_user=?, newest_print = ? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,container_bo,container_name,seq,content,reprint_flag,print_qty,reserve_field1,reserve_field2,print_time,print_user, date_code,qrcode, newest_print FROM zr_pkg_print_label_log ";

  private static final String SQL_SEL_TAG = "SELECT id,container_bo,container_name,seq,F_GET_TAG_VALUE(CONTENT, ?),reprint_flag,print_qty,reserve_field1,reserve_field2,print_time,print_user, date_code,qrcode, newest_print FROM zr_pkg_print_label_log ";


  private final Connection conn;

  public PkgPrintLabelLogDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgPrintLabelLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getContainerBo());
      ps.setString(3, data.getContainerName());
      ps.setString(4, data.getSeq());
      ps.setString(5, data.getContent());
      ps.setBoolean(6, data.isReprint());
      ps.setInt(7, data.getPrintQty());
      ps.setString(8, data.getReserveField1());
      ps.setString(9, data.getReserveField2());
      DateUtils.setDateTz(ps, 10, data.getPrintTime());
      ps.setString(11, data.getPrintUser());
      ps.setString(12, data.getDateCode());
      ps.setString(13, data.getQrcode());
      ps.setString(14, data.getNewestPrint());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgPrintLabelLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgPrintLabelLog data : dataList) {
        ps.setString(1, data.getId());
        ps.setString(2, data.getContainerBo());
        ps.setString(3, data.getContainerName());
        ps.setString(4, data.getSeq());
        ps.setString(5, data.getContent());
        ps.setBoolean(6, data.isReprint());
        ps.setInt(7, data.getPrintQty());
        ps.setString(8, data.getReserveField1());
        ps.setString(9, data.getReserveField2());
        DateUtils.setDateTz(ps, 10, data.getPrintTime());
        ps.setString(11, data.getPrintUser());
        ps.setString(12, data.getDateCode());
        ps.setString(13, data.getQrcode());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgPrintLabelLog data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getContainerBo());
      ps.setString(2, data.getContainerName());
      ps.setString(3, data.getSeq());
      ps.setString(4, data.getContent());
      ps.setBoolean(5, data.isReprint());
      ps.setInt(6, data.getPrintQty());
      ps.setString(7, data.getReserveField1());
      ps.setString(8, data.getReserveField2());
      DateUtils.setDateTz(ps, 9, data.getPrintTime());
      ps.setString(10, data.getPrintUser());
      ps.setString(11, data.getNewestPrint());
      ps.setString(12, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgPrintLabelLog> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgPrintLabelLog data : dataList) {
        ps.setString(1, data.getContainerBo());
        ps.setString(2, data.getContainerName());
        ps.setString(3, data.getSeq());
        ps.setString(4, data.getContent());
        ps.setBoolean(5, data.isReprint());
        ps.setInt(6, data.getPrintQty());
        ps.setString(7, data.getReserveField1());
        ps.setString(8, data.getReserveField2());
        DateUtils.setDateTz(ps, 9, data.getPrintTime());
        ps.setString(10, data.getPrintUser());
        ps.setString(11, data.getNewestPrint());
        ps.setString(12, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_print_label_log WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int deleteByContainer(String containerBo) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_pkg_print_label_log WHERE container_bo=?")) {
      ps.setString(1, containerBo);

      return ps.executeUpdate();
    }
  }

  public List<PkgPrintLabelLog> selectAll() throws SQLException {
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> selectByContainerBo(String containerBo) throws SQLException {
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where container_bo = ? ")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public List<PkgPrintLabelLog> select37ReprintReelTerminal(String containerBo)
      throws SQLException {//37卷盘终端标签
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_bo = ? and reprint_flag=false " +
            "and RESERVE_FIELD1 in('SAMSUNGE2-REEL','SAMSUNGSHORT-REEL','LG-REEL','GD80-REEL','PSN-HONOR')  order by print_time desc limit 1")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> select37ReprintReelCpn(String containerBo)
      throws SQLException {//37卷盘加贴标签
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_bo = ? and reprint_flag=false " +
            "and RESERVE_FIELD1 in('CPN-REEL')  order by print_time desc limit 1")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> select37ReprintInLabel(String containerBo)
      throws SQLException {//37内盒厂内标签：仅SEMTECH-INBOX一套模板
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_bo = ? and reprint_flag=false " +
            "and RESERVE_FIELD1 in('SEMTECH-INBOX','THINE-INBOX')  order by print_time desc ")) { //数量不做限制
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> select37ReprintInTerminalLabel(String containerBo)
      throws SQLException {//内盒终端标签
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_bo = ? and reprint_flag=false " +
            "and RESERVE_FIELD1 in('SAMSUNGE2-INBOX','SAMSUNGSHORT-INBOX','LG-INBOX','GD80-INBOX','BOX-HONOR')  order by print_time desc ")) { //数量不做限制
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> select37ReprintInCpn(String containerBo)
      throws SQLException {//内盒加贴标签
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_bo = ? and reprint_flag=false " +
            "and RESERVE_FIELD1 in('CPN-INBOX')  order by print_time desc ")) { //数量不做限制
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> select37ReprintOutLabel(String containerBo)
      throws SQLException {//外箱厂内标签
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_bo = ? and reprint_flag=false " +
            "and RESERVE_FIELD1 in('SEMTECH-OUTBOX1','THINE-OUTBOX')  order by print_time desc ")) { //数量不做限制
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> select37ReprintOutTerminalLabel(String containerBo)
      throws SQLException {//外箱终端标签
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_bo = ? and reprint_flag=false " +
            "and RESERVE_FIELD1 in('SEMTECH-OUTBOX2','SAMSUNGE2-OUTBOX')  order by print_time desc ")) { //数量不做限制
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> select37ReprintOutCpn(String containerBo)
      throws SQLException {//外箱加贴标签
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_bo = ? and reprint_flag=false " +
            "and RESERVE_FIELD1 in('CPN-OUTBOX')  order by print_time desc ")) { //数量不做限制
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> select37ReprintOut(String containerBo) throws SQLException {//外箱条码箱号
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_bo = ? and reprint_flag=false " +
            "and RESERVE_FIELD1 in('SEMTECH-XH')  order by print_time desc ")) { //数量不做限制
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public PkgPrintLabelLog selectNewByContainerBo(String containerBo, String reserveField1)
      throws SQLException { //查询最新的一条打印记录
    PkgPrintLabelLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where container_bo = ? and reserve_field1 = ? order by print_time desc limit 1")) {
      ps.setString(1, containerBo);
      ps.setString(2, reserveField1);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public PkgPrintLabelLog selectByQrCode(String qrCode)
      throws SQLException { //查询最新的一条打印记录
    PkgPrintLabelLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where QRCODE = ? ")) {
      ps.setString(1, qrCode);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public PkgPrintLabelLog selectByContatinerName(String contatinerName)
      throws SQLException { //查询最新的一条打印记录
    PkgPrintLabelLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where CONTAINER_NAME = ? ")) {
      ps.setString(1, contatinerName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public ArrayList<PkgPrintLabelLog> selectByContatinerNameList(String contatinerName)
      throws SQLException { //查询最新的一条打印记录
    ArrayList<PkgPrintLabelLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where CONTAINER_NAME = ? ")) {
      ps.setString(1, contatinerName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public ArrayList<PkgPrintLabelLog> selectByQrCodeList(String qrCode)
      throws SQLException { //查询最新的一条打印记录
    ArrayList<PkgPrintLabelLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "where QRCODE = ? ")) {
      ps.setString(1, qrCode);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public PkgPrintLabelLog selectNewByContainerBoAndTagAndLabel(String tagName, String containerBo,
      String reserveField1)
      throws SQLException { //查询最新的一条打印记录
    PkgPrintLabelLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_TAG
        + "where container_bo = ? and reserve_field1 = ? order by print_time desc limit 1")) {
      ps.setString(1, tagName);
      ps.setString(2, containerBo);
      ps.setString(3, reserveField1);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }


  public PkgPrintLabelLog selectByInventory(String reserveField1)
      throws SQLException { //查询最新的一条打印记录
    PkgPrintLabelLog result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where reserve_field1 = ? order by print_time desc")) {

      ps.setString(1, reserveField1);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public List<PkgPrintLabelLog> selectRecordsByContainerBo(String containerBo, String reserveField1,
      int num) throws SQLException { //查询最新的n条打印记录
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL
        + "where container_bo = ? and reserve_field1 = ? order by print_time desc limit ?")) {
      ps.setString(1, containerBo);
      ps.setString(2, reserveField1);
      ps.setInt(3, num);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> selectDnReprintInfo(String dn)
      throws SQLException { //查询某DN的所有记录，按照时间正序
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where reserve_field2 = ? order by print_time asc")) {
      ps.setString(1, dn);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> selectInventoryLog(String containerBo, String containerName,
      String seq) throws SQLException { //查询某DN的所有记录，按照时间正序
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where container_bo=? and container_name=? and seq=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, containerName);
      ps.setString(3, seq);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<String> selectAAlotByContainerBoOrderByPrintTime(String containerBo)
      throws SQLException {
    ArrayList<String> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT F_GET_TAG_VALUE(CONTENT, 'CUSTOMER_LOT_COMPLEX') from ZR_PKG_PRINT_LABEL_LOG where container_bo = ? and  RESERVE_FIELD1 in ('CHIPTRAY', 'CHIPTRAY-12')  order by PRINT_TIME desc ")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString(1));
      }
      return result;
    }
  }


  public String select76lotByContainerBoOrderByPrintTime(String containerBo) throws SQLException {
    String result = "";
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT F_GET_TAG_VALUE(CONTENT, '76_CUSTOMER_LOT_COMPLEX'),RESERVE_FIELD1 from ZR_PKG_PRINT_LABEL_LOG where container_bo = ? AND RESERVE_FIELD1 in('AAMPNIN1-13','AAMPNIN1') order by PRINT_TIME desc ")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = rs.getString(1);
      }
      return result;
    }
  }


  public String select68lotByContainerBoOrderByPrintTime(String containerBo) throws SQLException {
    String result = "";
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT F_GET_TAG_VALUE(CONTENT, '68_CUSTOMER_LOT'),RESERVE_FIELD1 from ZR_PKG_PRINT_LABEL_LOG where container_bo = ? AND RESERVE_FIELD1  in ('68IN1', '68IN1-1224') order by PRINT_TIME desc ")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = rs.getString(1);
      }
      return result;
    }
  }

  public String selectAC70lotByContainerBoOrderByPrintTime(String containerBo) throws SQLException {
    String result = "";
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT F_GET_TAG_VALUE(CONTENT, 'AC70ASYLOTIN'),RESERVE_FIELD1 from ZR_PKG_PRINT_LABEL_LOG where container_bo = ? AND RESERVE_FIELD1 in( 'HK037IN1-13', 'HK037IN1', 'HK037IN1-FC') order by PRINT_TIME desc ")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = rs.getString(1);
      }
      return result;
    }
  }

  public List<String> selectTagValueByContainerBoOrderByPrintTime(String tagName,
      String containerBo, String templateName) throws SQLException {
    ArrayList<String> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT F_GET_TAG_VALUE(CONTENT, ?) from ZR_PKG_PRINT_LABEL_LOG where container_bo = ? and  RESERVE_FIELD1 = ?  order by PRINT_TIME desc ")) {
      ps.setString(1, tagName);
      ps.setString(2, containerBo);
      ps.setString(3, templateName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString(1));
      }
      return result;
    }
  }

  public List<String> selectDA69DateCode(String containerBo) throws SQLException {
    ArrayList<String> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        "SELECT F_GET_TAG_VALUE(CONTENT, 'CUSTOMER_LOT_RESULT') || ':' ||date_code from ZR_PKG_PRINT_LABEL_LOG where container_bo = ? and  RESERVE_FIELD1 = 'DA69OUT1'  order by PRINT_TIME asc ")) {
      ps.setString(1, containerBo);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString(1));
      }
      return result;
    }
  }


  public PkgPrintLabelLog selectByPK(String id) throws SQLException {
    PkgPrintLabelLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }


  public PkgPrintLabelLog selectBySeq(String seq) throws SQLException {
    PkgPrintLabelLog result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE seq=?")) {
      ps.setString(1, seq);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public PkgPrintLabelLog selectLatestBySeq(String seq) throws SQLException {
    PkgPrintLabelLog result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE seq=? order by PRINT_TIME desc ")) {
      ps.setString(1, seq);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> selectLogsBySeq(String seq) throws SQLException {
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE seq=? order by PRINT_TIME desc ")) {
      ps.setString(1, seq);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public PkgPrintLabelLog selectLatestByQrcode(String qrcode) throws SQLException {
    PkgPrintLabelLog result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE qrcode=? order by PRINT_TIME desc ")) {
      ps.setString(1, qrcode);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> selectLogsByQrcode(String qrcode) throws SQLException {
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE qrcode=? order by PRINT_TIME desc ")) {
      ps.setString(1, qrcode);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> selectKeyInventoryLog(String containerBo, String containerName,
      String seq, String reserveField2) throws SQLException { //查询某DN的所有记录，按照时间正序
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "where container_bo=? and container_name=? and seq=? and reserve_field2=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, containerName);
      ps.setString(3, seq);
      ps.setString(4, reserveField2);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> selectKeyInventoryLogNew(String seq, String reserveField2)
      throws SQLException { //查询某DN的所有记录，按照时间正序
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "where  seq=? and reserve_field2=?")) {
      ps.setString(1, seq);
      ps.setString(2, reserveField2);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }

  public List<PkgPrintLabelLog> selectKeyInventoryLogNew(String containerBo, String containerName,
      String seq, String dateCode) throws SQLException { //查询某DN的所有记录，按照时间正序
    ArrayList<PkgPrintLabelLog> result = new ArrayList<PkgPrintLabelLog>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "where container_bo=? and container_name=? and seq=? and date_code=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, containerName);
      ps.setString(3, seq);
      ps.setString(4, dateCode);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
      return result;
    }
  }


  public List<PkgPrintLabelLog> select(Where where) throws SQLException {
    ArrayList<PkgPrintLabelLog> result = new ArrayList<>();
    try (PreparedStatement ps = where
        .prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<PkgPrintLabelLog> selectByLabelId(String reserveField1) throws SQLException {
    ArrayList<PkgPrintLabelLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "where reserve_field1 = ? order by print_time desc limit 300")) {

      ps.setString(1, reserveField1);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  private PkgPrintLabelLog convert(ResultSet rs) throws SQLException {
    PkgPrintLabelLog data = new PkgPrintLabelLog();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setContainerBo(rs.getString(index++));
    data.setContainerName(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setContent(rs.getString(index++));
    data.setReprintFlag(rs.getBoolean(index++));
    data.setPrintQty(rs.getInt(index++));
    data.setReserveField1(rs.getString(index++));
    data.setReserveField2(rs.getString(index++));
    data.setPrintTime(DateUtils.getDateTz(rs, index++));
    data.setPrintUser(rs.getString(index++));
    data.setDateCode(rs.getString(index++));
    data.setQrcode(rs.getString(index++));
    data.setNewestPrint(rs.getString(index++));
    return data;
  }

  public List<PkgPrintLabelLog> selectBySeqListLog(String s) throws SQLException {
    ArrayList<PkgPrintLabelLog> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE seq=? ")) {

      ps.setString(1, s);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }
}
