package conc;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static sun.swing.SwingUtilities2.adjustFocus;
import static sun.swing.SwingUtilities2.submit;

public class ThreadTests {
    public void hereSchedule() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        ScheduledFuture future = executor.scheduleAtFixedRate(() -> {
                    System.out.println(new Date().toString() + Thread.currentThread());
                    try {
                        int a = 10;
                       for (int i =0; i < 2000000000; i++){ a = (i + 1) * (int)(double)(i + 5)/2;}//Thread.sleep(2000);
                        System.out.print(a);
                    } catch (Exception e) {
                    }
                }
                , 1, 1, TimeUnit.SECONDS);
    }

    public void executors(){
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
             try {
                 Future f = executor.submit(() -> {throw new Exception("haha");});
                 f.get();
            }catch (InterruptedException | ExecutionException er){
                System.out.println(er);
            }

        }

       // FutureTask<String> futureTask1 = new FutureTask<String>(() -> {return "14";});
        executor.shutdown();
    }

    public void atom(){
        AtomicInteger a = new AtomicInteger(5);
        a.set(6);
        System.out.println(a);
    }

    public void iter(){
        List<Integer> alist = new ArrayList<>();
        alist.add(1);
        alist.add(3);
        alist.add(2);
        alist.add(4);
        alist.add(5);
        Iterator<Integer> iter = alist.listIterator();
        for( ;iter.hasNext();){
            System.out.println(iter.toString());
            if(iter.next() == 2){
                iter.remove();
            }
        }
        System.out.println(alist.size());
    }
}
