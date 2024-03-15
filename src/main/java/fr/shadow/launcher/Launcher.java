package fr.shadow.launcher;

import fr.flowarg.flowlogger.ILogger;
import fr.flowarg.flowlogger.Logger;
import fr.shadow.launcher.ui.PanelManager;
import fr.shadow.launcher.utils.Helpers;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class Launcher extends Application {
    private PanelManager panelManager;
    private static Launcher instance;
    private final ILogger logger;
    private final File launcherDir = Helpers.generateGamePath("ShadowLauncher");

    public Launcher(){
        instance = this;
        this.logger = new Logger("[ShadowLauncher]", new File(this.launcherDir, "launcher.log").toPath());
        this.launcherDir.mkdirs();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.logger.info("Starting Launcher");
        this.panelManager = new PanelManager(this, stage);
        this.panelManager.init();
    }

    public ILogger getLogger(){
        return logger;
    }

    public static Launcher getInstance(){
        return instance;
    }
}
