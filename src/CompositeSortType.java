public enum CompositeSortType {
    // enum  상속이 안 되서 코드 중복을 방치??
    TITLE_DESC{
        @Override
        int compare(CompositeTask a, CompositeTask b) {
            return a.getTitle().compareTo(b.getTitle());
        }
    },
    TITLE_ASC{
        @Override
        int compare(CompositeTask a, CompositeTask b) {
            return b.getTitle().compareTo(a.getTitle());
        }
    },
    DATE_DESC{
        @Override
        int compare(CompositeTask a, CompositeTask b) {
            return a.getDate().compareTo(b.getDate());
        }
    },
    DATE_ASC{
        @Override
        int compare(CompositeTask a, CompositeTask b) {
            return b.getDate().compareTo(a.getDate());
        }
    };

    abstract int compare(CompositeTask a, CompositeTask b);
}