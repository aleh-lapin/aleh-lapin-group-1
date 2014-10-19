package compile.runtime;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class MemoryEater {

    static final Logger logger = Logger.getLogger(MemoryEater.class);

    public static void acquire() {
        List v = new ArrayList();
        byte b[] = new byte[1048576];
        while (true) {
            v.add(b);
            Runtime rt = Runtime.getRuntime();

            System.out.println("free memory: " + rt.freeMemory());
            /*try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }*/
        }
    }

}
