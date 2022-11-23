package ame.psb.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ame.psb.db.IssueRecipeBoard;
import uia.utils.dao.DateUtils;

public class IssueRecipeBoardDao {

  private static final String SQL_INS = "INSERT INTO zr_issue_recipe_board(uuid,issue_recipe_id,slot_type,slot_no,board_name,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zr_issue_recipe_board SET issue_recipe_id=?,slot_type=?,slot_no=?,board_name=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE uuid=?";

  private static final String SQL_SEL = "SELECT uuid,issue_recipe_id,slot_type,slot_no,board_name,reversed_field1,reversed_field2,updated_user,updated_time FROM zr_issue_recipe_board ";

  private final Connection conn;

  public IssueRecipeBoardDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(IssueRecipeBoard data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getUuid());
      ps.setString(2, data.getIssueRecipeId());
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

  public int insert(List<IssueRecipeBoard> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (IssueRecipeBoard data : dataList) {
        ps.setString(1, data.getUuid());
        ps.setString(2, data.getIssueRecipeId());
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

  public int update(IssueRecipeBoard data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getIssueRecipeId());
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

  public int update(List<IssueRecipeBoard> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (IssueRecipeBoard data : dataList) {
        ps.setString(1, data.getIssueRecipeId());
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
        .prepareStatement("DELETE FROM zr_issue_recipe_board WHERE uuid=?")) {
      ps.setString(1, uuid);

      return ps.executeUpdate();
    }
  }

  public int deleteByIssueRecipeId(String issueRecipeId) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM zr_issue_recipe_board WHERE ISSUE_RECIPE_ID=?")) {
      ps.setString(1, issueRecipeId);

      return ps.executeUpdate();
    }
  }

  public List<IssueRecipeBoard> selectAll() throws SQLException {
    ArrayList<IssueRecipeBoard> result = new ArrayList<IssueRecipeBoard>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public IssueRecipeBoard selectByPK(String uuid) throws SQLException {
    IssueRecipeBoard result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE uuid=?")) {
      ps.setString(1, uuid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<IssueRecipeBoard> selectById(String id) throws SQLException {
    List<IssueRecipeBoard> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE issue_recipe_id=?")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private IssueRecipeBoard convert(ResultSet rs) throws SQLException {
    IssueRecipeBoard data = new IssueRecipeBoard();

    int index = 1;
    data.setUuid(rs.getString(index++));
    data.setIssueRecipeId(rs.getString(index++));
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
