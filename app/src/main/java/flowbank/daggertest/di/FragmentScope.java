package flowbank.daggertest.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by jinhui on 2018/5/17.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {



}
