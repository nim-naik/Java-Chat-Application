## 💬 Client-Server Chat Application (Java Socket Programming)

### 📌 Overview

This is a Java-based client-server chat application using socket programming. The system allows real-time message exchange between a server and multiple clients via TCP/IP. The UI can be enhanced with icons located in the `icons` folder, or you can use your own.

### 🔧 Features

* Basic one-to-one chat system using sockets
* Real-time communication over localhost or LAN
* Separate Client and Server programs
* Console-based or GUI-supported with optional icons
* Lightweight and easy to run

### 🚀 How to Run

#### Compile Both Files

cmd command
javac Server.java Client.java

#### Run the Server First

cmd command
java Server

#### Run the Client (in another terminal or system)

cmd command
java Client

Ensure that the server is running before starting the client.
Both must be on the same network or machine (for `localhost`).

### 💻 Class Descriptions

* **Server.java**

  * Waits for incoming client connections.
  * Listens to messages from clients and responds.
  * Can be extended for multi-client handling with threads.

* **Client.java**

  * Connects to the server and enables user input.
  * Sends and receives messages to/from the server.

### 🖼️ Icons

* Icons used in the GUI are located in the `icons` folder.
* You may replace or add your own icons by placing image files (e.g., `.png`, `.jpg`) in the `icons/` directory and updating their references in the code.

### 🛠 Requirements

* Java JDK 8 or higher
* Terminal or any Java IDE
* Optional: Internet or LAN setup for multi-system communication
