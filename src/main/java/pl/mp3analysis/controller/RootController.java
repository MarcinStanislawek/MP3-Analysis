package pl.mp3analysis.controller;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import lombok.Data;
import pl.mp3analysis.services.Utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Data
public class RootController {

    @FXML
    private Label isDone;
    @FXML
    private TextField mp3Directory;
    @FXML
    private TextField libraryDirectory;
    @FXML
    private Button findMp3;
    @FXML
    private Button saveDirectory;
    @FXML
    private Button submit;

    private Path path1;
    private Path path2;


    @FXML
    private void chooseDirectoryWithMp3s(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Stage stage = new Stage();
        File directory = directoryChooser.showDialog(stage);
        mp3Directory.setText(directory.toString());
    }

    @FXML
    private void chooseDirectoryToSaveLibrary(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Stage stage = new Stage();
        File directory = directoryChooser.showDialog(stage);
        libraryDirectory.setText(directory.toString());

    }

    @FXML
    private void saveValues(ActionEvent actionEvent) throws InvalidDataException, UnsupportedTagException {
        Utils utils = new Utils();

        Path path1 = Paths.get(mp3Directory.getText());
        Path path2 = Paths.get(libraryDirectory.getText());

        utils.readMp3s(path1, path2);

        isDone.setText("Biblioteka zapisana!");

    }
}
