package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.HtNpiOutMapInfo;
import uia.utils.dao.DateUtils;

public class HtNpiOutMapInfoDao {

  private static final String SQL_INS = "INSERT INTO zd_ht_npi_out_map_info(info_id,customer_group,device_name,combine_map_operation,package_type,out_flag,out_sample_id,symbol_length,map_folder_name_rule,map_file_name_rule,client_map_rule,map_upload_node,compressed_package_flag,out_mode,alignment_die_symbol,csv_flag,ftp_host,ftp_path,ftp_user,ftp_password,customer_mail_address,receiving_terminal,special_request_flag,special_request_id,updated_time,updated_user,customer_codes,ftp_port) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_ht_npi_out_map_info SET customer_group=?,device_name=?,combine_map_operation=?,package_type=?,out_flag=?,out_sample_id=?,symbol_length=?,map_folder_name_rule=?,map_file_name_rule=?,client_map_rule=?,map_upload_node=?,compressed_package_flag=?,out_mode=?,alignment_die_symbol=?,csv_flag=?,ftp_host=?,ftp_path=?,ftp_user=?,ftp_password=?,customer_mail_address=?,receiving_terminal=?,special_request_flag=?,special_request_id=?,updated_time=?,updated_user=?,customer_codes=?,ftp_port=? WHERE info_id=?";

  private static final String SQL_SEL = "SELECT info_id,customer_group,device_name,combine_map_operation,package_type,out_flag,out_sample_id,symbol_length,map_folder_name_rule,map_file_name_rule,client_map_rule,map_upload_node,compressed_package_flag,out_mode,alignment_die_symbol,csv_flag,ftp_host,ftp_path,ftp_user,ftp_password,customer_mail_address,receiving_terminal,special_request_flag,special_request_id,updated_time,updated_user,customer_codes,ftp_port FROM zd_ht_npi_out_map_info ";

  private final Connection conn;

  public HtNpiOutMapInfoDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(HtNpiOutMapInfo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getInfoId());
      ps.setString(2, data.getCustomerGroup());
      ps.setString(3, data.getDeviceName());
      ps.setString(4, data.getCombineMapOperation());
      ps.setString(5, data.getPackageType());
      ps.setString(6, data.getOutFlag());
      ps.setString(7, data.getOutSampleId());
      ps.setInt(8, data.getSymbolLength());
      ps.setString(9, data.getMapFolderNameRule());
      ps.setString(10, data.getMapFileNameRule());
      ps.setString(11, data.getClientMapRule());
      ps.setString(12, data.getMapUploadNode());
      ps.setString(13, data.getCompressedPackageFlag());
      ps.setString(14, data.getOutMode());
      ps.setString(15, data.getAlignmentDieSymbol());
      ps.setString(16, data.getCsvFlag());
      ps.setString(17, data.getFtpHost());
      ps.setString(18, data.getFtpPath());
      ps.setString(19, data.getFtpUser());
      ps.setString(20, data.getFtpPassword());
      ps.setString(21, data.getCustomerMailAddress());
      ps.setString(22, data.getReceivingTerminal());
      ps.setString(23, data.getSpecialRequestFlag());
      ps.setString(24, data.getSpecialRequestId());
      DateUtils.setDateTz(ps, 25, data.getUpdatedTime());
      ps.setString(26, data.getUpdatedUser());
      ps.setString(27, data.getCustomerCodes());
      ps.setInt(28, data.getFtpPort());

      return ps.executeUpdate();
    }
  }

  public int insert(List<HtNpiOutMapInfo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (HtNpiOutMapInfo data : dataList) {
        ps.setString(1, data.getInfoId());
        ps.setString(2, data.getCustomerGroup());
        ps.setString(3, data.getDeviceName());
        ps.setString(4, data.getCombineMapOperation());
        ps.setString(5, data.getPackageType());
        ps.setString(6, data.getOutFlag());
        ps.setString(7, data.getOutSampleId());
        ps.setInt(8, data.getSymbolLength());
        ps.setString(9, data.getMapFolderNameRule());
        ps.setString(10, data.getMapFileNameRule());
        ps.setString(11, data.getClientMapRule());
        ps.setString(12, data.getMapUploadNode());
        ps.setString(13, data.getCompressedPackageFlag());
        ps.setString(14, data.getOutMode());
        ps.setString(15, data.getAlignmentDieSymbol());
        ps.setString(16, data.getCsvFlag());
        ps.setString(17, data.getFtpHost());
        ps.setString(18, data.getFtpPath());
        ps.setString(19, data.getFtpUser());
        ps.setString(20, data.getFtpPassword());
        ps.setString(21, data.getCustomerMailAddress());
        ps.setString(22, data.getReceivingTerminal());
        ps.setString(23, data.getSpecialRequestFlag());
        ps.setString(24, data.getSpecialRequestId());
        DateUtils.setDateTz(ps, 25, data.getUpdatedTime());
        ps.setString(26, data.getUpdatedUser());
        ps.setString(27, data.getCustomerCodes());
        ps.setInt(28, data.getFtpPort());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(HtNpiOutMapInfo data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getCustomerGroup());
      ps.setString(2, data.getDeviceName());
      ps.setString(3, data.getCombineMapOperation());
      ps.setString(4, data.getPackageType());
      ps.setString(5, data.getOutFlag());
      ps.setString(6, data.getOutSampleId());
      ps.setInt(7, data.getSymbolLength());
      ps.setString(8, data.getMapFolderNameRule());
      ps.setString(9, data.getMapFileNameRule());
      ps.setString(10, data.getClientMapRule());
      ps.setString(11, data.getMapUploadNode());
      ps.setString(12, data.getCompressedPackageFlag());
      ps.setString(13, data.getOutMode());
      ps.setString(14, data.getAlignmentDieSymbol());
      ps.setString(15, data.getCsvFlag());
      ps.setString(16, data.getFtpHost());
      ps.setString(17, data.getFtpPath());
      ps.setString(18, data.getFtpUser());
      ps.setString(19, data.getFtpPassword());
      ps.setString(20, data.getCustomerMailAddress());
      ps.setString(21, data.getReceivingTerminal());
      ps.setString(22, data.getSpecialRequestFlag());
      ps.setString(23, data.getSpecialRequestId());
      DateUtils.setDateTz(ps, 24, data.getUpdatedTime());
      ps.setString(25, data.getUpdatedUser());
      ps.setString(26, data.getCustomerCodes());
      ps.setInt(27, data.getFtpPort());
      ps.setString(28, data.getInfoId());

      return ps.executeUpdate();
    }
  }

  public int update(List<HtNpiOutMapInfo> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (HtNpiOutMapInfo data : dataList) {
        ps.setString(1, data.getCustomerGroup());
        ps.setString(2, data.getDeviceName());
        ps.setString(3, data.getCombineMapOperation());
        ps.setString(4, data.getPackageType());
        ps.setString(5, data.getOutFlag());
        ps.setString(6, data.getOutSampleId());
        ps.setInt(7, data.getSymbolLength());
        ps.setString(8, data.getMapFolderNameRule());
        ps.setString(9, data.getMapFileNameRule());
        ps.setString(10, data.getClientMapRule());
        ps.setString(11, data.getMapUploadNode());
        ps.setString(12, data.getCompressedPackageFlag());
        ps.setString(13, data.getOutMode());
        ps.setString(14, data.getAlignmentDieSymbol());
        ps.setString(15, data.getCsvFlag());
        ps.setString(16, data.getFtpHost());
        ps.setString(17, data.getFtpPath());
        ps.setString(18, data.getFtpUser());
        ps.setString(19, data.getFtpPassword());
        ps.setString(20, data.getCustomerMailAddress());
        ps.setString(21, data.getReceivingTerminal());
        ps.setString(22, data.getSpecialRequestFlag());
        ps.setString(23, data.getSpecialRequestId());
        DateUtils.setDateTz(ps, 24, data.getUpdatedTime());
        ps.setString(25, data.getUpdatedUser());
        ps.setString(26, data.getCustomerCodes());
        ps.setInt(27, data.getFtpPort());
        ps.setString(28, data.getInfoId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String infoId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_ht_npi_out_map_info WHERE info_id=?")) {
      ps.setString(1, infoId);

      return ps.executeUpdate();
    }
  }

  public List<HtNpiOutMapInfo> selectAll() throws SQLException {
    ArrayList<HtNpiOutMapInfo> result = new ArrayList<HtNpiOutMapInfo>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HtNpiOutMapInfo> selectByDevice(String deviceName) throws SQLException {
    ArrayList<HtNpiOutMapInfo> result = new ArrayList<HtNpiOutMapInfo>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE device_name=? ")) {
      ps.setString(1, deviceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HtNpiOutMapInfo> selectByCustomerCode(String customerCode) throws SQLException {
    ArrayList<HtNpiOutMapInfo> result = new ArrayList<HtNpiOutMapInfo>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE customer_codes like ? ")) {
      ps.setString(1, "%" + customerCode + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<HtNpiOutMapInfo> selectByCustomerCodeAndDevice(String customerCode,
      String deviceName) throws SQLException {
    ArrayList<HtNpiOutMapInfo> result = new ArrayList<HtNpiOutMapInfo>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE customer_codes like ? AND device_name=?  ")) {
      ps.setString(1, "%" + customerCode + "%");
      ps.setString(2, deviceName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public HtNpiOutMapInfo selectByPK(String infoId) throws SQLException {
    HtNpiOutMapInfo result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE info_id=?")) {
      ps.setString(1, infoId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private HtNpiOutMapInfo convert(ResultSet rs) throws SQLException {
    HtNpiOutMapInfo data = new HtNpiOutMapInfo();

    int index = 1;
    data.setInfoId(rs.getString(index++));
    data.setCustomerGroup(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setCombineMapOperation(rs.getString(index++));
    data.setPackageType(rs.getString(index++));
    data.setOutFlag(rs.getString(index++));
    data.setOutSampleId(rs.getString(index++));
    data.setSymbolLength(rs.getInt(index++));
    data.setMapFolderNameRule(rs.getString(index++));
    data.setMapFileNameRule(rs.getString(index++));
    data.setClientMapRule(rs.getString(index++));
    data.setMapUploadNode(rs.getString(index++));
    data.setCompressedPackageFlag(rs.getString(index++));
    data.setOutMode(rs.getString(index++));
    data.setAlignmentDieSymbol(rs.getString(index++));
    data.setCsvFlag(rs.getString(index++));
    data.setFtpHost(rs.getString(index++));
    data.setFtpPath(rs.getString(index++));
    data.setFtpUser(rs.getString(index++));
    data.setFtpPassword(rs.getString(index++));
    data.setCustomerMailAddress(rs.getString(index++));
    data.setReceivingTerminal(rs.getString(index++));
    data.setSpecialRequestFlag(rs.getString(index++));
    data.setSpecialRequestId(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setCustomerCodes(rs.getString(index++));
    data.setFtpPort(rs.getInt(index++));

    return data;
  }
}
