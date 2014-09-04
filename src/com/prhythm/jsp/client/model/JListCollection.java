package com.prhythm.jsp.client.model;

import com.prhythm.jsp.client.util.JHttpClientClient;
import com.prhythm.jsp.client.util.JHttpClientUtil;
import com.prhythm.jsp.client.util.StringUtil;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Bruce on 8/18/2014.
 */
public class JListCollection extends JClientContext.BaseWeb implements Collection<JList>, JClientContext.Loadable<JListCollection> {

    LinkedList<JList> lists;

    boolean loaded;

    protected JListCollection(JClientContext context, JWeb web) {
        super(context, web);
        lists = new LinkedList<JList>();
    }

    public JList getById(UUID id) {
        if (size() == 0) {
            return loadById(id).load();
        } else {
            for (JList item : this) {
                if (item.getId().equals(id)) return item.load();
            }
            return loadById(id).load();
        }
    }

    public JList getByTitle(String title) {
        if (size() == 0) {
            return loadList(title).load();
        } else {
            for (JList item : this) {
                if (item.getTitle().equals(title)) return item.load();
            }
            return loadList(title).load();
        }
    }

    public JList get(int i) {
        return lists.get(i);
    }

    public void sort() {
        Collections.sort(lists, new Comparator<JList>() {
            @Override
            public int compare(JList o1, JList o2) {
                if (o1.getBaseType() == o2.getBaseType()) {
                    return o1.getBaseTemplate().compareTo(o2.getBaseTemplate());
                } else {
                    return o1.getBaseType() - o2.getBaseType();
                }
            }
        });
    }

    public void loadAll() {
        NodeList lists;
        try {
            lists = getDataFromListWS();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        NodeList siteData;
        try {
            siteData = getDataFromSiteDataWS();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        for (int i = 0; i < lists.getLength(); i++) {
            JList listObj;
            if (lists.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
            try {
                listObj = parse((Element) lists.item(i));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            if (siteData == null) continue;

            for (int j = 0; j < siteData.getLength(); j++) {
                if (siteData.item(j).getNodeType() != Node.ELEMENT_NODE) continue;
                Element data = (Element) siteData.item(j);
                NodeList internalName = data.getElementsByTagName("InternalName");
                if (internalName.getLength() > 0 && listObj.getId().equals(UUID.fromString(internalName.item(0).getFirstChild().getNodeValue().replace("{", "").replace("}", "")))) {

                    if (data.getElementsByTagName("BaseTemplate").getLength() > 0) {
                        String baseTemplate = data.getElementsByTagName("BaseTemplate").item(0).getFirstChild().getNodeValue();

                        if (Pattern.matches("[-]?\\d+", baseTemplate)) {
                            listObj.attributes.put("BaseTemplate", new JContentValue(getBaseTemplateName(Integer.parseInt(baseTemplate))));
                        } else {
                            listObj.attributes.put("BaseTemplate", new JContentValue(baseTemplate));
                        }
                    }

                    break;
                }
            }

            listObj = castType(listObj);
            JContentValue hidden = listObj.getAttribute("Hidden");
            if (hidden != null && !((Boolean) hidden.getValue())) add(listObj);
        }
        sort();
    }

    @Override
    public JListCollection load() {
        if (!loaded) {
            loaded = true;
            loadAll();
        }
        return this;
    }

    private JList loadById(UUID id) {
        if (id == null) throw new IllegalArgumentException();
        return loadList(id.toString());
    }

    protected JList loadList(String title) {
        if (title == null || title.length() == 0) throw new IllegalArgumentException();

        String body = null;
        try {
            body = JHttpClientUtil.postText(
                    context.getUrl() + JHttpClientUtil.Lists.URL,
                    JHttpClientUtil.Lists.GetList.replace("{listName}", StringUtil.escapeXml(title)),
                    JHttpClientClient.getWebserviceSopa()
            );
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        Node item;
        Document document;
        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(body.getBytes()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        NodeList list = document.getElementsByTagName("List");
        if (list.getLength() > 0)
            item = list.item(0);
        else
            return null;

        JList listObj;
        try {
            listObj = parse((Element) item);
            listObj.loaded = true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        try {
            body = JHttpClientUtil.postText(
                    context.getUrl() + JHttpClientUtil.Lists.URL,
                    JHttpClientUtil.Lists.GetList.replace("{listName}", StringUtil.escapeXml(title)),
                    JHttpClientClient.getWebserviceSopa()
            );
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        try {
            document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(body.getBytes()));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        NodeList meta = document.getElementsByTagName("sListMetadata");

        if (meta.getLength() > 0) {
            Element data = (Element) meta.item(0);
            if (data.getElementsByTagName("BaseTemplate").getLength() > 0) {
                String baseTemplate = data.getElementsByTagName("BaseTemplate").item(0).getFirstChild().getNodeValue();

                if (Pattern.matches("[-]?\\d+", baseTemplate)) {
                    listObj.attributes.put("BaseTemplate", new JContentValue(getBaseTemplateName(Integer.parseInt(baseTemplate))));
                } else {
                    listObj.attributes.put("BaseTemplate", new JContentValue(baseTemplate));
                }
            }
        }

        return castType(listObj);
    }

    String getBaseTemplateName(int baseTemplate) {
        switch (baseTemplate) {
            case -1:
                return "NotUsed";
            case 0:
                return "UnspecifiedListType";
            case 100:
                return "CustomList";
            case 101:
                return "DocumentLibrary";
            case 102:
                return "Survey";
            case 103:
                return "Links";
            case 104:
                return "Announcements";
            case 105:
                return "Contacts";
            case 106:
                return "Calendar";
            case 107:
                return "Tasks";
            case 108:
                return "DiscussionBoard";
            case 109:
                return "PictureLibrary";
            case 110:
                return "DataSources";
            case 111:
                return "SiteTemplateGallery";
            case 112:
                return "UserInformation";
            case 113:
                return "WebPartGallery";
            case 114:
                return "ListTemplateGaller";
            case 115:
                return "XmlFormLibrary";
            case 116:
                return "MasterPageGallery";
            case 117:
                return "NoCodeWorkflows";
            case 118:
                return "CustomWorkflowProcess";
            case 119:
                return "WikiPageLibrary";
            case 120:
                return "CustomGrid";
            case 121:
                return "Solutions";
            case 122:
                return "NoCodePublicWorkflow";
            case 123:
                return "Themes";
            case 124:
                return "DesignCatalog";
            case 125:
                return "AppDataCatalog";
            case 130:
                return "DataConnectionLibrary";
            case 140:
                return "WorkflowHistory";
            case 150:
                return "ProjectTasks";
            case 151:
                return "HelpLibrary";
            case 160:
                return "AccessRequestList";
            case 171:
                return "TasksWithTimelineAndHierarchy";
            case 175:
                return "MaintenanceLogsLibrary";
            case 200:
                return "MeetingSeries";
            case 201:
                return "Agenda";
            case 202:
                return "Attendees";
            case 204:
                return "Decisions";
            case 207:
                return "Objectives";
            case 210:
                return "TextBox";
            case 211:
                return "ThingsToBring";
            case 212:
                return "WorkspacePages";
            case 301:
                return "Posts";
            case 302:
                return "Comments";
            case 303:
                return "Categories";
            case 402:
                return "Facility";
            case 403:
                return "Whereabouts";
            case 404:
                return "CallTrack";
            case 405:
                return "Circulation";
            case 420:
                return "Timecard";
            case 421:
                return "Holidays";
            case 499:
                return "ImeDictionary";
            case 600:
                return "External";
            case 700:
                return "MySiteDocumentLibrary";
            case 850:
                return "Pages Library";
            case 851:
                return "AssetLibrary";
            case 1100:
                return "IssueTracking";
            case 1200:
                return "AdministratorTasks";
            case 1220:
                return "HealthRules";
            case 1221:
                return "HealthReports";
            case 1230:
                return "DraftAppsLibrary";
            default:
                return String.valueOf(baseTemplate);
        }
    }

    NodeList getDataFromListWS() throws Exception {
        String body = null;
        body = JHttpClientUtil.postText(
                context.getUrl() + JHttpClientUtil.Lists.URL,
                JHttpClientUtil.Lists.GetListCollection,
                JHttpClientClient.getWebserviceSopa()
        );

        Document document = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(new ByteArrayInputStream(body.getBytes()));

        return document.getElementsByTagName("List");
    }

    NodeList getDataFromSiteDataWS() throws Exception {
        String body = null;
        body = JHttpClientUtil.postText(
                context.getUrl() + JHttpClientUtil.SiteData.URL,
                JHttpClientUtil.SiteData.GetListCollection,
                JHttpClientClient.getWebserviceSopa()
        );

        Document document = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(new ByteArrayInputStream(body.getBytes()));

        NodeList vList = document.getElementsByTagName("vLists");
        if (vList.getLength() > 0) {
            return vList.item(0).getChildNodes();
        }
        return null;
    }

    JList parse(Element element) {
        JList listObj = new JList(context, web);
        listObj.putAttributes(element.getAttributes());

        NodeList fields = element.getElementsByTagName("Fields");
        if (fields.getLength() > 0) {
            listObj.getFields().parse((Element) fields.item(0));
        }
        return listObj;
    }

    JList castType(JList listObj) {
        if (listObj == null) return null;
        int baseType = listObj.getBaseType();
        switch (baseType) {
            default:
            case 0:
                break;
            case 1:
                listObj = new JDocumentLibrary(listObj);
                break;
            case 3:
                listObj = new JDiscussionBoard(listObj);
                break;
            case 4:
                listObj = new JSurvey(listObj);
                break;
            case 5:
                listObj = new JIssue(listObj);
                break;
        }

        String baseTemplate = listObj.getBaseTemplate();
        if (baseTemplate == null) return listObj;

        if ("Events".equalsIgnoreCase(baseTemplate) && !(listObj instanceof JCalendar))
            return new JCalendar(listObj);
        if ("Calendar".equalsIgnoreCase(baseTemplate) && !(listObj instanceof JCalendar))
            return new JCalendar(listObj);
        if ("DiscussionBoard".equalsIgnoreCase(baseTemplate) && !(listObj instanceof JDiscussionBoard))
            return new JDiscussionBoard(listObj);
        if ("PictureLibrary".equalsIgnoreCase(baseTemplate) && !(listObj instanceof JPictureLibrary))
            return new JPictureLibrary(listObj);
        if ("WikiPageLibrary".equalsIgnoreCase(baseTemplate) && !(listObj instanceof JWikiPageLibrary))
            return new JWikiPageLibrary(listObj);
        if ("WebPageLibrary".equalsIgnoreCase(baseTemplate) && !(listObj instanceof JWikiPageLibrary))
            return new JWikiPageLibrary(listObj);
        if ("Pages Library".equalsIgnoreCase(baseTemplate) && !(listObj instanceof JWikiPageLibrary))
            return new JWikiPageLibrary(listObj);
        return listObj;
    }

    @Override
    public int size() {
        load();
        return lists.size();
    }

    @Override
    public boolean isEmpty() {
        load();
        return lists.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        load();
        return lists.contains(o);
    }

    @Override
    public Iterator<JList> iterator() {
        load();
        return lists.iterator();
    }

    @Override
    public Object[] toArray() {
        load();
        return lists.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        load();
        return lists.toArray(a);
    }

    @Override
    public boolean add(JList list) {
        if (lists.contains(list)) {
            for (JList exists : lists) {
                if (exists.equals(list)) {
                    exists.mergeAttribute(list.attributes);
                    list.mergeAttribute(exists.attributes);
                    return true;
                }
            }
            return false;
        } else {
            return lists.add(list);
        }
    }

    @Override
    public boolean remove(Object o) {
        return lists.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return lists.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends JList> c) {
        boolean v = true;
        for (JList l : c) {
            if (!add(l)) v = false;
        }
        return v;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return lists.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return lists.retainAll(c);
    }

    @Override
    public void clear() {
        lists.clear();
    }

    @Override
    public void onDispose() {
        if (lists != null) {
            lists.clear();
            lists = null;
        }
        super.onDispose();
    }
}
