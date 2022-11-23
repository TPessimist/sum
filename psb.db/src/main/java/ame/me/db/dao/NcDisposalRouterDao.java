package ame.me.db.dao;

import ame.me.db.NcDisposalRouter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NcDisposalRouterDao {

  private static final String SQL_INS = "INSERT INTO nc_disp_router(handle,nc_code_def_bo,router_or_group_gbo,sequence) VALUES (?,?,?,?)";

  private static final String SQL_UPD = "UPDATE nc_disp_router SET nc_code_def_bo=?,router_or_group_gbo=?,sequence=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,nc_code_def_bo,router_or_group_gbo,sequence FROM nc_disp_router ";

  private static String SQL_ROUTER = "select distinct router_or_group_gbo from nc_disp_router where instr(router_or_group_gbo,':1020,',0,1)>0";

  private final Connection conn;

  public NcDisposalRouterDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(NcDisposalRouter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getNcCodeDefBo());
      ps.setString(3, data.getRouterOrGroupGbo());
      ps.setBigDecimal(4, data.getSequence());

      return ps.executeUpdate();
    }
  }

  public int insert(List<NcDisposalRouter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (NcDisposalRouter data : dataList) {
        ps.setString(1, data.getHandle());
        ps.setString(2, data.getNcCodeDefBo());
        ps.setString(3, data.getRouterOrGroupGbo());
        ps.setBigDecimal(4, data.getSequence());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(NcDisposalRouter data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getNcCodeDefBo());
      ps.setString(2, data.getRouterOrGroupGbo());
      ps.setBigDecimal(3, data.getSequence());
      ps.setString(4, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(List<NcDisposalRouter> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (NcDisposalRouter data : dataList) {
        ps.setString(1, data.getNcCodeDefBo());
        ps.setString(2, data.getRouterOrGroupGbo());
        ps.setBigDecimal(3, data.getSequence());
        ps.setString(4, data.getHandle());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String handle) throws SQLException {
    try (PreparedStatement ps = this.conn
        .prepareStatement("DELETE FROM nc_disp_router WHERE handle=?")) {
      ps.setString(1, handle);

      return ps.executeUpdate();
    }
  }

  public List<NcDisposalRouter> selectAll() throws SQLException {
    ArrayList<NcDisposalRouter> result = new ArrayList<NcDisposalRouter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<String> selectAllRouter() throws SQLException {

    ArrayList<String> result = new ArrayList<String>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_ROUTER)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString(1));
      }
      return result;
    }
  }

  public List<String> selectByRouter(String routerBo) throws SQLException {

    ArrayList<String> result = new ArrayList<String>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_ROUTER + " and router_or_group_gbo = ? ")) {
      ps.setString(1, routerBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result.add(rs.getString(1));
      }
      return result;
    }
  }

  public List<NcDisposalRouter> selectByNcCodeDef(String ncCodeDefBo) throws SQLException {
    ArrayList<NcDisposalRouter> result = new ArrayList<NcDisposalRouter>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE nc_code_def_bo=?")) {
      ps.setString(1, ncCodeDefBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public NcDisposalRouter selectByPK(String handle) throws SQLException {
    NcDisposalRouter result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE handle=?")) {
      ps.setString(1, handle);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private NcDisposalRouter convert(ResultSet rs) throws SQLException {
    NcDisposalRouter data = new NcDisposalRouter();

    int index = 1;
    data.setHandle(rs.getString(index++));
    data.setNcCodeDefBo(rs.getString(index++));
    data.setRouterOrGroupGbo(rs.getString(index++));
    data.setSequence(rs.getBigDecimal(index++));

    return data;
  }
}