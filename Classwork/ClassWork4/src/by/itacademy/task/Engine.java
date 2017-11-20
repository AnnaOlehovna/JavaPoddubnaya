package by.itacademy.task;

/**
 * Created by user on 20.11.2017.
 */
public class Engine {


    // переменная gas может принимать только значения из enum
    public enum GAS_TYPE{
        GAS_98, GAS_95

}

    private  double volume;
    private String type;
    private GAS_TYPE gas;// if(engine.getGas()==GAS_TYPE.GAS_95){} - так можно сравнивать
}
