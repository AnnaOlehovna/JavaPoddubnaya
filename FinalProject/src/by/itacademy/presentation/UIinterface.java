package by.itacademy.presentation;

import by.itacademy.manager.Manager;

public interface UIinterface {

    Manager manager = Manager.getInstance();

    void startUI();

    /**
     * Input and output for MENU
     */
    void Menu();
    /**
     * Input and output for WEATHER OUTPUT
     */
    void outputWeatherUI();
    /**
     * Input and output for SEARCH
     */
    void searchUI();
    /**
     * Input and output for SORT
     */
    void sortUI();

    void goodByeMessage();

    /**
     * Ask user to print name of City for Searching by city
     * @return String with name of the city
     */
     String askForCity();

    /**
     * Ask user to print MIN temperature for Searching
     * by temperature range
     */
    int askForTempMin();

    /**
     * Ask user to print MAX temperature for Searching
     * by temperature range
     */
     int askForTempMax();

    /**
     * Ask user to print date to show information on this date
     * @return String with date
     */
    String askForData();

    void askForRepeat();


    void printMessages(String text);
}
