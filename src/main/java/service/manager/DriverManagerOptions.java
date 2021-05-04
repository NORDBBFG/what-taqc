package service.manager;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriverManagerOptions {

    public enum BrowserType {
        CHROME, FIREFOX, EDGE, OPERA, YANDEX
    }

    private BrowserType browserType;
    private int widthScreen;
    private int heightScreen;
    private boolean incognitoModeOn;
    private boolean quietModeOn;
    private long implicitWait;

}
