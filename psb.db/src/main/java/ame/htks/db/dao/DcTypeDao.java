package ame.htks.db.dao;

import ame.htks.db.DcType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DcTypeDao {

  private static final String SQL_INS = "INSERT INTO zh_dc_type(type_id,item_name,type_align_pos_x,type_align_pos_y,type_align_pos_value,align_fun,wording,align_pos_x,align_pos_y,f_value_coor_x,f_value_coor_y,value_desc,formula_string,formula_mul,n_value_coor_x_range,n_value_coor_y_range,f_waferid_x,f_waferid_y,n_waferid_coor_x_range,n_waferid_coor_y_range,formula_sub_x_range,formula_sub_y_range,formula_add_x_range,formula_add_y_range,by_wafer_or_lot) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zh_dc_type SET item_name=?,type_align_pos_x=?,type_align_pos_y=?,type_align_pos_value=?,align_fun=?,wording=?,align_pos_x=?,align_pos_y=?,f_value_coor_x=?,f_value_coor_y=?,value_desc=?,formula_string=?,formula_mul=?,n_value_coor_x_range=?,n_value_coor_y_range=?,f_waferid_x=?,f_waferid_y=?,n_waferid_coor_x_range=?,n_waferid_coor_y_range=?,formula_sub_x_range=?,formula_sub_y_range=?,formula_add_x_range=?,formula_add_y_range=?,by_wafer_or_lot=? WHERE type_id=?";

  private static final String SQL_SEL = "SELECT type_id,item_name,type_align_pos_x,type_align_pos_y,type_align_pos_value,align_fun,wording,align_pos_x,align_pos_y,f_value_coor_x,f_value_coor_y,value_desc,formula_string,formula_mul,n_value_coor_x_range,n_value_coor_y_range,f_waferid_x,f_waferid_y,n_waferid_coor_x_range,n_waferid_coor_y_range,formula_sub_x_range,formula_sub_y_range,formula_add_x_range,formula_add_y_range,by_wafer_or_lot FROM zh_dc_type ";

  private final Connection conn;

  public DcTypeDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(DcType data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getTypeId());
      ps.setString(2, data.getItemName());
      ps.setString(3, data.getTypeAlignPosX());
      ps.setString(4, data.getTypeAlignPosY());
      ps.setString(5, data.getTypeAlignPosValue());
      ps.setString(6, data.getAlignFun());
      ps.setString(7, data.getWording());
      ps.setString(8, data.getAlignPosX());
      ps.setString(9, data.getAlignPosY());
      ps.setString(10, data.getfValueCoorX());
      ps.setString(11, data.getfValueCoorY());
      ps.setString(12, data.getValueDesc());
      ps.setString(13, data.getFormulaString());
      ps.setString(14, data.getFormulaMul());
      ps.setString(15, data.getnValueCoorXRange());
      ps.setString(16, data.getnValueCoorYRange());
      ps.setString(17, data.getfWaferidX());
      ps.setString(18, data.getfWaferidY());
      ps.setString(19, data.getnWaferidCoorXRange());
      ps.setString(20, data.getnWaferidCoorYRange());
      ps.setString(21, data.getFormulaSubXRange());
      ps.setString(22, data.getFormulaSubYRange());
      ps.setString(23, data.getFormulaAddXRange());
      ps.setString(24, data.getFormulaAddYRange());
      ps.setString(25, data.getByWaferOrLot());

      return ps.executeUpdate();
    }
  }

  public int update(DcType data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getItemName());
      ps.setString(2, data.getTypeAlignPosX());
      ps.setString(3, data.getTypeAlignPosY());
      ps.setString(4, data.getTypeAlignPosValue());
      ps.setString(5, data.getAlignFun());
      ps.setString(6, data.getWording());
      ps.setString(7, data.getAlignPosX());
      ps.setString(8, data.getAlignPosY());
      ps.setString(9, data.getfValueCoorX());
      ps.setString(10, data.getfValueCoorY());
      ps.setString(11, data.getValueDesc());
      ps.setString(12, data.getFormulaString());
      ps.setString(13, data.getFormulaMul());
      ps.setString(14, data.getnValueCoorXRange());
      ps.setString(15, data.getnValueCoorYRange());
      ps.setString(16, data.getfWaferidX());
      ps.setString(17, data.getfWaferidY());
      ps.setString(18, data.getnWaferidCoorXRange());
      ps.setString(19, data.getnWaferidCoorYRange());
      ps.setString(20, data.getFormulaSubXRange());
      ps.setString(21, data.getFormulaSubYRange());
      ps.setString(22, data.getFormulaAddXRange());
      ps.setString(23, data.getFormulaAddYRange());
      ps.setString(24, data.getByWaferOrLot());
      ps.setString(25, data.getTypeId());

      return ps.executeUpdate();
    }
  }

  public List<DcType> selectAll() throws SQLException {
    ArrayList<DcType> result = new ArrayList<DcType>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public DcType selectByPK(String typeId) throws SQLException {
    DcType result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE type_id=?")) {
      ps.setString(1, typeId);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<DcType> selectByType(String typeId) throws SQLException {
    ArrayList<DcType> result = new ArrayList<DcType>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE type_id=?")) {
      ps.setString(1, typeId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private DcType convert(ResultSet rs) throws SQLException {
    DcType data = new DcType();

    int index = 1;
    data.setTypeId(rs.getString(index++));
    data.setItemName(rs.getString(index++));
    data.setTypeAlignPosX(rs.getString(index++));
    data.setTypeAlignPosY(rs.getString(index++));
    data.setTypeAlignPosValue(rs.getString(index++));
    data.setAlignFun(rs.getString(index++));
    data.setWording(rs.getString(index++));
    data.setAlignPosX(rs.getString(index++));
    data.setAlignPosY(rs.getString(index++));
    data.setfValueCoorX(rs.getString(index++));
    data.setfValueCoorY(rs.getString(index++));
    data.setValueDesc(rs.getString(index++));
    data.setFormulaString(rs.getString(index++));
    data.setFormulaMul(rs.getString(index++));
    data.setnValueCoorXRange(rs.getString(index++));
    data.setnValueCoorYRange(rs.getString(index++));
    data.setfWaferidX(rs.getString(index++));
    data.setfWaferidY(rs.getString(index++));
    data.setnWaferidCoorXRange(rs.getString(index++));
    data.setnWaferidCoorYRange(rs.getString(index++));
    data.setFormulaSubXRange(rs.getString(index++));
    data.setFormulaSubYRange(rs.getString(index++));
    data.setFormulaAddXRange(rs.getString(index++));
    data.setFormulaAddYRange(rs.getString(index++));
    data.setByWaferOrLot(rs.getString(index++));

    return data;
  }
}
