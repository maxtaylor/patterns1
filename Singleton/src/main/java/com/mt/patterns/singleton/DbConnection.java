/**
 * Created by root on 27/10/16.
 */

package com.mt.patterns.singleton;


import org.apache.log4j.Logger;

public enum DbConnection {

    Instance;

    private final Logger log = Logger.getLogger(DbConnection.class);

    public void foo() {
        log.info("returning singleton");
    }

}
