package co.com.devco.automation.screenplay.as400.utils;

import co.com.devco.automation.screenplay.as400.exceptions.SslException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

@SuppressWarnings("java:S2095")
public class SSLContextFactory {

    private SSLContextFactory(){}

    public static SSLContext buildSSLContext()  {
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
                throw new SslException(e.getMessage());
        }

        TrustManager trustManager = new X509TrustManager() {

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            @SuppressWarnings({"java:S4830"})
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
                //
            }

            @SuppressWarnings({"java:S4830"})
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
                //
            }

        };

        try {
            sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
        } catch (KeyManagementException e) {
            throw new SslException(e.getMessage());
        }

        return sslContext;
    }

}
