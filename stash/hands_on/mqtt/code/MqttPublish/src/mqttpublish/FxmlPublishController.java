/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqttpublish;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.eclipse.paho.client.mqttv3.MqttClient;

public class FxmlPublishController implements Initializable {
    
    @FXML private TextField topic;
    @FXML private TextArea message;
    
    private MqttClient sampleClient;
    
    @FXML
    private void handlePublish(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
