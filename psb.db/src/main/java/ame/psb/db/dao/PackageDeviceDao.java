package ame.psb.db.dao;

import ame.psb.db.ViewPackageDevice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PackageDeviceDao {

  private static final String SQL_SEL = "SELECT customer_bo,customer,customer_name,package_bo,package,package_desc,device_bo,device,device_desc,cr_factor,bin_code_list,site FROM view_package_device ";

  private Connection conn;

  public PackageDeviceDao(Connection conn) {
    this.conn = conn;
  }

  public ArrayList<ViewPackageDevice> selectAll(String site) throws SQLException {
    ArrayList<ViewPackageDevice> items = new ArrayList<ViewPackageDevice>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE site=? ORDER BY package_bo,device_bo")) {
      ps.setString(1, site);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  public ArrayList<ViewPackageDevice> selectByCustomer(String customerBo) throws SQLException {
    ArrayList<ViewPackageDevice> items = new ArrayList<ViewPackageDevice>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE customer_bo=? ORDER BY device_bo")) {
      ps.setString(1, customerBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  public ArrayList<ViewPackageDevice> selectByPackage(String packageBo) throws SQLException {
    ArrayList<ViewPackageDevice> items = new ArrayList<ViewPackageDevice>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE package_bo=? ORDER BY customer,device_bo")) {
      ps.setString(1, packageBo);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        items.add(convert(rs));
      }
    }
    return items;
  }

  public ViewPackageDevice selectByDevice(String deviceBo) throws SQLException {
    ViewPackageDevice data = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + " WHERE device_bo=?")) {
      ps.setString(1, deviceBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = convert(rs);
      }
    }
    return data;
  }

  public ViewPackageDevice selectByDeviceName(String site, String deviceName) throws SQLException {
    ViewPackageDevice data = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + " WHERE site=? AND device=?")) {
      ps.setString(1, site);
      ps.setString(2, deviceName);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        data = convert(rs);
      }
    }
    return data;
  }

  private ViewPackageDevice convert(ResultSet rs) throws SQLException {
    ViewPackageDevice data = new ViewPackageDevice();

    int index = 1;
    data.setCustomerBo(rs.getString(index++));
    data.setCustomer(rs.getString(index++));
    data.setCustomerName(rs.getString(index++));
    data.setPackageBo(rs.getString(index++));
    data.setPackageName(rs.getString(index++));
    data.setPackageDesc(rs.getString(index++));
    data.setDeviceBo(rs.getString(index++));
    data.setDeviceName(rs.getString(index++));
    data.setDeviceDesc(rs.getString(index++));
    data.setCrFactor(rs.getString(index++));
    data.setBinCodeList(rs.getString(index++));

    return data;
  }
}
