package commands;

import java.io.File;
import java.nio.file.Path;
import others.Directory;
import others.Session;

public class cd extends Command{
  public static Session changeDirectory(String parameter, Session s){
    // need validate normalize parameter
    Directory workingDir = s.getWorkingDir();
    Directory targetDir = new Directory(parameter);
    // absolute dir
    if (targetDir.getPath().isAbsolute()){
      s.updateWorkingDir(targetDir);
    }
    // none absolute, concatenate with workingDir
    else{
      s.updateWorkingDir(workingDir.add(targetDir));
    }
    s.setStatus(1);

    return s;
  }
}
