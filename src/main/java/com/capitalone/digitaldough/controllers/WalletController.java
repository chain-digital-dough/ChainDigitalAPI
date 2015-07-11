package com.capitalone.digitaldough.controllers;

import com.chain.Bucket;
import com.chain.ChainException;
import com.chain.Client;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletController {

    @RequestMapping(value = "/getBuckets", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public List<Bucket> getWallet() {

        List<Bucket> buckets = null;

        try {

            Client client = new Client(
                    new URL("https://348352332fefba2808a8438eae54e7c2:b77f1606ecd55ef5b6a9fcc0d5147f5e@w.chain.com"));
            buckets = (client.getBuckets("4a7f7b45-94b4-4cfb-811f-0348351c122d"));

        } catch (MalformedURLException | ChainException e) {
            e.printStackTrace();
        }


        return buckets;

    }


}
