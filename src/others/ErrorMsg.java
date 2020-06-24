package others;


public enum ErrorMsg {
  // Add more error types after the comma
  INVALID_COMMAND("Error: Not able to execute command: %s%n"),
  FILE_NOT_EXIST("Error: File not found: %s%n"),
  DIRECTORY_NOT_EXIST("Error: Directory not found: %s%n"),
  ;
  
  private String errorString;
  private ErrorMsg(String errorString) {
    this.errorString = errorString;
  }
  
  /**
   * Print the error message
   * @param error the error type
   * @param args details about the error
   * Usage:
   * ErrorMsg.print(ErrorMsg.FILE_NOT_EXIST, "testfile.txt");
   */
  public static void print(ErrorMsg error, String args) {
    System.err.printf(error.errorString, args);
  }
}
