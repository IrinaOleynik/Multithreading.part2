import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    protected String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try {
            for (int i = 0; i < 4; i++) {
                Thread.sleep(2500);
                System.out.println(name + " - Всем привет!");
                count++;
            }
        } catch (InterruptedException err) {
        } finally {
            System.out.printf("%s завершен\n", name);
        }
        return count;
    }
}
