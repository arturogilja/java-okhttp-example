module mx.arturogil.httprequestexample {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.fasterxml.jackson.annotation;
    requires okhttp3;
    requires com.fasterxml.jackson.databind;

    opens mx.arturogil.httprequestexample to javafx.fxml;
    exports mx.arturogil.httprequestexample;
}