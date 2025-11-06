package com.example.Chat_Application.controller;

import com.example.Chat_Application.entites.Message;
import com.example.Chat_Application.entites.Room;
import com.example.Chat_Application.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:3000")
public class RoomController {

    private final RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }

    // create Room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId) {
        if(repository.findByRoomId(roomId) != null) {
            return ResponseEntity.badRequest().body("Room already exists!");
        }

        Room room = new Room();
        room.setRoomId(roomId);
        Room savedRoom = repository.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }

    // get Room
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId) {
        Room availableRoom = repository.findByRoomId(roomId);

        if(availableRoom == null) {
            return ResponseEntity.badRequest().body("Room not Found!!");
        }

        return ResponseEntity.ok(availableRoom);
    }

    // get Messages of Room
    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessage(@PathVariable String roomId,
                                                    @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                    @RequestParam(value = "size", defaultValue = "30", required = false) int size)  {
        Room getRoom = repository.findByRoomId(roomId);
        if(getRoom == null) {
            return ResponseEntity.badRequest().build();
        }

        // get Message , pagination
        List<Message> messages = getRoom.getMessages();

        int start = Math.max(0, messages.size()- (page + 1) * size);
        int end = Math.min(messages.size(), start+size);

        List<Message> paginatedMsg = messages.subList(start, end);

        return ResponseEntity.ok(paginatedMsg);
    }



}
