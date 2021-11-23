package br.com.cwi.reset.joacyfarias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class Aplicacao {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Aplicacao.class, args);

    }
}