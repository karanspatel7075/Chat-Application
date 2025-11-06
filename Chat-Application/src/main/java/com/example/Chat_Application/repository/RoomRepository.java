package com.example.Chat_Application.repository;

import com.example.Chat_Application.entites.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {

    // get the room using roomId
    Room findByRoomId(String roomId);
}
