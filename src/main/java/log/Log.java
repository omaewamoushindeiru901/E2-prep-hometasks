package log;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Log {
    private Logger logger = null;

    public Log(String name) {
        InputStream stream = Log.class.getClassLoader().
                getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
            this.logger = Logger.getLogger(name);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Logger getLogger() {
            return this.logger;
    }

    public void log(String message) {
        getLogger().info(message);
    }

    public void log(LogType type, String message) {
        switch (type) {
            case INFO:
                getLogger().info(message);
                break;
            case ERROR:
                getLogger().severe(message);
                break;
            case WARNING:
                getLogger().warning(message);
                break;
        }
    }
}
