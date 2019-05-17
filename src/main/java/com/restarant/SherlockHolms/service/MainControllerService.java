package com.restarant.SherlockHolms.service;

import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class MainControllerService {

    public Date convertStringtoDate(String dates) {
        String[]masDate = dates.split("/");
        return new Date(Integer.parseInt(masDate[2])-1900,Integer.parseInt(masDate[0])-1,Integer.parseInt(masDate[1]));
    }
}
