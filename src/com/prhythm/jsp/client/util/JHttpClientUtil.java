package com.prhythm.jsp.client.util;

import java.io.InputStream;
import java.util.HashMap;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Bruce on 8/18/2014.
 */
public class JHttpClientUtil {

    static JHttpClientClient client;

    public static void registerClient(JHttpClientClient client) {
        JHttpClientUtil.client = client;
    }

    public static JHttpClientClient getDefaultClient() {
        return client;
    }

    public static InputStream get(String url, HashMap<String, String> headers) throws Exception {
        if (client == null)
            throw new NotImplementedException();
        else
            return client.get(url, headers);
    }

    public static InputStream get(String url, HashMap<String, String> headers, String userName, String password, String domain) throws Exception {
        if (client == null)
            throw new NotImplementedException();
        else
            return client.get(url, headers, userName, password, domain);
    }

    public static InputStream post(String url, String content, HashMap<String, String> headers) throws Exception {
        if (client == null)
            throw new NotImplementedException();
        else
            return client.post(url, content, headers);
    }

    public static InputStream post(String url, String content, HashMap<String, String> headers, String userName, String password, String domain) throws Exception {
        if (client == null)
            throw new NotImplementedException();
        else
            return client.post(url, content, headers, userName, password, domain);
    }

    public static String getText(String url, HashMap<String, String> headers) throws Exception {
        if (client == null)
            throw new NotImplementedException();
        else
            return client.getText(url, headers);
    }

    public static String getText(String url, HashMap<String, String> headers, String userName, String password, String domain) throws Exception {
        if (client == null)
            throw new NotImplementedException();
        else
            return client.getText(url, headers, userName, password, domain);
    }

    public static String postText(String url, String content, HashMap<String, String> headers) throws Exception {
        if (client == null)
            throw new NotImplementedException();
        else
            return client.postText(url, content, headers);
    }

    public static String postText(String url, String content, HashMap<String, String> headers, String userName, String password, String domain) throws Exception {
        if (client == null)
            throw new NotImplementedException();
        else
            return client.postText(url, content, headers, userName, password, domain);
    }

    /**
     * http://msdn.microsoft.com/en-us/library/administration.aspx
     */
    public static interface Admin {
        String URL = "/_vti_adm/admin.asmx";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/alerts.aspx
     */
    public static interface Alters {
        String URL = "/_vti_bin/alerts.asmx";

        String DeleteAlerts = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteAlerts xmlns=\"http://schemas.microsoft.com/sharepoint/soap/2002/1/alerts/\">\n" +
                "      <IDs>\n" +
                "        <string>string</string>\n" +
                "        <string>string</string>\n" +
                "      </IDs>\n" +
                "    </DeleteAlerts>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetAlerts = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetAlerts xmlns=\"http://schemas.microsoft.com/sharepoint/soap/2002/1/alerts/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/websvcauthentication.aspx
     */
    public static interface Authentication {
        String URL = "/_vti_bin/authentication.asmx";

        String Login = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <Login xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <username>string</username>\n" +
                "      <password>string</password>\n" +
                "    </Login>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String Mode = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <Mode xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/copy.aspx
     */
    public static interface Copy {
        String URL = "/_vti_bin/copy.asmx";

        String CopyIntoItems = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CopyIntoItems xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <SourceUrl>string</SourceUrl>\n" +
                "      <DestinationUrls>\n" +
                "        <string>string</string>\n" +
                "        <string>string</string>\n" +
                "      </DestinationUrls>\n" +
                "      <Fields>\n" +
                "        <FieldInformation Type=\"Invalid or Integer or Text or Note or DateTime or Counter or Choice or Lookup or Boolean or Number or Currency or URL or Computed or Threading or Guid or MultiChoice or GridChoice or Calculated or File or Attachments or User or Recurrence or CrossProjectLink or ModStat or AllDayEvent or Error\" DisplayName=\"string\" InternalName=\"string\" Id=\"guid\" Value=\"string\" />\n" +
                "        <FieldInformation Type=\"Invalid or Integer or Text or Note or DateTime or Counter or Choice or Lookup or Boolean or Number or Currency or URL or Computed or Threading or Guid or MultiChoice or GridChoice or Calculated or File or Attachments or User or Recurrence or CrossProjectLink or ModStat or AllDayEvent or Error\" DisplayName=\"string\" InternalName=\"string\" Id=\"guid\" Value=\"string\" />\n" +
                "      </Fields>\n" +
                "      <Stream>base64Binary</Stream>\n" +
                "    </CopyIntoItems>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String CopyIntoItemsLocal = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CopyIntoItemsLocal xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <SourceUrl>string</SourceUrl>\n" +
                "      <DestinationUrls>\n" +
                "        <string>string</string>\n" +
                "        <string>string</string>\n" +
                "      </DestinationUrls>\n" +
                "    </CopyIntoItemsLocal>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetItem = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetItem xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <Url>string</Url>\n" +
                "    </GetItem>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/ms774834.aspx
     */
    public static interface Dws {
        String URL = "/_vti_bin/dws.asmx";

        String CanCreateDwsUrl = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CanCreateDwsUrl xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\">\n" +
                "      <url>string</url>\n" +
                "    </CanCreateDwsUrl>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String CreateDws = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CreateDws xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\">\n" +
                "      <name>string</name>\n" +
                "      <users>string</users>\n" +
                "      <title>string</title>\n" +
                "      <documents>string</documents>\n" +
                "    </CreateDws>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String CreateFolder = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CreateFolder xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\">\n" +
                "      <url>string</url>\n" +
                "    </CreateFolder>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteDws = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteDws xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteFolder = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteFolder xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\">\n" +
                "      <url>string</url>\n" +
                "    </DeleteFolder>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String FindDwsDoc = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <FindDwsDoc xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\">\n" +
                "      <id>string</id>\n" +
                "    </FindDwsDoc>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetDwsData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetDwsData xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\">\n" +
                "      <document>string</document>\n" +
                "      <lastUpdate>string</lastUpdate>\n" +
                "    </GetDwsData>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetDwsMetaData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetDwsMetaData xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\">\n" +
                "      <document>string</document>\n" +
                "      <id>string</id>\n" +
                "      <minimal>boolean</minimal>\n" +
                "    </GetDwsMetaData>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveDwsUser = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveDwsUser xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\">\n" +
                "      <id>string</id>\n" +
                "    </RemoveDwsUser>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RenameDws = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RenameDws xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\">\n" +
                "      <title>string</title>\n" +
                "    </RenameDws>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateDwsData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateDwsData xmlns=\"http://schemas.microsoft.com/sharepoint/soap/dws/\">\n" +
                "      <updates>string</updates>\n" +
                "      <meetingInstance>string</meetingInstance>\n" +
                "    </UpdateDwsData>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/forms.aspx
     */
    public static interface Forms {
        String URL = "/_vti_bin/forms.asmx";

        String GetForm = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetForm xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>{listName}</listName>\n" +
                "      <formUrl>{formUrl}</formUrl>\n" +
                "    </GetForm>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetFormCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetFormCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>{listName}</listName>\n" +
                "    </GetFormCollection>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/imaging.aspx
     */
    public static interface Imaging {
        String URL = "/_vti_bin/imaging.asmx";

        String CheckSubwebAndList = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CheckSubwebAndList xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\">\n" +
                "      <strUrl>string</strUrl>\n" +
                "    </CheckSubwebAndList>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String CreateNewFolder = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CreateNewFolder xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <strParentFolder>string</strParentFolder>\n" +
                "    </CreateNewFolder>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String Delete = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <Delete xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <strFolder>string</strFolder>\n" +
                "      <itemFileNames>\n" +
                "        <string>string</string>\n" +
                "        <string>string</string>\n" +
                "      </itemFileNames>\n" +
                "    </Delete>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String Download = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <Download xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <strFolder>string</strFolder>\n" +
                "      <itemFileNames>\n" +
                "        <string>string</string>\n" +
                "        <string>string</string>\n" +
                "      </itemFileNames>\n" +
                "      <type>unsignedInt</type>\n" +
                "      <fFetchOriginalIfNotAvailable>boolean</fFetchOriginalIfNotAvailable>\n" +
                "    </Download>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String Edit = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <Edit xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <strFolder>string</strFolder>\n" +
                "      <itemFileName>string</itemFileName>\n" +
                "      <recipe>xml</recipe>\n" +
                "    </Edit>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetItemsByIds = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetItemsByIds xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <ids>\n" +
                "        <unsignedInt>unsignedInt</unsignedInt>\n" +
                "        <unsignedInt>unsignedInt</unsignedInt>\n" +
                "      </ids>\n" +
                "    </GetItemsByIds>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetItemsXMLData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetItemsXMLData xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <strFolder>string</strFolder>\n" +
                "      <itemFileNames>\n" +
                "        <string>string</string>\n" +
                "        <string>string</string>\n" +
                "      </itemFileNames>\n" +
                "    </GetItemsXMLData>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListItems = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListItems xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <strFolder>string</strFolder>\n" +
                "    </GetListItems>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String ListPictureLibrary = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <ListPictureLibrary xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String Rename = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <Rename xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <strFolder>string</strFolder>\n" +
                "      <request>xml</request>\n" +
                "    </Rename>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String Upload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <Upload xmlns=\"http://schemas.microsoft.com/sharepoint/soap/ois/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <strFolder>string</strFolder>\n" +
                "      <bytes>base64Binary</bytes>\n" +
                "      <fileName>string</fileName>\n" +
                "      <fOverWriteIfExist>boolean</fOverWriteIfExist>\n" +
                "    </Upload>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/ms774413.aspx
     */
    public static interface DspSts {
        String URL = "/_vti_bin/dspsts.asmx";

        String Query = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Header>\n" +
                "    <authentication xmlns=\"http://schemas.microsoft.com/sharepoint/dsp\">xml</authentication>\n" +
                "    <dataRoot allowRemoteDataAccess=\"boolean\" xmlns=\"http://schemas.microsoft.com/sharepoint/dsp\">\n" +
                "      <root>string</root>\n" +
                "    </dataRoot>\n" +
                "    <request document=\"content or system\" method=\"query\" xmlns=\"http://schemas.microsoft.com/sharepoint/dsp\" />\n" +
                "    <versions xmlns=\"http://schemas.microsoft.com/sharepoint/dsp\">\n" +
                "      <version>string</version>\n" +
                "      <version>string</version>\n" +
                "    </versions>\n" +
                "  </soap12:Header>\n" +
                "  <soap12:Body>\n" +
                "    <queryRequest xmlns=\"http://schemas.microsoft.com/sharepoint/dsp\">\n" +
                "      <dsQuery select=\"string\" resultContent=\"both or schemaOnly or dataOnly\" columnMapping=\"element or attribute\" resultNamespace=\"string\" resultPrefix=\"string\" resultRoot=\"string\" resultRow=\"string\" startPosition=\"string\" comparisonLocale=\"string\">\n" +
                "        <Query RowLimit=\"long\">\n" +
                "          <ServerParameterInfo />\n" +
                "          <Fields>\n" +
                "            <Field xsi:nil=\"true\" />\n" +
                "            <Field xsi:nil=\"true\" />\n" +
                "            <AllFields xsi:nil=\"true\" />\n" +
                "          </Fields>\n" +
                "          <ServerParameters>\n" +
                "            <ServerParameter xsi:nil=\"true\" />\n" +
                "            <ServerParameter xsi:nil=\"true\" />\n" +
                "          </ServerParameters>\n" +
                "          <Where>xml</Where>\n" +
                "          <OrderBy>\n" +
                "            <OrderField xsi:nil=\"true\" />\n" +
                "            <OrderField xsi:nil=\"true\" />\n" +
                "          </OrderBy>\n" +
                "        </Query>\n" +
                "      </dsQuery>\n" +
                "      <ptQuery>xml</ptQuery>\n" +
                "    </queryRequest>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        // MessageName="queryRequest"
    }

    /**
     * http://msdn.microsoft.com/en-us/library/lists.aspx
     */
    public static interface Lists {
        String URL = "/_vti_bin/lists.asmx";

        String AddAttachment = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddAttachment xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <listItemID>string</listItemID>\n" +
                "      <fileName>string</fileName>\n" +
                "      <attachment>base64Binary</attachment>\n" +
                "    </AddAttachment>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddDiscussionBoardItem = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddDiscussionBoardItem xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <message>base64Binary</message>\n" +
                "    </AddDiscussionBoardItem>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddList = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddList xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <description>string</description>\n" +
                "      <templateID>int</templateID>\n" +
                "    </AddList>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddListFromFeature = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddListFromFeature xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <description>string</description>\n" +
                "      <featureID>guid</featureID>\n" +
                "      <templateID>int</templateID>\n" +
                "    </AddListFromFeature>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddWikiPage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddWikiPage xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <listRelPageUrl>string</listRelPageUrl>\n" +
                "      <wikiContent>string</wikiContent>\n" +
                "    </AddWikiPage>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String ApplyContentTypeToList = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <ApplyContentTypeToList xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <webUrl>string</webUrl>\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "      <listName>string</listName>\n" +
                "    </ApplyContentTypeToList>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String CheckInFile = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CheckInFile xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "      <comment>string</comment>\n" +
                "      <CheckinType>string</CheckinType>\n" +
                "    </CheckInFile>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String CheckOutFile = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CheckOutFile xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "      <checkoutToLocal>string</checkoutToLocal>\n" +
                "      <lastmodified>string</lastmodified>\n" +
                "    </CheckOutFile>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String CreateContentType = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CreateContentType xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <displayName>string</displayName>\n" +
                "      <parentType>string</parentType>\n" +
                "      <fields>string</fields>\n" +
                "      <contentTypeProperties>string</contentTypeProperties>\n" +
                "      <addToView>string</addToView>\n" +
                "    </CreateContentType>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteAttachment = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteAttachment xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <listItemID>string</listItemID>\n" +
                "      <url>string</url>\n" +
                "    </DeleteAttachment>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteContentType = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteContentType xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "    </DeleteContentType>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteContentTypeXmlDocument = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteContentTypeXmlDocument xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "      <documentUri>string</documentUri>\n" +
                "    </DeleteContentTypeXmlDocument>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteList = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteList xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "    </DeleteList>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetAttachmentCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetAttachmentCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <listItemID>string</listItemID>\n" +
                "    </GetAttachmentCollection>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetList = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetList xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>{listName}</listName>\n" +
                "    </GetList>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListAndView = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListAndView xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <viewName>string</viewName>\n" +
                "    </GetListAndView>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListContentType = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListContentType xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "    </GetListContentType>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListContentTypes = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListContentTypes xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "    </GetListContentTypes>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListContentTypesAndProperties = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListContentTypesAndProperties xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "      <propertyPrefix>string</propertyPrefix>\n" +
                "      <includeWebProperties>boolean</includeWebProperties>\n" +
                "    </GetListContentTypesAndProperties>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListItemChanges = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListItemChanges xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <viewFields>string</viewFields>\n" +
                "      <since>string</since>\n" +
                "      <contains>string</contains>\n" +
                "    </GetListItemChanges>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListItemChangesSinceToken = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListItemChangesSinceToken xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <viewName>string</viewName>\n" +
                "      <query>string</query>\n" +
                "      <viewFields>string</viewFields>\n" +
                "      <rowLimit>string</rowLimit>\n" +
                "      <queryOptions>string</queryOptions>\n" +
                "      <changeToken>string</changeToken>\n" +
                "      <contains>string</contains>\n" +
                "    </GetListItemChangesSinceToken>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListItemChangesWithKnowledge = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListItemChangesWithKnowledge xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <viewName>string</viewName>\n" +
                "      <query>string</query>\n" +
                "      <viewFields>string</viewFields>\n" +
                "      <rowLimit>string</rowLimit>\n" +
                "      <queryOptions>string</queryOptions>\n" +
                "      <syncScope>string</syncScope>\n" +
                "      <knowledge>string</knowledge>\n" +
                "      <contains>string</contains>\n" +
                "    </GetListItemChangesWithKnowledge>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListItems = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListItems xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>{listName}</listName>\n" +
                "      <viewName>{viewName}</viewName>\n" +
                "      <query>{query}</query>\n" +
                "      <viewFields>{viewFields}</viewFields>\n" +
                "      <rowLimit>{rowLimit}</rowLimit>\n" +
                "      <queryOptions><QueryOptions>{queryOptions}</QueryOptions></queryOptions>\n" +
                "      <webID>{webID}</webID>\n" +
                "    </GetListItems>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetVersionCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetVersionCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <strlistID>string</strlistID>\n" +
                "      <strlistItemID>string</strlistItemID>\n" +
                "      <strFieldName>string</strFieldName>\n" +
                "    </GetVersionCollection>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UndoCheckOut = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UndoCheckOut xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "    </UndoCheckOut>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateContentType = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateContentType xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "      <contentTypeProperties>string</contentTypeProperties>\n" +
                "      <newFields>string</newFields>\n" +
                "      <updateFields>string</updateFields>\n" +
                "      <deleteFields>string</deleteFields>\n" +
                "      <addToView>string</addToView>\n" +
                "    </UpdateContentType>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateContentTypeXmlDocument = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateContentTypeXmlDocument xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "      <newDocument>string</newDocument>\n" +
                "    </UpdateContentTypeXmlDocument>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateContentTypesXmlDocument = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateContentTypesXmlDocument xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <newDocument>string</newDocument>\n" +
                "    </UpdateContentTypesXmlDocument>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateList = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateList xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <listProperties>string</listProperties>\n" +
                "      <newFields>string</newFields>\n" +
                "      <updateFields>string</updateFields>\n" +
                "      <deleteFields>string</deleteFields>\n" +
                "      <listVersion>string</listVersion>\n" +
                "    </UpdateList>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateListItems = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateListItems xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <updates>string</updates>\n" +
                "    </UpdateListItems>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateListItemsWithKnowledge = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateListItemsWithKnowledge xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <updates>string</updates>\n" +
                "      <syncScope>string</syncScope>\n" +
                "      <knowledge>string</knowledge>\n" +
                "    </UpdateListItemsWithKnowledge>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/ms774629.aspx
     */
    public static interface Meetings {
        String URL = "/_vti_bin/meetings.asmx";

        String AddMeeting = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddMeeting xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <organizerEmail>string</organizerEmail>\n" +
                "      <uid>string</uid>\n" +
                "      <sequence>unsignedInt</sequence>\n" +
                "      <utcDateStamp>dateTime</utcDateStamp>\n" +
                "      <title>string</title>\n" +
                "      <location>string</location>\n" +
                "      <utcDateStart>dateTime</utcDateStart>\n" +
                "      <utcDateEnd>dateTime</utcDateEnd>\n" +
                "      <nonGregorian>boolean</nonGregorian>\n" +
                "    </AddMeeting>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddMeetingFromICal = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddMeetingFromICal xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <organizerEmail>string</organizerEmail>\n" +
                "      <icalText>string</icalText>\n" +
                "    </AddMeetingFromICal>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String CreateWorkspace = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CreateWorkspace xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <title>string</title>\n" +
                "      <templateName>string</templateName>\n" +
                "      <lcid>unsignedInt</lcid>\n" +
                "      <timeZoneInformation>\n" +
                "        <bias>int</bias>\n" +
                "        <standardDate>\n" +
                "          <year>unsignedShort</year>\n" +
                "          <month>unsignedShort</month>\n" +
                "          <dayOfWeek>unsignedShort</dayOfWeek>\n" +
                "          <day>unsignedShort</day>\n" +
                "          <hour>unsignedShort</hour>\n" +
                "          <minute>unsignedShort</minute>\n" +
                "          <second>unsignedShort</second>\n" +
                "          <milliseconds>unsignedShort</milliseconds>\n" +
                "        </standardDate>\n" +
                "        <standardBias>int</standardBias>\n" +
                "        <daylightDate>\n" +
                "          <year>unsignedShort</year>\n" +
                "          <month>unsignedShort</month>\n" +
                "          <dayOfWeek>unsignedShort</dayOfWeek>\n" +
                "          <day>unsignedShort</day>\n" +
                "          <hour>unsignedShort</hour>\n" +
                "          <minute>unsignedShort</minute>\n" +
                "          <second>unsignedShort</second>\n" +
                "          <milliseconds>unsignedShort</milliseconds>\n" +
                "        </daylightDate>\n" +
                "        <daylightBias>int</daylightBias>\n" +
                "      </timeZoneInformation>\n" +
                "    </CreateWorkspace>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteWorkspace = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteWorkspace xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetMeetingWorkspaces = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetMeetingWorkspaces xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <recurring>boolean</recurring>\n" +
                "    </GetMeetingWorkspaces>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetMeetingsInformation = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetMeetingsInformation xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <requestFlags>unsignedInt</requestFlags>\n" +
                "      <lcid>unsignedInt</lcid>\n" +
                "    </GetMeetingsInformation>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveMeeting = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveMeeting xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <recurrenceId>unsignedInt</recurrenceId>\n" +
                "      <uid>string</uid>\n" +
                "      <sequence>unsignedInt</sequence>\n" +
                "      <utcDateStamp>dateTime</utcDateStamp>\n" +
                "      <cancelMeeting>boolean</cancelMeeting>\n" +
                "    </RemoveMeeting>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RestoreMeeting = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RestoreMeeting xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <uid>string</uid>\n" +
                "    </RestoreMeeting>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String SetAttendeeResponse = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <SetAttendeeResponse xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <attendeeEmail>string</attendeeEmail>\n" +
                "      <recurrenceId>unsignedInt</recurrenceId>\n" +
                "      <uid>string</uid>\n" +
                "      <sequence>unsignedInt</sequence>\n" +
                "      <utcDateTimeOrganizerCriticalChange>dateTime</utcDateTimeOrganizerCriticalChange>\n" +
                "      <utcDateTimeAttendeeCriticalChange>dateTime</utcDateTimeAttendeeCriticalChange>\n" +
                "      <response>responseAccepted or responseTentative or responseDeclined</response>\n" +
                "    </SetAttendeeResponse>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String SetWorkspaceTitle = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <SetWorkspaceTitle xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <title>string</title>\n" +
                "    </SetWorkspaceTitle>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateMeeting = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateMeeting xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <uid>string</uid>\n" +
                "      <sequence>unsignedInt</sequence>\n" +
                "      <utcDateStamp>dateTime</utcDateStamp>\n" +
                "      <title>string</title>\n" +
                "      <location>string</location>\n" +
                "      <utcDateStart>dateTime</utcDateStart>\n" +
                "      <utcDateEnd>dateTime</utcDateEnd>\n" +
                "      <nonGregorian>boolean</nonGregorian>\n" +
                "    </UpdateMeeting>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateMeetingFromICal = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateMeetingFromICal xmlns=\"http://schemas.microsoft.com/sharepoint/soap/meetings/\">\n" +
                "      <icalText>string</icalText>\n" +
                "      <ignoreAttendees>boolean</ignoreAttendees>\n" +
                "    </UpdateMeetingFromICal>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/people.aspx
     */
    public static interface People {
        String URL = "/_vti_bin/people.asmx";

        String IsClaimsMode = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <IsClaimsModeResponse xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <IsClaimsModeResult>boolean</IsClaimsModeResult>\n" +
                "    </IsClaimsModeResponse>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
        String ResolvePrincipals = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <ResolvePrincipals xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <principalKeys>\n" +
                "        <string>string</string>\n" +
                "        <string>string</string>\n" +
                "      </principalKeys>\n" +
                "      <principalType>None or User or DistributionList or SecurityGroup or SharePointGroup or All</principalType>\n" +
                "      <addToUserInfoList>boolean</addToUserInfoList>\n" +
                "    </ResolvePrincipals>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String SearchPrincipals = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <SearchPrincipals xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <searchText>string</searchText>\n" +
                "      <maxResults>int</maxResults>\n" +
                "      <principalType>None or User or DistributionList or SecurityGroup or SharePointGroup or All</principalType>\n" +
                "    </SearchPrincipals>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/permissions.aspx
     */
    public static interface Permissions {
        String URL = "/_vti_bin/permissions.asmx";

        String AddPermission = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddPermission xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <objectName>string</objectName>\n" +
                "      <objectType>string</objectType>\n" +
                "      <permissionIdentifier>string</permissionIdentifier>\n" +
                "      <permissionType>string</permissionType>\n" +
                "      <permissionMask>int</permissionMask>\n" +
                "    </AddPermission>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddPermissionCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddPermissionCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <objectName>string</objectName>\n" +
                "      <objectType>string</objectType>\n" +
                "      <permissionsInfoXml>string</permissionsInfoXml>\n" +
                "    </AddPermissionCollection>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetPermissionCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetPermissionCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <objectName>string</objectName>\n" +
                "      <objectType>string</objectType>\n" +
                "    </GetPermissionCollection>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemovePermission = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemovePermission xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <objectName>string</objectName>\n" +
                "      <objectType>string</objectType>\n" +
                "      <permissionIdentifier>string</permissionIdentifier>\n" +
                "      <permissionType>string</permissionType>\n" +
                "    </RemovePermission>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemovePermissionCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemovePermissionCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <objectName>string</objectName>\n" +
                "      <objectType>string</objectType>\n" +
                "      <memberIdsXml>string</memberIdsXml>\n" +
                "    </RemovePermissionCollection>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdatePermission = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdatePermission xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <objectName>string</objectName>\n" +
                "      <objectType>string</objectType>\n" +
                "      <permissionIdentifier>string</permissionIdentifier>\n" +
                "      <permissionType>string</permissionType>\n" +
                "      <permissionMask>int</permissionMask>\n" +
                "    </UpdatePermission>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/ms774821.aspx
     */
    public static interface SiteData {
        String URL = "/_vti_bin/sitedata.asmx";

        String EnumerateFolder = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <EnumerateFolder xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <strFolderUrl>string</strFolderUrl>\n" +
                "    </EnumerateFolder>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetAttachments = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetAttachments xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <strItemId>string</strItemId>\n" +
                "    </GetAttachments>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetChanges = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetChanges xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <objectType>VirtualServer or ContentDatabase or SiteCollection or Site or List or Folder or ListItem or ListItemAttachments</objectType>\n" +
                "      <contentDatabaseId>string</contentDatabaseId>\n" +
                "      <LastChangeId>string</LastChangeId>\n" +
                "      <CurrentChangeId>string</CurrentChangeId>\n" +
                "      <Timeout>int</Timeout>\n" +
                "    </GetChanges>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetChangesEx = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetChangesEx xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <version>int</version>\n" +
                "      <xmlInput>string</xmlInput>\n" +
                "    </GetChangesEx>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetContent = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetContent xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <objectType>VirtualServer or ContentDatabase or SiteCollection or Site or List or Folder or ListItem or ListItemAttachments</objectType>\n" +
                "      <objectId>string</objectId>\n" +
                "      <folderUrl>string</folderUrl>\n" +
                "      <itemId>string</itemId>\n" +
                "      <retrieveChildItems>boolean</retrieveChildItems>\n" +
                "      <securityOnly>boolean</securityOnly>\n" +
                "      <lastItemIdOnPage>string</lastItemIdOnPage>\n" +
                "    </GetContent>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetList = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetList xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <strListName>{strListName}</strListName>\n" +
                "    </GetList>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListItems = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListItems xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <strListName>string</strListName>\n" +
                "      <strQuery>string</strQuery>\n" +
                "      <strViewFields>string</strViewFields>\n" +
                "      <uRowLimit>unsignedInt</uRowLimit>\n" +
                "    </GetListItems>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetSite = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetSite xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetSiteAndWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetSiteAndWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <strUrl>string</strUrl>\n" +
                "    </GetSiteAndWeb>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetSiteUrl = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetSiteUrl xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <Url>string</Url>\n" +
                "    </GetSiteUrl>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetURLSegments = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetURLSegments xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <strURL>string</strURL>\n" +
                "    </GetURLSegments>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/sites.aspx
     */
    public static interface Sites {
        String URL = "/_vti_bin/sites.asmx";

        String CreateWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CreateWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <url>string</url>\n" +
                "      <title>string</title>\n" +
                "      <description>string</description>\n" +
                "      <templateName>string</templateName>\n" +
                "      <language>unsignedInt</language>\n" +
                "      <locale>unsignedInt</locale>\n" +
                "      <collationLocale>unsignedInt</collationLocale>\n" +
                "      <uniquePermissions>boolean</uniquePermissions>\n" +
                "      <anonymous>boolean</anonymous>\n" +
                "      <presence>boolean</presence>\n" +
                "    </CreateWeb>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <url>string</url>\n" +
                "    </DeleteWeb>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String ExportSolution = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <ExportSolution xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <solutionFileName>string</solutionFileName>\n" +
                "      <title>string</title>\n" +
                "      <description>string</description>\n" +
                "      <fullReuseExportMode>boolean</fullReuseExportMode>\n" +
                "      <includeWebContent>boolean</includeWebContent>\n" +
                "    </ExportSolution>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String ExportWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <ExportWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <jobName>string</jobName>\n" +
                "      <webUrl>string</webUrl>\n" +
                "      <dataPath>string</dataPath>\n" +
                "      <includeSubwebs>boolean</includeSubwebs>\n" +
                "      <includeUserSecurity>boolean</includeUserSecurity>\n" +
                "      <overWrite>boolean</overWrite>\n" +
                "      <cabSize>int</cabSize>\n" +
                "    </ExportWeb>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String ExportWorkflowTemplate = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <ExportWorkflowTemplate xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <solutionFileName>string</solutionFileName>\n" +
                "      <title>string</title>\n" +
                "      <description>string</description>\n" +
                "      <workflowTemplateName>string</workflowTemplateName>\n" +
                "      <destinationListUrl>string</destinationListUrl>\n" +
                "    </ExportWorkflowTemplate>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetSite = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetSite xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <SiteUrl>{SiteUrl}</SiteUrl>\n" +
                "    </GetSite>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetSiteTemplates = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetSiteTemplates xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <LCID>unsignedInt</LCID>\n" +
                "    </GetSiteTemplates>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetUpdatedFormDigest = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetUpdatedFormDigest xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetUpdatedFormDigestInformation = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetUpdatedFormDigestInformation xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <url>string</url>\n" +
                "    </GetUpdatedFormDigestInformation>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String ImportWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <ImportWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <jobName>string</jobName>\n" +
                "      <webUrl>string</webUrl>\n" +
                "      <dataFiles>\n" +
                "        <string>string</string>\n" +
                "        <string>string</string>\n" +
                "      </dataFiles>\n" +
                "      <logPath>string</logPath>\n" +
                "      <includeUserSecurity>boolean</includeUserSecurity>\n" +
                "      <overWrite>boolean</overWrite>\n" +
                "    </ImportWeb>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }


    /**
     * http://msdn.microsoft.com/en-us/library/search.aspx
     */
    public static interface Search {
        String URL = "/_vti_bin/search.asmx";

        String GetPortalSearchInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetPortalSearchInfo xmlns=\"http://microsoft.com/webservices/OfficeServer/QueryService\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetQuerySuggestions = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetQuerySuggestions xmlns=\"http://microsoft.com/webservices/OfficeServer/QueryService\">\n" +
                "      <queryXml>string</queryXml>\n" +
                "    </GetQuerySuggestions>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetSearchMetadata = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetSearchMetadata xmlns=\"http://microsoft.com/webservices/OfficeServer/QueryService\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String Query = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <Query xmlns=\"urn:Microsoft.Search\">\n" +
                "      <queryXml>string</queryXml>\n" +
                "    </Query>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String QueryEx = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <QueryEx xmlns=\"http://microsoft.com/webservices/OfficeServer/QueryService\">\n" +
                "      <queryXml>string</queryXml>\n" +
                "    </QueryEx>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RecordClick = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RecordClick xmlns=\"urn:Microsoft.Search\">\n" +
                "      <clickInfoXml>string</clickInfoXml>\n" +
                "    </RecordClick>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String Registration = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <Registration xmlns=\"urn:Microsoft.Search\">\n" +
                "      <registrationXml>string</registrationXml>\n" +
                "    </Registration>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String Status = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <Status xmlns=\"urn:Microsoft.Search\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/ms772647.aspx
     */
    public static interface UserGroup {
        String URL = "/_vti_bin/usergroup.asmx";

        String AddGroup = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddGroup xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <groupName>string</groupName>\n" +
                "      <ownerIdentifier>string</ownerIdentifier>\n" +
                "      <ownerType>string</ownerType>\n" +
                "      <defaultUserLoginName>string</defaultUserLoginName>\n" +
                "      <description>string</description>\n" +
                "    </AddGroup>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddGroupToRole = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddGroupToRole xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "      <groupName>string</groupName>\n" +
                "    </AddGroupToRole>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddRole = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddRole xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "      <description>string</description>\n" +
                "      <permissionMask>int</permissionMask>\n" +
                "    </AddRole>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddRoleDef = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddRoleDef xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "      <description>string</description>\n" +
                "      <permissionMask>unsignedLong</permissionMask>\n" +
                "    </AddRoleDef>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddUserCollectionToGroup = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddUserCollectionToGroup xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <groupName>string</groupName>\n" +
                "      <usersInfoXml>string</usersInfoXml>\n" +
                "    </AddUserCollectionToGroup>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddUserCollectionToRole = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddUserCollectionToRole xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "      <usersInfoXml>string</usersInfoXml>\n" +
                "    </AddUserCollectionToRole>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddUserToGroup = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddUserToGroup xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <groupName>string</groupName>\n" +
                "      <userName>string</userName>\n" +
                "      <userLoginName>string</userLoginName>\n" +
                "      <userEmail>string</userEmail>\n" +
                "      <userNotes>string</userNotes>\n" +
                "    </AddUserToGroup>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddUserToRole = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddUserToRole xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "      <userName>string</userName>\n" +
                "      <userLoginName>string</userLoginName>\n" +
                "      <userEmail>string</userEmail>\n" +
                "      <userNotes>string</userNotes>\n" +
                "    </AddUserToRole>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetAllUserCollectionFromWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetAllUserCollectionFromWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetCurrentUserInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetCurrentUserInfo xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetGroupCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetGroupCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <groupNamesXml>string</groupNamesXml>\n" +
                "    </GetGroupCollection>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetGroupCollectionFromRole = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetGroupCollectionFromRole xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "    </GetGroupCollectionFromRole>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetGroupCollectionFromSite = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetGroupCollectionFromSite xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetGroupCollectionFromUser = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetGroupCollectionFromUser xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <userLoginName>string</userLoginName>\n" +
                "    </GetGroupCollectionFromUser>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetGroupCollectionFromWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetGroupCollectionFromWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetGroupInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetGroupInfo xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <groupName>string</groupName>\n" +
                "    </GetGroupInfo>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetRoleCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetRoleCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleNamesXml>string</roleNamesXml>\n" +
                "    </GetRoleCollection>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetRoleCollectionFromGroup = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetRoleCollectionFromGroup xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <groupName>string</groupName>\n" +
                "    </GetRoleCollectionFromGroup>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetRoleCollectionFromUser = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetRoleCollectionFromUser xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <userLoginName>string</userLoginName>\n" +
                "    </GetRoleCollectionFromUser>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetRoleCollectionFromWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetRoleCollectionFromWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetRoleInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetRoleInfo xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "    </GetRoleInfo>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetRolesAndPermissionsForCurrentUser = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetRolesAndPermissionsForCurrentUser xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetRolesAndPermissionsForSite = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetRolesAndPermissionsForSite xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetUserCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetUserCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <userLoginNamesXml>string</userLoginNamesXml>\n" +
                "    </GetUserCollection>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetUserCollectionFromGroup = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetUserCollectionFromGroup xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <groupName>string</groupName>\n" +
                "    </GetUserCollectionFromGroup>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetUserCollectionFromRole = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetUserCollectionFromRole xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "    </GetUserCollectionFromRole>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetUserCollectionFromSite = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetUserCollectionFromSite xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetUserCollectionFromWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetUserCollectionFromWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetUserInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetUserInfo xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <userLoginName>string</userLoginName>\n" +
                "    </GetUserInfo>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetUserLoginFromEmail = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetUserLoginFromEmail xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <emailXml>string</emailXml>\n" +
                "    </GetUserLoginFromEmail>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveGroup = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveGroup xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <groupName>string</groupName>\n" +
                "    </RemoveGroup>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveGroupFromRole = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveGroupFromRole xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "      <groupName>string</groupName>\n" +
                "    </RemoveGroupFromRole>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveRole = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveRole xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "    </RemoveRole>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveUserCollectionFromGroup = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveUserCollectionFromGroup xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <groupName>string</groupName>\n" +
                "      <userLoginNamesXml>string</userLoginNamesXml>\n" +
                "    </RemoveUserCollectionFromGroup>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveUserCollectionFromRole = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveUserCollectionFromRole xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "      <userLoginNamesXml>string</userLoginNamesXml>\n" +
                "    </RemoveUserCollectionFromRole>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveUserCollectionFromSite = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveUserCollectionFromSite xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <userLoginNamesXml>string</userLoginNamesXml>\n" +
                "    </RemoveUserCollectionFromSite>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveUserFromGroup = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveUserFromGroup xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <groupName>string</groupName>\n" +
                "      <userLoginName>string</userLoginName>\n" +
                "    </RemoveUserFromGroup>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveUserFromRole = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveUserFromRole xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <roleName>string</roleName>\n" +
                "      <userLoginName>string</userLoginName>\n" +
                "    </RemoveUserFromRole>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveUserFromSite = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveUserFromSite xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <userLoginName>string</userLoginName>\n" +
                "    </RemoveUserFromSite>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveUserFromWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveUserFromWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <userLoginName>string</userLoginName>\n" +
                "    </RemoveUserFromWeb>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateGroupInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateGroupInfo xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <oldGroupName>string</oldGroupName>\n" +
                "      <groupName>string</groupName>\n" +
                "      <ownerIdentifier>string</ownerIdentifier>\n" +
                "      <ownerType>string</ownerType>\n" +
                "      <description>string</description>\n" +
                "    </UpdateGroupInfo>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateRoleDefInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateRoleDefInfo xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <oldRoleName>string</oldRoleName>\n" +
                "      <roleName>string</roleName>\n" +
                "      <description>string</description>\n" +
                "      <permissionMask>unsignedLong</permissionMask>\n" +
                "    </UpdateRoleDefInfo>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateRoleInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateRoleInfo xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <oldRoleName>string</oldRoleName>\n" +
                "      <roleName>string</roleName>\n" +
                "      <description>string</description>\n" +
                "      <permissionMask>int</permissionMask>\n" +
                "    </UpdateRoleInfo>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateUserInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateUserInfo xmlns=\"http://schemas.microsoft.com/sharepoint/soap/directory/\">\n" +
                "      <userLoginName>string</userLoginName>\n" +
                "      <userName>string</userName>\n" +
                "      <userEmail>string</userEmail>\n" +
                "      <userNotes>string</userNotes>\n" +
                "    </UpdateUserInfo>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/ms772545.aspx
     */
    public static interface Versions {
        String URL = "/_vti_bin/versions.asmx";

        String DeleteAllVersions = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteAllVersions xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <fileName>string</fileName>\n" +
                "    </DeleteAllVersions>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteVersion = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteVersion xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <fileName>string</fileName>\n" +
                "      <fileVersion>string</fileVersion>\n" +
                "    </DeleteVersion>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetVersions = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetVersions xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <fileName>string</fileName>\n" +
                "    </GetVersions>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RestoreVersion = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RestoreVersion xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <fileName>string</fileName>\n" +
                "      <fileVersion>string</fileVersion>\n" +
                "    </RestoreVersion>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/views.aspx
     */
    public static interface Views {
        String URL = "/_vti_bin/views.asmx";

        String AddView = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddView xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <viewName>string</viewName>\n" +
                "      <viewFields>string</viewFields>\n" +
                "      <query>string</query>\n" +
                "      <rowLimit>string</rowLimit>\n" +
                "      <type>string</type>\n" +
                "      <makeViewDefault>boolean</makeViewDefault>\n" +
                "    </AddView>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteView = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteView xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <viewName>string</viewName>\n" +
                "    </DeleteView>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetView = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetView xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>{listName}</listName>\n" +
                "      <viewName>{viewName}</viewName>\n" +
                "    </GetView>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetViewCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetViewCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>{listName}</listName>\n" +
                "    </GetViewCollection>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetViewHtml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetViewHtml xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <viewName>string</viewName>\n" +
                "    </GetViewHtml>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateView = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateView xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <viewName>string</viewName>\n" +
                "      <viewProperties>string</viewProperties>\n" +
                "      <query>string</query>\n" +
                "      <viewFields>string</viewFields>\n" +
                "      <aggregations>string</aggregations>\n" +
                "      <formats>string</formats>\n" +
                "      <rowLimit>string</rowLimit>\n" +
                "    </UpdateView>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateViewHtml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateViewHtml xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <viewName>string</viewName>\n" +
                "      <viewProperties>string</viewProperties>\n" +
                "      <toolbar>string</toolbar>\n" +
                "      <viewHeader>string</viewHeader>\n" +
                "      <viewBody>string</viewBody>\n" +
                "      <viewFooter>string</viewFooter>\n" +
                "      <viewEmpty>string</viewEmpty>\n" +
                "      <rowLimitExceeded>string</rowLimitExceeded>\n" +
                "      <query>string</query>\n" +
                "      <viewFields>string</viewFields>\n" +
                "      <aggregations>string</aggregations>\n" +
                "      <formats>string</formats>\n" +
                "      <rowLimit>string</rowLimit>\n" +
                "    </UpdateViewHtml>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateViewHtml2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateViewHtml2 xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <listName>string</listName>\n" +
                "      <viewName>string</viewName>\n" +
                "      <viewProperties>string</viewProperties>\n" +
                "      <toolbar>string</toolbar>\n" +
                "      <viewHeader>string</viewHeader>\n" +
                "      <viewBody>string</viewBody>\n" +
                "      <viewFooter>string</viewFooter>\n" +
                "      <viewEmpty>string</viewEmpty>\n" +
                "      <rowLimitExceeded>string</rowLimitExceeded>\n" +
                "      <query>string</query>\n" +
                "      <viewFields>string</viewFields>\n" +
                "      <aggregations>string</aggregations>\n" +
                "      <formats>string</formats>\n" +
                "      <rowLimit>string</rowLimit>\n" +
                "      <openApplicationExtension>string</openApplicationExtension>\n" +
                "    </UpdateViewHtml2>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/ms774569.aspx
     */
    public static interface WebPartPages {
        String URL = "/_vti_bin/webpartpages.asmx";

        String AddWebPart = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddWebPart xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "      <webPartXml>string</webPartXml>\n" +
                "      <storage>None or Personal or Shared</storage>\n" +
                "    </AddWebPart>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AddWebPartToZone = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AddWebPartToZone xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "      <webPartXml>string</webPartXml>\n" +
                "      <storage>None or Personal or Shared</storage>\n" +
                "      <zoneId>string</zoneId>\n" +
                "      <zoneIndex>int</zoneIndex>\n" +
                "    </AddWebPartToZone>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String AssociateWorkflowMarkup = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <AssociateWorkflowMarkup xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <configUrl>string</configUrl>\n" +
                "      <configVersion>string</configVersion>\n" +
                "    </AssociateWorkflowMarkup>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String ConvertWebPartFormat = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <ConvertWebPartFormat xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <inputFormat>string</inputFormat>\n" +
                "      <formatConversionOption>ConvertToWebPartExportFormat or ConvertToWebPartDesignerPersistenceFormat</formatConversionOption>\n" +
                "    </ConvertWebPartFormat>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteWebPart = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteWebPart xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "      <storageKey>guid</storageKey>\n" +
                "      <storage>None or Personal or Shared</storage>\n" +
                "    </DeleteWebPart>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String ExecuteProxyUpdates = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <ExecuteProxyUpdates xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <updateData>string</updateData>\n" +
                "    </ExecuteProxyUpdates>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String FetchLegalWorkflowActions = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <FetchLegalWorkflowActions xmlns=\"http://microsoft.com/sharepoint/webpartpages\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetAssemblyMetaData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetAssemblyMetaData xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <assemblyName>string</assemblyName>\n" +
                "      <baseTypes>string</baseTypes>\n" +
                "    </GetAssemblyMetaData>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetBindingResourceData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetBindingResourceData xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <ResourceName>string</ResourceName>\n" +
                "    </GetBindingResourceData>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetCustomControlList = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetCustomControlList xmlns=\"http://microsoft.com/sharepoint/webpartpages\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetDataFromDataSourceControl = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetDataFromDataSourceControl xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <dscXml>string</dscXml>\n" +
                "      <contextUrl>string</contextUrl>\n" +
                "    </GetDataFromDataSourceControl>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetExpandedListViewXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetExpandedListViewXml xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <webId>string</webId>\n" +
                "      <listViewXml>string</listViewXml>\n" +
                "      <listGuid>string</listGuid>\n" +
                "      <listUrl>string</listUrl>\n" +
                "      <listDisplayName>string</listDisplayName>\n" +
                "      <hasConnection>boolean</hasConnection>\n" +
                "      <partialView>boolean</partialView>\n" +
                "    </GetExpandedListViewXml>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetFormCapabilityFromDataSourceControl = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetFormCapabilityFromDataSourceControl xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <dscXml>string</dscXml>\n" +
                "    </GetFormCapabilityFromDataSourceControl>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetSafeAssemblyInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetSafeAssemblyInfo xmlns=\"http://microsoft.com/sharepoint/webpartpages\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWebPart = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWebPart xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <pageurl>string</pageurl>\n" +
                "      <storageKey>guid</storageKey>\n" +
                "      <storage>None or Personal or Shared</storage>\n" +
                "    </GetWebPart>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWebPart2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWebPart2 xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <pageurl>string</pageurl>\n" +
                "      <storageKey>guid</storageKey>\n" +
                "      <storage>None or Personal or Shared</storage>\n" +
                "      <behavior>Version3</behavior>\n" +
                "    </GetWebPart2>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWebPartCrossPageCompatibility = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWebPartCrossPageCompatibility xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <sourcePageUrl>string</sourcePageUrl>\n" +
                "      <sourcePageContents>string</sourcePageContents>\n" +
                "      <targetPageUrl>string</targetPageUrl>\n" +
                "      <targetPageContents>string</targetPageContents>\n" +
                "      <providerPartID>string</providerPartID>\n" +
                "      <lcid>string</lcid>\n" +
                "    </GetWebPartCrossPageCompatibility>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWebPartPage = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWebPartPage xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <documentName>string</documentName>\n" +
                "      <behavior>Version3</behavior>\n" +
                "    </GetWebPartPage>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWebPartPageConnectionInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWebPartPageConnectionInfo xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <sourcePageUrl>string</sourcePageUrl>\n" +
                "      <sourcePageContents>string</sourcePageContents>\n" +
                "      <providerPartID>string</providerPartID>\n" +
                "      <lcid>string</lcid>\n" +
                "    </GetWebPartPageConnectionInfo>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWebPartPageDocument = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWebPartPageDocument xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <documentName>string</documentName>\n" +
                "    </GetWebPartPageDocument>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWebPartProperties = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWebPartProperties xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "      <storage>None or Personal or Shared</storage>\n" +
                "    </GetWebPartProperties>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWebPartProperties2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWebPartProperties2 xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "      <storage>None or Personal or Shared</storage>\n" +
                "      <behavior>Version3</behavior>\n" +
                "    </GetWebPartProperties2>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetXmlDataFromDataSource = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetXmlDataFromDataSource xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <queryXml>string</queryXml>\n" +
                "    </GetXmlDataFromDataSource>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveWorkflowAssociation = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveWorkflowAssociation xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <configUrl>string</configUrl>\n" +
                "      <configVersion>string</configVersion>\n" +
                "    </RemoveWorkflowAssociation>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RenderWebPartForEdit = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RenderWebPartForEdit xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <webPartXml>string</webPartXml>\n" +
                "    </RenderWebPartForEdit>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String SaveWebPart = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <SaveWebPart xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "      <storageKey>guid</storageKey>\n" +
                "      <webPartXml>string</webPartXml>\n" +
                "      <storage>None or Personal or Shared</storage>\n" +
                "    </SaveWebPart>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String SaveWebPart2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <SaveWebPart2 xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "      <storageKey>guid</storageKey>\n" +
                "      <webPartXml>string</webPartXml>\n" +
                "      <storage>None or Personal or Shared</storage>\n" +
                "      <allowTypeChange>boolean</allowTypeChange>\n" +
                "    </SaveWebPart2>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String ValidateWorkflowMarkupAndCreateSupportObjects = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <ValidateWorkflowMarkupAndCreateSupportObjects xmlns=\"http://microsoft.com/sharepoint/webpartpages\">\n" +
                "      <workflowMarkupText>string</workflowMarkupText>\n" +
                "      <rulesText>string</rulesText>\n" +
                "      <configBlob>string</configBlob>\n" +
                "      <flag>string</flag>\n" +
                "    </ValidateWorkflowMarkupAndCreateSupportObjects>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }

    /**
     * http://msdn.microsoft.com/en-us/library/webs.aspx
     */
    public static interface Webs {
        String URL = "/_vti_bin/webs.asmx";

        String CreateContentType = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CreateContentType xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <displayName>string</displayName>\n" +
                "      <parentType>string</parentType>\n" +
                "      <newFields>string</newFields>\n" +
                "      <contentTypeProperties>string</contentTypeProperties>\n" +
                "    </CreateContentType>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String CustomizeCss = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <CustomizeCss xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <cssFile>string</cssFile>\n" +
                "    </CustomizeCss>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String DeleteContentType = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <DeleteContentType xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "    </DeleteContentType>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetActivatedFeatures = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetActivatedFeatures xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetAllSubWebCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetAllSubWebCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetColumns = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetColumns xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetContentType = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetContentType xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "    </GetContentType>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetContentTypes = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetContentTypes xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetCustomizedPageStatus = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetCustomizedPageStatus xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <fileUrl>string</fileUrl>\n" +
                "    </GetCustomizedPageStatus>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetListTemplates = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetListTemplates xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetObjectIdFromUrl = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetObjectIdFromUrl xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <objectUrl>string</objectUrl>\n" +
                "    </GetObjectIdFromUrl>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWeb = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWeb xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <webUrl>{webUrl}</webUrl>\n" +
                "    </GetWeb>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String GetWebCollection = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <GetWebCollection xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RemoveContentTypeXmlDocument = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RemoveContentTypeXmlDocument xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "      <documentUri>string</documentUri>\n" +
                "    </RemoveContentTypeXmlDocument>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RevertAllFileContentStreams = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RevertAllFileContentStreams xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\" />\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RevertCss = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RevertCss xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <cssFile>string</cssFile>\n" +
                "    </RevertCss>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String RevertFileContentStream = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <RevertFileContentStream xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <fileUrl>string</fileUrl>\n" +
                "    </RevertFileContentStream>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateColumns = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateColumns xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <newFields>string</newFields>\n" +
                "      <updateFields>string</updateFields>\n" +
                "      <deleteFields>string</deleteFields>\n" +
                "    </UpdateColumns>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateContentType = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateContentType xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "      <contentTypeProperties>string</contentTypeProperties>\n" +
                "      <newFields>string</newFields>\n" +
                "      <updateFields>string</updateFields>\n" +
                "      <deleteFields>string</deleteFields>\n" +
                "    </UpdateContentType>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String UpdateContentTypeXmlDocument = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <UpdateContentTypeXmlDocument xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <contentTypeId>string</contentTypeId>\n" +
                "      <newDocument>string</newDocument>\n" +
                "    </UpdateContentTypeXmlDocument>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String WebUrlFromPageUrl = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <WebUrlFromPageUrl xmlns=\"http://schemas.microsoft.com/sharepoint/soap/\">\n" +
                "      <pageUrl>string</pageUrl>\n" +
                "    </WebUrlFromPageUrl>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>";
    }
}
