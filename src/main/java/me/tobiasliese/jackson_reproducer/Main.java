package me.tobiasliese.jackson_reproducer;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import me.tobiasliese.jackson_reproducer.config.ConfigManager;

public class Main extends Application {

	public static void main(String[] args) {

		System.out.println(ConfigManager.config);

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setScene(new Scene(new Label("Hello world")));
		primaryStage.show();
	}
}