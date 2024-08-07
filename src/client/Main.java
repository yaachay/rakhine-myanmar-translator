package client;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	private boolean isLoadedSplash = false;
	Image icon = new Image(getClass().getResourceAsStream("icon.png"));

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Load splash screen FXML
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Splash.fxml"));
		Parent splashLayout = loader.load();
		SplashController controller = loader.getController();

		Scene splashScene = new Scene(splashLayout);

		// Create the splash screen stage
		Stage splashStage = new Stage();
		splashStage.initStyle(StageStyle.UNDECORATED);
		splashStage.getIcons().add(icon);
		splashStage.setTitle("RM Translator");
		splashStage.setScene(splashScene);
		splashStage.setResizable(false);
		splashStage.show();

		// Use ScheduledService to close the splash screen and open the main application
		ScheduledService<Void> splashService = new ScheduledService<Void>() {
			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {
					@Override
					protected Void call() throws Exception {
//						Thread.sleep(3000); // Simulate loading
						for (int i = 0; i <= 100; i++) {
							Thread.sleep(30); // Simulate time-consuming task
							controller.updateProgress(i/100.0);
						}
						return null;
					}
				};
			}
		};
		splashService.setOnSucceeded(event -> {
			if (!isLoadedSplash) {
				splashStage.close();
				isLoadedSplash = true;
				// Open the main application
				Home home = new Home();
				Stage homeStage = new Stage();
				try {
					home.start(homeStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		splashService.start();
		splashService.setOnScheduled(event -> controller.updateProgress(0));
		splashService.setOnRunning(event -> controller.updateProgress(0));
		splashService.progressProperty().addListener((observable, oldValue, newValue) -> {
			javafx.application.Platform.runLater(() -> controller.updateProgress(newValue.doubleValue()));
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
