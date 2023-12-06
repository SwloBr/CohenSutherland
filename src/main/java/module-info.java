module com.swlo.graphic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.swlo.graphic to javafx.fxml;
    exports com.swlo.graphic;
    exports com.swlo.graphic.utils.limits;
    opens com.swlo.graphic.utils.limits to javafx.fxml;
    exports com.swlo.graphic.view;
    opens com.swlo.graphic.view to javafx.fxml;
    exports com.swlo.graphic.utils.calcules;
    opens com.swlo.graphic.utils.calcules to javafx.fxml;
}