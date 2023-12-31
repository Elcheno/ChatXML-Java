module com.dam.chatsocket_java {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.xml.bind;
    requires java.logging;

    opens com.dam.chatsocket_java to javafx.fxml;
    exports com.dam.chatsocket_java;

    opens com.dam.chatsocket_java.model.domain to java.xml.bind, javafx.base;
    opens com.dam.chatsocket_java.model.connections;
    exports com.dam.chatsocket_java.controllers;
    opens com.dam.chatsocket_java.controllers to javafx.fxml;

    opens com.dam.chatsocket_java.model.dto to javafx.base;


}