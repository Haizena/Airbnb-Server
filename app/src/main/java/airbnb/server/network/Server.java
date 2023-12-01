package airbnb.server.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import airbnb.server.util.Logger;

public class Server {
    private Logger logger;
    private int portNo;
    private int connectedClients = 0;

    public Server(Logger logger, int portNo)
    {
        this.logger = logger;
        this.portNo = portNo;
    }

    public void start()
    {
        logger.logConsole("-------------------------------------------------------------");

        ServerSocket serverSocket;
        Socket clientSocket;
        ClientController clientController;
        Thread clientThread;

        try
        {
            serverSocket = new ServerSocket(portNo);
            logger.log("[SERVER] " + InetAddress.getLocalHost().getHostAddress() + ":" + serverSocket.getLocalPort() + " - STARTED");

            while(true)
            {
                if(connectedClients == 0)
                    logger.logConsole("Waiting...");

                clientSocket = serverSocket.accept();
                connectedClients++;

                clientController = new ClientController(clientSocket, logger);
                clientThread = new Thread(clientController);

                clientThread.start();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
