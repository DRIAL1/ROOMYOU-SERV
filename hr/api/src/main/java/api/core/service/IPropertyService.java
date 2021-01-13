package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IPropertyService {

 // PROPERTY
 public EntityResult propertyQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult propertyDetailsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult propertyInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult propertyUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult propertyDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 
 //PROPERTYTYPE
 public EntityResult propertyTypeQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult propertyTypeInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult propertyTypeUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult propertyTypeDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 

}