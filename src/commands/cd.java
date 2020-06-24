package commands;

import others.Directory;
import others.Session;

public class cd extends Command{
  public static Session changeDirectory(String parameter, Session s){
    // need validate normalize parameter
    Directory workingDir = s.getWorkingDir();
    //temp validate
    if (parameter.equals("")) return s;
    Directory targetDir = new Directory(parameter);

    if (!targetDir.isAbsolute()){
      targetDir = workingDir.add(targetDir);
    }
    if(targetDir.toFile().isDirectory()){
      s.updateWorkingDir(targetDir);
      s.setStatus(1);
    }
    return s;
  }
}
