package net.media.training.live.dip;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 13, 2011
 * Time: 10:05:38 AM
 * To change this template use File | Settings | File Templates.
 */


// create two different classes one for files and for database
// create an interface with read, write, encoding functions
// hardcoding of file paths
// can create interface for read and write also (ans)


/**
 * InnerEncodingModule
 */
interface Reader {
    public void get_data();
}

interface Writer {
    public void write_data();
}

class encodeWithFiles implements Reader, Writer{
    BufferedReader reader;
    BufferedWriter writer;
    public void get_data(){
        reader = new BufferedReader(new FileReader("src/main/java/net/media/training/live/dip/beforeEncryption.txt"));
    }

    public void write_data(){
        writer = new BufferedWriter(new FileWriter("src/main/java/net/media/training/live/dip/afterEncryption.txt"));
    }

    public void encode(){
        try{
            this.get_data();
            this.write_data();
            String aLine;
            while ((aLine = reader.readLine()) != null) {
                String encodedLine = Base64.getEncoder().encodeToString(aLine.getBytes());
                writer.write(encodedLine);
            }
            writer.flush();
            writer.close();
            reader.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class encodeBasedOnNetworkAndDatabase implements Reader, Writer{
    InputStream in = null;
    InputStreamReader reader = new InputStreamReader(in);
    StringBuilder inputString1 = new StringBuilder();
    URL url = null;
    String inputString;
    String encodedString;
    MyDatabase database;
    public void get_data(){
        try {
            url = new URL("http", "myfirstappwith.appspot.com", "index.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            in = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            int c;
            c = reader.read();
            while (c != -1) {
                inputString1.append((char) c);
                c = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write_data(){
        inputString = inputString1.toString();
        encodedString = Base64.getEncoder().encodeToString(inputString.getBytes());
    }

    public void encode(){
        database = new MyDatabase();
        database.write(encodedString);
    }
}

public class EncodingModule {
    public void encodeWithFiles() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/net/media/training/live/dip/beforeEncryption.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/net/media/training/live/dip/afterEncryption.txt"));
            String aLine;
            while ((aLine = reader.readLine()) != null) {
                String encodedLine = Base64.getEncoder().encodeToString(aLine.getBytes());
                writer.write(encodedLine);
            }
            writer.flush();
            writer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void encodeBasedOnNetworkAndDatabase() {
        URL url = null;
        try {
            url = new URL("http", "myfirstappwith.appspot.com", "index.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        try {
            in = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader reader = new InputStreamReader(in);
        StringBuilder inputString1 = new StringBuilder();
        try {
            int c;
            c = reader.read();
            while (c != -1) {
                inputString1.append((char) c);
                c = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputString = inputString1.toString();
        String encodedString = Base64.getEncoder().encodeToString(inputString.getBytes());
        MyDatabase database = new MyDatabase();
        database.write(encodedString);
    }
}

