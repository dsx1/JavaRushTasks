package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    public static void main(String[] args) throws IOException {
        int portNumber = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Serves is active...");
            while (true){
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
                continue;
            }
        } catch (IOException e) {
            serverSocket.close();
            e.getMessage();
        }
    }

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String,Connection> pair : connectionMap.entrySet()){
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Не получилось отправить сообщение...");
            }
        }
    }

    private static class Handler extends Thread{
        private Socket socket;
        public Handler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {

            if (socket != null && socket.getRemoteSocketAddress() != null) {
                ConsoleHelper.writeMessage("Established a new connection to a remote socket address: " + socket.getRemoteSocketAddress());
            }
            String userName = null;

            try (Connection connection = new Connection(socket)) {

                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An exchange of data error to a remote socket address");
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
                ConsoleHelper.writeMessage("Closed connection to a remote socket address: "); // + socketAddress);
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                if (answer.getType() == MessageType.USER_NAME) {
                    if (!answer.getData().isEmpty()) {
                        if (!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String,Connection> pair : connectionMap.entrySet()){
                if (!(pair.getKey().equals(userName))){
                    connection.send(new Message(MessageType.USER_ADDED,pair.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message != null && message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }
            }
        }
    }
}
