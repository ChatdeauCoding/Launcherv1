package fr.shadow.launcher.panels.partials;

import fr.shadow.launcher.panel.Panel;
import fr.shadow.launcher.ui.PanelManager;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import fr.flowarg.materialdesignfontfx.MaterialDesignIcon;
import fr.flowarg.materialdesignfontfx.MaterialDesignIconView;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TopBar extends Panel {
    private GridPane topBar;

    @Override
    public String getName() {
        return "TopBar";
    }

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);
        this.topBar = this.layout;
        this.layout.setStyle("-fx-background-color : rgb(84, 85, 85)");

        //separation
        //TopBar left side
        ImageView imageView = new ImageView();
        imageView.setImage(new Image("images/icon.png"));
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(25);
        setLeft(imageView);
        this.layout.getChildren().add(imageView);

        //center
        Label title = new Label("Shadow Launcher");
        title.setFont(Font.font("Consolas", FontWeight.BOLD, FontPosture.REGULAR, 18f));
        title.setStyle("-fx-text-fill: white");
        setCenterH(title);
        this.layout.getChildren().add(title);

        //right

        GridPane topBarButton = new GridPane();
        topBarButton.setMinWidth(100d);
        topBarButton.setMaxWidth(100d);
        setCanTakeAllSize(topBarButton);
        setRight(topBarButton);
        this.layout.getChildren().add(topBarButton);

        //buttons machin truc la
        final var closeBtn = new MaterialDesignIconView<>(MaterialDesignIcon.W.WINDOW_CLOSE);
        final var fullscreenBtn = new MaterialDesignIconView<>(MaterialDesignIcon.W.WINDOW_MAXIMIZE);
        final var minimizeBtn = new MaterialDesignIconView<>(MaterialDesignIcon.W.WINDOW_MINIMIZE);
        setCanTakeAllWidth(closeBtn, fullscreenBtn, minimizeBtn);

        closeBtn.setFill(Color.WHITE);
        closeBtn.setOpacity(.7f);
        closeBtn.setSize("18px");
        closeBtn.setOnMouseEntered(e -> closeBtn.setOpacity(1f));
        closeBtn.setOnMouseExited(e -> closeBtn.setOpacity(.7f));
        closeBtn.setOnMouseClicked(e -> System.exit(0));
        closeBtn.setTranslateX(70f);

        fullscreenBtn.setFill(Color.WHITE);
        fullscreenBtn.setOpacity(.7f);
        fullscreenBtn.setSize("14px");
        fullscreenBtn.setOnMouseEntered(e -> fullscreenBtn.setOpacity(1f));
        fullscreenBtn.setOnMouseExited(e -> fullscreenBtn.setOpacity(.7f));
        fullscreenBtn.setOnMouseClicked(e -> this.panelManager.getStage().setMaximized(!this.panelManager.getStage().isMaximized()));
        fullscreenBtn.setTranslateX(50.0d);

        minimizeBtn.setFill(Color.WHITE);
        minimizeBtn.setOpacity(.7f);
        minimizeBtn.setSize("18px");
        minimizeBtn.setOnMouseEntered(e -> minimizeBtn.setOpacity(1f));
        minimizeBtn.setOnMouseExited(e -> minimizeBtn.setOpacity(.7f));
        minimizeBtn.setOnMouseClicked(e -> this.panelManager.getStage().setIconified(true));
        minimizeBtn.setTranslateX(26.0d);

        topBarButton.getChildren().addAll(closeBtn, fullscreenBtn, minimizeBtn);



    }
}
