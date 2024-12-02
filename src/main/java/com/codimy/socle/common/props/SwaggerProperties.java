package com.codimy.socle.common.props;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "config.swagger")
public class SwaggerProperties {

    private List<String> urls;
}