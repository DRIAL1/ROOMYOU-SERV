package model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("RoomDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/RoomDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class RoomDao extends OntimizeJdbcDaoSupport {

 public static final String ATTR_ID = "room_id";
 public static final String ATTR_FLAT_ID = "flat_id";
 public static final String ATTR_USER = "user_";
 public static final String ATTR_PRICE = "price";
 public static final String ATTR_ADDRESS_CITY = "city";
 public static final String QUERY_ROOM_DETAILS = "details";
 

}