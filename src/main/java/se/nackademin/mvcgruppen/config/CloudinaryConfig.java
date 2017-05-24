package se.nackademin.mvcgruppen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class CloudinaryConfig {

    private final Environment mEnv;

    public CloudinaryConfig(Environment mEnv) {
        this.mEnv = mEnv;
    }

    @Bean(name="com.cloudinary.cloud_name")
    public String getCloudinaryCloudName()
    {
        return mEnv.getProperty("com.cloudinary.cloud_name");
    }


    @Bean(name="com.cloudinary.api_key")
    public String getCloudinaryApiKey()
    {
        return mEnv.getProperty("com.cloudinary.api_key");
    }

    @Bean(name="com.cloudinary.api_secret")
    public String getCloudinaryApiSecret()
    {
        return mEnv.getProperty("com.cloudinary.api_secret");
    }

}
