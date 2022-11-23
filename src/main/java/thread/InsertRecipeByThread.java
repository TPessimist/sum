package thread;

import com.google.common.collect.Lists;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import recipe.PostRecipe;
import recipe.Recipe;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class InsertRecipeByThread {

    public static void threadInsertRecipe(List<Recipe> recipes) throws SQLException {

        //划分为大小100的list
        List<List<Recipe>> list = Lists.partition(recipes,100);
        //创建等待队列
        CountDownLatch latch = new CountDownLatch(list.size());
        //创建线程池，最大线程数量为10
        int threadPoolMax = Math.min(list.size(), 10);

        ThreadFactory springThreadFactory = new CustomizableThreadFactory("Thread-pool-");
        ExecutorService threadPool = Executors.newFixedThreadPool(threadPoolMax, springThreadFactory);

        //获取数据库连接
        Connection conn = PostRecipe.initConn();

        //执行
        for(int i =0;i<list.size();i++){

            List<Recipe> subList = list.get(i);

            MyThread postRecipeThread = new MyThread(subList,latch,i,conn);

            threadPool.execute(postRecipeThread);

        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            threadPool.shutdown();
            conn.close();
        }

    }

}
