package com.example.paymentapp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class PaymentController {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://online.yoco.com/v1/refunds/";

    @PostMapping("/refund")
    public Object refund(@RequestBody RefundPayment refundPayment, HttpServletRequest request) {
        Object response = null;

        try {
            HttpHeaders headers = new HttpHeaders();

            refundPayment.setChargeId("ch_xpnGtOMMObOw");

            String header = request.getParameter("X-Auth-Secret-Key");
            headers.set("X-Auth-Secret-Key", header);

            HttpEntity entity = new HttpEntity(refundPayment, headers);

            response = restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);

        } catch (Exception e) {

            System.out.println("------------------------------");
            System.out.println(e.getMessage());
            System.out.println("------------------------------");

            return e.getMessage();

        }

        return response;
    }
}
