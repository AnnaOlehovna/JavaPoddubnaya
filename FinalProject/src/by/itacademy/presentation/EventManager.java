package by.itacademy.presentation;

import by.itacademy.Listener;
import by.itacademy.Manager;

public class EventManager {
   Listener listener = Manager.getInstance();

    public void sendMessage(String problem){
        listener.getProblem(problem);
    }
}
