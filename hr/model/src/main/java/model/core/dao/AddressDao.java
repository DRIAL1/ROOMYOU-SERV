package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("AddressDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/AddressDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class AddressDao extends OntimizeJdbcDaoSupport {

 public static final String ATTR_ADDRESS = "address_id";
 public static final String ATTR_STREET = "street_name";
 public static final String ATTR_NUMBER = "street_number";
 public static final String ATTR_FLOOR = "floor";
 public static final String ATTR_DOOR = "street_door";
 public static final String ATTR_GEOLOCATION = "geolocation";
 public static final String ATTR_PROVINCE = "province";
 public static final String ATTR_CITY = "city";
 public static final String ATTR_POSTAL_CODE = "postal_code";
 
 

}