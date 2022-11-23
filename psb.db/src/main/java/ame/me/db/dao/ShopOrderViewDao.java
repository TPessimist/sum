package ame.me.db.dao;

import ame.me.db.ShopOrderView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ShopOrderViewDao {

  private static final String SQL_INS = "INSERT INTO WIP.VIEW_SHOP_ORDER (HANDLE, SITE, SHOP_ORDER, STATUS_BO, PRIORITY, PLANNED_ITEM_BO, PLANNED_START_DATE, PLANNED_COMP_DATE, SCHEDULED_START_DATE, SCHEDULED_COMP_DATE, ACTUAL_START_DATE, ACTUAL_COMP_DATE, LOT_NAME, DPT_NO, LOT_TYPE, CUSTOMER,ITEM_GROUP_BO,PKG,IN_TIME) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE SHOP_ORDER SET PLANNED_COMP_DATE  = ? WHERE HANDLE = ?";

  private static final String SQL_UPD_SCHE = "UPDATE SHOP_ORDER SET SCHEDULED_COMP_DATE  = ? WHERE HANDLE = ?";

  private static final String SQL_SEL = "SELECT HANDLE, SITE, SHOP_ORDER, STATUS_BO, PRIORITY, PLANNED_ITEM_BO, PLANNED_START_DATE, PLANNED_COMP_DATE, SCHEDULED_START_DATE, SCHEDULED_COMP_DATE, ACTUAL_START_DATE, ACTUAL_COMP_DATE, LOT_NAME, DPT_NO, LOT_TYPE, CUSTOMER,ITEM_GROUP_BO,PKG,IN_TIME FROM WIP.VIEW_SHOP_ORDER ";

  private static final String SQL_SEL_DEVICE = "SELECT HANDLE, SITE, SHOP_ORDER, STATUS_BO, PRIORITY, PLANNED_ITEM_BO, PLANNED_START_DATE, PLANNED_COMP_DATE, SCHEDULED_START_DATE, SCHEDULED_COMP_DATE, ACTUAL_START_DATE, ACTUAL_COMP_DATE, LOT_NAME, DPT_NO, LOT_TYPE, CUSTOMER,ITEM_GROUP_BO,PKG,IN_TIME FROM WIP.VIEW_SHOP_ORDER_ITEMGROUP ";

  private static final String SQL_SEL_VALUE = "SELECT  ZE.VALUE FROM  ZD_LOOKUP_EX AS ZE INNER JOIN VIEW_SHOP_ORDER AS VO ON ZE.ID=VO.HANDLE ";

  private final Connection conn;

  public ShopOrderViewDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ShopOrderView data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getShopOrder());
      ps.setString(4, data.getStatusBo());
      ps.setInt(5, data.getPriority());
      ps.setString(6, data.getPlannedItemBo());
      ps.setTimestamp(7, new Timestamp(data.getPlannedStartDate().getTime()));
      ps.setTimestamp(8, new Timestamp(data.getPlannedCompDate().getTime()));
      ps.setTimestamp(9, new Timestamp(data.getScheduledStartDate().getTime()));
      ps.setTimestamp(10, new Timestamp(data.getScheduledCompDate().getTime()));
      ps.setTimestamp(11, new Timestamp(data.getActualStartDate().getTime()));
      ps.setTimestamp(12, new Timestamp(data.getActualCompDate().getTime()));
      ps.setString(13, data.getLotName());
      ps.setString(14, data.getDptNo());
      ps.setString(15, data.getLotType());
      ps.setString(16, data.getCustomer());
      ps.setString(17, data.getItemGroupBo());
      ps.setString(18, data.getPkg());
      ps.setTimestamp(19, new Timestamp(data.getInTime().getTime()));

      return ps.executeUpdate();
    }
  }

  public int updateSche(ShopOrderView data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD_SCHE)) {
      ps.setTimestamp(1, new Timestamp(data.getScheduledCompDate().getTime() - 28800000));
      ps.setString(2, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public int update(ShopOrderView data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setTimestamp(1, new Timestamp(data.getPlannedCompDate().getTime() - 28800000));
      ps.setString(2, data.getHandle());
        	
        	/*
        	ps.setString(1, data.getHandle());
            ps.setString(2,data.getSite());
            ps.setString(3, data.getShopOrder());
            ps.setString(4, data.getStatusBo());
            ps.setInt(5, data.getPriority());
            ps.setString(6, data.getPlannedItemBo());
            ps.setTimestamp(7, new Timestamp(data.getPlannedStartDate().getTime()));
            ps.setTimestamp(8, new Timestamp(data.getPlannedCompDate().getTime()));
            ps.setTimestamp(9, new Timestamp(data.getScheduledStartDate().getTime()));
            ps.setTimestamp(10, new Timestamp(data.getScheduledCompDate().getTime()));
            ps.setTimestamp(11, new Timestamp(data.getActualStartDate().getTime()));
            ps.setTimestamp(12, new Timestamp(data.getActualCompDate().getTime()));
            ps.setString(13, data.getLotName());
            ps.setString(14, data.getDptNo());
            ps.setString(15, data.getLotType());
*/
      return ps.executeUpdate();
    }
  }

  public List<ShopOrderView> selectAll(String site) throws SQLException {
    ArrayList<ShopOrderView> result = new ArrayList<ShopOrderView>();
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

  public List<ShopOrderView> selectByShopOrder(String shopOrderBo) throws SQLException {
    ArrayList<ShopOrderView> result = new ArrayList<ShopOrderView>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE HANDLE = ?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ShopOrderView selectBySO(String shopOrderBo) throws SQLException {
    ShopOrderView result = new ShopOrderView();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE HANDLE = ?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ShopOrderView selectByPK(String shopOrderBo) throws SQLException {
    ShopOrderView result = new ShopOrderView();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_DEVICE + "WHERE HANDLE = ?")) {
      ps.setString(1, shopOrderBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<ShopOrderView> selectByCustomer(String lotName) throws SQLException {
    ArrayList<ShopOrderView> result = new ArrayList<ShopOrderView>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE CUSTOMER = ?")) {
      ps.setString(1, lotName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ShopOrderView> selectByDevice(String device) throws SQLException {
    ArrayList<ShopOrderView> result = new ArrayList<ShopOrderView>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE item_group_bo = ?")) {
      ps.setString(1, device);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ShopOrderView> selectByItemGroupAndStatusBo(String itemGroupBo, String statusBo) throws SQLException {
    ArrayList<ShopOrderView> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL_DEVICE + "WHERE item_group_bo = ? and STATUS_BO = ?")) {
      ps.setString(1, itemGroupBo);
      ps.setString(2, statusBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<ShopOrderView> selectByInTime(Date date1, Date date2) throws SQLException {
    ArrayList<ShopOrderView> result = new ArrayList<ShopOrderView>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE in_time >= ? and in_time < ?")) {

      DateUtils.setDateTz(ps, 1, date1);
      DateUtils.setDateTz(ps, 2, date2);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  private ShopOrderView convert(ResultSet rs) throws SQLException {
    ShopOrderView data = new ShopOrderView();

    data.setHandle(rs.getString(1));
    data.setSite(rs.getString(2));
    data.setShopOrder(rs.getString(3));
    data.setStatusBo(rs.getString(4));
    data.setPriority(rs.getInt(5));
    data.setPlannedItemBo(rs.getString(6));
    data.setPlannedStartDate(DateUtils.getDateTz(rs, 7));
    data.setPlannedCompDate(DateUtils.getDateTz(rs, 8));
    data.setScheduledStartDate(DateUtils.getDateTz(rs, 9));
    data.setScheduledCompDate(DateUtils.getDateTz(rs, 10));
    data.setActualStartDate(DateUtils.getDateTz(rs, 11));
    data.setActualCompDate(DateUtils.getDateTz(rs, 12));
    data.setLotName(rs.getString(13));
    data.setDptNo(rs.getString(14));
    data.setLotType(rs.getString(15));
    data.setCustomer(rs.getString(16));
    data.setItemGroupBo(rs.getString(17));
    data.setPkg(rs.getString(18));
    data.setInTime(DateUtils.getDateTz(rs, 19));

    return data;
  }

  /**
   * @param param
   * @return
   * @throws SQLException
   */
  public List<String> selectDevices(String param) throws SQLException {
    List<String> result = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL_VALUE + "WHERE VO.CUSTOMER =? AND  ZE.SUBID ='CUST_PART_NUM1'")) {
      ps.setString(1, param);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(rs.getString("VALUE"));
      }
      return result;
    }
  }


}
