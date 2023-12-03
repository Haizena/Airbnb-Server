package airbnb.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import airbnb.server.network.Server;
import airbnb.server.util.Logger;

public class Main
{
    private static final String VERSION = "1.0";
    private static final int DEFAULT_PORT_NO = 8888;
    private static final int MAX_MENU = 3;
    
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static Logger logger;
    private static int portNo;

    public static void start()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        logger = new Logger(bw);

        try
        {
            FileInputStream fis = new FileInputStream("netconfig");
            ObjectInputStream ois = new ObjectInputStream(fis);

            portNo = (int) ois.readObject();

            ois.close();
            fis.close();
        }
        catch(Exception e)
        {
            portNo = DEFAULT_PORT_NO;
        }

        try
        {
            bw.write("kit 2023 Second Semester Fusion Project - Airbnb-Server v" + VERSION + "\n");
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            int flag = 0;
            while (interfaces.hasMoreElements() && flag == 0) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback())
                    continue;
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (!addr.getHostAddress().contains(":"))
                    {
                        bw.write("[Server IP = " + addr.getHostAddress() + ":" + portNo + "]\n");
                        flag = 1;
                        break;
                    }
                }
            }

            int selection = 0;
            while(selection != MAX_MENU)
            {
                showMenu();
                selection = getSelection();
                handleMenu(selection);
            }

            bw.write("-------------------------------------------------------------\n");
            bw.write("Airbnb-Server Exit\n");

            bw.close();
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void showMenu()
    {
        try
        {
            bw.write("-------------------------------------------------------------\n");
            bw.write("1. Start Server\n");
            bw.write("2. Configurate Network\n");
            bw.write("3. Exit\n");
            bw.flush();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static int getSelection()
    {
        try
        {
            bw.write(">> ");
            bw.flush();
            
            int selection = Integer.parseInt(br.readLine());
            
            if(selection >= 1 && selection <= MAX_MENU)
                return selection;
            else
                throw new NumberFormatException();
        }
        catch(NumberFormatException e)
        {
            try
            {
                bw.write("Please Input 1.." + MAX_MENU + "\n");
                bw.flush();

                return getSelection();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return 0;
    }

    public static void handleMenu(int selection)
    {
        switch(selection)
        {
            case 1 :
                Server server = new Server(logger, portNo);
                server.start();

                break;
            case 2 :
                try
                {
                    bw.write("-------------------------------------------------------------\n");
                    bw.write("[Port# = " + portNo + "]\n");
                    bw.write("Input Port Number >> ");
                    bw.flush();

                    try
                    {
                        portNo = Integer.parseInt(br.readLine());
                        
                        bw.write("Port Number Set\n");
                        bw.flush();
                    }
                    catch(NumberFormatException e)
                    {
                        bw.write("Wrong Port Number\n");
                        bw.flush();
                    }
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }

                try
                {
                    FileOutputStream fos = new FileOutputStream("netconfig");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(portNo);
                    oos.flush();

                    oos.close();
                    fos.close();
                }
                catch(Exception e)
                {}

                break;
            default :
                break;
        }
    }
}
