package ame.me.db.dao;

import ame.me.db.BomComponent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class BomComponentDao {

  private static final String SQL_INS = "INSERT INTO bom_component(handle,bom_bo,component_gbo,sequence,enabled,valid_start,valid_end,use_item_defaults,pre_assembled,assy_data_type_bo,qty,test_part,bom_template,disassemble_operation_bo,create_trackable_sfc,maximum_usage,maximum_nc,assemble_as_req,auto_consume_kit,created_date_time,modified_date_time,bom_component_type,parent_sequence,erp_sequence,order_item_number,erp_change_number) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE bom_component SET bom_bo=?,component_gbo=?,sequence=?,enabled=?,valid_start=?,valid_end=?,use_item_defaults=?,pre_assembled=?,assy_data_type_bo=?,qty=?,test_part=?,bom_template=?,disassemble_operation_bo=?,create_trackable_sfc=?,maximum_usage=?,maximum_nc=?,assemble_as_req=?,auto_consume_kit=?,created_date_time=?,modified_date_time=?,bom_component_type=?,parent_sequence=?,erp_sequence=?,order_item_number=?,erp_change_number=? WHERE handle=?";

  private static final String SQL_UPD_MODIFYDATETIME = "UPDATE bom_component SET modified_date_time = CURRENT_TIMESTAMP WHERE bom_bo = ? ";

  private static final String SQL_SEL = "SELECT handle,bom_bo,component_gbo,sequence,enabled,valid_start,valid_end,use_item_defaults,pre_assembled,assy_data_type_bo,qty,test_part,bom_template,disassemble_operation_bo,create_trackable_sfc,maximum_usage,maximum_nc,assemble_as_req,auto_consume_kit,created_date_time,modified_date_time,bom_component_type,parent_sequence,erp_sequence,order_item_number,erp_change_number FROM bom_component ";

  private final Connection conn;

  public BomComponentDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BomComponent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getBomBo());
      ps.setString(3, data.getComponentGbo());
      ps.setBigDecimal(4, data.getSequence());
      ps.setString(5, data.getEnabled());
      DateUtils.setDateTz(ps, 6, data.getValidStart());
      DateUtils.setDateTz(ps, 7, data.getValidEnd());
      ps.setString(8, data.getUseItemDefaults());
      ps.setString(9, data.getPreAssembled());
      ps.setString(10, data.getAssyDataTypeBo());
      ps.setBigDecimal(11, data.getQty());
      ps.setString(12, data.getTestPart());
      ps.setString(13, data.getBomTemplate());
      ps.setString(14, data.getDisassembleOperationBo());
      ps.setString(15, data.getCreateTrackableSfc());
      ps.setBigDecimal(16, data.getMaximumUsage());
      ps.setBigDecimal(17, data.getMaximumNc());
      ps.setString(18, data.getAssembleAsReq());
      ps.setString(19, data.getAutoConsumeKit());
      DateUtils.setDateTz(ps, 20, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 21, data.getModifiedDateTime());
      ps.setString(22, data.getBomComponentType());
      ps.setBigDecimal(23, data.getParentSequence());
      ps.setBigDecimal(24, data.getErpSequence());
      ps.setString(25, data.getOrderItemNumber());
      ps.setString(26, data.getErpChangeNumber());

      return ps.executeUpdate();
    }
  }

  public int insert(List<BomComponent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BomComponent data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getBomBo());
        ps.setString(3, data.getComponentGbo());
        ps.setBigDecimal(4, data.getSequence());
        ps.setString(5, data.getEnabled());
        DateUtils.setDateTz(ps, 6, data.getValidStart());
        DateUtils.setDateTz(ps, 7, data.getValidEnd());
        ps.setString(8, data.getUseItemDefaults());
        ps.setString(9, data.getPreAssembled());
        ps.setString(10, data.getAssyDataTypeBo());
        ps.setBigDecimal(11, data.getQty());
        ps.setString(12, data.getTestPart());
        ps.setString(13, data.getBomTemplate());
        ps.setString(14, data.getDisassembleOperationBo());
        ps.setString(15, data.getCreateTrackableSfc());
        ps.setBigDecimal(16, data.getMaximumUsage());
        ps.setBigDecimal(17, data.getMaximumNc());
        ps.setString(18, data.getAssembleAsReq());
        ps.setString(19, data.getAutoConsumeKit());
        DateUtils.setDateTz(ps, 20, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 21, data.getModifiedDateTime());
        ps.setString(22, data.getBomComponentType());
        ps.setBigDecimal(23, data.getParentSequence());
        ps.setBigDecimal(24, data.getErpSequence());
        ps.setString(25, data.getOrderItemNumber());
        ps.setString(26, data.getErpChangeNumber());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }


  public int updateModifyDateTime(String bomRef) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_MODIFYDATETIME)) {
      ps.setString(1, bomRef);

      return ps.executeUpdate();
    }
  }

  public int update(BomComponent data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getBomBo());
      ps.setString(2, data.getComponentGbo());
      ps.setBigDecimal(3, data.getSequence());
      ps.setString(4, data.getEnabled());
      DateUtils.setDateTz(ps, 5, data.getValidStart());
      DateUtils.setDateTz(ps, 6, data.getValidEnd());
      ps.setString(7, data.getUseItemDefaults());
      ps.setString(8, data.getPreAssembled());
      ps.setString(9, data.getAssyDataTypeBo());
      ps.setBigDecimal(10, data.getQty());
      ps.setString(11, data.getTestPart());
      ps.setString(12, data.getBomTemplate());
      ps.setString(13, data.getDisassembleOperationBo());
      ps.setString(14, data.getCreateTrackableSfc());
      ps.setBigDecimal(15, data.getMaximumUsage());
      ps.setBigDecimal(16, data.getMaximumNc());
      ps.setString(17, data.getAssembleAsReq());
      ps.setString(18, data.getAutoConsumeKit());
      DateUtils.setDateTz(ps, 19, data.getCreatedDateTime());
      DateUtils.setDateTz(ps, 20, data.getModifiedDateTime());
      ps.setString(21, data.getBomComponentType());
      ps.setBigDecimal(22, data.getParentSequence());
      ps.setBigDecimal(23, data.getErpSequence());
      ps.setString(24, data.getOrderItemNumber());
      ps.setString(25, data.getErpChangeNumber());
      ps.setString(26, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<BomComponent> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BomComponent data : dataList) {
        ps.setString(1, data.getBomBo());
        ps.setString(2, data.getComponentGbo());
        ps.setBigDecimal(3, data.getSequence());
        ps.setString(4, data.getEnabled());
        DateUtils.setDateTz(ps, 5, data.getValidStart());
        DateUtils.setDateTz(ps, 6, data.getValidEnd());
        ps.setString(7, data.getUseItemDefaults());
        ps.setString(8, data.getPreAssembled());
        ps.setString(9, data.getAssyDataTypeBo());
        ps.setBigDecimal(10, data.getQty());
        ps.setString(11, data.getTestPart());
        ps.setString(12, data.getBomTemplate());
        ps.setString(13, data.getDisassembleOperationBo());
        ps.setString(14, data.getCreateTrackableSfc());
        ps.setBigDecimal(15, data.getMaximumUsage());
        ps.setBigDecimal(16, data.getMaximumNc());
        ps.setString(17, data.getAssembleAsReq());
        ps.setString(18, data.getAutoConsumeKit());
        DateUtils.setDateTz(ps, 19, data.getCreatedDateTime());
        DateUtils.setDateTz(ps, 20, data.getModifiedDateTime());
        ps.setString(21, data.getBomComponentType());
        ps.setBigDecimal(22, data.getParentSequence());
        ps.setBigDecimal(23, data.getErpSequence());
        ps.setString(24, data.getOrderItemNumber());
        ps.setString(25, data.getErpChangeNumber());
        ps.setString(26, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateHandle(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement(" update BOM set HAS_BEEN_RELEASED = 'false' where HANDLE = ?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM bom_component WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<BomComponent> selectAll() throws SQLException {
    ArrayList<BomComponent> result = new ArrayList<BomComponent>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public BomComponent selectByPK(String handle) throws SQLException {
    BomComponent result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private BomComponent convert(ResultSet rs) throws SQLException {
    BomComponent data = new BomComponent();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setBomBo(rs.getString(index++));
    data.setComponentGbo(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));
    data.setEnabled(rs.getString(index++));
    data.setValidStart(DateUtils.getDateTz(rs, index++));
    data.setValidEnd(DateUtils.getDateTz(rs, index++));
    data.setUseItemDefaults(rs.getString(index++));
    data.setPreAssembled(rs.getString(index++));
    data.setAssyDataTypeBo(rs.getString(index++));
    data.setQty(rs.getBigDecimal(index++));
    data.setTestPart(rs.getString(index++));
    data.setBomTemplate(rs.getString(index++));
    data.setDisassembleOperationBo(rs.getString(index++));
    data.setCreateTrackableSfc(rs.getString(index++));
    data.setMaximumUsage(rs.getBigDecimal(index++));
    data.setMaximumNc(rs.getBigDecimal(index++));
    data.setAssembleAsReq(rs.getString(index++));
    data.setAutoConsumeKit(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setBomComponentType(rs.getString(index++));
    data.setParentSequence(rs.getBigDecimal(index++));
    data.setErpSequence(rs.getBigDecimal(index++));
    data.setOrderItemNumber(rs.getString(index++));
    data.setErpChangeNumber(rs.getString(index++));

    return data;
  }
}
