package airbnb.server.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger
{
	private String logPath = "log/" + LocalDate.now() + ".txt";
	private FileWriter logger = null;
	private BufferedWriter bw;
	
	public Logger(BufferedWriter bw)
	{
		this.bw = bw;

		if(logger == null)
		{
			try
			{
				File logDir = new File("log");
				if(!logDir.exists())
					logDir.mkdirs();

				File logFile = new File(logPath);

				if(!logFile.exists())
				{
					logger = new FileWriter(logFile, true);
					logger.append(LocalDate.now() + " SERVER LOG\n");
					logger.append("------------------------------\n");
					logger.flush();
				}
				else
				{
					logger = new FileWriter(logFile, true);
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void logFile(String msg)
	{
		try
		{
			logger.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " " + msg + "\n");
			logger.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public synchronized void logConsole(String msg)
	{
		try
		{
			bw.write(msg);
			bw.write("\n");
			bw.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public synchronized void log(String msg)
	{
		logFile(msg);
		logConsole(msg);
	}

	public void close()
	{
		try
		{
			logger.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
