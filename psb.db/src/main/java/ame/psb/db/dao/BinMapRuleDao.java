package ame.psb.db.dao;

import ame.psb.db.BinMapRule;
import ame.psb.db.ViewBinMapRule;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class BinMapRuleDao {

  private static final String SQL_INS = "INSERT INTO zd_binmap_rule(id,start_x,start_y,wafer_direction,row_count,col_count,die_qty,lot_id_row,lot_id_col,wafer_id_row,wafer_id_col,positive,symbol_length,symbol_interval,alignment_die_symbol,incoming_bad_die_symbol,process_bad_die_symbol,dutms,xdie_size,ydie_size,updated_user,updated_time,status,ink_symbol,background_file_id,screen_inch,strip_block_length) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_binmap_rule SET start_x=?,start_y=?,wafer_direction=?,row_count=?,col_count=?,die_qty=?,lot_id_row=?,lot_id_col=?,wafer_id_row=?,wafer_id_col=?,positive=?,symbol_length=?,symbol_interval=?,alignment_die_symbol=?incoming_bad_die_symbol=?,process_bad_die_symbol=?,dutms=?,xdie_size=?,ydie_size=?,updated_user=?,updated_time=?,ink_symbol=?,background_file_id=?,screen_inch=?,strip_block_length=? WHERE id=?";

  private static final String SQL_SEL = "SELECT id,start_x,start_y,wafer_direction,row_count,col_count,die_qty,lot_id_row,lot_id_col,wafer_id_row,wafer_id_col,positive,symbol_length,symbol_interval,alignment_die_symbol,incoming_bad_die_symbol,process_bad_die_symbol,dutms,xdie_size,ydie_size,updated_user,updated_time,status,ink_symbol,background_file_id,screen_inch,strip_block_length FROM zd_binmap_rule ";

  private final Connection conn;

  public BinMapRuleDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(BinMapRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setInt(2, data.getStartX());
      ps.setInt(3, data.getStartY());
      ps.setInt(4, data.getWaferDirection());
      if (data.getRowCount() != null && data.getRowCount() > 0) {
        ps.setInt(5, data.getRowCount());
      } else {
        ps.setNull(5, Types.INTEGER);
      }
      if (data.getColCount() != null && data.getColCount() > 0) {
        ps.setInt(6, data.getColCount());
      } else {
        ps.setNull(6, Types.INTEGER);
      }
      if (data.getDieQty() != null && data.getDieQty() > 0) {
        ps.setInt(7, data.getDieQty());
      } else {
        ps.setNull(7, Types.INTEGER);
      }
      if (data.getLotIdRow() != null && data.getLotIdRow() > 0) {
        ps.setInt(8, data.getLotIdRow());
      } else {
        ps.setNull(8, Types.INTEGER);
      }
      if (data.getLotIdCol() != null && data.getLotIdCol() > 0) {
        ps.setInt(9, data.getLotIdCol());
      } else {
        ps.setNull(9, Types.INTEGER);
      }
      if (data.getWaferIdRow() != null && data.getWaferIdRow() > 0) {
        ps.setInt(10, data.getWaferIdRow());
      } else {
        ps.setNull(10, Types.INTEGER);
      }
      if (data.getWaferIdCol() != null && data.getWaferIdCol() > 0) {
        ps.setInt(11, data.getWaferIdCol());
      } else {
        ps.setNull(11, Types.INTEGER);
      }
      ps.setString(12, data.getPositive());
      ps.setInt(13, data.getSymbolLength());
      ps.setInt(14, data.getSymbolInterval());
      ps.setString(15, data.getAlignmentDieSymbol());
      ps.setString(16, data.getIncomingBadDieSymbol());
      ps.setString(17, data.getProcessBadDieSymbol());
      ps.setString(18, data.getDutms());
      ps.setBigDecimal(19, data.getXdieSize());
      ps.setBigDecimal(20, data.getYdieSize());
      ps.setString(21, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 22, data.getUpdatedTime());
      ps.setString(23, data.getStatus());
      ps.setString(24, data.getInkSymbol());
      ps.setString(25, data.getBackgroundFileId());
      ps.setBigDecimal(26, data.getScreenInch());
      if (data.getStripBlockLength() != null && data.getStripBlockLength() > 0) {
        ps.setInt(27, data.getStripBlockLength());
      } else {
        ps.setNull(27, Types.INTEGER);
      }
      return ps.executeUpdate();
    }
  }

  public int insert(List<BinMapRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (BinMapRule data : dataList) {
        ps.setString(1, data.getId());
        ps.setInt(2, data.getStartX());
        ps.setInt(3, data.getStartY());
        ps.setInt(4, data.getWaferDirection());
        if (data.getRowCount() != null && data.getRowCount() > 0) {
          ps.setInt(5, data.getRowCount());
        } else {
          ps.setNull(5, Types.INTEGER);
        }
        if (data.getColCount() != null && data.getColCount() > 0) {
          ps.setInt(6, data.getColCount());
        } else {
          ps.setNull(6, Types.INTEGER);
        }
        if (data.getDieQty() != null && data.getDieQty() > 0) {
          ps.setInt(7, data.getDieQty());
        } else {
          ps.setNull(7, Types.INTEGER);
        }
        if (data.getLotIdRow() != null && data.getLotIdRow() > 0) {
          ps.setInt(8, data.getLotIdRow());
        } else {
          ps.setNull(8, Types.INTEGER);
        }
        if (data.getLotIdCol() != null && data.getLotIdCol() > 0) {
          ps.setInt(9, data.getLotIdCol());
        } else {
          ps.setNull(9, Types.INTEGER);
        }
        if (data.getWaferIdRow() != null && data.getWaferIdRow() > 0) {
          ps.setInt(10, data.getWaferIdRow());
        } else {
          ps.setNull(10, Types.INTEGER);
        }
        if (data.getWaferIdCol() != null && data.getWaferIdCol() > 0) {
          ps.setInt(11, data.getWaferIdCol());
        } else {
          ps.setNull(11, Types.INTEGER);
        }
        ps.setString(12, data.getPositive());
        ps.setInt(13, data.getSymbolLength());
        ps.setInt(14, data.getSymbolInterval());
        ps.setString(15, data.getAlignmentDieSymbol());
        ps.setString(16, data.getIncomingBadDieSymbol());
        ps.setString(17, data.getProcessBadDieSymbol());
        ps.setString(18, data.getDutms());
        ps.setBigDecimal(19, data.getXdieSize());
        ps.setBigDecimal(20, data.getYdieSize());
        ps.setString(21, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 22, data.getUpdatedTime());
        ps.setString(23, data.getStatus());
        ps.setString(24, data.getInkSymbol());
        ps.setString(25, data.getBackgroundFileId());
        ps.setBigDecimal(26, data.getScreenInch());
        if (data.getStripBlockLength() != null && data.getStripBlockLength() > 0) {
          ps.setInt(27, data.getStripBlockLength());
        } else {
          ps.setNull(27, Types.INTEGER);
        }
        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int updateById(BigDecimal screenInch,String updateUser,Date updateTime,String id ) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement("UPDATE zd_binmap_rule SET SCREEN_INCH = ? ,UPDATED_USER = ? , UPDATED_TIME = ? \n"
        + "WHERE id = ? ")) {
      ps.setBigDecimal(1,screenInch);
      ps.setString(2, updateUser);
      DateUtils.setDateTz(ps, 3, updateTime);
      ps.setString(4, id);

      return ps.executeUpdate();
    }
  }

  public int update(BinMapRule data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setInt(1, data.getStartX());
      ps.setInt(2, data.getStartY());
      ps.setInt(3, data.getWaferDirection());
      if (data.getRowCount() != null && data.getRowCount() > 0) {
        ps.setInt(4, data.getRowCount());
      } else {
        ps.setNull(4, Types.INTEGER);
      }
      if (data.getColCount() != null && data.getColCount() > 0) {
        ps.setInt(5, data.getColCount());
      } else {
        ps.setNull(5, Types.INTEGER);
      }
      if (data.getDieQty() != null && data.getDieQty() > 0) {
        ps.setInt(6, data.getDieQty());
      } else {
        ps.setNull(6, Types.INTEGER);
      }
      if (data.getLotIdRow() != null && data.getLotIdRow() > 0) {
        ps.setInt(7, data.getLotIdRow());
      } else {
        ps.setNull(7, Types.INTEGER);
      }
      if (data.getLotIdCol() != null && data.getLotIdCol() > 0) {
        ps.setInt(8, data.getLotIdCol());
      } else {
        ps.setNull(8, Types.INTEGER);
      }
      if (data.getWaferIdRow() != null && data.getWaferIdRow() > 0) {
        ps.setInt(9, data.getWaferIdRow());
      } else {
        ps.setNull(9, Types.INTEGER);
      }
      if (data.getWaferIdCol() != null && data.getWaferIdCol() > 0) {
        ps.setInt(10, data.getWaferIdCol());
      } else {
        ps.setNull(10, Types.INTEGER);
      }
      ps.setString(11, data.getPositive());
      ps.setInt(12, data.getSymbolLength());
      ps.setInt(13, data.getSymbolInterval());
      ps.setString(14, data.getAlignmentDieSymbol());
      ps.setString(15, data.getIncomingBadDieSymbol());
      ps.setString(16, data.getProcessBadDieSymbol());
      ps.setString(17, data.getDutms());
      ps.setBigDecimal(18, data.getXdieSize());
      ps.setBigDecimal(19, data.getYdieSize());
      ps.setString(20, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 21, data.getUpdatedTime());
      ps.setString(22, data.getInkSymbol());
      ps.setString(23, data.getBackgroundFileId());
      ps.setBigDecimal(24, data.getScreenInch());
      if (data.getStripBlockLength() != null && data.getStripBlockLength() > 0) {
        ps.setInt(25, data.getStripBlockLength());
      } else {
        ps.setNull(25, Types.INTEGER);
      }
      ps.setString(26, data.getId());

      return ps.executeUpdate();
    }
  }

  public int update(List<BinMapRule> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (BinMapRule data : dataList) {
        ps.setInt(1, data.getStartX());
        ps.setInt(2, data.getStartY());
        ps.setInt(3, data.getWaferDirection());
        if (data.getRowCount() != null && data.getRowCount() > 0) {
          ps.setInt(4, data.getRowCount());
        } else {
          ps.setNull(4, Types.INTEGER);
        }
        if (data.getColCount() != null && data.getColCount() > 0) {
          ps.setInt(5, data.getColCount());
        } else {
          ps.setNull(5, Types.INTEGER);
        }
        if (data.getDieQty() != null && data.getDieQty() > 0) {
          ps.setInt(6, data.getDieQty());
        } else {
          ps.setNull(6, Types.INTEGER);
        }
        if (data.getLotIdRow() != null && data.getLotIdRow() > 0) {
          ps.setInt(7, data.getLotIdRow());
        } else {
          ps.setNull(7, Types.INTEGER);
        }
        if (data.getLotIdCol() != null && data.getLotIdCol() > 0) {
          ps.setInt(8, data.getLotIdCol());
        } else {
          ps.setNull(8, Types.INTEGER);
        }
        if (data.getWaferIdRow() != null && data.getWaferIdRow() > 0) {
          ps.setInt(9, data.getWaferIdRow());
        } else {
          ps.setNull(9, Types.INTEGER);
        }
        if (data.getWaferIdCol() != null && data.getWaferIdCol() > 0) {
          ps.setInt(10, data.getWaferIdCol());
        } else {
          ps.setNull(10, Types.INTEGER);
        }
        ps.setString(11, data.getPositive());
        ps.setInt(12, data.getSymbolLength());
        ps.setInt(13, data.getSymbolInterval());
        ps.setString(14, data.getAlignmentDieSymbol());
        ps.setString(15, data.getIncomingBadDieSymbol());
        ps.setString(16, data.getProcessBadDieSymbol());
        ps.setString(17, data.getDutms());
        ps.setBigDecimal(18, data.getXdieSize());
        ps.setBigDecimal(19, data.getYdieSize());
        ps.setString(20, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 21, data.getUpdatedTime());
        ps.setString(22, data.getInkSymbol());
        ps.setString(23, data.getBackgroundFileId());
        ps.setBigDecimal(24, data.getScreenInch());
        if (data.getStripBlockLength() != null && data.getStripBlockLength() > 0) {
          ps.setInt(25, data.getStripBlockLength());
        } else {
          ps.setNull(25, Types.INTEGER);
        }
        ps.setString(26, data.getId());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String id) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("delete from zd_binmap_rule WHERE id=?")) {
      ps.setString(1, id);

      return ps.executeUpdate();
    }
  }

  public int virtualDelete(String id, String user) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_binmap_rule SET status='D',updated_time=?,updated_user=? WHERE id=?")) {
      DateUtils.setDateTz(ps, 1, new Date());
      ps.setString(2, user);
      ps.setString(3, id);

      return ps.executeUpdate();
    }
  }

  public int updateInkSymbol(String id, String inkSymbol) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_binmap_rule SET INK_SYMBOL=? WHERE id=?")) {
      ps.setString(1, inkSymbol);
      ps.setString(2, id);

      return ps.executeUpdate();
    }
  }

  public int updateAlignmentSymbol(String id, String alignmentSymbol) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "UPDATE zd_binmap_rule SET ALIGNMENT_DIE_SYMBOL=? WHERE id=?")) {
      ps.setString(1, alignmentSymbol);
      ps.setString(2, id);

      return ps.executeUpdate();
    }
  }

  public List<ViewBinMapRule> selectAll() throws SQLException {
    ArrayList<ViewBinMapRule> result = new ArrayList<ViewBinMapRule>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE status<>'D'")) {
      ps.setMaxRows(0);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ViewBinMapRule selectByPK(String id, boolean containsDeleted) throws SQLException {
    ViewBinMapRule result = null;
    String sql = SQL_SEL + "WHERE id=?";
    if (!containsDeleted) {
      sql += "AND status<>'D'";
    }
    try (PreparedStatement ps = this.conn.prepareStatement(sql)) {

      ps.setMaxRows(0);

      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ViewBinMapRule convert(ResultSet rs) throws SQLException {
    ViewBinMapRule data = new ViewBinMapRule();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setStartX(rs.getInt(index++));
    data.setStartY(rs.getInt(index++));
    data.setWaferDirection(rs.getInt(index++));
    data.setRowCount(rs.getInt(index++));
    data.setColCount(rs.getInt(index++));
    data.setDieQty(rs.getInt(index++));
    data.setLotIdRow(rs.getInt(index++));
    data.setLotIdCol(rs.getInt(index++));
    data.setWaferIdRow(rs.getInt(index++));
    data.setWaferIdCol(rs.getInt(index++));
    data.setPositive(rs.getString(index++));
    data.setSymbolLength(rs.getInt(index++));
    data.setSymbolInterval(rs.getInt(index++));
    data.setAlignmentDieSymbol(rs.getString(index++));
    data.setIncomingBadDieSymbol(rs.getString(index++));
    data.setProcessBadDieSymbol(rs.getString(index++));
    data.setDutms(rs.getString(index++));
    data.setXdieSize(rs.getBigDecimal(index++));
    data.setYdieSize(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setStatus(rs.getString(index++));
    data.setInkSymbol(rs.getString(index++));
    data.setBackgroundFileId(rs.getString(index++));
    data.setScreenInch(rs.getBigDecimal(index++));
    data.setStripBlockLength(rs.getInt(index++));

    return data;
  }


  private BinMapRule convertBinMapRule(ResultSet rs) throws SQLException {
    BinMapRule data = new BinMapRule();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setStartX(rs.getInt(index++));
    data.setStartY(rs.getInt(index++));
    data.setWaferDirection(rs.getInt(index++));
    data.setRowCount(rs.getInt(index++));
    data.setColCount(rs.getInt(index++));
    data.setDieQty(rs.getInt(index++));
    data.setLotIdRow(rs.getInt(index++));
    data.setLotIdCol(rs.getInt(index++));
    data.setWaferIdRow(rs.getInt(index++));
    data.setWaferIdCol(rs.getInt(index++));
    data.setPositive(rs.getString(index++));
    data.setSymbolLength(rs.getInt(index++));
    data.setSymbolInterval(rs.getInt(index++));
    data.setAlignmentDieSymbol(rs.getString(index++));
    data.setIncomingBadDieSymbol(rs.getString(index++));
    data.setProcessBadDieSymbol(rs.getString(index++));
    data.setDutms(rs.getString(index++));
    data.setXdieSize(rs.getBigDecimal(index++));
    data.setYdieSize(rs.getBigDecimal(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));
    data.setStatus(rs.getString(index++));
    data.setInkSymbol(rs.getString(index++));
    data.setBackgroundFileId(rs.getString(index++));
    data.setScreenInch(rs.getBigDecimal(index++));
    data.setStripBlockLength(rs.getInt(index++));

    return data;
  }

  public List<BinMapRule> selectByIds(Where where) throws SQLException {
    List<BinMapRule> list = new ArrayList<>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        list.add(convertBinMapRule(rs));
      }
      return list;
    }
  }
}