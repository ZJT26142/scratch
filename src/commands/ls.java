package commands;

import java.io.IOException;
import others.Directory;
import others.Session;
import java.io.File;

public class ls extends Command {
  public static Session listContent(String parameter, Session s){
    Directory workingDir = s.getWorkingDir();
    Directory targetDir = new Directory(parameter);
    String[] result;
    if (parameter.equals("")||parameter.equals(".")) {
      result = new File(workingDir.getDirectory()).list();

    }
    else if (parameter.equals("..")){
      result = new File(new File(workingDir.getDirectory()).getParent()).list();
    }
    else if (!targetDir.getDirectory().equals("")){
      result = new File(targetDir.getDirectory()).list();
    }
    else{ // error
      s.setStatus(0);
      return s;
    }
    for (int i=0;i<result.length;i++){
      System.out.print(" "+ result[i]);
    }
    System.out.println();
    s.setStatus(1);
    return s;
  }
}
