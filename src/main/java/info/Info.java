package info;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.net.InetAddress;

public class Info {
    @Getter
    private final String domain;
    @Getter@Setter
    private String name = null;
    @Getter@Setter
    private String twitter = null;
    @Getter@Setter
    private String facebook = null;
    @Getter@Setter
    private String logo = null;
    @Getter@Setter
    private String icon = null;
    @Getter@Setter
    private String employees = null;
    @Getter@Setter
    private String address = null;

    @SneakyThrows
    Info(String domain) {
        InetAddress inetAddress = InetAddress.getByName(domain);
        this.domain = domain;
    }
}
