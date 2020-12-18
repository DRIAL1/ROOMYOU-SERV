package ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.core.service.IRoomService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/rooms")
@ComponentScan(basePackageClasses = { api.core.service.IRoomService.class })
public class RoomRestController extends ORestController<IRoomService> {

 @Autowired
 private IRoomService roomService;

 @Override
 public IRoomService getService() {
  return this.roomService;
 }
}