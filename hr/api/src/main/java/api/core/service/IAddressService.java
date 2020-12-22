package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IAddressService {

 // ROOM
 public EntityResult addressQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult addressInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult addressUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult addressDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}