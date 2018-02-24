package cn.unisolution.demo.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/2/13.
 */

@Component
@ConfigurationProperties(prefix = "dbjyjy")

public class DBJYJYSetting {


    private String url;

    private String host;

    private String port;


    public String getUrl() {
        return url;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
