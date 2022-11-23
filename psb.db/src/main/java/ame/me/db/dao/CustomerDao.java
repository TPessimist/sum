package ame.me.db.dao;

import ame.me.db.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class CustomerDao {

  private static final String SQL_INS = "INSERT INTO customer(handle,site,customer,customer_name,address1,address2,city,state_prov,country,postal_code,modified_date_time,created_date_time) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE customer SET site=?,customer=?,customer_name=?,address1=?,address2=?,city=?,state_prov=?,country=?,postal_code=?,modified_date_time=?,created_date_time=? WHERE handle=?";

  private static final String SQL_SEL = "SELECT handle,site,customer,customer_name,address1,address2,city,state_prov,country,postal_code,modified_date_time,created_date_time FROM customer ";

  private final Connection conn;

  public CustomerDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(Customer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getHandle());
      ps.setString(2, data.getSite());
      ps.setString(3, data.getCustomer());
      ps.setString(4, data.getCustomerName());
      ps.setString(5, data.getAddress1());
      ps.setString(6, data.getAddress2());
      ps.setString(7, data.getCity());
      ps.setString(8, data.getStateProv());
      ps.setString(9, data.getCountry());
      ps.setString(10, data.getPostalCode());
      DateUtils.setDateTz(ps, 11, data.getModifiedDateTime());
      DateUtils.setDateTz(ps, 12, data.getCreatedDateTime());

      return ps.executeUpdate();
    }
  }

  public int update(Customer data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getSite());
      ps.setString(2, data.getCustomer());
      ps.setString(3, data.getCustomerName());
      ps.setString(4, data.getAddress1());
      ps.setString(5, data.getAddress2());
      ps.setString(6, data.getCity());
      ps.setString(7, data.getStateProv());
      ps.setString(8, data.getCountry());
      ps.setString(9, data.getPostalCode());
      DateUtils.setDateTz(ps, 10, data.getModifiedDateTime());
      DateUtils.setDateTz(ps, 11, data.getCreatedDateTime());
      ps.setString(12, data.getHandle());

      return ps.executeUpdate();
    }
  }

  public List<Customer> selectAll(String site) throws SQLException {
    ArrayList<Customer> result = new ArrayList<Customer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? ORDER BY customer")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Customer> selectByNamePrefix(String site, String name) throws SQLException {
    ArrayList<Customer> result = new ArrayList<Customer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND customer like ? ORDER BY customer")) {
      ps.setString(1, site);
      ps.setString(2, name + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<Customer> selectByCustomerGroup(String groupName, String customer)
      throws SQLException {
    ArrayList<Customer> result = new ArrayList<Customer>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL
            + " A LEFT JOIN ZD_LOOKUP B ON A.CUSTOMER = B.VALUE AND B.ID = 'CUSTOMER_GROUP' WHERE B.GROUP_NAME = ? AND A.CUSTOMER=? ")) {
      ps.setString(1, groupName);
      ps.setString(2, customer);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public Customer selectByName(String site, String name) throws SQLException {
    Customer data = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND customer=?")) {
      ps.setString(1, site);
      ps.setString(2, name);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = convert(rs);
      }
    }
    return data;
  }

  public Customer selectByName(String name) throws SQLException {
    Customer data = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE customer=?")) {
      ps.setString(1, name);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = convert(rs);
      }
    }
    return data;
  }

  private Customer convert(ResultSet rs) throws SQLException {
    Customer data = new Customer();

    data.setHandle(rs.getString(1));
    data.setSite(rs.getString(2));
    data.setCustomer(rs.getString(3));
    data.setCustomerName(rs.getString(4));
    data.setAddress1(rs.getString(5));
    data.setAddress2(rs.getString(6));
    data.setCity(rs.getString(7));
    data.setStateProv(rs.getString(8));
    data.setCountry(rs.getString(9));
    data.setPostalCode(rs.getString(10));
    data.setModifiedDateTime(DateUtils.getDateTz(rs, 11));
    data.setCreatedDateTime(DateUtils.getDateTz(rs, 12));

    return data;
  }
}