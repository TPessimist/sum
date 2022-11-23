package ame.psb.db.conf;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class DB {

  public static final String VERSION = "0.0.3 0706A";

  static {
    try {
      DataSource.initial("slf4j");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Connection create() throws SQLException {
    if ("ORA".equals(System.getProperty("psb.env"))) {
      Connection conn = Oracle.create();
      return new ConnectionProxy(conn);
    } else {
      // Connection conn = Hana.create();
      return DataSource.getConnection();
    }
  }

  public static Connection createSpc() throws SQLException {
    Connection conn = Hana.createSpc();
    return new ConnectionProxy(conn);
  }

  public static class ConnectionProxy implements Connection {

    private final Connection conn;

    ConnectionProxy(Connection conn) {
      this.conn = conn;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
      return this.conn.isWrapperFor(iface);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
      return this.conn.unwrap(iface);
    }

    @Override
    public void abort(Executor executor) throws SQLException {
      this.conn.abort(executor);

    }

    @Override
    public void clearWarnings() throws SQLException {
      this.conn.clearWarnings();
    }

    @Override
    public void close() throws SQLException {
      if (!getAutoCommit()) {
        rollback();
      }
      this.conn.close();
    }

    @Override
    public void commit() throws SQLException {
      this.conn.commit();
      this.conn.setAutoCommit(true);
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
      return this.conn.createArrayOf(typeName, elements);
    }

    @Override
    public Blob createBlob() throws SQLException {
      return this.conn.createBlob();
    }

    @Override
    public Clob createClob() throws SQLException {
      return this.conn.createClob();
    }

    @Override
    public NClob createNClob() throws SQLException {
      return this.conn.createNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
      return this.conn.createSQLXML();
    }

    @Override
    public Statement createStatement() throws SQLException {
      return this.conn.createStatement();
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency)
        throws SQLException {
      return this.conn.createStatement(resultSetType, resultSetConcurrency);
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency,
        int resultSetHoldability) throws SQLException {
      return this.conn.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
      return this.conn.createStruct(typeName, attributes);
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
      return this.conn.getAutoCommit();
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
      this.conn.setAutoCommit(autoCommit);
    }

    @Override
    public String getCatalog() throws SQLException {
      return this.conn.getCatalog();
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
      this.conn.setCatalog(catalog);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
      return this.conn.getClientInfo();
    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
      this.conn.setClientInfo(properties);
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
      return this.conn.getClientInfo(name);
    }

    @Override
    public int getHoldability() throws SQLException {
      return this.conn.getHoldability();
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
      this.conn.setHoldability(holdability);
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
      return this.conn.getMetaData();
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
      return this.conn.getNetworkTimeout();
    }

    @Override
    public String getSchema() throws SQLException {
      return this.conn.getSchema();
    }

    @Override
    public void setSchema(String schema) throws SQLException {
      this.conn.setSchema(schema);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
      return this.conn.getTransactionIsolation();
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
      this.conn.setTransactionIsolation(level);
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
      return this.conn.getTypeMap();
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
      this.conn.setTypeMap(map);
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
      return this.conn.getWarnings();
    }

    @Override
    public boolean isClosed() throws SQLException {
      return this.conn.isClosed();
    }

    @Override
    public boolean isReadOnly() throws SQLException {
      return this.conn.isReadOnly();
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
      this.conn.setReadOnly(readOnly);

    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
      return this.conn.isValid(timeout);
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
      return this.conn.nativeSQL(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
      return this.conn.prepareCall(sql);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
        throws SQLException {
      return this.conn.prepareCall(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
        int resultSetHoldability) throws SQLException {
      return this.conn.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    /**
     * 原则上不允许select超过10000行，已免导致Tomcat full gc
     */
    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
      PreparedStatement ps = this.conn.prepareStatement(sql);
      ps.setMaxRows(Hana.getMaxRow());
      return ps;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
        throws SQLException {
      return this.conn.prepareStatement(sql, autoGeneratedKeys);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
      return this.conn.prepareStatement(sql, columnIndexes);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames)
        throws SQLException {
      return this.conn.prepareStatement(sql, columnNames);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType,
        int resultSetConcurrency) throws SQLException {
      return this.conn.prepareStatement(sql, resultSetType, resultSetConcurrency);
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType,
        int resultSetConcurrency, int resultSetHoldability) throws SQLException {
      return this.conn
          .prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
      this.conn.releaseSavepoint(savepoint);
    }

    @Override
    public void rollback() throws SQLException {
      this.conn.rollback();
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
      this.conn.rollback(savepoint);
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
      this.conn.setClientInfo(name, value);
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
      this.conn.setNetworkTimeout(executor, milliseconds);
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
      return this.conn.setSavepoint();
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
      return this.conn.setSavepoint(name);
    }

  }
}
