package application;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	Parent root;
	Image icon = new Image(getClass().getResourceAsStream("icon.png"));

	@Override
	public void start(Stage primaryStage) {
		try {
			Registry localRegistry = LocateRegistry.getRegistry("127.0.01", 1200);
			boolean registryAccessible = isRegistryAccessible(localRegistry, "TranslatorService");

			if (registryAccessible) {
				root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			} else {
				root = FXMLLoader.load(getClass().getResource("Error.fxml"));
			}
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("RM Translator");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isRegistryAccessible(Registry registry, String remoteObjectName) {
		try {
			// Attempt to lookup the specified remote object in the registry
			registry.lookup(remoteObjectName);
			return true; // Lookup successful, registry is accessible
		} catch (RemoteException | NotBoundException e) {
			// Lookup failed, registry might not be accessible or object not found
			return false;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
