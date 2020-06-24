package commands;
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
    // execute command based on its name, return session after execution
    switch(this.name){
      case "exit":
        System.out.println("Command exit detected.");
        s = exit.exit(s);
        return s;
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
      case "mkdir":
        System.out.println("Command mkdir detected");
        // execute command
        s = mkdir.mkdir(parameter, s);
        return s;
    }
    return s;
  }

}
