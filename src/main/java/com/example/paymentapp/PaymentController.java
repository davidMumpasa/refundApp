package com.example.paymentapp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller

public class PaymentController {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://online.yoco.com/v1/refunds/";
    String SECRET_KEY = "sk_test_960bfde0VBrLlpK098e4ffeb53e1";

    @GetMapping("/refund")
    public Object refund(){
        Object res =null;

            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Auth-Secret-Key", SECRET_KEY);
            RefundPayment refundPayment = new RefundPayment();
            refundPayment.setChargeId("ch_xpnGtOMMObOw");

            HttpEntity entity = new HttpEntity(refundPayment,headers);

        try{
              res =  restTemplate.exchange(url, HttpMethod.POST,entity,Object.class);
        } catch (Exception e){
            return e.getMessage();

        }
            System.out.println("------------------------------");

            System.out.println(res);

            System.out.println("------------------------------");



        return res;
    }
}
