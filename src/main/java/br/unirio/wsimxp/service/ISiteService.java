package br.unirio.wsimxp.service;

import br.unirio.wsimxp.entity.Site;
import br.unirio.wsimxp.entity.User;

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
