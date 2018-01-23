package by.itacademy.Manager;

import by.itacademy.Manager.Listener;
import by.itacademy.Manager.Manager;

public class EventManager {
   Listener listener = Manager.getInstance();

    public void sendMessage(String problem){
        listener.getProblem(problem);
    }
}
