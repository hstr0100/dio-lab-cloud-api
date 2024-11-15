package dev.hstr0100.dio.iss.client;

import dev.hstr0100.dio.iss.dto.ISSLocationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@FeignClient(name = "iss-now", url = "http://api.open-notify.org")
public interface ISSClient {

    @GetMapping("iss-now.json")
    ISSLocationDTO getCurrentLocation();

}
