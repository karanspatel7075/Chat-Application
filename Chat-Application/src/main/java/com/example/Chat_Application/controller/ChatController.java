package com.example.Chat_Application.controller;

import com.example.Chat_Application.entites.Message;
import com.example.Chat_Application.entites.MessageRequest;
import com.example.Chat_Application.entites.Room;
import com.example.Chat_Application.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller
@CrossOrigin("http://localhost:3000")
public class ChatController {

    @Autowired
    private RoomRepository repository;

    // for sending and receiving message
    @MessageMapping("/sendMessage/{roomId}") // message ayega = /app/sendMessage/roomId
    @SendTo("/topic/room/{roomId}")  // message publish hoga = subscribe
    public Message sendMessage(@DestinationVariable String roomId, @RequestBody MessageRequest request) throws Exception {
        Room room = repository.findByRoomId(request.getRoomId());

        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());

        if(room!=null) {
            room.getMessages().add(message);
            repository.save(room);
        } else {
            throw new RuntimeException();
        }

        return message;
    }
}
