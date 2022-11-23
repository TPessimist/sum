package ame.psb.db;

import javax.persistence.Entity;

/**
 * Operation Custom Fields
 *
 * @author Kyle K. Lin
 */
@Entity
public interface OperationEx {

  public static final String CF_CYCLE_TIME_TYPE = "CYCLE_TIME_TYPE";

  public static final String CF_OPERATION_TYPE = "OPERATION_TYPE";

  public static final String CF_RECIPE_TYPE = "RECIPE_TYPE";

  public static final String CF_STAGE = "STAGE";

  public static final String CF_PROP_NAMES = "PROP_NAMES";

  public static final String CF_PACKING_SOURCE = "PACKING_SOURCE";

  public static final String CF_BINMAP_TYPE = "BINMAP_TYPE";

  public static final String OPERATION_TYPE_PROCESS = "P";

  public static final String OPERATION_TYPE_METROLOGY = "M";

  public static final String OPERATION_TYPE_INTEGRATION = "I";

  public static final String OPERATION_TYPE_OUTSOURCE = "O";

  public static final String OPERATION_TYPE_BOX = "B";

  public static final String OPERATION_TYPE_CARTON = "C";

  public static final String OPERATION_TYPE_EXTRA = "X";

  public static final String OPERATION_TYPE_SAMPLING = "S";

  public static final String CYCLE_TIME_TYPE_LOT = "L";

  public static final String CYCLE_TIME_TYPE_WAFER = "W";

  public static final String RECIPE_TYPE_NO = "N";

  public static final String RECIPE_TYPE_FIXED = "F";

  public static final String RECIPE_TYPE_PATTERN = "P";

  public static final String RECIPE_TYPE_CP = "CP";

  public static final String RECIPE_TYPE_MATRIX = "M";

  public static final String PACKING_TYPE_CONTAINER = "C";

  public static final String PACKING_TYPE_SFC = "S";

}
