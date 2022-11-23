package ame.me.db.dao;

import ame.me.db.Router;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouterDao {

  private static final String SQL_SEL = "SELECT handle,change_stamp,site,router,router_type,description,temporary_router,status_bo,entry_router_step_bo,copied_from_router_bo,revision,current_revision,has_been_released,eff_start_date,eff_end_date,created_date_time,modified_date_time,gui_representation,original_status_bo,disposition_group_bo,prev_site,original_transfer_key,display_type,hold_id,send_as_shared,sent_to_erp,erp_change_number,relaxed_flow,bom_bo FROM router ";

  private final Connection conn;

  public RouterDao(Connection conn) {
    this.conn = conn;
  }

  public List<Router> selectAll(String site) throws SQLException {
    ArrayList<Router> result = new ArrayList<Router>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? ORDER BY router")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public Router selectByName(String site, String routerName) throws SQLException {
    Router router = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND router=? AND current_revision='true' ")) {
      ps.setString(1, site);
      ps.setString(2, routerName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        router = convert(rs);
      }
    }
    return router;
  }


  public Router selectByHandle(String site, String routerBo) throws SQLException {
    Router router = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND handle=? ")) {
      ps.setString(1, site);
      ps.setString(2, routerBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        router = convert(rs);
      }
    }
    return router;
  }

  public Router selectByName(String site, String routerName, String revision) throws SQLException {
    Router router = null;
    if (revision == null || revision.trim().length() == 0) {
      return selectByName(site, routerName);
    }

    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND router=? AND revision=? ")) {
      ps.setString(1, site);
      ps.setString(2, routerName);
      ps.setString(3, revision);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        router = convert(rs);
      }
    }
    return router;
  }

  public List<Router> selectByNamePrefix(String site, String namePrefix) throws SQLException {
    ArrayList<Router> result = new ArrayList<Router>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND router LIKE ? ORDER BY router")) {
      ps.setString(1, site);
      ps.setString(2, namePrefix + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private Router convert(ResultSet rs) throws SQLException {
    Router data = new Router();

    data.setHandle(rs.getString(1));
    data.setChangeStamp(rs.getBigDecimal(2));
    data.setSite(rs.getString(3));
    data.setRouter(rs.getString(4));
    data.setRouterType(rs.getString(5));
    data.setDescription(rs.getString(6));
    data.setTemporaryRouter(rs.getString(7));
    data.setStatusBo(rs.getString(8));
    data.setEntryRouterStepBo(rs.getString(9));
    data.setCopiedFromRouterBo(rs.getString(10));
    data.setRevision(rs.getString(11));
    data.setCurrentRevision(rs.getString(12));
    data.setHasBeenReleased(rs.getString(13));
    data.setEffStartDate(rs.getTimestamp(14));
    data.setEffEndDate(rs.getTimestamp(15));
    data.setCreatedDateTime(rs.getTimestamp(16));
    data.setModifiedDateTime(rs.getTimestamp(17));
    data.setGuiRepresentation(rs.getString(18));
    data.setOriginalStatusBo(rs.getString(19));
    data.setDispositionGroupBo(rs.getString(20));
    data.setPrevSite(rs.getString(21));
    data.setOriginalTransferKey(rs.getString(22));
    data.setDisplayType(rs.getString(23));
    data.setHoldId(rs.getBigDecimal(24));
    data.setSendAsShared(rs.getString(25));
    data.setSentToErp(rs.getString(26));
    data.setErpChangeNumber(rs.getString(27));
    data.setRelaxedFlow(rs.getString(28));
    data.setBomBo(rs.getString(29));

    return data;
  }
}