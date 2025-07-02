public class Incrementer implements Commands{


    LoaderFile loaderFile = new LoaderFile();

    public void useCommand(String command){

        switch (command) {
            case Commands.INCREMENT -> increment();
            case Commands.RESET -> reset();
            case Commands.STOP -> stop();
            default -> System.out.println("Читай ТЗ!");
        };
    }
    public void increment(){
        int inc = loaderFile.getCounter()+1;
        loaderFile.write(inc);
        System.out.println("Инкрементация выполнена! Состояние счетчика: '"+loaderFile.getCounter()+"'!");
    }
    public void reset(){
        loaderFile.write(0);
        System.out.println("Счетчик файла обнулен! Текущее состояние '" + loaderFile.getCounter() +"'");

    };
    public void stop(){
        System.out.print("Текущее состояние счетчика: '" + loaderFile.getCounter() +"'! " );
        System.out.println("Завершаю работу");
    };
}
