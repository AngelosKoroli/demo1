package com.example.demo1;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Player {
    @JsonProperty("id")
    int id;

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("height_feet")
    int heightFeet;

    @JsonProperty("height_inches")
    int heightInches;

    @JsonProperty("last_name")
    String lastName;

    @JsonProperty("Position")
    String Position;


    public Player() {

    }

    public Player(int id, String firstName, int heightFeet,int heightInches, String lastName, String Position) {
        this.id = id;
        this.firstName = firstName;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.lastName = lastName;
        this.Position = Position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getHeightFeet() {
        return heightFeet;
    }

    public void setHeightFeet(int heightFeet) {
        this.heightFeet = heightFeet;
    }
    public int getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(int heightInches) {
        this.heightInches = heightInches;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }
    /*
    {
        "data": [
        {
            "id": 237,
                "first_name": "LeBron",
                "height_feet": 6,
                "height_inches": 8,
                "last_name": "James",
                "position": "F",
                "team": {
            "id": 14,
                    "abbreviation": "LAL",
                    "city": "Los Angeles",
                    "conference": "West",
                    "division": "Pacific",
                    "full_name": "Los Angeles Lakers",
                    "name": "Lakers"
        },
            "weight_pounds": 250
        }
  ],
        "meta": {
        "current_page": 1,
                "next_page": null,
                "per_page": 25
    }

     */
}
