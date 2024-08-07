package client;

import javafx.fxml.FXML;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

import javafx.scene.image.ImageView;

import javafx.scene.input.KeyEvent;
import server.TranslatorService;

public class HomeController {
	@FXML
	private ImageView logoImage;
	@FXML
	private TextArea rkInputBox;
	@FXML
	private TextArea myInputBox;
	
	// Event Listener on TextArea[#rkInputBox].onKeyTyped
	@FXML
	public void onRKKeyTyped(KeyEvent event) {
		String text = rkInputBox.getText();
		try
		{
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1200);
			TranslatorService translatorService = (TranslatorService) registry.lookup("TranslatorService");
			myInputBox.setText(translatorService.translateRK2MY(text));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on TextArea[#myInputBox].onKeyTyped
	@FXML
	public void onMYKeyTyped(KeyEvent event) {
		String text = myInputBox.getText();
		try
		{
			Registry registry = LocateRegistry.getRegistry("127.0.01", 1200);
			TranslatorService translatorService = (TranslatorService) registry.lookup("TranslatorService");
			rkInputBox.setText(translatorService.translateMY2RK(text));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button.onAction
	@FXML
	public void onClickCopyRK(ActionEvent event) {
		copyCliboard(rkInputBox.getText());
	}

	// Event Listener on Button.onAction
	@FXML
	public void onClickCopyALL(ActionEvent event) {
		String text = "<<ရခိုင်>>\n"+rkInputBox.getText()+"\n\n<<မြန်မာ>>\n"+myInputBox.getText();
		copyCliboard(text);
	}

	// Event Listener on Button.onAction
	@FXML
	public void onClickCopyMY(ActionEvent event) {
		copyCliboard(myInputBox.getText());
	}
	
	public void copyCliboard(String text) {
		StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
	}
	
}
