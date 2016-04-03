package net.toregard.fault;

public class BusinessFault extends Exception{
    private int id;


   public BusinessFault(int id, String message) {
      super(message);
       this.id=id;
    }

    public int getId() {
        return id;
    }
}
