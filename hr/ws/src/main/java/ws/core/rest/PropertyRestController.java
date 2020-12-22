package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.core.service.IPropertyService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/properties")
@ComponentScan(basePackageClasses = { api.core.service.IPropertyService.class })
public class PropertyRestController extends ORestController<IPropertyService> {

 @Autowired
 private IPropertyService propertyService;

 @Override
 public IPropertyService getService() {
  return this.propertyService;
 }
}