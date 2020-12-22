package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.core.service.IAddressService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/address")
@ComponentScan(basePackageClasses = { api.core.service.IAddressService.class })
public class AddressRestController extends ORestController<IAddressService> {

 @Autowired
 private IAddressService addresService;

 @Override
 public IAddressService getService() {
  return this.addresService;
 }
}