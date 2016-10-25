package server;

import java.io.OutputStream;
import java.util.Date;

public class GreetingServlet {
	public void execute(OutputStream out) throws Exception{
		String htmlData = "<h1> Hello Web, "+ new Date(System.currentTimeMillis())  +" </h1><hr>";
		out.write(htmlData.getBytes());
		out.flush();
	}
}
