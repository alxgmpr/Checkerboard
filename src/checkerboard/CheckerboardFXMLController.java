/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author alex
 */
public class CheckerboardFXMLController implements Initializable, Startable {
    private int numRows = 8;
    private int numCols = 8;
    
    private Stage stage;
    
    @FXML
    private AnchorPane anchorPane;
    
    private Checkerboard checkerboard;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.checkerboard = new Checkerboard(numRows, numCols, anchorPane.getWidth(), anchorPane.getHeight());
        this.checkerboard.setAnchorPane(anchorPane);
        this.anchorPane = this.checkerboard.build();
        
        
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            this.checkerboard.setBoardHeight(anchorPane.getHeight());
            this.checkerboard.setBoardWidth(anchorPane.getWidth());
            this.anchorPane = this.checkerboard.build();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
    }
    
    @FXML
    public void handleGrid16(ActionEvent event) {
        this.checkerboard.setNumCols(16);
        this.checkerboard.setNumRows(16);
        this.anchorPane = checkerboard.build();
    }
    
    @FXML
    public void handleGrid10(ActionEvent event) {
        this.checkerboard.setNumCols(10);
        this.checkerboard.setNumRows(10);
        this.anchorPane = checkerboard.build();
    }
    
    @FXML
    public void handleGrid8(ActionEvent event) {
        this.checkerboard.setNumCols(8);
        this.checkerboard.setNumRows(8);
        this.anchorPane = checkerboard.build();
    }
    
    @FXML
    public void handleGrid3(ActionEvent event) {
        this.checkerboard.setNumCols(3);
        this.checkerboard.setNumRows(3);
        this.anchorPane = checkerboard.build();
    }
    
    @FXML
    public void handleColorDefault(ActionEvent event) {
        this.checkerboard.setLightColor(Color.RED);
        this.checkerboard.setDarkColor(Color.BLACK);
        this.anchorPane = checkerboard.build();
    }
    
    @FXML
    public void handleColorBlue(ActionEvent event) {
        this.checkerboard.setLightColor(Color.SKYBLUE);
        this.checkerboard.setDarkColor(Color.DARKBLUE);
        this.anchorPane = checkerboard.build();
    }
    
}
