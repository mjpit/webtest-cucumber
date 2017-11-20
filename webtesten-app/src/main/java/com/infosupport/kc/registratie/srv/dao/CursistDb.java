package com.infosupport.kc.registratie.srv.dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Eigen annotatie zodat we op andere punten in onze app kunnen aangeven welke
 * database we willen hebben.
 * 
 * @author teunh
 * 
 */
@Qualifier
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CursistDb {
}
