package ame.psb.db.dao;

import ame.psb.db.Lookup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class LookupDao {

  private static final String SQL_SEL1 = "SELECT id,subid,value,group_name FROM zd_lookup ";

  private static final String SQL_UPD = "UPDATE zd_lookup SET id = ?, subid = ? , value = ? , group_name = ? where id = ?";

  private Connection conn;

  public LookupDao(Connection conn) {
    this.conn = conn;
  }

  public static synchronized String nextValue(Connection conn, String id, String subid,
      Function<String, String> gen) throws SQLException {
    LookupDao dao = new LookupDao(conn);
    Lookup lk = dao.selectByPK(id, subid);
    String nextValue = null;
    if (lk == null) {
      nextValue = gen.apply(null);
      dao.insert(id, subid, nextValue);
    } else {
      nextValue = gen.apply(lk.getValue());
      dao.update(id, subid, nextValue);

    }
    return nextValue;
  }

  public Lookup selectByPK(String id, String subid) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=? AND subid=? ")) {
      ps.setString(1, id);
      ps.setString(2, subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public Optional<Lookup> selectByPKOptional(String id, String subid) throws SQLException {
    Optional<Lookup> lookup = Optional.empty();

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=? AND subid=? ")) {
      ps.setString(1, id);
      ps.setString(2, subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = Optional.of(this.convert(rs));
      }
    }
    return lookup;
  }

  public Lookup selectByPK2(String id, String value) throws SQLException {
    Lookup lookup = null;

    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=? AND value=?")) {
      ps.setString(1, id);
      ps.setString(2, value);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public List<Lookup> selectByIDAndValue(String id, String value) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id = ? AND value=?")) {
      ps.setString(1, id);
      ps.setString(2, value);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public Lookup selectByDetail(String id, String value, String groupName) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? AND value=? AND group_name=?")) {
      ps.setString(1, id);
      ps.setString(2, value);
      ps.setString(3, groupName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public List<Lookup> selectByGroup(String id, String groupName) throws SQLException {
    List<Lookup> lookupList = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? AND group_name=?")) {
      ps.setString(1, id);
      ps.setString(2, groupName);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        lookupList.add(this.convert(rs));
      }
    }
    return lookupList;
  }

  public Lookup selectByFGroup(String id, String groupName) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? AND group_name=?")) {
      ps.setString(1, id);
      ps.setString(2, groupName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public Lookup selectBySubidAndGroup(String subid, String groupName) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE subid=? AND group_name=?")) {
      ps.setString(1, subid);
      ps.setString(2, groupName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public List<Lookup> selectBySubid(String id, String subid) throws SQLException {
    List<Lookup> lookupList = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=? AND subid=?")) {
      ps.setString(1, id);
      ps.setString(2, subid);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        lookupList.add(this.convert(rs));
      }
    }
    return lookupList;
  }

  public Lookup selectByGroup(String id, String subId, String groupName) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? AND subid=? AND group_name=?")) {
      ps.setString(1, id);
      ps.setString(2, subId);
      ps.setString(3, groupName);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public Lookup selectByIdAll(String id) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? ")) {
      ps.setString(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    return lookup;
  }

  public List<Lookup> selectValues(String id) throws SQLException {
    List<Lookup> lookupList = new ArrayList<>();
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=? ")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        lookupList.add(this.convert(rs));
      }
    }
    return lookupList;
  }

  public List<Lookup> selectSubid(String value) throws SQLException {
    List<Lookup> lookupList = new ArrayList<>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE value=? AND id  = 'DPT_AREA' ")) {
      ps.setString(1, value);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        lookupList.add(this.convert(rs));
      }
    }
    return lookupList;
  }

  public List<Lookup> selectByGroupName(String id) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE group_name=? and id = 'PKG_CT' ORDER BY subid")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> selectBySingleGroupName(String id) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE group_name=? ORDER BY subid")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> selectByGroupNameAll(String id) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE group_name=?  ORDER BY subid")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> selectByGroupNameOrderBy() throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL1 + "WHERE  id = 'FC_SPECIAL_OPERATION_DEFECT' ORDER BY to_number(SUBID) DESC")) {

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> selectAll() throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id = 'PKG_CT' ORDER BY subid")) {
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> selectBySubid(String id) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE subid like ? and id = 'PKG_CT' ORDER BY subid")) {
      ps.setString(1, "%" + id + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> select(String id) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? ORDER BY subid")) {
      ps.setString(1, id);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> selectOrderByNumberSeqAndGroupName(String id, String groupName)
      throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn.prepareStatement(
        SQL_SEL1 + "WHERE id=? and group_name =?  ORDER BY to_number(subid) asc")) {
      ps.setString(1, id);
      ps.setString(2, groupName);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> selectByPrefix(String id) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id like ? ORDER BY subid")) {
      ps.setString(1, id + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public Lookup selectByPrefixId(String id, String subid, String value) throws SQLException {
    Lookup result = null;
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL1 + "WHERE id like ?  and SUBID = ? and VALUE like ? ORDER BY subid")) {
      ps.setString(1, id + "%");
      ps.setString(2, subid);
      ps.setString(3, value + "%");

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result = this.convert(rs);
      }
    }
    return result;
  }

  public List<Lookup> selectByPreLikeSubId(String id, String subid) throws SQLException {
    List<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL1 + "WHERE id = ?  and SUBID like ? ORDER BY subid")) {
      ps.setString(1, id + "%");
      ps.setString(2, subid + "%");

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> selectByLikeSubId(String id, String subid) throws SQLException {
    List<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(
            SQL_SEL1 + "WHERE id = ?  and SUBID like ? ORDER BY subid")) {
      ps.setString(1, id + "%");
      ps.setString(2, "%" + subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public List<Lookup> selectForMail(String id, String subId) throws SQLException {
    ArrayList<Lookup> result = new ArrayList<Lookup>();
    try (PreparedStatement ps = this.conn
        .prepareStatement(SQL_SEL1 + "WHERE id=? AND subid like ?")) {
      ps.setString(1, id);
      ps.setString(2, subId);

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        result.add(this.convert(rs));
      }
    }
    return result;
  }

  public boolean isConfigured(String id, String subid) throws SQLException {
    Lookup lookup = null;
    try (PreparedStatement ps = this.conn.prepareStatement(SQL_SEL1 + "WHERE id=? AND subid=? ")) {
      ps.setString(1, id);
      ps.setString(2, subid);

      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        lookup = this.convert(rs);
      }
    }
    if (lookup != null) {
      return true;
    }
    return false;
  }

  public int insert(String id, String subid, String value) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zd_lookup(id,subid,value) VALUES(?,?,?)");
    ps.setString(1, id);
    ps.setString(2, subid);
    ps.setString(3, value);
    return ps.executeUpdate();
  }

  public int insert(String id, String subid, String value, String groupName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zd_lookup(id,subid,value,group_name) VALUES(?,?,?,?)");
    ps.setString(1, id);
    ps.setString(2, subid);
    ps.setString(3, value);
    ps.setString(4, groupName);
    return ps.executeUpdate();
  }

  public int insert(Lookup lk) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zd_lookup(id,subid,value,group_name) VALUES(?,?,?,?)");
    ps.setString(1, lk.getId());
    ps.setString(2, lk.getSubid());
    ps.setString(3, lk.getValue());
    ps.setString(4, lk.getGroupName());
    return ps.executeUpdate();
  }

  public int insert(List<Lookup> lookups) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("INSERT INTO zd_lookup(id,subid,value,group_name) VALUES(?,?,?,?)");
    for (Lookup lk : lookups) {
      ps.setString(1, lk.getId());
      ps.setString(2, lk.getSubid());
      ps.setString(3, lk.getValue());
      ps.setString(4, lk.getGroupName());
      ps.addBatch();
    }
    return ps.executeBatch().length;
  }

  public int update(String id, String subid, String value) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_lookup SET value=? WHERE id=? AND subid=?");
    ps.setString(1, value);
    ps.setString(2, id);
    ps.setString(3, subid);
    return ps.executeUpdate();
  }

  public int updateGroupName(String id, String subid, String groupName) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("UPDATE zd_lookup SET GROUP_NAME=? WHERE id=? AND subid=?");
    ps.setString(1, groupName);
    ps.setString(2, id);
    ps.setString(3, subid);
    return ps.executeUpdate();
  }

  public int deleteById(String id) throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement("delete from zd_lookup WHERE id=?");
    ps.setString(1, id);
    return ps.executeUpdate();
  }

  public int delete(String id, String subid) throws SQLException {
    PreparedStatement ps = this.conn
        .prepareStatement("delete from zd_lookup WHERE id=? and subid=?");
    ps.setString(1, id);
    ps.setString(2, subid);
    return ps.executeUpdate();
  }

  public int updateBySubid(String id, String subid, String value, String groupname)
      throws SQLException {
    PreparedStatement ps = this.conn.prepareStatement(SQL_UPD + " AND SUBID = ?");
    ps.setString(1, id);
    ps.setString(2, subid);
    ps.setString(3, value);
    ps.setString(4, groupname);
    ps.setString(5, id);
    ps.setString(6, subid);
    return ps.executeUpdate();
  }

  private Lookup convert(ResultSet rs) throws SQLException {
    Lookup data = new Lookup();
    data.setId(rs.getString(1));
    data.setSubid(rs.getString(2));
    data.setValue(rs.getString(3));
    data.setGroupName(rs.getString(4));
    return data;
  }
}
