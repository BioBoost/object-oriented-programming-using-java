package fxmlwalktheplank;

import gamelogic.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class WalkThePlankController implements Initializable {
    
    private Player player;
    
    @FXML private TextField nickname;
    
    @FXML
    private void createPlayerHandler(ActionEvent event) {
        String playerNickname = nickname.getText();
        player = new Player(playerNickname);
        System.out.println("Created new player: " + player);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}
