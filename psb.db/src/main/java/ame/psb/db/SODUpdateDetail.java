package ame.psb.db;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SODUpdateDetail {

  private String sfc;

  private Date sod;

}
