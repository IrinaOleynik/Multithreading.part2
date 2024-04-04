import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<MyCallable> myCallableList = new ArrayList<>();

        myCallableList.add(new MyCallable("поток 1"));
        myCallableList.add(new MyCallable("поток 2"));
        myCallableList.add(new MyCallable("поток 3"));
        myCallableList.add(new MyCallable("поток 4"));

        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        final List<Future<Integer>> tasks = threadPool.invokeAll(myCallableList);

        for (Future<Integer> future : tasks) {
            System.out.println("Количество отправленных сообщений: " + future.get());
        }

        System.out.println("Количество отправленных сообщений: " + threadPool.invokeAny(myCallableList));
        threadPool.shutdown();
    }
}