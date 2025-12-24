# Chat Application

<img width="1600" height="1067" alt="image" src="https://github.com/user-attachments/assets/f811d795-14fc-4fe9-8214-c61ac42a08d7" />

A **real-time chat application** built with **Java, Spring Boot, WebSocket, and Redis**, enabling users to create or join chat rooms and exchange messages in real-time.

---

## 🔹 Features

- Create and join chat rooms dynamically.
- Real-time messaging using **WebSocket (STOMP)**.
- Messages are persisted for each room.
- Pagination support for messages in each room.
- Frontend interface with live chat updates.
- Cross-origin support for local frontend (React/HTML/JS) integration.

---

## 💻 Tech Stack

| Layer | Technology |
|-------|------------|
| Frontend | HTML, CSS, JavaScript |
| Backend | Java 17, Spring Boot |
| Real-Time Messaging | WebSocket (STOMP) |
| Persistence | MongoDB (Messages), Room Repository |
| Authentication & Security | Spring Security (optional / role-based) |
| Messaging Cache | Redis (Pub/Sub, GEO – optional) |
| Build & Dependency | Maven |
| API Endpoints | REST API for Room Management |
| Deployment | Localhost (for development) |

---

## 🔹 API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/v1/rooms` | POST | Create a new room |
| `/api/v1/rooms/{roomId}` | GET | Join a room by ID |
| `/api/v1/rooms/{roomId}/messages` | GET | Get paginated messages for a room |
| `/app/sendMessage/{roomId}` | WebSocket | Send message to a room (broadcast) |
| `/topic/room/{roomId}` | WebSocket | Subscribe to messages from a room |

---

## 🔹 Project Structure

- **WebSocketConfig.java** → Configures WebSocket endpoints and message broker.
- **ChatController.java** → Handles real-time message sending and broadcasting to subscribed clients.
- **RoomController.java** → REST endpoints to create, join rooms and fetch paginated messages.
- **Frontend JS** → Handles room creation, joining, sending messages, and updating chat UI dynamically.

---

## 🔹 How to Run

### Backend
1. Clone the repository:
```bash
git clone <repo-url>
```

## How to run project
Frontend

- Open the frontend HTML/JS in a browser.
- Enter Room ID and Username to join or create a chat room.
- Start sending messages in real-time.

---

## 🧠 Learning Outcomes

| Skill | Description |
|-------|-------------|
| Real-Time Communication | Implemented using WebSocket and STOMP. |
| REST APIs | Built endpoints for room management and message retrieval. |
| Persistence & Pagination | Stored chat messages with pagination support. |
| Frontend-Backend Integration | Connected JS frontend to Spring Boot backend for live updates. |
| Spring Boot Practices | Learned project structure, dependency management, and configurations. |

---

## 🔹 Future Enhancements

| Feature | Description |
|---------|-------------|
| User Authentication | Add login/signup and role-based access. |
| Online/Offline Status | Show users' online presence in chat rooms. |
| File/Media Sharing | Enable sending images, files, or videos. |
| Private Messaging | Support one-on-one chat along with group chat. |
| Cloud Deployment | Deploy on cloud platforms for real-time access globally. |
