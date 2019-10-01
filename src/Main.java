import java.time.LocalDateTime;
import java.util.List;

public class Main {
    // 큰 흐름은 탬플릿 메소드로 만들고
    // 상세는 라이플 사이클을 타는 비지터 패턴으로 만든다../
    // 의존성 역전 --> 구상객체를 알아야 하는 애가 추상 객체를 알도록
    // 제어 역전 --> 제어 구문이 라이프 사이클을 갖고 있는 애를 소모하도록...

    public static void main(String[] args) {
        if (1 != 1){
            CompositeTask root = new CompositeTask("Root", LocalDateTime.now());
            root.addTask("sub1", LocalDateTime.now());
            root.addTask("sub2", LocalDateTime.now());

            TaskReport report = root.getReport(CompositeSortType.TITLE_ASC);
            List<TaskReport> list = report.getList();
            CompositeTask sub1 = list.get(0).getTask();
            CompositeTask sub2 = list.get(1).getTask();
            sub1.addTask("sub1_1", LocalDateTime.now());
            sub1.addTask("sub1_2", LocalDateTime.now());
            sub2.addTask("sub2_1", LocalDateTime.now());
            sub2.addTask("sub2_2", LocalDateTime.now());

    //        Renderer renderer1 = new Renderer(()->new ConsoleVisitor());
    //        renderer1.render(root.getReport(CompositeSortType.TITLE_ASC));

            Renderer renderer2 = new Renderer(()->new JsonVisitor());
            renderer2.render(root.getReport(CompositeSortType.TITLE_ASC));
        }

        CommandTask root = new CommandTask("Root", LocalDateTime.now());
        // 커맨드 객체에 어그리게이터를 끼워 넣어서 실행 결과를 어그리게이터에게 쏴주고 이 어그리게이터가 인보커가 됨.
        // 여기서는 CommandTask 가 인보커가 됨.
        root.addTask("sub1", LocalDateTime.now());
        root.addTask("sub2", LocalDateTime.now());

//        Renderer renderer1 = new Renderer(()->new ConsoleVisitor());
        Renderer renderer1 = new Renderer(()->new JsonVisitor());
        renderer1.render(root.getReport(CompositeSortType.TITLE_ASC));
        root.undo();
        renderer1.render(root.getReport(CompositeSortType.TITLE_ASC));
        root.undo();
        renderer1.render(root.getReport(CompositeSortType.TITLE_ASC));
        root.redo();
        renderer1.render(root.getReport(CompositeSortType.TITLE_ASC));


//        Renderer renderer2 = new Renderer(()->new JsonVisitor());
//        renderer2.render(root.getReport(CompositeSortType.TITLE_ASC));


        // 제대로 커맨드 객체를 만들면 메소드가 없음....
        // 커맨드 객체는 addCommand 만 갖고 있으면 다른 모든 메소드를 다 처리할 수 있음.
    }
}