package task3;

public class ParsingThread extends Thread {

    private DownloadThread downloadThread;

    public void setDownloadThread(DownloadThread downloadThread) {
        this.downloadThread = downloadThread;
    }

    //методы wait() и notify() находят в Object, а не в Thread

    @Override
    public void run() {
        System.out.println("threadParsing start");

        //засыпаем и ждем пока нас разбудит downloadThread
        try {
            wait();
        } catch (InterruptedException e) {}

        //нас разбудили

        System.out.println("json parsing");
        //parsing
        //будим downloadThread - надо будет сделать синхронизацию
        downloadThread.notify();

        //засыпаем и ждем пока нас разбудит downloadThread
        System.out.println("wait for xml");
        try {
            wait();
        } catch (InterruptedException e) {}

        System.out.println("xml parsing");
        //parsing

        System.out.println("threadParsing end");


    }
}
