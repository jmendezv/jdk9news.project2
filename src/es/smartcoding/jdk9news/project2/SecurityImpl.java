/**
 * 
 */
package es.smartcoding.jdk9news.project2;

import static java.lang.System.*;

/**
 * @author pep
 *
 */
public class SecurityImpl implements Security {

    /* (non-Javadoc)
     * @see es.smartcoding.jdk9news.Security#isSecure(java.lang.String)
     */
    @Override
    public boolean isSecure(String password) throws Exception {
	return password.matches(Security.SECURE_PASSWORD_REG_EXPR);
    }

}
