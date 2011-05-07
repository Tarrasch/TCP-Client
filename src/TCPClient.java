
import java.io.*;
import java.net.*;

class TCPClient {

    public static final String GET_REQUEST = "GET / HTTP/1.0\n\n";

    public static void main(String argv[]) throws Exception {
        String sentence;  /* sentence typed in by the user       */
        String modifiedSentence; /* user's sentence after being  */
        /* modified by the server       */

        BufferedReader inFromUser =
                new BufferedReader(
                new InputStreamReader(System.in));

        String hostName = inFromUser.readLine();
        int port = Integer.parseInt(inFromUser.readLine());

        Socket clientSocket = new Socket(hostName, port);

        DataOutputStream outToServer =
                new DataOutputStream(
                clientSocket.getOutputStream());
        BufferedReader inFromServer =
                new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));

        /* Send the user's inputted line to the server */
        outToServer.writeBytes(GET_REQUEST);

        /* Get the sentence back from the server after being modified */
        Thread.sleep(300);
        String s = "";
        while (inFromServer.ready()) {
            s += inFromServer.readLine() + "\n";
        }

        if (s.contains("200 OK")) {
            /* Output the modified sentence */
            System.out.println("FROM TCP SERVER: "
                    + s.length() + " characters long reply.");

        } else {
            System.out.println("Bad! Got " + s.split("\n")[0]);
        }
        /* close the TCP socket */
        clientSocket.close();
    }
}
