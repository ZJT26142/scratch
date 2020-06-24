package commands;


import others.Directory;
import others.Session;
import java.io.File;

public class ls extends Command {
  public static Session listContent(String parameter, Session s){
    Directory workingDir = s.getWorkingDir();
    Directory targetDir = new Directory(parameter);
    String[] result;
    // if targetDir is absolute, exists
    if (targetDir.getPath().isAbsolute() && targetDir.exists()){
      result = targetDir.toFile().list();
    }
    // else add target with working
    else if (workingDir.add(targetDir).exists()){
      result = workingDir.add(targetDir).toFile().list();
    }
    // error
    else{
      s.setStatus(0);
      return s;
    }
    // print result
    for (int i=0;i<result.length;i++){
      if(i%4 == 0 && i!=0){
        System.out.println();
      }
      System.out.print(" "+ result[i]);
    }
    System.out.println();
    s.setStatus(1);
    return s;
  }
}
