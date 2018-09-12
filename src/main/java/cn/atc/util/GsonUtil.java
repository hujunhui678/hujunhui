package cn.atc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


public class GsonUtil {
    //���ô�������,ֱ��ʹ��Gson.�Ϳ��Ե��÷���
    private static Gson gson = null;
    //�ж�gson�����Ƿ������,�������򴴽�����
    static {
        if (gson == null) {
            //gson = new Gson();
            //��ʹ��GsonBuilder��ʽʱ����Ϊ�յ�ʱ���������json�ַ������м�ֵkey��,��ʾ��ʽ��"key":null����ֱ��new�����ľ�û��"key":null��
            gson= new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        }
    }
    //�޲ε�˽�й��췽��
    private GsonUtil() {
    }

    /**
     * ������ת��json��ʽ
     * 
     * @param object
     * @return String
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * ��jsonת���ض���cls�Ķ���
     * 
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            //����json����Ͷ�������,��jsonת�ɶ���
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * json�ַ���ת��list
     * 
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            //���ݷ��ͷ��ؽ���ָ��������,TypeToken<List<T>>{}.getType()��ȡ��������
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * json�ַ���ת��list����map��
     * 
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * json�ַ���ת��map��
     * 
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}