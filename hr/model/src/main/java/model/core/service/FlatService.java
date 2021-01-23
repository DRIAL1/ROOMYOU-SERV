package model.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ontimize.db.EntityResult;
import api.core.service.IFlatService;
import model.core.dao.AddressDao;
import model.core.dao.FlatDao;
import model.core.dao.RoomDao;

import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("FlatService")
@Lazy
public class FlatService implements IFlatService {

	@Autowired
	private FlatDao flatDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private AddressDao addressDao;

	@Override
	public EntityResult flatQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.flatDao, keyMap, attrList);
	}

	@Override
	public EntityResult flatInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.flatDao, attrMap);
	}

	@Override
	public EntityResult flatUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.flatDao, attrMap, keyMap);
	}

	@Override
	public EntityResult flatDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.flatDao, keyMap);
	}

	@Override
	public EntityResult roomQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.roomDao, keyMap, attrList);
	}

	@Override
	public EntityResult roomDetailsQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.roomDao, keyMap, attrList, "details");
	}

	@Override
	public EntityResult roomInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		String user = SecurityContextHolder.getContext().getAuthentication().getName();
		attrMap.put(RoomDao.ATTR_USER, user);
		if (!attrMap.containsKey(RoomDao.ATTR_FLAT_ID)) {
			Map<String, Object> attrAddress = new HashMap<String, Object>();
			attrAddress.put(AddressDao.ATTR_CITY, attrMap.remove(AddressDao.ATTR_CITY));
			attrAddress.put(AddressDao.ATTR_DOOR, attrMap.remove(AddressDao.ATTR_DOOR));
			attrAddress.put(AddressDao.ATTR_FLOOR, attrMap.remove(AddressDao.ATTR_FLOOR));
			attrAddress.put(AddressDao.ATTR_NUMBER, attrMap.remove(AddressDao.ATTR_NUMBER));
			attrAddress.put(AddressDao.ATTR_POSTAL_CODE, attrMap.remove(AddressDao.ATTR_POSTAL_CODE));
			attrAddress.put(AddressDao.ATTR_PROVINCE, attrMap.remove(AddressDao.ATTR_PROVINCE));
			attrAddress.put(AddressDao.ATTR_STREET, attrMap.remove(AddressDao.ATTR_STREET));
			
			if (!attrAddress.containsKey(AddressDao.ATTR_STREET) && !attrAddress.containsKey(AddressDao.ATTR_FLOOR)) {
				throw new OntimizeJEERuntimeException("ADDRESS_DATA_IS_INCOMPLETE_STREET_AND_FLOOR_IS_REQUIRED");
			}
			
			EntityResult addressInsert = this.addressInsert(attrAddress);
			
			if (addressInsert.getCode() == EntityResult.OPERATION_WRONG) {
				throw new OntimizeJEERuntimeException("ADDRESS_CAN_NOT_BE_INSERTED");
			}
			
			Map<String,Object> attrFlat = new HashMap<String, Object>();
			attrFlat.put(FlatDao.ATTR_ADDRESS, addressInsert.get(FlatDao.ATTR_ADDRESS));
			EntityResult flatInsert = this.flatInsert(attrFlat);
			
			if (flatInsert.getCode() == EntityResult.OPERATION_WRONG) {
				throw new OntimizeJEERuntimeException("FLAT_CAN_NOT_BE_INSERTED");
			}
			
			attrMap.put(RoomDao.ATTR_FLAT_ID, flatInsert.get(FlatDao.ATTR_FLAT));
			
		}
		return this.daoHelper.insert(this.roomDao, attrMap);
	}

	@Override
	public EntityResult roomUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.roomDao, attrMap, keyMap);
	}

	@Override
	public EntityResult roomDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.roomDao, keyMap);
	}
	
	@Override
	public EntityResult roomDetailsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.roomDelete(keyMap);
	}
	
	
	@Override
	public EntityResult addressQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.addressDao, keyMap, attrList);
	}

	@Override
	public EntityResult addressInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.addressDao, attrMap);
	}

	@Override
	public EntityResult addressUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.addressDao, attrMap, keyMap);
	}

	@Override
	public EntityResult addressDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.addressDao, keyMap);
	}

	@Override
	public EntityResult roomDetailsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		/* El nombre de este método estaba mal, le faltaba la S de Details.
		 * En este detalle, sólo se puede modificar la dirección del piso. Falta modificar el precio, imagen o similares.
		 * De la misma manera que para la insercción necesitábamos agregarla información a dirección, aquí necesitamos hacer lo mismo
		 * Pero necesitamos saber el adress_id para poder hacer eso. Para ello hacemos una consulta con el room_id para conocer el flat_id,
		 * y con el flat_id para conocer el adress_id */
		
		// Obtenemos el flat_id
		
		List <String>flatIdAttr = new ArrayList<String>();
		flatIdAttr.add(RoomDao.ATTR_FLAT_ID);
		
		EntityResult flatQuery = this.roomQuery(keyMap, flatIdAttr);
		
		if (flatQuery.getCode() == EntityResult.OPERATION_WRONG) {
			throw new OntimizeJEERuntimeException("ERROR_RETRIEVING_FLAT_ID");
		}
		
		int flat_id = (int) flatQuery.getRecordValues(0).get(FlatDao.ATTR_FLAT);
		
		// Con el flat_id, obtendremos el address_id
		
		List <String>addressIdAttr = new ArrayList<String>();
		addressIdAttr.add(FlatDao.ATTR_ADDRESS);
		
		Map<String, Object> flatIdKey = new HashMap<String, Object>();
		flatIdKey.put(FlatDao.ATTR_FLAT, flat_id);
		
		EntityResult adressQuery = this.flatQuery(flatIdKey, addressIdAttr);
		
		if (adressQuery.getCode() == EntityResult.OPERATION_WRONG) {
			throw new OntimizeJEERuntimeException("ERROR_RETRIEVING_ADDRESS_ID");
		}
		
		int address_id = (int) adressQuery.getRecordValues(0).get(AddressDao.ATTR_ADDRESS);
		
		// Actualizamos los valores de la dirección filtrando por el address_id correspondiente
		
		Map<String, Object> addressIdKey = new HashMap<String, Object>();
		addressIdKey.put(AddressDao.ATTR_ADDRESS, address_id);
		
		EntityResult addressUpdate = this.addressUpdate(attrMap, addressIdKey);
		
		if (addressUpdate.getCode() == EntityResult.OPERATION_WRONG) {
			throw new OntimizeJEERuntimeException("ERROR_UPDATING_ADDRESS");
		}
		
		
		// return this.roomUpdate(attrMap, keyMap); -> Se comenta esta línea para que no falle. Habría que eliminar todos los elementos
		// de attrMap para filtrarlos por aquellos que únicamente pertenezcan a la habitación y no a la dirección para comprobar si queda
		// algo pendiente de modificar.
		// ↓ Por ese motivo se incluyen estas líneas abajo ↓
		
		EntityResult entityResult = new EntityResult();
		entityResult.setCode(EntityResult.OPERATION_SUCCESSFUL);
		return entityResult;
		
		/* OS FALTA COMPLETAR CON MÁS COSAS EL DETALLE Y LA ACTUALIZACIÓN DE DATOS*/
	}

}