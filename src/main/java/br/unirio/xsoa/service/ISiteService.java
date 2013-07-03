package br.unirio.xsoa.service;

import br.unirio.xsoa.entity.Site;
import br.unirio.xsoa.entity.User;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: felipe
 * Date: 6/21/13
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
public interface ISiteService {
    Set<Site> findByUser(User user);
}
