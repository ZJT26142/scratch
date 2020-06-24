package commands;

import others.Directory;
import others.Session;


public class mkdir extends Command {

  public static Session mkdir(String parameter, Session s) {
    //temp validate empty parameter
    if (parameter.equals("")) return s;
    Directory target = new Directory(parameter);
    // absolute path or relative path , isDirectory()
      // abs
      // rel , add to workingDir
    if(!target.isAbsolute()){
      target = s.getWorkingDir().add(target);
    }
    // no such directory exists , create a new dir
    if(target.toFile().isDirectory()){
      System.out.println("Directory already exists.");
      return s;
    }
    else if (target.toFile().mkdirs()) s.setStatus(1);
    return s;
  }
}
