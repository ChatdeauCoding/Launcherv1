package fr.shadow.launcher.panel;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.Node;

public interface ITakePlace {
    default void setCanTakeAllSize(Node node) {
        GridPane.setHgrow(node, Priority.ALWAYS);
        GridPane.setVgrow(node, Priority.ALWAYS);
    }

    default void setCanTakeAllWidth(Node ... nodes){
        for (Node n : nodes){
            GridPane.setVgrow(n, Priority.ALWAYS);
        }
    }
}
