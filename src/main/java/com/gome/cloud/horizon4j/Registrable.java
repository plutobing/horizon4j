package com.gome.cloud.horizon4j;

/**
 * Created by pluto on 1/10/16.
 */
public interface Registrable {

    void register(Namable t);

    Namable unregister(String key);

}
