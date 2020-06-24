package commands;

import java.io.File;
import java.nio.file.Path;
import others.Directory;
import others.Session;

public class cd extends Command{
  public static Session changeDirectory(String parameter, Session s){
    // validate and update dir
    Directory oldDir;
    Directory newDir;
    oldDir = s.getWorkingDir();
    newDir = new Directory(parameter);

    if(parameter.equals(".")){
      s.setStatus(1);
    }
    else if(parameter.equals("..")){
      // update workingDir to parent dir
      File current = new File(s.getWorkingDir().getDirectory());
      s.updateWorkingDir(new Directory(current.getParent()));
      s.setStatus(1);
    }


    if(!newDir.getDirectory().equals("")) {
      s.updateWorkingDir(newDir);
      s.setStatus(1);
    }
    else{
      s.setStatus(0);
    }
    return s;
  }
}
