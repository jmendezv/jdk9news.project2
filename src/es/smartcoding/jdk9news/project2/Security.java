package es.smartcoding.jdk9news.project2;

import java.nio.charset.Charset;

import static java.lang.System.*;

/**
 * 
 * @author pep
 *
 */
@FunctionalInterface
public interface Security {

    /**
     * Regular expressión that follows security enterprise password's policy
     * 
     * ^ Start anchor
     * 
     * (?=.*[A-Z].*[A-Z]) Ensure string has two uppercase letters.
     * 
     * (?=.*[!@#$&*_]) Ensure string has one special case letter.
     * 
     * (?=.*[0-9].*[0-9]) Ensure string has two digits.
     * 
     * (?=.*[a-z].*[a-z].*[a-z]) Ensure string has three lowercase letters.
     * 
     * .{8} Ensure string is of length 8.
     * 
     * $ End anchor.
     */
    public static final String SECURE_PASSWORD_REG_EXPR = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*_])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$";

    /**
     * 
     * @param password
     * @return
     * @throws Exception
     */
    public abstract boolean isSecure(String password) throws Exception;

    /**
     * 
     * @param user
     * @param password
     */
    public static void log(String user, String password) {
	out.printf("Error de registro %s %s%n", user, "********");
    }

    /**
     * 
     * @param user
     * @param password
     * @throws Exception
     */
    public default void register(String user, String password) throws Exception {
	register(user.getBytes(), password.getBytes(Charset.defaultCharset()));
    }

    /**
     * 
     * @param user
     * @throws Exception
     */
    public default void register(String user) throws Exception {
	register(user.getBytes(), "********".getBytes());
    }

    /*
     * Este método efectivamente registra el usuario y la clave
     */
    private void register(byte[] user, byte[] password) throws Exception {
	out.printf("Registrando usuario %s con clave %s.%n", new String(user), new String(password));
	// ...
    }
}
