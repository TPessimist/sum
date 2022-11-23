package uia.utils.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

  public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

  public static void setDate(PreparedStatement ps, int index, Date value) throws SQLException {
    if (value == null) {
      ps.setNull(index, java.sql.Types.TIMESTAMP);
    } else {
      ps.setTimestamp(index, new java.sql.Timestamp(value.getTime()));
    }
  }

  public static void setDateTz(PreparedStatement ps, int index, Date value) throws SQLException {
    if (value == null) {
      ps.setNull(index, java.sql.Types.TIMESTAMP);
    } else {
      ps.setTimestamp(index,
          new java.sql.Timestamp(value.getTime() - TimeZone.getDefault().getRawOffset()));
    }
  }

  public static Date getDate(ResultSet rs, int index) throws SQLException {
    if (rs.getObject(index) == null) {
      return null;
    }
    return new Date(rs.getTimestamp(index).getTime());
  }

  public static Date getDateTz(ResultSet rs, int index) throws SQLException {
    if (rs.getObject(index) == null) {
      return null;
    }
    return new Date(rs.getTimestamp(index).getTime() + TimeZone.getDefault().getRawOffset());
  }

  //LocalDate -> Date
  public static Date asDate(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
  }

  //LocalDateTime -> Date
  public static Date asDate(LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
  }

  //Date -> LocalDate
  public static LocalDate asLocalDate(Date date) {
    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
  }

  //Date -> LocalDateTime
  public static LocalDateTime asLocalDateTime(Date date) {
    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

  public static String format(Date date) {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
  }
}
