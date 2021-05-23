package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentService {

    private final static String FILE_CONFIG_NAME = "driverConfig.properties";
    private final static String URL_REGEX = "((https?:\\/\\/)?)[a-zA-Z0-9-\\.]+(:\\d{4})?";

    private enum PropertyType {
        BROWSER_TYPE("browserType"),
        PATH_TO_BROWSER("pathToBrowser"),
        APP_URL("appUrl"),
        FULL_SCREEN_MODE("fullScreenMode"),
        INCOGNITO_MODE_ON("incognitoModeOn"),
        IMPLICIT_WAIT("implicitWait"),
        APP_TITLE("appTitle");

        private String stringValue;
        PropertyType(String stringValue){
            this.stringValue = stringValue;
        }
        public String getCode(){ return stringValue;}
    }

    private final Properties properties;

    private String browserType;
    private String appUrl;
    private boolean fullScreenMode;
    private boolean incognitoModeOn;
    private int implicitWait;

    private String appTitle;

    public EnvironmentService() {
        this.properties = getEnvironmentProperties();
        setBrowserType(properties.getProperty(PropertyType.BROWSER_TYPE.stringValue, DefaultDriverOptions.browserType));
        setAppUrl(properties.getProperty(PropertyType.APP_URL.stringValue, DefaultDriverOptions.appUrl));
        setFullScreenMode(properties.getProperty(PropertyType.FULL_SCREEN_MODE.stringValue, DefaultDriverOptions.fullScreenMode));
        setIncognitoModeOn(properties.getProperty(PropertyType.INCOGNITO_MODE_ON.stringValue, DefaultDriverOptions.incognitoModeOn));
        setImplicitWait(properties.getProperty(PropertyType.IMPLICIT_WAIT.stringValue, DefaultDriverOptions.implicitWait));
        setAppTitle(properties.getProperty(PropertyType.APP_TITLE.stringValue, DefaultDriverOptions.appTitle));
    }

    public String getBrowserType() {
        return browserType;
    }
    public String getAppUrl() {
        return appUrl;
    }
    public boolean isFullScreenMode() {
        return fullScreenMode;
    }
    public boolean isIncognitoModeOn() {
        return incognitoModeOn;
    }
    public int getImplicitWait() {
        return implicitWait;
    }
    public String getAppTitle() {
        return appTitle;
    }

    private Properties getEnvironmentProperties() {
        try (InputStream fis = getClass().getClassLoader().getResourceAsStream(FILE_CONFIG_NAME)) {
            Properties prop = new Properties();
            prop.load(fis);
            return prop;
        } catch (IOException ex) {
            System.out.println(ex);
            return null;
        }
    }
    private void setBrowserType(String browserType) {
        this.browserType = browserType;
    }
    private void setAppUrl(String appUrl) {
        if(appUrl.matches(URL_REGEX))
            this.appUrl = appUrl;
    }
    private void setFullScreenMode(String fullScreenMode) {
        this.fullScreenMode = Boolean.parseBoolean(fullScreenMode);
    }
    private void setIncognitoModeOn(String incognitoModeOn) {
        this.incognitoModeOn = Boolean.parseBoolean(incognitoModeOn);
    }
    private void setImplicitWait(String implicitWait) {
        this.implicitWait = Integer.parseInt(implicitWait);
    }
    private void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

}
