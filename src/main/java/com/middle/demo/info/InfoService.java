package com.middle.demo.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InfoService {

    @Autowired
    private InfoRepository info_repository;

    public InfoService(InfoRepository info_repository){
        this.info_repository = info_repository;
    }

    public void addInfo(Info info) {
        info_repository.save(info);
    }

    public Info findInfo(String domain) {
        if (info_repository.findById(domain).isPresent()){
            return info_repository.findById(domain).get();
        }
        Info new_info = new Info(domain, "", "", "", "", "", "", "");
        addInfo(new_info);
        return new_info;
    }
}
