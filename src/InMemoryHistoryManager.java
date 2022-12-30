import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private List<Task> viewHistory = new ArrayList<>();
    protected int index = 0;

    @Override
    public void add(Task task) {
        if (viewHistory.size() < 10) {
            viewHistory.add(task);
        } else {
            viewHistory.set(index++, task);
            if (index == 10) {
                index = 0;
            }
        }
    }

    @Override
    public void getHistory() {
        for (int i = 0; i < viewHistory.size(); i++) {
            System.out.println(viewHistory.get(i));
        }
    }
}
