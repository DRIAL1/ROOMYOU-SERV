package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IRoomService {

 // ROOM
 public EntityResult roomQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult roomDetailsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult roomInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult roomUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult roomDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 
 // ROOMDETAIL
 public EntityResult roomTypeQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult roomTypeInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult roomTypeUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult roomTypeDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}