package xyz.antsgroup.demo.logging.log4j2;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * Created by ants_ypc on 1/28/16.
 */

public class MyApp {

    private Logger logger = LogManager.getLogger(MyApp.class.getName());
    private static final Marker SQL_MARKER = MarkerManager.getMarker("SQL");
//    private static final Marker UPDATE_MARKER = MarkerManager.getMarker("SQL_UPDATE").setParents(SQL_MARKER);
    private static final Marker QUERY_MARKER = MarkerManager.getMarker("SQL_QUERY").setParents(SQL_MARKER);

    public void  doQuery(String table) {
        logger.entry();
        logger.debug(QUERY_MARKER, "SELECT * FROM {}", table);
        logger.exit();
    }
//
//    public String doUpdate(String table, Map<String, String> params) {
//        logger.entry();
//
//        if (logger.isDebugEnabled()) {
//            logger.debug(UPDATE_MARKER, "UPDATE {} SET {}", table, formatCols());
//
//            return logger.exit();
//        }
//    }
//
//    private String formatCols(Map<String, String> cols) {
//        StringBuilder sb = new StringBuilder();
//        boolean first = true;
//        for (Map.Entry<String, String> entry : cols.entrySet()) {
//            if (!first) {
//                sb.append(", ");
//            }
//            sb.append(entry.getKey()).append("=").append(entry.getValue());
//            first = false;
//        }
//        return sb.toString();
//    }
}