package airbnb.server.network;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import airbnb.server.persistence.request.*;
import airbnb.server.util.Logger;

public class ClientController implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Logger logger;

    public ClientController(Socket clientSocket, Logger logger)
    {
        this.clientSocket = clientSocket;
        try
        {
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        this.logger = logger;

        logger.log("[CLIENT] " + clientSocket.getInetAddress().getHostName() + " - CONNECTED");
    }

    public void run()
    {
        // test();
        start();
    }

    public void start()
    {
        Request packet = null;
        Object sendPacket = null;

        try
        {
            while(true)
            {
                packet = (Request) ois.readObject();
                logger.log("[CLIENT] " + clientSocket.getInetAddress().getHostName() + " - REQUESTS " + packet.getType().getName());

                switch(packet.getType().type())
                {
                    case 1 :
                        sendPacket = RequestHandler.convenienceControl(packet);

                        break;
                    case 2 :
                        sendPacket = RequestHandler.discountControl(packet);

                        break;
                    case 3 :
                        sendPacket = RequestHandler.houseControl(packet);

                        break;
                    case 4 :
                        sendPacket = RequestHandler.paymentControl(packet);

                        break;
                    case 5 :
                        sendPacket = RequestHandler.reservationControl(packet);

                        break;
                    case 6 :
                        sendPacket = RequestHandler.reviewControl(packet);

                        break;
                    case 7 :
                        sendPacket = RequestHandler.userControl(packet);

                        break;
                    default :
                        sendPacket = null;
                        
                        break;
                }

                oos.writeObject(sendPacket);
                oos.flush();
            }
        }
        catch (EOFException e)
        {
            close();
        }
        catch (Exception e)
        {
            logger.log("[CLIENT] " + clientSocket.getInetAddress().getHostName() + " - NETWORK ERROR");
            close();
        }
    }

    public void close()
    {
        try
        {
            logger.log("[CLIENT] " + clientSocket.getInetAddress().getHostName() + " - DISCONNECTED");

            ois.close();
            oos.close();
            clientSocket.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void test()
    {
        try
        {
            while(true)
            {
                String testString = (String) ois.readObject();
                logger.logConsole(testString);
            }
        }
        catch(EOFException e)
        {
            close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
