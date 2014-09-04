package com.prhythm.jsp.client.ext;

import com.prhythm.jsp.client.util.HttpResponseException;
import com.prhythm.jsp.client.util.JHttpClientClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.DigestSchemeFactory;
import org.apache.http.impl.auth.KerberosSchemeFactory;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by Bruce on 8/18/2014.
 */
public class Apache43Client extends JHttpClientClient {

    public Apache43Client() {
    }

    public Apache43Client(String userName, String password, String domain) {
        super(userName, password, domain);
    }

    @Override
    public InputStream get(String url, HashMap<String, String> headers, String userName, String password, String domain) throws Exception {
        Registry<AuthSchemeProvider> authSchemeRegistry = RegistryBuilder.<AuthSchemeProvider>create()
                .register(AuthSchemes.NTLM, new JCIFSNTLMSchemeFactory())
                .register(AuthSchemes.BASIC, new BasicSchemeFactory())
                .register(AuthSchemes.DIGEST, new DigestSchemeFactory())
                .register(AuthSchemes.SPNEGO, new SPNegoSchemeFactory())
                .register(AuthSchemes.KERBEROS, new KerberosSchemeFactory())
                .build();

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY, new NTCredentials(userName, password, "", domain));

        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultAuthSchemeRegistry(authSchemeRegistry)
                .build();

        HttpGet get = new HttpGet(url);
        if (headers != null && headers.size() > 0) {
            for (String name : headers.keySet()) {
                get.addHeader(name, headers.get(name));
            }
        }

        System.out.printf("Request url: %s%n", url);

        HttpResponse response = httpClient.execute(get, context);
        StatusLine statusLine = response.getStatusLine();

        switch (statusLine.getStatusCode()) {
            case 200:
                break;
            default:
                throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }

        return response.getEntity().getContent();
    }

    @Override
    public InputStream post(String url, String content, HashMap<String, String> headers, String userName, String password, String domain) throws Exception {
        Registry<AuthSchemeProvider> authSchemeRegistry = RegistryBuilder.<AuthSchemeProvider>create()
                .register(AuthSchemes.NTLM, new JCIFSNTLMSchemeFactory())
                .register(AuthSchemes.BASIC, new BasicSchemeFactory())
                .register(AuthSchemes.DIGEST, new DigestSchemeFactory())
                .register(AuthSchemes.SPNEGO, new SPNegoSchemeFactory())
                .register(AuthSchemes.KERBEROS, new KerberosSchemeFactory())
                .build();

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY, new NTCredentials(userName, password, "", domain));

        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultAuthSchemeRegistry(authSchemeRegistry)
                .build();

        HttpPost post = new HttpPost(url);
        HttpEntity entity = new StringEntity(content, "utf-8");
        post.setEntity(entity);
        if (headers != null && headers.size() > 0) {
            for (String name : headers.keySet()) {
                post.addHeader(name, headers.get(name));
            }
        }

        if (content != null && content.contains("<soap12:Body>"))
            System.out.printf("Request url: %s > %s%n", url, getAction(content));
        else
            System.out.printf("Request url: %s%n", url);

        HttpResponse response = httpClient.execute(post, context);

        StatusLine statusLine = response.getStatusLine();
        switch (statusLine.getStatusCode()) {
            case 200:
                break;
            default:
                throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }

        return response.getEntity().getContent();
    }
}
