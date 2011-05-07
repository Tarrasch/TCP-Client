/***********************************************************/
/* TCPClient.java                                          */
/*                                                         */
/* comments added Amer 10/2007, 9/2009                     */
/* A better name would be MakeUpperCaseClientUsingTCP      */
/*                                                         */
/*  STUDENT NAME goes here                                 */
/*  COURSE NAME and SEMESTER goes here                     */
/*  DATE goes here                                         */
/*  This module will <blah, blah, blah> [STUDENT FILL IN]  */
/*    A DESCRIPTION OF WHAT THIS MODULE DOES]              */
/***********************************************************/


import java.io.*;
import java.net.*;

class TCPClient
   {
   /* Avoid magic number used in Kurose-Ross example  Amer 10/2007 */
   /* [STUDENTS - you should randomize your port number]           */
   public static final int TCP_SERVER_PORT = 6789;

   public static void main(String argv[]) throws Exception
      {
      String sentence;  /* sentence typed in by the user       */
      String modifiedSentence; /* user's sentence after being  */
                               /* modified by the server       */

      BufferedReader inFromUser =
         new BufferedReader(
           new InputStreamReader(System.in));

      /* Create socket for TCP connection                       */
      /* [STUDENTS - replace hostname with your machine's name] */
      Socket clientSocket = new Socket("hostname", TCP_SERVER_PORT);

      DataOutputStream outToServer =
         new DataOutputStream(
           clientSocket.getOutputStream());
      BufferedReader inFromServer =
         new BufferedReader(new InputStreamReader(
           clientSocket.getInputStream()));

      /* Input a line interactively from a user */
      sentence = inFromUser.readLine();

      /* Send the user's inputted line to the server */
      outToServer.writeBytes(sentence + '\n');

      /* Get the sentence back from the server after being modified */
      modifiedSentence = inFromServer.readLine();

      /* Output the modified sentence */
      System.out.println("FROM TCP SERVER: " +
         modifiedSentence);

      /* close the TCP socket */
      clientSocket.close();
      }
   }
