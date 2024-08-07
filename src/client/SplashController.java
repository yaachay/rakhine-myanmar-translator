package client;

import javafx.fxml.FXML;

import javafx.scene.control.ProgressBar;

public class SplashController {
	@FXML
	private ProgressBar progressBar;
	
	public void updateProgress(double progress) {
        progressBar.setProgress(progress);
    }

}
