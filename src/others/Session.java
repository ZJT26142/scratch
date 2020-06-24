package others;

public class Session {
  Directory workingDir;
  int status=0;
  public Session(Directory dir){
    workingDir = dir;
  }
  public Directory getWorkingDir(){
    return this.workingDir;
  }
  public void updateWorkingDir(Directory dir){
    this.workingDir = dir;
  }
  public void setStatus(int status){
    this.status = status;
  }
  public int getStatus(){
    return this.status;
  }
}
