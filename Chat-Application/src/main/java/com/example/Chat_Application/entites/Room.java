package com.example.Chat_Application.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "rooms")
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    private String id; // mongo db unique identifier
    private String roomId;

    private List<Message> messages = new ArrayList<>();
}
