package com.daily.util;

import com.daily.common.Constants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Azir on 2018/2/1.
 */
public class TZParamUtil {


    private static ObjectMapper mapper = new ObjectMapper();
    /**
    *  Author: 代刘洋
    *  Time：  2018/2/1  22:31
    *  Title:
    *  Param:
    *  Response: TZ 收参工具类
    *
    */
    public static Map<String, Object> getParams(HttpServletRequest request) {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                try {
                    Map<String, Object> readValue = new HashMap<>();
                    if (request.getMethod().toString().equals("GET")) {
                        Enumeration e = request.getParameterNames();
                        while (e.hasMoreElements()) {
                            String paramName = (String) e.nextElement();
                            String paramValue = request.getParameter(paramName);
                            //形成键值对应的map
                            readValue.put(paramName, paramValue);
                        }
                    } else {
                        byte[] requestStream = readFromStream(request.getInputStream());
                        if (requestStream == null || requestStream.length <= 0) {
                            requestStream = (byte[]) request.getAttribute(Constants.REQUEST_STREM);
                        } else {
                            request.setAttribute(Constants.REQUEST_STREM, requestStream);
                        }
                        readValue = mapper.readValue(requestStream, Map.class);
                    }
                    String token = request.getHeader(Constants.TOKEN);
                    if (token != null) {
                        readValue.put("token", token);
                    }
                    return readValue;
                } catch (JsonParseException e) {
                    e.printStackTrace();
                } catch (JsonMappingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }


            /**
            *  Author: 代刘洋
            *  Time：  2018/2/1  22:32
            *  Title:
            *  Param:
            *  Response:    TZ 工具类
            *
            */
    public static byte[] readFromStream(InputStream in) {
        BufferedInputStream bufin = new BufferedInputStream(in);
        int buffSize = 1024;
        ByteArrayOutputStream out = new ByteArrayOutputStream(buffSize);
        byte[] temp = new byte[buffSize];

        try {
            int size = 0;
            while ((size = bufin.read(temp)) != -1) {
                out.write(temp, 0, size);
            }

            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                bufin.close();
                bufin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
