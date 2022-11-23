package ame.psb.db.dao;

import ame.psb.db.PkgJumpOperation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PkgJumpOperationDao {

  private static final String SQL_INS = "INSERT INTO zd_pkg_jump_operation(container_type,dept,operation,seq,description,remarks,note) VALUES (?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_pkg_jump_operation SET dept=?,operation=?,seq=?,description=?,remarks=?,note=? WHERE container_type=?";

  private static final String SQL_SEL = "SELECT container_type,dept,operation,seq,description,remarks,note FROM zd_pkg_jump_operation ";

  private final Connection conn;

  public PkgJumpOperationDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(PkgJumpOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getContainerType());
      ps.setString(2, data.getDept());
      ps.setString(3, data.getOperation());
      ps.setString(4, data.getSeq());
      ps.setString(5, data.getDescription());
      ps.setString(6, data.getRemarks());
      ps.setString(7, data.getNote());

      return ps.executeUpdate();
    }
  }

  public int insert(List<PkgJumpOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (PkgJumpOperation data : dataList) {
        ps.setString(1, data.getContainerType());
        ps.setString(2, data.getDept());
        ps.setString(3, data.getOperation());
        ps.setString(4, data.getSeq());
        ps.setString(5, data.getDescription());
        ps.setString(6, data.getRemarks());
        ps.setString(7, data.getNote());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(PkgJumpOperation data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getDept());
      ps.setString(2, data.getOperation());
      ps.setString(3, data.getSeq());
      ps.setString(4, data.getDescription());
      ps.setString(5, data.getRemarks());
      ps.setString(6, data.getNote());
      ps.setString(7, data.getContainerType());

      return ps.executeUpdate();
    }
  }

  public int update(List<PkgJumpOperation> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (PkgJumpOperation data : dataList) {
        ps.setString(1, data.getDept());
        ps.setString(2, data.getOperation());
        ps.setString(3, data.getSeq());
        ps.setString(4, data.getDescription());
        ps.setString(5, data.getRemarks());
        ps.setString(6, data.getNote());
        ps.setString(7, data.getContainerType());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String containerType) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_pkg_jump_operation WHERE container_type=?")) {
      ps.setString(1, containerType);

      return ps.executeUpdate();
    }
  }

  public List<PkgJumpOperation> selectAll() throws SQLException {
    ArrayList<PkgJumpOperation> result = new ArrayList<PkgJumpOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public PkgJumpOperation selectByPK(String containerType) throws SQLException {
    PkgJumpOperation result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_type=?")) {
      ps.setString(1, containerType);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public PkgJumpOperation selectByTypeAndOperation(String containerType, String operation)
      throws SQLException { //通过容器类型和当前站点查
    PkgJumpOperation result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_type=? AND operation=?")) {
      ps.setString(1, containerType);
      ps.setString(2, operation);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<PkgJumpOperation> selectByTypeAndDept(String containerType, String dept, String seq)
      throws SQLException { //通过容器类型和部门查小于当前seq的
    ArrayList<PkgJumpOperation> result = new ArrayList<PkgJumpOperation>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE container_type=? AND dept=? AND seq<? order by seq asc")) {
      ps.setString(1, containerType);
      ps.setString(2, dept);
      ps.setString(3, seq);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private PkgJumpOperation convert(ResultSet rs) throws SQLException {
    PkgJumpOperation data = new PkgJumpOperation();

    int index = 1;
    data.setContainerType(rs.getString(index++));
    data.setDept(rs.getString(index++));
    data.setOperation(rs.getString(index++));
    data.setSeq(rs.getString(index++));
    data.setDescription(rs.getString(index++));
    data.setRemarks(rs.getString(index++));
    data.setNote(rs.getString(index++));

    return data;
  }
}
