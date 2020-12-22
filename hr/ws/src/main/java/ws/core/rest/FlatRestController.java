package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.core.service.IFlatService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/flats")
@ComponentScan(basePackageClasses = { api.core.service.IFlatService.class })
public class FlatRestController extends ORestController<IFlatService> {

 @Autowired
 private IFlatService flatService;

 @Override
 public IFlatService getService() {
  return this.flatService;
 }
}