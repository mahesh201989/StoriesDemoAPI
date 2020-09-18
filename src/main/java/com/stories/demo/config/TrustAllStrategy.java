package com.stories.demo.config;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class TrustAllStrategy implements TrustStrategy {
/**
 * Implement strategy to always trust certificates.
 * @see {org.apache.http.ssl.TrustStrategy} TrustStrategy
 */
	@Override
	public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
	    return true;
	}
	
	@SuppressWarnings("deprecation")
	public static HttpComponentsClientHttpRequestFactory buildCustomRequestFactory(String host, int port) throws MoxtraSingleSignOnProcessException {
        HttpComponentsClientHttpRequestFactory requestFactory = null;
        SSLConnectionSocketFactory sslSocketFactory = null;
        SSLContext sslContext = null;
        HttpClient httpClient = null;
        NoopHostnameVerifier hostNameVerifier = new NoopHostnameVerifier();
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();

    try {
        sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustAllStrategy()).useProtocol("TLSv1.2").build();
        sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostNameVerifier);
        clientBuilder.setSSLSocketFactory(sslSocketFactory);

        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("HTTPS", sslSocketFactory)
                .register("HTTP", PlainConnectionSocketFactory.getSocketFactory()).build();

        PoolingHttpClientConnectionManager clientConnectionMgr = new PoolingHttpClientConnectionManager(registry);
        HttpHost customHttpHost = new HttpHost(host, port);
        clientConnectionMgr.setSocketConfig(customHttpHost, SocketConfig.custom().setSoTimeout(100).build());

        httpClient = HttpClients.custom().setConnectionManager(clientConnectionMgr).build();
        requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
    } catch (Exception e) {
        throw new MoxtraSingleSignOnProcessException("A problem occured when tried to setup SSL configuration for API call", e);
    }

    return requestFactory;
}

}
