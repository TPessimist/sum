package uia.utils.dao;

import ame.psb.db.conf.Hana;
import org.junit.Test;

public class JavaClassPrinterTest {

  @Test
  public void testGenerateTable() throws Exception {
    // JavaClassPrinter.Result result = new JavaClassPrinter(Hana.createTest(),
    // "ZR_OUT_SFC".toUpperCase()).generate("ame.psb.db.dao", "ame.psb.db",
    // "OutSfc");

    JavaClassPrinter.Result result = new JavaClassPrinter(Hana.createTest(),

        "ZR_HOLD_BONED_SFC".toUpperCase())
        .generate("ame.psb.db.dao", "ame.psb.db", "HoldBonedSfc");
    
    System.out.println("=========================");
    System.out.println(result.dto);
    System.out.println("=========================");
    System.out.println(result.dao);
  }
  /*
  @Test
  public void testGenerateDTO() throws Exception {
    System.out
        .println(new JavaClassPrinter(DB.create(), "ZD_AREA_EQUIPMENT")
            .generateDTO("ame.psb.db", "AreaEquipment"));
  }
  
  @Test
  public void testGenerateView() throws Exception {
    Env.initialTest();

    JavaClassPrinter.Result result = new JavaClassPrinter(Hana.createTest(),
        "ZD_AREA_EQUIPMENT")
        .generate4View("ame.psb.db.dao", "ame.psb.db", "AreaEquipment");
    System.out.println("=========================");
    System.out.println(result.dto);
    System.out.println("=========================");
    System.out.println(result.dao);
  }*/

    /*
    @Test
    public void testGenerateView() throws Exception {
        Env.initial("app.properties");

        JavaClassPrinter.Result result = new JavaClassPrinter(Hana.createTest(), "VIEW_PKG_MULTILABEL_DEPEND_TAG")
                .generate4View("ame.psb.db.dao", "ame.psb.db", "ViewPkgMultiLabelDependTag");
        System.out.println("=========================");
        System.out.println(result.dto);
        System.out.println("=========================");
        System.out.println(result.dao);
    }

    @Test
    public void testGenerateDTO() throws Exception {
        System.out
                .println(new JavaClassPrinter(DB.create(), "ZD_SORT_MANIPULATION").generateDTO("ame.psb.db", "SortManipulation"));
    }

    @Test
    public void testGenerateDAO() throws Exception {
        System.out.println(new JavaClassPrinter(DB.create(), "ZD_SORT_MANIPULATION").generateDAO("uia.utils.dao",
                "uia.utils.dao", "SortManipulation"));
    }

    @Test
    public void testGenerateDAO4View() throws Exception {
        System.out.println(new JavaClassPrinter(DB.create(), "ZD_SORT_MANIPULATION").generateDAO4View("uia.utils.dao",
                "uia.utils.dao", "SortManipulation"));
    }*/

}
