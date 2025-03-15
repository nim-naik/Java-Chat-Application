# 🚀 Java Chat Application

## Overview

A lightweight yet powerful **real-time chat application** built with Java! 💬✨ Inspired by WhatsApp, this project lets users exchange messages instantly over a multi-threaded server. Built using **Java Swing, AWT, and Socket programming**, it features a user-friendly interface and smooth communication. While it lacks media sharing and encryption (for now 😉), future updates will bring authentication, security, and enhanced UI.

## Features

- Private chat between two users
- Real-time message transmission
- User-friendly graphical interface
- Simple and lightweight design

## Similarities to WhatsApp

- Real-time chat using sockets
- Private messaging between users
- GUI-based chat interface

## Differences from WhatsApp

- No media sharing (only text messages are supported)
- No end-to-end encryption (messages are sent in plain text)
- No cloud sync (messages are not stored for retrieval after session ends)
- No user authentication (users connect without login verification)

## Technologies Used

- Java Swing (for GUI components)
- Java AWT (for additional UI enhancements)
- Java Socket Programming (for client-server communication)

## Project Structure

```
ChatApplication/
│-- src/
│   │-- Client.java
│   │-- Server.java
│-- README.md
│-- LICENSE
```

## Installation & Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/chat-application-java.git
   ```
2. Open the project in an IDE (IntelliJ IDEA, Eclipse, NetBeans, etc.).
3. Compile and run the `Server.java` file first.
4. Run multiple instances of `Client.java` to start chatting.

## How It Works

- The `Server` class listens for client connections and manages communication.
- The `Client` class establishes a connection with the server and enables chat functionality.
- Messages are sent over sockets and displayed in the chat window.

## Future Enhancements

- Implementing encryption for secure messaging
- Adding user authentication
- Enhancing UI with modern design elements
- Supporting media file sharing (images, audio, and video messages)
- Adding a chat history feature with cloud backup

