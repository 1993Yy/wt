package com.yy.common.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufOutputStream;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.BaseCodec;
import org.redisson.client.protocol.Decoder;
import org.redisson.client.protocol.Encoder;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @package: com.yy.common.config
 * @className: RedisConfig
 * @author: Created By Yy
 * @date: 2020-09-14 22:05
 */
@Configuration
public class RedisConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(){
        Config config=new Config();
        config.setTransportMode(TransportMode.NIO);
        config.setCodec(new FastJsonCodec());
        SingleServerConfig server = config.useSingleServer();
        server.setAddress("redis://localhost:6379")
                .setDatabase(5);
        return Redisson.create(config);
    }



    static class FastJsonCodec extends BaseCodec{
        private final static ParserConfig defaultRedisConfig = new ParserConfig();
        static {
            defaultRedisConfig.setAutoTypeSupport(true);
        }
        @Override
        public Decoder<Object> getValueDecoder() {
            return (buf,state)-> JSON.parseObject(new String(buf.array(), IOUtils.UTF8), Object.class, defaultRedisConfig);
        }

        @Override
        public Encoder getValueEncoder() {
            return in ->{
                ByteBuf out = ByteBufAllocator.DEFAULT.buffer();
                try {
                    ByteBufOutputStream os = new ByteBufOutputStream(out);
                    JSON.writeJSONString(os, in,SerializerFeature.WriteClassName);
                    return os.buffer();
                } catch (IOException e) {
                    out.release();
                    throw e;
                } catch (Exception e) {
                    out.release();
                    throw new IOException(e);
                }
            };
        }
    }
}
