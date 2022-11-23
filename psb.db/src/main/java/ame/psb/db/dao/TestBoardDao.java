package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.TestBoard;
import uia.utils.dao.DateUtils;
import uia.utils.dao.Where;

public class TestBoardDao {

  private static final String SQL_INS = "INSERT INTO zd_test_board(uuid,test_modle,slot_type,slot_no,board_name,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_test_board SET test_modle=?,slot_type=?,slot_no=?,board_name=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,test_modle,slot_type,slot_no,board_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_test_board ";

  private final Connection conn;

  public TestBoardDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(TestBoard data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getTestModle());
      ps.setString(3, data.getSlotType());
      ps.setString(4, data.getSlotNo());
      ps.setString(5, data.getBoardName());
      ps.setString(6, data.getReversedField1());
      ps.setString(7, data.getReversedField2());
      ps.setString(8, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<TestBoard> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (TestBoard data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getTestModle());
        ps.setString(3, data.getSlotType());
        ps.setString(4, data.getSlotNo());
        ps.setString(5, data.getBoardName());
        ps.setString(6, data.getReversedField1());
        ps.setString(7, data.getReversedField2());
        ps.setString(8, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 9, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(TestBoard data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getTestModle());
      ps.setString(2, data.getSlotType());
      ps.setString(3, data.getSlotNo());
      ps.setString(4, data.getBoardName());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
      ps.setString(9, data.getUuid());

      return ps.executeUpdate();
    }
  }

  public int update(List<TestBoard> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (TestBoard data : dataList) {
        ps.setString(1, data.getTestModle());
        ps.setString(2, data.getSlotType());
        ps.setString(3, data.getSlotNo());
        ps.setString(4, data.getBoardName());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());
        ps.setString(9, data.getUuid());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String uuid) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zd_test_board WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public List<TestBoard> selectAll() throws SQLException {
    ArrayList<TestBoard> result = new ArrayList<TestBoard>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<TestBoard> selectAll(Where where) throws SQLException {
    ArrayList<TestBoard> result = new ArrayList<TestBoard>();
    try (PreparedStatement ps = where.prepareStatement(this.conn, SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<TestBoard> selectByTestModle(String testModle)
      throws SQLException {
    List<TestBoard> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE TEST_MODLE=? ")) {
      ps.setString(1, testModle);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<TestBoard> selectByTestModleAndSlotNoAndSlotType(String testModle, String slotNo, String slotType)
      throws SQLException {
    List<TestBoard> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE TEST_MODLE=? AND SLOT_NO =? AND SLOT_TYPE =?")) {
      ps.setString(1, testModle);
      ps.setString(2, slotNo);
      ps.setString(3, slotType);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public TestBoard selectByTestModleAndsLotNoAndboardName(String testModle, String sLotNo,
      String boardName) throws SQLException {
    TestBoard result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE TEST_MODLE=? and SLOT_NO = ? and board_name = ?")) {
      ps.setString(1, testModle);
      ps.setString(2, sLotNo);
      ps.setString(3, boardName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public TestBoard selectByPK(String uuid) throws SQLException {
    TestBoard result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  private TestBoard convert(ResultSet rs) throws SQLException {
    TestBoard data = new TestBoard();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setTestModle(rs.getString(index++));
    data.setSlotType(rs.getString(index++));
    data.setSlotNo(rs.getString(index++));
    data.setBoardName(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
