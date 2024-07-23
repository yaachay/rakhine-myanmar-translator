package application.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TranslatorServer {
	public static final String serverLogo = " ____  __  __   ____\n"
			+ "|  _ \\|  \\/  | / ___|  ___ _ ____   _____ _ __ \n"
			+ "| |_) | |\\/| | \\___ \\ / _ \\ '__\\ \\ / / _ \\ '__|\n"
			+ "|  _ <| |  | |  ___) |  __/ |   \\ V /  __/ |   \n"
			+ "|_| \\_\\_|  |_| |____/ \\___|_|    \\_/ \\___|_|   \n";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(serverLogo);
			TranslatorService translatorService = new TranslatorImpl();
			Registry registry = LocateRegistry.createRegistry(1200);
			registry.rebind("TranslatorService", translatorService);
			System.out.println("TranslatorService is running...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
