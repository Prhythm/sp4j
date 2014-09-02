package com.prhythm.jsp.client.ext;

import com.prhythm.jsp.client.util.WebServiceClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Bruce on 8/18/2014.
 */
public class Apache43Client extends WebServiceClient {

    @Override
    public WebServiceResponse execute(String url, String soapEntity, String userName, String password, String domain) {

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
        post.addHeader("Content-Type", "application/soap+xml; charset=utf-8");
        HttpEntity entity = new StringEntity(soapEntity, "utf-8");
        post.setEntity(entity);

        HttpResponse response = null;
        try {
            System.out.printf("Request url: %s > %s%n", url, getAction(soapEntity));
            response = httpClient.execute(post, context);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StatusLine statusLine = response.getStatusLine();
        switch (statusLine.getStatusCode()) {
            case 200:
                break;
            default:
                return new WebServiceResponse(statusLine.getStatusCode(), statusLine.getReasonPhrase(), null);
        }

        HttpEntity responseEntity = response.getEntity();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            responseEntity.writeTo(baos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new WebServiceResponse(statusLine.getStatusCode(), statusLine.getReasonPhrase(), new String(baos.toByteArray()));
    }

}
