package com.chris.entities;

import java.util.ArrayList;

public class RoomList {
    ArrayList<Room> roomCollection = new ArrayList<Room>();
    private double score;

    public RoomList() {

    }

    RoomList(RoomList old) {
        this.roomCollection = old.getRoomCollection();
        this.score = old.getScore();
    }

    public ArrayList<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(ArrayList<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
