package application;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BSWcontrol extends Application implements Initializable{
	@FXML 
	Text scoreText;
	@FXML
	TextField gloryName;
	
	static int ScorePosition=0;
	static int score=0;
	
	@FXML
	public void submit() {
		SqlScores scr=new SqlScores();
		String name=gloryName.getText();
		scr.insertScore(name, score);
		scr.closeConnection();
		//((Node)event.getSource()).getScene().getWindow().hide();
		Stage stage = (Stage) gloryName.getScene().getWindow();	    
	    stage.close();
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		try {				
	        		AnchorPane root=new AnchorPane();
	        		root = (AnchorPane) FXMLLoader.load(getClass().getResource("BestScoreWindow.fxml"));
	                stage = new Stage();
	                stage.setScene(new Scene(root));  
	                stage.show();
	        }catch(Exception e) {
	           e.printStackTrace();
	   }
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		scoreText.setText("Your score is "+(ScorePosition+1));
	}

}