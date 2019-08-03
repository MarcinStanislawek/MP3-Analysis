package pl.mp3analysis.controller;

import com.mpatric.mp3agic.Mp3File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Path;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import pl.mp3analysis.App;
import pl.mp3analysis.services.Utils;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;

public class RootController {

    @FXML
    private Label isDone;
    @FXML
    private Label mp3Directory;
    @FXML
    private Label libraryDirectory;
    private Stage primaryStage = new Stage();
    private DirectoryChooser directoryChooser = new DirectoryChooser();
    Utils utils;

    @FXML
    private void chooseDirectoryWithMp3s(ActionEvent actionEvent) {
        File directory = directoryChooser.showDialog(primaryStage);
        mp3Directory.setText(directory.toString());
    }

    @FXML
    private void chooseDirectoryToSaveLibrary(ActionEvent actionEvent2) {
        File directory = directoryChooser.showDialog(primaryStage);
        libraryDirectory.setText(directory.toString());

    }

    @FXML
    private void saveValues(ActionEvent actionEventSave) {

        isDone.setText("Biblioteka zapisana!");

    }
}
