package com.bsoft.office.sysconfig.mapper;

import com.bsoft.office.common.constant.BsoftConfigProperty;
import com.bsoft.office.sysconfig.decrypt.ResponseEncrypter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.util.ClassUtil;
import lombok.SneakyThrows;

import java.io.Closeable;
import java.io.IOException;

public class EncryptObjectWriter extends ObjectWriter {
    protected EncryptObjectWriter(ObjectMapper mapper, SerializationConfig config, JavaType rootType, PrettyPrinter pp) {
        super(mapper, config, rootType, pp);
    }

    protected EncryptObjectWriter(ObjectMapper mapper, SerializationConfig config) {
        super(mapper, config);
    }

    protected EncryptObjectWriter(ObjectMapper mapper, SerializationConfig config, FormatSchema s) {
        super(mapper, config, s);
    }

    protected EncryptObjectWriter(ObjectWriter base, SerializationConfig config, GeneratorSettings genSettings, Prefetch prefetch) {
        super(base, config, genSettings, prefetch);
    }

    protected EncryptObjectWriter(ObjectWriter base, SerializationConfig config) {
        super(base, config);
    }

    protected EncryptObjectWriter(ObjectWriter base, JsonFactory f) {
        super(base, f);
    }

    @SneakyThrows
    public void writeValue(JsonGenerator g, Object value) throws IOException {
        _assertNotNull("g", g);
        _configureGenerator(g);
        if (_config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (value instanceof Closeable)) {
            Closeable toClose = (Closeable) value;
            try {
                Object encryptData = value;
                if (BsoftConfigProperty.cryptFlag == 1) {
                    encryptData = ResponseEncrypter.encrypt(value); //返回值加密
                }
                _prefetch.serialize(g, encryptData, _serializerProvider());
                if (_config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                    g.flush();
                }
            } catch (Exception e) {
                ClassUtil.closeOnFailAndThrowAsIOE(null, toClose, e);
                return;
            }
            toClose.close();
        } else {
            Object encryptData = value;
            if (BsoftConfigProperty.cryptFlag == 1) {
                encryptData = ResponseEncrypter.encrypt(value); //返回值加密
            }
            _prefetch.serialize(g, encryptData, _serializerProvider());
            if (_config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)) {
                g.flush();
            }
        }
    }
}
