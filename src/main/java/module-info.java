module com.mycompany.finalstd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires javafx.base;

    opens com.mycompany.finalstd to javafx.fxml, java.sql;
    opens Services to java.sql,javafx.base;
    exports com.mycompany.finalstd;
}
