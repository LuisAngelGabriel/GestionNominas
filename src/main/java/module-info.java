module com.example.gestionnominas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires jdk.compiler;

    opens com.example.gestionnominas to javafx.fxml;
    exports com.example.gestionnominas;
}