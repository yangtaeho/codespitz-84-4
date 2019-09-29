import java.util.ArrayList;
import java.util.List;

public class TaskReport {
    private final CompositeTask task;
    private final List<TaskReport> list = new ArrayList<>(); // List 가 TaskReport 의 제네릭을 받는 시점에서....본인이 리프이자 트리 이므로써 컴포짓 패턴이 됨.

    public TaskReport(CompositeTask task) {
        this.task = task;
    }

    public void add(TaskReport report) {
        list.add(report);
    }

    public CompositeTask getTask() {
        return task;
    }

    public List<TaskReport> getList() {
        return list;
    }
}