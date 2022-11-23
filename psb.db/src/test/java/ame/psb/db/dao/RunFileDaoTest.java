package ame.psb.db.dao;

import ame.psb.commons.Env;
import ame.psb.db.RunFile;
import ame.psb.db.conf.DB;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RunFileDaoTest {

    @Test
    public void test1() {
        try {
            Env.initialProd();
            RunFileDao runFileDao = new RunFileDao(DB.create());
            RunFile runFile = runFileDao.selectByPK("8b57d622-b547-435a-9d50-a7b791399ca3");
            System.out.println(new String (runFile.getBinary()));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}