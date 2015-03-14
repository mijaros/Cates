package org.cates.domain

import groovy.transform.Canonical

/**
 * Created by jcechace on 14/03/15.
 */
@Canonical class Cat {

    public static enum Gender {
        MALE, FEMALE,
    }



    String name
    String ems
    String breed
    Date birthDate
    Gender gender
    Boolean premior
    Exhibitor owner
}
