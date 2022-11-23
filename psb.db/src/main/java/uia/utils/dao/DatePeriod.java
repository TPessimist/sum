package uia.utils.dao;

import java.util.Date;

public class DatePeriod {

  public Date minTime;

  public Date maxTime;


  public DatePeriod() {

  }


  public DatePeriod(Date minTime, Date maxTime) {
    this.minTime = minTime;
    this.maxTime = maxTime;

  }

  public static Date minDate(Date date1, Date date2) {
    if (date1 == null) {
      return date2;//may null
    }
    if (date2 == null) {
      return date1;
    }
    if (date1.after(date2)) {
      return date2;
    } else {
      return date1;
    }

  }

  public static Date maxDate(Date date1, Date date2) {
    if (date1 == null) {
      return date2;//may null
    }
    if (date2 == null) {
      return date1;
    }
    if (date1.before(date2)) {
      return date2;
    } else {
      return date1;
    }

  }

  // Min < Max => available
  public boolean isAvailable() {
    if (minTime == null || maxTime == null) {
      return true;
    }
    return minTime.before(maxTime);
  }

  //Intersection 
  public DatePeriod crossWith(DatePeriod target) {
    DatePeriod result = new DatePeriod();
    result.minTime = maxDate(this.minTime, target.minTime);
    result.maxTime = minDate(this.maxTime, target.maxTime);
    return result;
  }

}
