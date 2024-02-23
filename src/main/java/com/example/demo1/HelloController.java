package com.example.demo1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HelloController {
    public TextField playerSearch;

    public TableView<Player> playerTableView;
    public TableColumn<Player, Integer> id;
    public TableColumn<Player,String> FirstName;
    public TableColumn<Player,String> LastName;
    public TableColumn<Player,Integer> HeightFeet;
    public TableColumn<Player,Integer> HeightInches;
    public TableColumn<Player,String> Position;

    public void initialize() throws Exception {

        playerTableView.setEditable(true);
        id.setCellValueFactory(new PropertyValueFactory<Player, Integer>("id"));
        id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        id.setOnEditCommit(event -> {
            Player cellData = event.getRowValue();
            cellData.setId(event.getNewValue());
        });

        FirstName.setCellValueFactory(new PropertyValueFactory<Player, String>("FirstName"));
        FirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        FirstName.setOnEditCommit(event -> {
            Player cellData = event.getRowValue();
            cellData.setFirstName(event.getNewValue());
        });

        LastName.setCellValueFactory(new PropertyValueFactory<Player, String>("LastName"));
        LastName.setCellFactory(TextFieldTableCell.forTableColumn());
        LastName.setOnEditCommit(event -> {
            Player cellData = event.getRowValue();
            cellData.setLastName(event.getNewValue());
        });

        HeightFeet.setCellValueFactory(new PropertyValueFactory<Player, Integer>("HeightFeet"));
        HeightFeet.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        HeightFeet.setOnEditCommit(event -> {
            Player cellData = event.getRowValue();
            cellData.setHeightFeet(event.getNewValue());
        });
        HeightInches.setCellValueFactory(new PropertyValueFactory<Player, Integer>("HeightInches"));
        HeightInches.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        HeightInches.setOnEditCommit(event -> {
            Player cellData = event.getRowValue();
            cellData.setHeightInches(event.getNewValue());
        });
            Position.setCellValueFactory(new PropertyValueFactory<Player, String>("LastName"));
            Position.setCellFactory(TextFieldTableCell.forTableColumn());
            Position.setOnEditCommit(event -> {
                Player cellData = event.getRowValue();
                cellData.setPosition(event.getNewValue());
        });
    }
    @FXML
    protected void NewPlayer() throws Exception{
        String playerRequested = playerSearch.getText();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://free-nba.p.rapidapi.com/players/" +playerRequested))
                .header("X-RapidAPI-Key", "155251ef6fmsh337f75b21b3c139p1b5d3djsn6e6dbc8b6952")
                .header("X-RapidAPI-Host", "free-nba.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body());
        // By reading the JSON tree, the code can now get individual "key":"value" pairs
        // The value of the "result" key is an ARRAY of JSON objects
        JsonNode arrayOfPlayers = jsonNode.get("data");
        for (JsonNode eachPlayer : arrayOfPlayers) {
            // read 1 JSON object (its "key":"value" pairs) into the fields of a ChuckNorrisJoke object.
            System.out.println(eachPlayer);

            Player player = new Player();
            player.setId(eachPlayer.get("id").asInt());
            player.setFirstName(eachPlayer.get("first_name").asText());
            player.setHeightFeet(eachPlayer.get("height_feet").asInt());
            player.setHeightInches(eachPlayer.get("height_inches").asInt());
            player.setLastName(eachPlayer.get("last_name").asText());
            player.setPosition(eachPlayer.get("position").asText());

        }


System.out.println("Add Player");
    }
}