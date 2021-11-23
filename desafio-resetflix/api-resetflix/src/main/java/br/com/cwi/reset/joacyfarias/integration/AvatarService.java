package br.com.cwi.reset.joacyfarias.integration;

import br.com.cwi.reset.joacyfarias.integration.response.AvatarResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "avatar", url = "https://some-random-api.ml/img")
public interface AvatarService {

    @RequestMapping(method = RequestMethod.GET, value = "/dog")
    AvatarResponse buscarAvatarAtor();
}
