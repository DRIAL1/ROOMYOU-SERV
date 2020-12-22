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

}