package others;
import java.io.File;
import java.io.IOException;

public class Directory {
  String dir;
  File file;

  public Directory(String dir){
    if(new File(dir).isDirectory()) {
      this.dir = new File(dir).getAbsolutePath();
    }
    // invalid dir
    else{
      this.dir="";
      System.out.println("failed to recognize directory:"+dir);
    }
    if(new File(dir).isFile()){
      this.file = new File(dir);
    }
  }

  public String getDirectory(){
    try {
      return new File(dir).getCanonicalPath();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return this.dir;
  }
  // Not sure if i should let dir class handle getting all of the subdirectories into a string
  // I might end up changing it so directory gives an array, and ls class turns it into string
  // - Meng He
  public String getAllSubDirectories() {
    // TODO Auto-generated method stub
    return null;
  }

}
