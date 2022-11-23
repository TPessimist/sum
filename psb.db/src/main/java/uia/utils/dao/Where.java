package uia.utils.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Where {

  private ArrayList<RuleType> rules;

  private ArrayList<String> orders;

  private int limit = -1;

  public Where() {
    this.rules = new ArrayList<RuleType>();
    this.orders = new ArrayList<String>();
  }

  public void addOrder(String fieldName) {
    this.orders.add(fieldName);
  }

  public Where orderBy(String fieldName) {
    this.addOrder(fieldName);
    return this;
  }

  public Where limit(int limit) {
    this.limit = limit;
    return this;
  }

  public String generate() {
    if (this.rules.size() == 0) {
      return "";
    }
    List<String> data = this.rules.stream().map(c -> c.getStatement()).collect(Collectors.toList());

    return String.join(" AND ", data);
  }

  public Where notEq(String key, Object value) {
    if (this.isEmpty(key) || this.isEmpty(value)) {
      return this;
    }
    this.rules.add(new NotEqType(key, value));
    return this;
  }

  public Where notEqOrNull(String key, Object value) {
    if (this.isEmpty(key)) {
      return this;
    }
    this.rules.add(new NotEqType(key, value));
    return this;
  }

  public Where eq(String key, Object value) {
    if (this.isEmpty(key) || this.isEmpty(value)) {
      return this;
    }
    this.rules.add(new EqType(key, value));
    return this;
  }

  public Where eqOrNull(String key, Object value) {
    if (this.isEmpty(key)) {
      return this;
    }
    this.rules.add(new EqType(key, value));
    return this;
  }

  public Where like(String key, Object value) {
    if (this.isEmpty(key) || this.isEmpty(value)) {
      return this;
    }
    this.rules.add(new LikeType(key, "%" + value + "%"));
    return this;
  }


  public Where notlike(String key, Object value) {
    if (this.isEmpty(key) || this.isEmpty(value)) {
      return this;
    }
    this.rules.add(new LikeType(key + " not", "%" + value + "%"));
    return this;
  }

  public Where likePrefix(String key, Object value) {
    if (this.isEmpty(key) || this.isEmpty(value)) {
      return this;
    }
    this.rules.add(new LikeType(key, value + "%"));
    return this;
  }

  public Where likeBegin(String key, Object value) {
    if (this.isEmpty(key) || this.isEmpty(value)) {
      return this;
    }
    this.rules.add(new LikeType(key, value + "%"));
    return this;
  }

  public Where likeBeginOrNull(String key, Object value) {
    if (this.isEmpty(key)) {
      return this;
    }
    this.rules.add(new LikeType(key, value != null ? value + "%" : null));
    return this;
  }

  public Where between(String key, Object value1, Object value2) {
    if (this.isEmpty(key) || this.isEmpty(value1) || this.isEmpty(value2)) {
      return this;
    }
    this.rules.add(new BetweenType(key, value1, value2));
    return this;
  }

  public Where in(String key, Object... value) {
    if (this.isEmpty(key)) {
      return this;
    }
    this.rules.add(new InType(key, value));
    return this;
  }

  public Where where(RuleType where) {
    this.rules.add(where);
    return this;
  }

  public PreparedStatement prepareStatement(Connection conn, String selectSql) throws SQLException {
    String orders = this.orders.size() == 0 ? "" : " ORDER BY " + String.join(",", this.orders);
    if (this.limit > 0) {
      orders += " limit " + this.limit;
    }

    String where = this.generate();
    PreparedStatement ps;
    if (where == null || where.length() == 0) {
      ps = conn.prepareStatement(selectSql + orders);
    } else {
      ps = conn.prepareStatement(selectSql + " WHERE " + where + orders);
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

  class NotEqType implements RuleType {

    private final String key;

    private final Object value;

    public NotEqType(String key, Object value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String getStatement() {
      return this.value == null ? this.key + " is not null " : this.key + "<>?";
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
      if (this.value1 instanceof Date) {
        DateUtils.setDateTz(ps, index++, (Date) this.value1);
        DateUtils.setDateTz(ps, index++, (Date) this.value2);
      } else {
        ps.setObject(index++, this.value1);
        ps.setObject(index++, this.value2);
      }
      return index;
    }
  }

  class InType implements RuleType {

    private final String key;

    private final Object[] value;

    public InType(String key, Object... value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public String getStatement() {
      if (value.length == 0) {
        return " 1=2 ";
      }
      StringBuilder sql = new StringBuilder();
      for (int i = 0; i < this.value.length; i++) {
        sql.append("?,");
      }
      return this.key + " in (" + sql.substring(0, sql.length() - 1) + ")";
    }

    @Override
    public int accpet(PreparedStatement ps, int index) throws SQLException {
      for (int i = 0; i < this.value.length; i++) {
        ps.setObject(index++, this.value[i]);
      }

      return index;
    }
  }
}
