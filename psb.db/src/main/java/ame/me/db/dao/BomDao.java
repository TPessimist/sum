package ame.me.db.dao;

import ame.me.db.Bom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BomDao {

  private static final String SQL_INS = "INSERT INTO bom(handle,change_stamp,site,bom,bom_type,description,status_bo,tmp_bom,copied_from_bom_bo,revision,current_revision,bom_template,has_been_released,eff_start_date,eff_end_date,effectivity_control,prev_site,original_transfer_key,erp_bill_of_material,created_date_time,modified_date_time,partition_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE bom SET change_stamp=?,site=?,bom=?,bom_type=?,description=?,status_bo=?,tmp_bom=?,copied_from_bom_bo=?,revision=?,current_revision=?,bom_template=?,has_been_released=?,eff_start_date=?,eff_end_date=?,effectivity_control=?,prev_site=?,original_transfer_key=?,erp_bill_of_material=?,created_date_time=?,modified_date_time=?,partition_date=? WHERE handle=?";

  private static final String SQL_UPD_HASBEENRELEASED = "UPDATE bom SET has_been_released = 'false'  WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,bom,bom_type,description,status_bo,tmp_bom,copied_from_bom_bo,revision,current_revision,bom_template,has_been_released,eff_start_date,eff_end_date,effectivity_control,prev_site,original_transfer_key,erp_bill_of_material,created_date_time,modified_date_time,partition_date FROM bom ";

  private final Connection conn;

  public BomDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Bom data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setBigDecimal(2, data.getChangeStamp());
      ps.setString(3, data.getSite());
      ps.setString(4, data.getBom());
      ps.setString(5, data.getBomType());
      ps.setString(6, data.getDescription());
      ps.setString(7, data.getStatusBo());
      ps.setString(8, data.getTmpBom());
      ps.setString(9, data.getCopiedFromBomBo());
      ps.setString(10, data.getRevision());
      ps.setString(11, data.getCurrentRevision());
      ps.setString(12, data.getBomTemplate());
      ps.setString(13, data.getHasBeenReleased());
      DateUtils.setDateTz(ps, 14, data.getEffStartDate());
      DateUtils.setDateTz(ps, 15, data.getEffEndDate());
      ps.setString(16, data.getEffectivityControl());
      ps.setString(17, data.getPrevSite());
      ps.setString(18, data.getOriginalTransferKey());
      ps.setString(19, data.getErpBillOfMaterial());
      DateUtils.setDateTz(ps, 20, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 21, data.getModifiedDateTime());
      DateUtils.setDateTz(ps, 22, data.getPartitionDate());

      return ps.executeUpdate();
    }
  }

  public int insert(List<Bom> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (Bom data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setBigDecimal(2, data.getChangeStamp());
        ps.setString(3, data.getSite());
        ps.setString(4, data.getBom());
        ps.setString(5, data.getBomType());
        ps.setString(6, data.getDescription());
        ps.setString(7, data.getStatusBo());
        ps.setString(8, data.getTmpBom());
        ps.setString(9, data.getCopiedFromBomBo());
        ps.setString(10, data.getRevision());
        ps.setString(11, data.getCurrentRevision());
        ps.setString(12, data.getBomTemplate());
        ps.setString(13, data.getHasBeenReleased());
        DateUtils.setDateTz(ps, 14, data.getEffStartDate());
        DateUtils.setDateTz(ps, 15, data.getEffEndDate());
        ps.setString(16, data.getEffectivityControl());
        ps.setString(17, data.getPrevSite());
        ps.setString(18, data.getOriginalTransferKey());
        ps.setString(19, data.getErpBillOfMaterial());
        DateUtils.setDateTz(ps, 20, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 21, data.getModifiedDateTime());
        DateUtils.setDateTz(ps, 22, data.getPartitionDate());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateReleased(String bomRef) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_HASBEENRELEASED)) {
      ps.setString(1, bomRef);
      return ps.executeUpdate();
    }
  }

  public int update(Bom data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setBigDecimal(1, data.getChangeStamp());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getBom());
      ps.setString(4, data.getBomType());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getStatusBo());
      ps.setString(7, data.getTmpBom());
      ps.setString(8, data.getCopiedFromBomBo());
      ps.setString(9, data.getRevision());
      ps.setString(10, data.getCurrentRevision());
      ps.setString(11, data.getBomTemplate());
      ps.setString(12, data.getHasBeenReleased());
      DateUtils.setDateTz(ps, 13, data.getEffStartDate());
      DateUtils.setDateTz(ps, 14, data.getEffEndDate());
      ps.setString(15, data.getEffectivityControl());
      ps.setString(16, data.getPrevSite());
      ps.setString(17, data.getOriginalTransferKey());
      ps.setString(18, data.getErpBillOfMaterial());
      DateUtils.setDateTz(ps, 19, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 20, data.getModifiedDateTime());
      DateUtils.setDateTz(ps, 21, data.getPartitionDate());
      ps.setString(22, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<Bom> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (Bom data : dataList) {
        ps.setBigDecimal(1, data.getChangeStamp());
        ps.setString(2, data.getSite());
        ps.setString(3, data.getBom());
        ps.setString(4, data.getBomType());
        ps.setString(5, data.getDescription());
        ps.setString(6, data.getStatusBo());
        ps.setString(7, data.getTmpBom());
        ps.setString(8, data.getCopiedFromBomBo());
        ps.setString(9, data.getRevision());
        ps.setString(10, data.getCurrentRevision());
        ps.setString(11, data.getBomTemplate());
        ps.setString(12, data.getHasBeenReleased());
        DateUtils.setDateTz(ps, 13, data.getEffStartDate());
        DateUtils.setDateTz(ps, 14, data.getEffEndDate());
        ps.setString(15, data.getEffectivityControl());
        ps.setString(16, data.getPrevSite());
        ps.setString(17, data.getOriginalTransferKey());
        ps.setString(18, data.getErpBillOfMaterial());
        DateUtils.setDateTz(ps, 19, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 20, data.getModifiedDateTime());
        DateUtils.setDateTz(ps, 21, data.getPartitionDate());
        ps.setString(22, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("DELETE FROM bom WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<Bom> selectAll() throws SQLException {
    ArrayList<Bom> result = new ArrayList<Bom>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public Bom selectByPK(String handle) throws SQLException {
    Bom result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private Bom convert(ResultSet rs) throws SQLException {
    Bom data = new Bom();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setChangeStamp(rs.getBigDecimal(index++));
    data.setSite(rs.getString(index++));
    data.setBom(rs.getString(index++));
    data.setBomType(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setTmpBom(rs.getString(index++));
    data.setCopiedFromBomBo(rs.getString(index++));
    data.setRevision(rs.getString(index++));
    data.setCurrentRevision(rs.getString(index++));
    data.setBomTemplate(rs.getString(index++));
    data.setHasBeenReleased(rs.getString(index++));
    data.setEffStartDate(DateUtils.getDateTz(rs, index++));
    data.setEffEndDate(DateUtils.getDateTz(rs, index++));
    data.setEffectivityControl(rs.getString(index++));
    data.setPrevSite(rs.getString(index++));
    data.setOriginalTransferKey(rs.getString(index++));
    data.setErpBillOfMaterial(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setPartitionDate(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
