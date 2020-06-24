package others;
import java.io.File;
import java.nio.file.*;


public class Directory {
  Path path;
  Path parent;
  File dir; //file representation of this directory

  public Directory(String dir){
    this.path = Paths.get(dir).normalize();
    this.parent = this.path.getParent();
    this.dir = this.path.toFile();
  }

  public Directory add(Directory dir){
    // add target path to this.path
    Path oldPath = this.getPath();
    Path newPath = Paths.get(oldPath.toString(), dir.toString());
    Directory result = new Directory(newPath.toString());
    return result;
  }

  public Path getPath(){
    return this.path;
  }

  public boolean exists(){
    return this.dir.exists();
  }

  public File toFile(){
    return this.dir;
  }

  @Override
  public String toString() {
    return this.dir.getPath();
  }

  // Not sure if i should let dir class handle getting all of the subdirectories into a string
  // I might end up changing it so directory gives an array, and ls class turns it into string
  // - Meng He
  public String getAllSubDirectories() {
    // TODO Auto-generated method stub
    return null;
  }

}
