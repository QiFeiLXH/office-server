package com.bsoft.office.sysconfig.mapper;
import com.bsoft.office.common.constant.BsoftConfigProperty;
import com.bsoft.office.sysconfig.decrypt.RequestDecrypter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import lombok.SneakyThrows;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptObjectMapper extends ObjectMapper {
    @SneakyThrows
    @Override
    public <T> T readValue(InputStream src, JavaType valueType)
    {
        _assertNotNull("src", src);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (!ServletFileUpload.isMultipartContent(request) && BsoftConfigProperty.cryptFlag.equals(1)) {
            byte[] data = getData(src);
            byte[] decryData = RequestDecrypter.decryptPost(data); //POST请求解密
            return readValue(decryData,valueType);
        }else{
            return (T) _readMapAndClose(_jsonFactory.createParser(src), valueType);
        }

    }


    @Override
    protected ObjectWriter _newWriter(SerializationConfig config) {
        return new EncryptObjectWriter(this, config);
    }

    private byte[] getData(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] cache = new byte[8000];
        int nRead = 0;
        while ((nRead = in.read(cache)) != -1) {
            out.write(cache, 0, nRead);
            out.flush();
        }
        out.close();
        in.close();
        return out.toByteArray();
    }
}
