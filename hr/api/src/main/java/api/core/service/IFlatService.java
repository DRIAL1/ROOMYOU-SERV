package api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IFlatService {

 // FLAT
 public EntityResult flatQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
 public EntityResult flatInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
 public EntityResult flatUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 public EntityResult flatDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
 
//ROOM
public EntityResult roomQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
public EntityResult roomDetailsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
public EntityResult roomInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
public EntityResult roomUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
public EntityResult roomDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
public EntityResult roomDetailsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

//ADDRESS
public EntityResult addressQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
public EntityResult addressInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
public EntityResult addressUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
public EntityResult addressDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;



}