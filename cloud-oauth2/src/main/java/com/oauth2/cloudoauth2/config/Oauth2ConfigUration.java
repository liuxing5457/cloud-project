package com.oauth2.cloudoauth2.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;

/**
 * @ClassName Oauth2ConfigUration
 * @Description TODO
 * @Author  xuzibang
 * @Date 2019/11/16
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2ConfigUration extends AuthorizationServerConfigurerAdapter {

    public static final String SERVICE = "service";
    public static final String TRUST = "trust";
    public static final String WEB = "web";
    public static final String MOBILE = "mobile";
    public static final String READ = "read";
    public static final String WRITE = "write";

    public static final String HAS_SERVICE_SCOPE = "#oauth2.hasScope('" + SERVICE + "') ";
    public static final String HAS_READ_SCOPE = "#oauth2.hasScope('" + READ + "') ";
    public static final String HAS_WRITE_SCOPE = "#oauth2.hasScope('" + WRITE + "') ";
    public static final String HAS_WEB_SCOPE = "#oauth2.hasScope('" + WEB + "') ";
    public static final String HAS_MOBILE_SCOPE = "#oauth2.hasScope('" + MOBILE + "') ";
    public static final String HAS_SERVICE_SCOPE_AND_WEB_SCOPE = HAS_SERVICE_SCOPE + "OR #oauth2.hasScope('" + WEB + "')";
    public static final String HAS_SERVICE_SCOPE_AND_MOBILE_SCOPE = HAS_SERVICE_SCOPE + "OR #oauth2.hasScope('" + MOBILE + "')";
    public static final String HAS_SERVICE_SCOPE_AND_MOBILE_SCOPE_AND_WEB_SCOPE = HAS_SERVICE_SCOPE_AND_WEB_SCOPE + "OR #oauth2.hasScope('" + MOBILE + "')";
    public static final String HAS_MOBILE_SCOPE_AND_WEB_SCOPE = HAS_MOBILE_SCOPE + "OR " + HAS_WEB_SCOPE;

    @Autowired
    TokenStore tokenStore;

    @Autowired
    AccessTokenConverter accessTokenConverter;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 数据配置
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        security.allowFormAuthenticationForClients().checkTokenAccess("permitAll()");
    }


    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource());
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
       /** clients
                .inMemory().withClient("service").secret("{noop}service")
                .authorizedGrantTypes("client_credentials", "authorization_code", "password", "refresh_token")
                .scopes(SERVICE, READ, WRITE, TRUST)
                .autoApprove(true)
                .authorities("ROLE_TRUSTED_CLIENT")
                .accessTokenValiditySeconds(7200)
                .and()
                .withClient("web_client").secret("{noop}web_clnt")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes(WEB, READ, WRITE)
                .accessTokenValiditySeconds(7200) // 1 hour
                .refreshTokenValiditySeconds(14400) // 2 hours
                .and()
                .withClient("mobile_client").secret("{noop}mobile_clnt")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes(MOBILE, READ, WRITE)
                .accessTokenValiditySeconds(7200) // 1 hour
                .refreshTokenValiditySeconds(14400); // 2 hours*/
        /**读取数据库存储的用户信息*/
        clients.withClientDetails(clientDetails());
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter);
    }
}
