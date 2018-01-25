package by.itacademy.Manager;


public class EventManager {

   private Listener listener = Manager.getInstance();

    protected void sendMessage(String message){
        listener.getMessage(message);
    }
}
