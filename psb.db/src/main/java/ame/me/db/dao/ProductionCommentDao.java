package ame.me.db.dao;

import ame.me.db.ProductionComment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ProductionCommentDao {

  private static final String SQL_SEL = "SELECT handle,site,context_gbo,sequence,user_bo,comments,activity,comment_type,state,reason_code_bo,created_date_time,modified_date_time,production_context_gbo,txn_id FROM production_comment ";

  private final Connection conn;

  public ProductionCommentDao(Connection conn) {
    this.conn = conn;
  }

  public List<ProductionComment> selectAll() throws SQLException {
    ArrayList<ProductionComment> result = new ArrayList<ProductionComment>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public List<ProductionComment> selectByResource(String resource) throws SQLException {
    ArrayList<ProductionComment> result = new ArrayList<ProductionComment>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE context_gbo=?")) {
      ps.setString(1, resource);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public ProductionComment selectByPK(String handle) throws SQLException {
    ProductionComment result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ProductionComment convert(ResultSet rs) throws SQLException {
    ProductionComment data = new ProductionComment();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setSite(rs.getString(index++));
    data.setContextGbo(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));
    data.setUserBo(rs.getString(index++));
    data.setComments(rs.getString(index++));
    data.setActivity(rs.getString(index++));
    data.setCommentType(rs.getString(index++));
    data.setState(rs.getString(index++));
    data.setReasonCodeBo(rs.getString(index++));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, index++));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, index++));
    data.setProductionContextGbo(rs.getString(index++));
    data.setTxnId(rs.getString(index++));

    return data;
  }
}