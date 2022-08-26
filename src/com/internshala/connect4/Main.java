package com.internshala.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loder = new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane rootGridPane = loder.load();
		controller = loder.getController();
		controller.creatPlayGround();

		Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
		MenuBar menuBar = creatMenus();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		menuPane.getChildren().addAll(menuBar);
		primaryStage.setScene(new Scene(rootGridPane));
		primaryStage.setTitle("Connect Four");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private MenuBar creatMenus() {
		Menu filemenu = new Menu("file");
		MenuItem newGame = new MenuItem("New Game");
		newGame.setOnAction(event -> controller.resetGame());
		MenuItem ResetGame = new MenuItem("Reset Game");
		ResetGame.setOnAction(event -> controller.resetGame());
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem ExitGame = new MenuItem("Exit game");
		ExitGame.setOnAction(event -> ExitGame());

		filemenu.getItems().addAll(ResetGame, newGame, separatorMenuItem, ExitGame);
		Menu Helpmenu = new Menu("Help");

		MenuItem AboutGame = new MenuItem("About Game");
		AboutGame.setOnAction(event -> AboutConnect4());

		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuItem AboutMe = new MenuItem("About Me");
		AboutMe.setOnAction(event -> AboutMe());

		Helpmenu.getItems().addAll(AboutGame, separatorMenuItem, AboutMe);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(filemenu, Helpmenu);
		return menuBar;
	}

	private void AboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About the Developer");
		alert.setHeaderText("Arbaaz khan");
		alert.setContentText(" Hey! its me The Devloper of this Wonderful Game ");
		alert.show();
	}

	private void AboutConnect4() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About connect4 Game");
		alert.setHeaderText("How to play?");
		alert.setContentText(
				"players first choose a color and then take turns dropping colored discs \"+ \"from the top into a seven-column, six-row vertically suspended grid.\"+ \"The pieces fall straight down, occupying the next available space within the column.\"+ \"The objective of the game is to be the first to form a horizontal, vertical,\"+ \"or diagonal line of four of one's own discs. Connect Four is a solved game.\"+ \"The first player can always win by playing the right moves.\");");
		alert.show();
	}

	private void ExitGame() {
		Platform.exit();
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
