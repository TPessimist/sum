package ame.psb.db.dao;

import ame.psb.db.ContainerNewLot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uia.utils.dao.DateUtils;

public class ContainerNewLotDao {

  private static final String SQL_INS = "INSERT INTO zd_container_new_lot(container_bo,shop_order,lot_no,new_lot_no,reversed_field1,reversed_field2,updated_user,updated_time) VALUES (?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "UPDATE zd_container_new_lot SET lot_no=?,new_lot_no=?,reversed_field1=?,reversed_field2=?,updated_user=?,updated_time=? WHERE container_bo=? AND shop_order=?";

  private static final String SQL_SEL = "SELECT container_bo,shop_order,lot_no,new_lot_no,reversed_field1,reversed_field2,updated_user,updated_time FROM zd_container_new_lot ";

  private final Connection conn;

  public ContainerNewLotDao(Connection conn) {
    this.conn = conn;
  }

  public int insert(ContainerNewLot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getContainerBo());
      ps.setString(2, data.getShopOrder());
      ps.setString(3, data.getLotNo());
      ps.setString(4, data.getNewLotNo());
      ps.setString(5, data.getReversedField1());
      ps.setString(6, data.getReversedField2());
      ps.setString(7, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

      return ps.executeUpdate();
    }
  }

  public int insert(List<ContainerNewLot> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      for (ContainerNewLot data : dataList) {
        ps.setString(1, data.getContainerBo());
        ps.setString(2, data.getShopOrder());
        ps.setString(3, data.getLotNo());
        ps.setString(4, data.getNewLotNo());
        ps.setString(5, data.getReversedField1());
        ps.setString(6, data.getReversedField2());
        ps.setString(7, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 8, data.getUpdatedTime());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int update(ContainerNewLot data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      ps.setString(1, data.getLotNo());
      ps.setString(2, data.getNewLotNo());
      ps.setString(3, data.getReversedField1());
      ps.setString(4, data.getReversedField2());
      ps.setString(5, data.getUpdatedUser());
      DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
      ps.setString(7, data.getContainerBo());
      ps.setString(8, data.getShopOrder());

      return ps.executeUpdate();
    }
  }

  public int update(List<ContainerNewLot> dataList) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {
      for (ContainerNewLot data : dataList) {
        ps.setString(1, data.getLotNo());
        ps.setString(2, data.getNewLotNo());
        ps.setString(3, data.getReversedField1());
        ps.setString(4, data.getReversedField2());
        ps.setString(5, data.getUpdatedUser());
        DateUtils.setDateTz(ps, 6, data.getUpdatedTime());
        ps.setString(7, data.getContainerBo());
        ps.setString(8, data.getShopOrder());

        ps.addBatch();
      }
      return ps.executeBatch().length;
    }
  }

  public int delete(String containerBo, String shopOrder) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(
        "DELETE FROM zd_container_new_lot WHERE container_bo=? AND shop_order=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, shopOrder);

      return ps.executeUpdate();
    }
  }

  public List<ContainerNewLot> selectAll() throws SQLException {
    ArrayList<ContainerNewLot> result = new ArrayList<ContainerNewLot>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL)) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public ContainerNewLot selectByPK(String containerBo, String shopOrder) throws SQLException {
    ContainerNewLot result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE container_bo=? AND shop_order=?")) {
      ps.setString(1, containerBo);
      ps.setString(2, shopOrder);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public ContainerNewLot selectByContainer(String containerBo) throws SQLException {
    ContainerNewLot result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL + "WHERE container_bo=? ")) {
      ps.setString(1, containerBo);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  private ContainerNewLot convert(ResultSet rs) throws SQLException {
    ContainerNewLot data = new ContainerNewLot();

    int index = 1;
    data.setContainerBo(rs.getString(index++));
    data.setShopOrder(rs.getString(index++));
    data.setLotNo(rs.getString(index++));
    data.setNewLotNo(rs.getString(index++));
    data.setReversedField1(rs.getString(index++));
    data.setReversedField2(rs.getString(index++));
    data.setUpdatedUser(rs.getString(index++));
    data.setUpdatedTime(DateUtils.getDateTz(rs, index++));

    return data;
  }
}
