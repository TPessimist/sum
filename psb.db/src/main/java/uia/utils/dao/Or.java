package uia.utils.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Or {

  private ArrayList<RuleType> rules;

  public Or() {
    this.rules = new ArrayList<RuleType>();
  }

  public String generate() {
    if (this.rules.size() == 0) {
      return "";
    }
    List<String> data = this.rules.stream().map(c -> c.getStatement()).collect(Collectors.toList());

    return String.join(" OR ", data);
  }

  public Or eq(String key, Object value) {
    if (isEmpty(key) || isEmpty(value)) {
      return this;
    }
    this.rules.add(new EqType(key, value));
    return this;
  }

  public Or eqOrNull(String key, Object value) {
    if (isEmpty(key)) {
      return this;
    }
    this.rules.add(new EqType(key, value));
    return this;
  }

  public Or likeBegin(String key, Object value) {
    if (isEmpty(key) || isEmpty(value)) {
      return this;
    }
    this.rules.add(new LikeType(key, value + "%"));
    return this;
  }

  public Or likeBeginOrNull(String key, Object value) {
    if (isEmpty(key)) {
      return this;
    }
    this.rules.add(new LikeType(key, value != null ? value + "%" : null));
    return this;
  }

  public Or between(String key, Object value1, Object value2) {
    if (isEmpty(key) || isEmpty(value1) || isEmpty(value2)) {
      return this;
    }
    this.rules.add(new BetweenType(key, value1, value2));
    return this;
  }

  public Or or(RuleType where) {
    this.rules.add(where);
    return this;
  }

  public PreparedStatement prepareStatement(Connection conn, String selectSql) throws SQLException {
    String where = generate();
    PreparedStatement ps;
    if (where == null || where.length() == 0) {
      ps = conn.prepareStatement(selectSql);
    } else {
      ps = conn.prepareStatement(selectSql + " WHERE " + where);
    }
    int i = 1;
    for (RuleType rule : this.rules) {
      i = rule.accpet(ps, i);
    }
    return ps;
  }

  private boolean isEmpty(Object value) {
    return value == null || value.toString().trim().length() == 0;
  }

  public static interface RuleType {

    public String getStatement();

    public int accpet(PreparedStatement ps, int index) throws SQLException;
  }

  class EqType implements RuleType {

    private final String key;

    private final Object value;

    public EqType(String key, Object value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String getStatement() {
      return this.value == null ? this.key + " is null " : this.key + "=?";
    }

    @Override
    public int accpet(PreparedStatement ps, int index) throws SQLException {
      if (this.value != null) {
        ps.setObject(index++, this.value);
      }
      return index;
    }
  }

  class LikeType implements RuleType {

    private final String key;

    private final Object value;

    public LikeType(String key, Object value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String getStatement() {
      return this.value == null ? this.key + " is null " : this.key + " like ?";
    }

    @Override
    public int accpet(PreparedStatement ps, int index) throws SQLException {
      if (this.value != null) {
        ps.setObject(index++, this.value);
      }
      return index;
    }
  }

  class BetweenType implements RuleType {

    private final String key;

    private final Object value1;

    private final Object value2;

    public BetweenType(String key, Object value1, Object value2) {
      this.key = key;
      this.value1 = value1;
      this.value2 = value2;
    }

    @Override
    public String getStatement() {
      return "(" + this.key + " between ? and ?)";
    }

    @Override
    public int accpet(PreparedStatement ps, int index) throws SQLException {
      ps.setObject(index++, this.value1);
      ps.setObject(index++, this.value2);
      return index;
    }
  }
}
