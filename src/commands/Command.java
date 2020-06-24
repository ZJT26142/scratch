package commands;
import java.io.IOException;
import others.*;

public class Command {
  String name;
  String parameter = "";
  Session s;
  public Command (String name, String parameter, Session s){
    this.name = name;
    this.parameter = parameter;
    this.s = s;
  }
  public Command (String name, Session s){
    this.name = name;
    this.s = s;
  }
  public Command (){

  }
  public Session executeCommand(){
    // execute command based on its name, return 0 if command name is invalid, return 1 if command exists
    switch(this.name){
      case "cd":
        System.out.println("command cd detected.");
        // execute command
        s = cd.changeDirectory(parameter, s);
        return s;
      case "ls":
        System.out.println("command ls detected.");
        // execute command
        s = ls.listContent(parameter, s);
        return s;

    }
    return s;
  }

}
