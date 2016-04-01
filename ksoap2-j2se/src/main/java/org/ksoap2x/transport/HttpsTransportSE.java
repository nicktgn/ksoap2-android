package org.ksoap2x.transport;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

/**
 * HttpsTransportSE is a simple transport for https protocal based connections. It creates a #HttpsServiceConnectionSE
 * with the provided parameters.
 *
 * @author Manfred Moser <manfred@simpligility.com>
 */
public class HttpsTransportSE extends HttpTransportSE{

    static final String PROTOCOL = "https";
    private static final String PROTOCOL_FULL = PROTOCOL + "://";
    
    //connection instance, used for setting the SSLSocketFactory
    private HttpsServiceConnectionSE connection;

    protected String host;
    protected int port;
    protected String file;

    public HttpsTransportSE (URL url){
        this(url, ServiceConnection.DEFAULT_TIMEOUT);
    }

    public HttpsTransportSE (String url){
        this(url, ServiceConnection.DEFAULT_TIMEOUT);
    }

    public HttpsTransportSE (URL url, int timeout){
        super(url.toString(), timeout);

        this.host = url.getHost();
        this.port = url.getPort();
        if(this.port == -1) {
            this.port = url.getDefaultPort(); 
        }
        this.file = url.getFile();
    }
    
    public HttpsTransportSE (String url, int timeout){
        super(url, timeout);
        try{
            URL urlObj = new URL(url);
            this.host = urlObj.getHost();
            this.port = urlObj.getPort();
            if(this.port == -1) {
                this.port = urlObj.getDefaultPort();
            }
            this.file = urlObj.getFile();

        } catch(MalformedURLException e){
            this.host = "";
            this.port = 443;
            this.file = "";
        }
    }

    public HttpsTransportSE (String host, int port, String file, int timeout) {
        super(HttpsTransportSE.PROTOCOL_FULL + host + ":" + port + file, timeout);
        this.host = host;
        this.port = port;
        this.file = file;
    }

    /**
     * Creates instance of HttpTransportSE with set url and defines a
     * proxy server to use to access it
     *
     * @param proxy
     * Proxy information or <code>null</code> for direct access
     */
    public HttpsTransportSE(Proxy proxy, String host, int port, String file, int timeout) {
        super(proxy, HttpsTransportSE.PROTOCOL_FULL + host + ":" + port + file);
        this.host = host;
        this.port = port;
        this.file = file;
        this.timeout = timeout;
    }

    /**
     * Returns the HttpsServiceConnectionSE and creates it if necessary
     * @see org.ksoap2x.transport.HttpsTransportSE#getServiceConnection()
     */
    public ServiceConnection getServiceConnection() throws IOException
    {
        if(connection != null) {
            return connection;
        } else {
            connection = new HttpsServiceConnectionSE(proxy, host, port, file, timeout);
            return connection;
        }
    }
}
