import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.List;
import java.util.function.Consumer;

public class UdpService<T extends Serializable> extends Thread{

    private DatagramSocket socket;
    private byte[] buf = new byte[256];
    private Consumer<List<T>> receiveHandler;
    private final int port = 50001;
    private Class<T> mappingClass;

    public UdpService(Class<T> mappingClass, Consumer<List<T>> receiveHandler) {
        this.mappingClass = mappingClass;
        this.receiveHandler = receiveHandler;
    }

    public void run() {

        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String received = new String(packet.getData(), 0, packet.getLength());

            CsvToBean<T> csv = new CsvToBean<T>();
            CSVReader csvReader = new CSVReader(new StringReader(received),';');
            List<T> list = csv.parse(setColumnMapping(), csvReader);
            receiveHandler.accept(list);
        }
    }

    private ColumnPositionMappingStrategy<T> setColumnMapping()
    {
        ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<T>();
        strategy.setType(mappingClass);
        String[] columns = new String[] {"title", "count", "price", "discount", "sum"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
