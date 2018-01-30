package by.itacademy.manager;


public class EventManager {

   private Listener listener = Manager.getInstance();

    protected void sendMessage(String message){
        listener.getMessage(message);
    }
}
