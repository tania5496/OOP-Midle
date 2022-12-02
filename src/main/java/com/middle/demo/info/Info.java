package com.middle.demo.info;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.net.InetAddress;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Info {
    @Id
    private String domain;
    private String name = null;
    private String twitter = null;
    private String facebook = null;
    private String logo = null;
    private String icon = null;
    private String employees = null;
    private String address = null;

    @SneakyThrows
    Info(String domain) {
        InetAddress inetAddress = InetAddress.getByName(domain);
        this.domain = domain;
    }
}