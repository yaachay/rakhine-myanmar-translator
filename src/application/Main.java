package application;
	
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.plaf.synth.SynthStyleFactory;

import application.server.TranslatorService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	Image icon = new Image(getClass().getResourceAsStream("icon.png"));
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("RM Translator");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String rkTitle = "ဇာကိုလားလေ့။";
		
		try
		{
			Registry registry = LocateRegistry.getRegistry("127.0.01", 1200);
			TranslatorService translatorService = (TranslatorService) registry.lookup("TranslatorService");
			System.out.print(translatorService.translateRK2MY(rkTitle));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		launch(args);
	}
}
