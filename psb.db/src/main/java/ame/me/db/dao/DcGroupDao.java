package ame.me.db.dao;

import ame.me.db.DcGroup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DcGroupDao {

  private static final String SQL_INS = "INSERT INTO dc_group(handle,dc_group,description,site,collect_data_at,pass_fail_group,revision,current_revision,status_bo,authentication_required,erp,collect_method,collection_type,created_date_time,modified_date_time,erp_inspection,erp_whole_group_inspection,me_eval_inspection,pass_fail_number) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE dc_group SET dc_group=?,description=?,site=?,collect_data_at=?,pass_fail_group=?,revision=?,current_revision=?,status_bo=?,authentication_required=?,erp=?,collect_method=?,collection_type=?,created_date_time=?,modified_date_time=?,erp_inspection=?,erp_whole_group_inspection=?,me_eval_inspection=?,pass_fail_number=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,dc_group,description,site,collect_data_at,pass_fail_group,revision,current_revision,status_bo,authentication_required,erp,collect_method,collection_type,created_date_time,modified_date_time,erp_inspection,erp_whole_group_inspection,me_eval_inspection,pass_fail_number FROM dc_group ";

  private final Connection conn;

  public DcGroupDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DcGroup data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getDcGroup());
      ps.setString(3, data.getDescription());
      ps.setString(4, data.getSite());
      ps.setString(5, data.getCollectDataAt());
      ps.setString(6, data.getPassFailGroup());
      ps.setString(7, data.getRevision());
      ps.setString(8, data.getCurrentRevision());
      ps.setString(9, data.getStatusBo());
      ps.setString(10, data.getAuthenticationRequired());
      ps.setString(11, data.getErp());
      ps.setString(12, data.getCollectMethod());
      ps.setString(13, data.getCollectionType());
      ps.setTimestamp(14, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(15, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(16, data.getErpInspection());
      ps.setString(17, data.getErpWholeGroupInspection());
      ps.setString(18, data.getMeEvalInspection());
      ps.setBigDecimal(19, data.getPassFailNumber());

      return ps.executeUpdate();
    }
  }

  public int update(DcGroup data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDcGroup());
      ps.setString(2, data.getDescription());
      ps.setString(3, data.getSite());
      ps.setString(4, data.getCollectDataAt());
      ps.setString(5, data.getPassFailGroup());
      ps.setString(6, data.getRevision());
      ps.setString(7, data.getCurrentRevision());
      ps.setString(8, data.getStatusBo());
      ps.setString(9, data.getAuthenticationRequired());
      ps.setString(10, data.getErp());
      ps.setString(11, data.getCollectMethod());
      ps.setString(12, data.getCollectionType());
      ps.setTimestamp(13, new Timestamp(data.getCreatedDateTime().getTime()));
      ps.setTimestamp(14, new Timestamp(data.getModifiedDateTime().getTime()));
      ps.setString(15, data.getErpInspection());
      ps.setString(16, data.getErpWholeGroupInspection());
      ps.setString(17, data.getMeEvalInspection());
      ps.setBigDecimal(18, data.getPassFailNumber());
      ps.setString(19, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public List<DcGroup> selectAll(String site) throws SQLException {
    ArrayList<DcGroup> result = new ArrayList<DcGroup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? ORDER BY handle")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public DcGroup selectByPK(String handle) throws SQLException {
    DcGroup result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public DcGroup selectByName(String site, String dcGroupName) throws SQLException {
    DcGroup result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? AND dc_group=?")) {
      ps.setString(1, site);
      ps.setString(2, dcGroupName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public DcGroup selectByName(String site, String dcGroupName, String revision)
      throws SQLException {
    DcGroup item = null;
    if (revision == null || revision.trim().length() == 0) {
      return selectByName(site, dcGroupName);
    }

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND dc_group=? AND revision=? ")) {
      ps.setString(1, site);
      ps.setString(2, dcGroupName);
      ps.setString(3, revision);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        item = convert(rs);
      }
    }
    return item;
  }

  private DcGroup convert(ResultSet rs) throws SQLException {
    DcGroup data = new DcGroup();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setDcGroup(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setCollectDataAt(rs.getString(index++));
    data.setPassFailGroup(rs.getString(index++));
    data.setRevision(rs.getString(index++));
    data.setCurrentRevision(rs.getString(index++));
    data.setStatusBo(rs.getString(index++));
    data.setAuthenticationRequired(rs.getString(index++));
    data.setErp(rs.getString(index++));
    data.setCollectMethod(rs.getString(index++));
    data.setCollectionType(rs.getString(index++));
    data.setCreatedDateTime(rs.getTimestamp(index++));
    data.setModifiedDateTime(rs.getTimestamp(index++));
    data.setErpInspection(rs.getString(index++));
    data.setErpWholeGroupInspection(rs.getString(index++));
    data.setMeEvalInspection(rs.getString(index++));
    data.setPassFailNumber(rs.getBigDecimal(index++));

    return data;
  }
}
