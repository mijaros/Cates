package org.cates

import griffon.core.Configuration
import griffon.core.addon.GriffonAddon
import griffon.core.event.EventHandler
import griffon.core.injection.Module
import org.codehaus.griffon.runtime.core.injection.AbstractModule
import org.codehaus.griffon.runtime.util.ResourceBundleProvider
import org.codehaus.griffon.runtime.datasource.DataSourceAddon
import org.codehaus.griffon.runtime.mybatis.DefaultMybatisConfiguration
import org.codehaus.griffon.runtime.mybatis.DefaultMybatisStorage
import org.codehaus.griffon.runtime.mybatis.DefaultMybatisHandler
import org.codehaus.griffon.runtime.mybatis.DefaultMybatisFactory
import org.codehaus.griffon.runtime.mybatis.MybatisAddon
import griffon.plugins.mybatis.MybatisStorage
import griffon.plugins.mybatis.MybatisFactory
import griffon.plugins.mybatis.MybatisHandler
import org.kordamp.jipsy.ServiceProviderFor

import static griffon.util.AnnotationUtils.named

@ServiceProviderFor(Module)
class ApplicationModule extends AbstractModule {
    @Override
    protected void doConfigure() {
        bind(EventHandler)
                .to(ApplicationEventHandler)
                .asSingleton()

        bind(GriffonAddon.class)
                .to(DataSourceAddon.class)
                .asSingleton();
        bind(ResourceBundle.class)
                .withClassifier(named("mybatis"))
                .toProvider(new ResourceBundleProvider("Mybatis"))
                .asSingleton();

        bind(Configuration.class)
                .withClassifier(named("mybatis"))
                .to(DefaultMybatisConfiguration.class)
                .asSingleton();

        bind(MybatisStorage.class)
                .to(DefaultMybatisStorage.class)
                .asSingleton();

        bind(MybatisFactory.class)
                .to(DefaultMybatisFactory.class)
                .asSingleton();

        bind(MybatisHandler.class)
                .to(DefaultMybatisHandler.class)
                .asSingleton();

        bind(GriffonAddon.class)
                .to(MybatisAddon.class)
                .asSingleton();
    }

}