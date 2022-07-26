package com.pepsiwyl;

import com.pepsiwyl.starterspringbootstarterautoconfigure.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by pepsi-wyl
 * @date 2022-03-17 13:48
 */

@Service
public class StarterService_T {

    @Autowired
    StarterService starterService;

    public void t(){
        System.out.println(starterService.Starter("pepsi-wyl"));
    }

}
