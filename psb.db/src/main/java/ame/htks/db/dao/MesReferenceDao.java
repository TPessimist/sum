package ame.htks.db.dao;

import ame.htks.db.MesReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesReferenceDao {

  private static final String SQL_SEL = "SELECT id,key1,key2,key3,property_name,property_value,value_flag,created_by,created_time FROM zh_mes_reference ";

  private static final String SQL_INS = "insert into zh_mes_reference ( id,key1,key2,key3,property_name,property_value,value_flag,created_by,created_time ) values (?,?,?,?,?,?,?,?,?)";

  private static final String SQL_UPD = "update  zh_mes_reference set property_value = ?,value_flag = ?,created_by = ?,created_time =? where id = ? and key1 = ? and key2 = ?  and key3 = ? and PROPERTY_NAME = ?";


  private final Connection conn;

  public MesReferenceDao(Connection conn) {
    this.conn = conn;
  }

  public List<MesReference> select(String id) throws SQLException {
    ArrayList<MesReference> result = new ArrayList<MesReference>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? ORDER BY key1,property_name")) {
      ps.setString(1, id);

      ////
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<MesReference> select(String id, String key1) throws SQLException {
    ArrayList<MesReference> result = new ArrayList<MesReference>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND key1=? ORDER BY key2,property_name")) {
      ps.setString(1, id);
      ps.setString(2, key1);

      //
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<MesReference> select(String id, String key1, String key2) throws SQLException {
    ArrayList<MesReference> result = new ArrayList<MesReference>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE id=? AND key1=? AND key2=? ORDER BY key3,property_name")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, key2);

      //
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }

  public List<MesReference> select(String id, String key1, String key2, String key3)
      throws SQLException {
    ArrayList<MesReference> result = new ArrayList<MesReference>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE id=? AND key1=? AND key2=? AND key3=? ORDER BY property_name")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, key2);
      ps.setString(4, key3);

      //
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public MesReference selectProp(String id, String key1, String propertyName) throws SQLException {
    MesReference result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND key1=? AND property_name=?")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, propertyName);

      //
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  /*
   * cc
   * */
  public MesReference selectProp2(String id, String key1, String propertyName, String propertyValue)
      throws SQLException {
    MesReference result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL + "WHERE id=? AND key1=? AND property_name=? and property_value=?")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, propertyName);
      ps.setString(4, propertyValue);

      //
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }


  public MesReference selectContainerSize(String id, String key1, String propertyName)
      throws SQLException {
    MesReference result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND key1=? AND property_name=?")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, propertyName);

      //
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public MesReference selectNetWeight(String id, String key1, String propertyName)
      throws SQLException {
    MesReference result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND key1=? AND property_name=?")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, propertyName);

      //
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public MesReference selectWeightUnit(String id, String key1, String propertyName)
      throws SQLException {
    MesReference result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND key1=? AND property_name=?")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, propertyName);

      //
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public MesReference selectProp(String id, String key1, String key2, String propertyName)
      throws SQLException {
    MesReference result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND key1=? AND key2=? AND property_name=?")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, key2);
      ps.setString(4, propertyName);

      //
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public MesReference selectProp(String id, String key1, String key2, String key3,
      String propertyName) throws SQLException {
    MesReference result = null;
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL + "WHERE id=? AND key1=? AND key2=? AND key3=? AND property_name=?")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, key2);
      ps.setString(4, key3);
      ps.setString(5, propertyName);

      //
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }
      return result;
    }
  }

  public List<MesReference> selectByPropertyName(String id, String key1, String propertyName)
      throws SQLException {
    ArrayList<MesReference> result = new ArrayList<MesReference>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND key1=? AND property_name=?")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, propertyName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(convert(rs));
      }
      return result;
    }
  }


  public int insert(MesReference data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_INS)) {
      ps.setString(1, data.getId());
      ps.setString(2, data.getKey1());
      ps.setString(3, data.getKey2());
      ps.setString(4, data.getKey3());
      ps.setString(5, data.getPropertyName());
      ps.setString(6, data.getPropertyValue());
      ps.setString(7, data.getValueFlag());
      ps.setString(8, data.getCreatedBy());
      ps.setString(9, data.getCreatedTime());

      return ps.executeUpdate();
    }
  }


  public int update(MesReference data) throws SQLException {
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_UPD)) {

      ps.setString(1, data.getPropertyValue());
      ps.setString(2, data.getValueFlag());
      ps.setString(3, data.getCreatedBy());
      ps.setString(4, data.getCreatedTime());
      ps.setString(5, data.getId());
      ps.setString(6, data.getKey1());
      ps.setString(7, data.getKey2());
      ps.setString(8, data.getKey3());
      ps.setString(9, data.getPropertyName());

      return ps.executeUpdate();
    }
  }

  public MesReference selectPropWithNullException(String id, String key1, String propertyName)
      throws SQLException {
    MesReference result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL + "WHERE id=? AND key1=? AND property_name=?")) {
      ps.setString(1, id);
      ps.setString(2, key1);
      ps.setString(3, propertyName);

      //
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = convert(rs);
      }

      if (null == result) {
        throw new SQLException(String.format("DN:%s中%s资料未上传, 请确认是否已上传!", key1, propertyName));
      }
      return result;
    }
  }


  public void insertOrUpdate(MesReference data) throws Exception {
    MesReference reference = selectProp(data.getId(), data.getKey1(), data.getKey2(),
        data.getKey3(), data.getPropertyName());
    if (null == reference) {
      insert(data);
    } else {
      update(data);
    }

  }

  private MesReference convert(ResultSet rs) throws SQLException {
    MesReference data = new MesReference();

    int index = 1;
    data.setId(rs.getString(index++));
    data.setKey1(rs.getString(index++));
    data.setKey2(rs.getString(index++));
    data.setKey3(rs.getString(index++));
    data.setPropertyName(rs.getString(index++));
    data.setPropertyValue(rs.getString(index++));
    data.setValueFlag(rs.getString(index++));
    data.setCreatedBy(rs.getString(index++));
    data.setCreatedTime(rs.getString(index++));

    return data;
  }
}
