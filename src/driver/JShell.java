package driver;// **********************************************************
// Assignment2:
// Student1:
// UTORID user_name:
// UT Student #:
// Author:
//
// Student2: Jitong Zhang
// UTORID user_name: zhangjit
// UT Student #: 1004700905
// Author: Jitong Zhang
//
// Student3:
// UTORID user_name:
// UT Student #:
// Author:
//
// Student4:
// UTORID user_name:
// UT Student #:
// Author:
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************

import commands.*;
import java.io.IOException;
import java.util.*;
import others.*;


public class JShell {

  public static void main(String[] args){
    // init current Session
    Session s = new Session(new Directory(System.getProperty("user.dir")));
    do {
      // prompt, get input
      String input;
      Scanner sc = new Scanner(System.in);
      System.out.print("$"+s.getWorkingDir().getDirectory()+">");
      input = sc.nextLine();
      System.out.println("Scanned: " + input);
      if (input.equals("exit")) {
        break;
      }

      // parse the input into command, parameter(s)
      String[] parsed = input.split(" ", 2);

      // create a new command using parsed input
      Command cmd;
      if(parsed.length == 2) {
        cmd = new Command(parsed[0], parsed[1], s);
      }
      else{
        cmd = new Command(parsed[0], s);
      }
      // validate the command
          // validate command name
          // validate command parameters
      // execute the command
      s = cmd.executeCommand();

      if(s.getStatus()==0){
        System.out.println("Command not found, Or Error found in parameters.");
      }
    } while(true);

  }

}
