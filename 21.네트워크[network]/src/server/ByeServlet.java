package server;

import java.io.OutputStream;
import java.util.Date;

public class ByeServlet {
	public void execute(OutputStream out) throws Exception{
		String htmlData = "<h1> Bye Web, "+ new Date(System.currentTimeMillis())  +" </h1><hr>";
		out.write(htmlData.getBytes());
		out.flush();
	}
}
