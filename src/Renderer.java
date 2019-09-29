import java.util.function.Supplier;

public class Renderer {
    // 첫 번째로 배우는 ???? 비지터 패턴

    private final Supplier<Visitor> factory;

    public Renderer(Supplier<Visitor> factory) {
        this.factory = factory;
    }

    // 내부 변수가 없는 함수 와 아닌 함수는 큰 차이가 난다...
    public void render(TaskReport report) {
        render(factory.get(), report, 0);
    }

    // 객체 지향은 new 때리는 거다
    private void render(Visitor visitor, TaskReport report, int depth) {
        visitor.drawTask(report.getTask(), depth);
        for (TaskReport r : report.getList()) {
            render(visitor, r, depth + 1);
        }
        visitor.end(depth);
    }
}