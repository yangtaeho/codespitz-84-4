public class JSONVisitor implements Visitor {
    @Override
    public void drawTask(CompositeTask task, int depth) {
        String padding = getPadding(depth);
        System.out.println(padding + "{");
        System.out.println(padding + " title: \"" + task.getTitle() + "\",");
        System.out.println(padding + " date: \"" + task.getDate() + "\",");
        System.out.println(padding + " isComplete: " + task.getComplete() + ",");
        System.out.println(padding + " sub: [ ");
    }

    private String getPadding(int depth) {
        String padding = "";
        for (int i = 0; i < depth; i++) {
            padding += "  ";
        }
        return padding;
    }

    @Override
    public void end(int depth) {
        String padding = getPadding(depth);
        System.out.println(padding + "  ]");
        System.out.println(padding + "},"); // trailing comma 허용하자.... 비지터 패턴...에 분기점 넣어야 하니까..
    }
}