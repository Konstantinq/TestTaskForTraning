import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoaderFile {
    String pathStr ="./increment.txt";
    private LoaderFile instance;
    private File f;
    private Path path;
    private int counter;
    LoaderFile(){
        f = new File(pathStr);
        path = Paths.get(pathStr);
        if(f.exists() && !f.isDirectory()) {
            read();
        }else {

            System.out.println("Создание файла increment.txt в относительной директории: "+ System.getProperty("user.dir"));
            f = new File(pathStr);
            write(0);
            System.out.println("Текущее состояние счетчика '"+counter+"'");

        }

    };

    public LoaderFile getInstance(){
        if (instance == null) instance = new LoaderFile();
        return instance;
    }

    public int getCounter(){
        return counter;
    }

    public void write(int i){

        try {
            String str = ""+i;
            counter = Integer.parseInt(str);
            byte[] bs = str.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            //System.out.println("Счетчик загружен, значение '"+Files.readAllBytes(writtenFilePath).toString()+"'");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void read(){
        try {
            System.out.println(Files.readString(Path.of(pathStr)));
            counter = Integer.parseInt(Files.readString(Path.of(pathStr)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
