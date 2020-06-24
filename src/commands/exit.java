package commands;

import others.Session;

public class exit {
  public static Session exit(Session s){
    s.setStatus(-1);
    return s;
  }
}
